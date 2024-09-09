package io.github.anantharajuc.sbmwa.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/index") 
public class Controller 
{
	@GetMapping() 
    public String persons() 
	{	
		return "index.html";
    }
}
