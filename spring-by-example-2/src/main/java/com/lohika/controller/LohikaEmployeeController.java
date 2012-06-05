package com.lohika.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lohika.domain.LohikaEmployee;
import com.lohika.service.PersistenceService;

@Controller
@RequestMapping("/employee/")
public class LohikaEmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(LohikaEmployeeController.class);

	@Resource
	private PersistenceService<LohikaEmployee, Long> lohikaEmployeeService;

	@RequestMapping(method = RequestMethod.GET, value = "list")
	public ModelAndView listLohikaEmployees() {
		logger.debug("Received request to list persons");
		ModelAndView mav = new ModelAndView();
		List<LohikaEmployee> lohikaEmployeeList = lohikaEmployeeService.find();

		logger.debug("Person Listing count = " + lohikaEmployeeList.size());

		mav.addObject("lohikaEmployeeList", lohikaEmployeeList);

		mav.setViewName("list");

		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "edit")
	public ModelAndView editEmployeeParam(@RequestParam(value = "id", required = false) Long id) {
		logger.debug("Received request to edit person id : " + id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("edit");
		LohikaEmployee lohikaEmployee = null;
		if (id == null) {
			lohikaEmployee = new LohikaEmployee();
		} else {
			lohikaEmployee = lohikaEmployeeService.find(id);
		}

		mav.addObject("lohikaEmployee", lohikaEmployee);
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "edit/{id}")
	public ModelAndView editEmployeePath(@PathVariable Long id) {
		logger.debug("Received request to edit person id : " + id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("edit");
		LohikaEmployee lohikaEmployee = null;
		if (id == null) {
			lohikaEmployee = new LohikaEmployee();
		} else {
			lohikaEmployee = lohikaEmployeeService.find(id);
			if (lohikaEmployee == null) {
				mav.setView(new RedirectView("/employee/edit"));
				return mav;
			}
		}

		mav.addObject("lohikaEmployee", lohikaEmployee);
		return mav;

	}

	@RequestMapping(method = RequestMethod.POST, value = "edit")
	public String savePerson(@Valid @ModelAttribute LohikaEmployee lohikaEmployee, BindingResult bindingResult) {
		logger.debug("Received postback on person " + lohikaEmployee);
		if (bindingResult.hasErrors()) {
			return "edit";
		} else {
			lohikaEmployeeService.saveOrUpdate(lohikaEmployee);
			return "redirect:list";
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "delete")
	public String deleteEmployeeParam(@RequestParam(value = "id", required = false) Long id) {
		logger.debug("Received request to delete person id : " + id);
		LohikaEmployee lohikaEmployee = lohikaEmployeeService.find(id);
		if (lohikaEmployee != null) {
			lohikaEmployeeService.delete(lohikaEmployee);
		}
		return "redirect:list";

	}

	@RequestMapping(method = RequestMethod.GET, value = "delete/{id}")
	public String deleteEmployeePath(@PathVariable Long id) {
		logger.debug("Received request to delete person id : " + id);
		LohikaEmployee lohikaEmployee = lohikaEmployeeService.find(id);
		if (lohikaEmployee != null) {
			lohikaEmployeeService.delete(lohikaEmployee);
		}
		return "redirect:list";

	}

}
