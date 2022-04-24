package com.qa.PlayerMS.controllers;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/myroute")
public class PlayerController {
		
	@GetMapping
	public String myFirstRoute() {
		return "Hello from my Spring Web App";
	}
	
	@GetMapping(path = "/mysecondroute")
	public String MySecondRoute() {
		return "Hello from my other route";
	}

}
