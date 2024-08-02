package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.mvc;
import com.example.demo.repository.mvc_repository;

import jakarta.servlet.http.HttpSession;

@Controller 
//data flow from html file

public class mvc_controllers {
	@Autowired
	mvc_repository repo;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/")
	public String getall(Model m) {
		List<mvc> li = (List<mvc>) repo.findAll();
		m.addAttribute("add-products",li);
		return "home";
		
	}
	@GetMapping("/getbyid/{id}")
	public String getbyid(@PathVariable(value="id") int id,Model m) {
		Optional<mvc> c = repo.findById(id);
		mvc v =c.get();
		m.addAttribute("products",v);
		return "edit";
		
	}
	@PostMapping("/save_products")
	public String insert(@ModelAttribute mvc mc, HttpSession hs) {  //httpsession is jstl for popups
		repo.save(mc);
		hs.setAttribute("message", "successfully added");
		return "redirect:/load";
		
	}
	@PutMapping("/update")
	public String edit(@ModelAttribute mvc m,HttpSession hs) {
		repo.save(m);
		hs.setAttribute("message", "successfully updated");
		return "redirect:/";
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable (value="id") int id,HttpSession hs) {
		repo.deleteById(id);
		hs.setAttribute("message", "successfull deleted");
		return "redirect:/";
	}
	
	@GetMapping("/load")
	public String load() {
		return "add";
		
	}
}
