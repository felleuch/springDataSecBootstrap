package com.faiez.controller;

import com.faiez.model.Pet;
import com.faiez.service.PetService;
import com.faiez.validation.PetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by faiez.elleuch on 19/02/14.
 */
@Controller
@RequestMapping("/pets")
public class PetController {


	@Autowired
	private PetService petService;

	@Autowired
	private PetValidator petValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(petValidator);
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newPetPage() {
		ModelAndView mav = new ModelAndView("pets/pet-new", "pet", new Pet());
		return mav;
	}


	@RequestMapping(value="/create", method= RequestMethod.POST)
	public ModelAndView createNewPet(@ModelAttribute @Valid Pet pet,
									  BindingResult result,
									  final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("pet-new");

		ModelAndView mav = new ModelAndView();
		String message = "New pet "+pet.getName()+" was successfully created.";

		petService.create(pet);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView shopListPage() {
		ModelAndView mav = new ModelAndView("pets/pet-list");
		List<Pet> petList = petService.findAll();
		mav.addObject("petList", petList);
		return mav;
	}


}
