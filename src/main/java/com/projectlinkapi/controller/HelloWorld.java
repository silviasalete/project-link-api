package com.projectlinkapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorld {

	@GetMapping
	@ResponseBody
	public String helloWorld() {
		return "API BASE FUNCIONANDO";
	}
}
