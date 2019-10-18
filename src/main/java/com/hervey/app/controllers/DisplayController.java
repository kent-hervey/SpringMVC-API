package com.hervey.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayController {
	//Although this project has no html front-end, a display is used for capability confirmation purposes.

	
	@GetMapping("/display")
	public String displayTest() {
		//return "displaytest.jsp";
		//return "showCourses.jsp";
		return "display.jsp";
	}
	
	
	
	
}
