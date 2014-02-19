package com.faiez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by faiez.elleuch on 19/02/14.
 */
@Controller
public class NavigationController {

	@RequestMapping(value={"/", "index"}, method= RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index");
	}
}
