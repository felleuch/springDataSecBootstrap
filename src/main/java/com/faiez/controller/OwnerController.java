package com.faiez.controller;

import com.faiez.exception.BusinessException;
import com.faiez.model.Owner;
import com.faiez.model.Pet;
import com.faiez.response.OwnerDto;
import com.faiez.response.OwnerLigne;
import com.faiez.service.OwnerService;
import com.faiez.validation.OwnerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faiez.elleuch on 24/02/14.
 */
@Controller
@RequestMapping("/owners")
@SessionAttributes("ownerObject")
public class OwnerController {



	@Autowired
	private OwnerService ownerService;

	@Autowired
	private OwnerValidator ownerValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {

		binder.setValidator(ownerValidator);
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newOwerPage() {
		ModelAndView mav = new ModelAndView("owners/owner-new", "owner", new Owner());
		return mav;
	}


	@RequestMapping(value="/create", method= RequestMethod.POST)
	public ModelAndView createNewOwner(@ModelAttribute @Valid Owner owner,
									 BindingResult result,
									 final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("owner-new");

		ModelAndView mav = new ModelAndView();
		String message = "New owner "+owner.getFirstname()+" "+owner.getLastname()+" was successfully created.";

		ownerService.create(owner);
		mav.setViewName("redirect:/owners/list.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}


	@RequestMapping(value="/allowners", method= RequestMethod.GET, produces="application/json")
	public @ResponseBody
	OwnerDto allPets() {
		List<Owner> ownerList = ownerService.findAll();

		List<OwnerLigne> lst = new ArrayList<OwnerLigne>();
		for(Owner o:ownerList){
			OwnerLigne pl = new OwnerLigne();
			pl.setId(o.getId());
			pl.setFirstName(o.getFirstname());
			pl.setLastName(o.getLastname());

			lst.add(pl);
		}

		OwnerDto ownerDtoObject = new OwnerDto();
		ownerDtoObject.setAaData(lst);
		return ownerDtoObject;
	}


	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView ownerListPage() {
		ModelAndView mav = new ModelAndView("owners/owner-list");
		/*List<Pet> petList = petService.findAll();
		mav.addObject("petList", petList);*/
		return mav;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editOwnerPage(@PathVariable Integer id) {
		Owner owner = ownerService.findById(id);
		ModelAndView mav = new ModelAndView("owners/owner-edit");
		mav.addObject("ownerObject",owner);
		return mav;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editOwner(@ModelAttribute("ownerObject") @Valid Owner owner,
								BindingResult result,
								@PathVariable Integer id,
								final RedirectAttributes redirectAttributes) throws BusinessException {

		if (result.hasErrors())
			return new ModelAndView("owners/owner-edit");

		ModelAndView mav = new ModelAndView("redirect:/owners/list.html");
		String message = "Owner was successfully updated.";

		ownerService.update(owner);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteOwner(@PathVariable Integer id,
								  final RedirectAttributes redirectAttributes) throws BusinessException {

		ModelAndView mav = new ModelAndView("redirect:/owners/list.html");

		Owner owner = ownerService.delete(id);
		String message = "The owner "+owner.getLastname()+" was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}












}
