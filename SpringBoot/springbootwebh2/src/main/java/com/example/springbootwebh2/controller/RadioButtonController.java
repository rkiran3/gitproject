package com.example.springbootwebh2.controller;

import com.example.springbootwebh2.model.RadioButtonForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class RadioButtonController {

	@GetMapping("/radiobutton")
	public String showradiobutton(@ModelAttribute("radioButtonForm") RadioButtonForm radioButtonForm,
			Model model) {
        String[] monthsArr = { "January", "February" };
        List<String> months = Arrays.asList(monthsArr);
        if (radioButtonForm.selMonth == null) {
            radioButtonForm.selMonth = "January";
        }
        if (radioButtonForm.months == null) {
            radioButtonForm.months = months;
        }

        // add attributes to display in screen.
		model.addAttribute("radioButtonForm", radioButtonForm);
		return "radiobutton";
	}
}
