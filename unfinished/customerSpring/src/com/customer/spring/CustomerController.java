package com.customer.spring;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model){
		model.addAttribute("customers",customerService.getCustomers());
		return "list-customers";
	}
	
	@GetMapping("/add")
	public String addCustomer(Model model){
		Customer customer=new Customer();
		model.addAttribute("customer", customer);		
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult binding){
		if(binding.hasErrors()){
			return "redirect:/customer/add";
		}else{
			customerService.saveCustomer(customer);
		return "redirect:/customer/list";
		}
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("customerId") int id, Model model){
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id){
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
}
