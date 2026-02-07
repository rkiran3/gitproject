package com.example.springbootwebh2.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DateController {

	@GetMapping("/dtCalc")
	public String greeting(@RequestParam(name="curDt", required=false, defaultValue="2022-01-01") String name, 
			@RequestParam(name="addDays", required=false, defaultValue="30") String addDays,
            @RequestParam(name="selMonth", required=false, defaultValue="") String selMonth,
			Model model) {
		LocalDate now = LocalDate.parse(name);
		LocalDate nxt = now.plusDays(Integer.parseInt(addDays));
		System.out.println("New date: " + nxt.toString());
        String[] monthsArr = { "January", "February" };
        List<String> months = Arrays.asList(monthsArr);

        // add attributes to display in screen.
        model.addAttribute("selMonth", selMonth);
        model.addAttribute("months", months);
        model.addAttribute("curDt", now.toString());
		model.addAttribute("addDays", addDays);
		model.addAttribute("nxtDt", nxt.toString());

		return "datecalculator";
	}

}
