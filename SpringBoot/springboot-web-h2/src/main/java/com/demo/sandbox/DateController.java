package com.demo.sandbox;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DateController {

	@GetMapping("/dtCalc")
	public String greeting(@RequestParam(name="curDt", required=false, defaultValue="2022-01-01") String name, 
			@RequestParam(name="addDays", required=false, defaultValue="30") String addDays,
			Model model) {
		LocalDate now = LocalDate.parse(name);
		
		LocalDate nxt = now.plusDays(Integer.valueOf(addDays));
		System.out.println("New date: " + nxt.toString());
		
		model.addAttribute("curDt", now.toString());		
		model.addAttribute("addDays", addDays);
		
		model.addAttribute("nxtDt", nxt.toString());
		
		return "datecalculator";
	}

}
