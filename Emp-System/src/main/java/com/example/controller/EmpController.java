package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Employee;
import com.example.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	
		@Autowired
		private EmpService service;
		
		@GetMapping("/")
		public String home(Model m)
		{
			List<Employee> emp=service.getAllEmp();
			m.addAttribute("emp",emp);
		return "index";
		}

		@GetMapping("/form")
		public String addemp()
	
		{
			return "form";
		}
	
		@PostMapping("/register")
		public String empRegister(@ModelAttribute Employee e,HttpSession session)
		{
			
			System.out.println(e);
			service.addemp(e);
			session.setAttribute("msg","Employee added successfully");
			return "redirect:/";
		}
		
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable int id, Model m) {
			Employee e = service.getEMpById(id);
			m.addAttribute("emp", e);
			return "edit";
		}
		
		@PostMapping("/update")
		public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
			service.addemp(e);
			session.setAttribute("msg", "Employee data updated sucessfully");
			return "redirect:/";
		}
		
		
		
		  @GetMapping("/delete/{id}") public String deleteEMp(@PathVariable int id,
		  HttpSession session) {
		  
		  service.deleteemp(id); session.setAttribute("msg",
		 "Employee data deleted sucessfully"); return "redirect:/"; }
		 
		 

		
}


