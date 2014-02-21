package com.faiez.controller;

import com.faiez.model.FileMeta;
import com.faiez.model.Pet;
import com.faiez.response.PetDto;
import com.faiez.response.PetLigne;
import com.faiez.service.PetService;
import com.faiez.validation.PetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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
	public ModelAndView petListPage() {
		ModelAndView mav = new ModelAndView("pets/pet-list");
		/*List<Pet> petList = petService.findAll();
		mav.addObject("petList", petList);*/
		return mav;
	}





	@RequestMapping(value="/allpets", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody	PetDto allPets() {
		List<Pet> petList = petService.findAll();

				List<PetLigne> lst = new ArrayList<PetLigne>();
				for(Pet p:petList){
					PetLigne pl = new PetLigne();
					pl.setName(p.getName());
					pl.setColor(p.getColor());
					lst.add(pl);
				}

		PetDto petDtoObject = new PetDto();
		petDtoObject.setAaData(lst);
		return petDtoObject;
	}


	LinkedList<FileMeta> files = new LinkedList<FileMeta>();
	FileMeta fileMeta = null;

	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response) {

		//1. build an iterator
		Iterator<String> itr =  request.getFileNames();
		MultipartFile mpf = null;

		//2. get each file
		while(itr.hasNext()){

			//2.1 get next MultipartFile
			mpf = request.getFile(itr.next());
			System.out.println(mpf.getOriginalFilename() +" uploaded! "+files.size());

			//2.2 if files > 10 remove the first from the list
			if(files.size() >= 10)
				files.pop();

			//2.3 create new fileMeta
			fileMeta = new FileMeta();
			fileMeta.setFileName(mpf.getOriginalFilename());
			fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
			fileMeta.setFileType(mpf.getContentType());

			try {
				fileMeta.setBytes(mpf.getBytes());

				// copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream("D:/temp/" + mpf.getOriginalFilename()));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//2.4 add to files
			files.add(fileMeta);

		}

		// result will be like this
		// [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
		return files;

	}


}
