package com.faiez.controller;

import com.faiez.model.Owner;
import com.faiez.response.OwnerDto;
import com.faiez.response.OwnerLigne;
import com.faiez.service.OwnerService;
import com.faiez.validation.OwnerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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

}
