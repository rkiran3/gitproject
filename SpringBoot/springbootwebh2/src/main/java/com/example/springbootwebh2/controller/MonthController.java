package com.example.springbootwebh2.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MonthController {

	@GetMapping("/mtCalc")
	public String greeting(@RequestParam(name="curMt", required=false, defaultValue="2022-01-01") String name, 
			@RequestParam(name="addMt", required=false, defaultValue="3") String addMt,
			Model model) {
		LocalDate now = LocalDate.parse(name);
		
		LocalDate nxt = now.plusMonths(Integer.valueOf(addMt));
		System.out.println("New Month: " + nxt.toString());
		
		model.addAttribute("curMt", now.toString());
		model.addAttribute("addMt", addMt);
		
		model.addAttribute("nxtMt", nxt.toString());
		
		return "monthcalculator";
	}
}
