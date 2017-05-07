package com.restaurant.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.restaurant.spring.entity.NonVeg;
import com.restaurant.spring.entity.User;
import com.restaurant.spring.entity.Veg;
import com.restaurant.spring.service.RestaurantService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(RedirectAttributes attr){
		attr.addFlashAttribute("loggedOut","you have been logged out");
		return "redirect:/restaurant/login";
	}

	@RequestMapping(value = "/food", method = { RequestMethod.GET, RequestMethod.POST })
	public String food(User user, RedirectAttributes attr) {
		if (restaurantService.isVerified(user)){
			if (restaurantService.isAdmin(user))
				return "redirect:/restaurant/adminLoginManager";
			else
				return "food";
		}else
			attr.addFlashAttribute("loginErrorMessage", " please check username and password");
			return "redirect:/restaurant/login";
	}

	@GetMapping("/food/veg")
	public String veg(Model model) {
		model.addAttribute("vegitems", restaurantService.getAllVeg());
		return "veg";
	}

	@GetMapping("/food/nonveg")
	public String nonVeg(Model model) {
		model.addAttribute("nonvegitems", restaurantService.getAllNonVeg());
		return "non-veg";
	}

	@GetMapping("/adminLoginManager")
	public String adminLoginManager() {
		return "admin-login-manager";
	}

	@GetMapping("/adminLoginManager/users")
	public String list(Model model) {
		model.addAttribute("users", restaurantService.getUsers());
		return "admin-login-manager-users";
	}

	@GetMapping("/adminLoginManager/users/add")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "add-user";
	}

	@GetMapping("/add")
	public String addUserSignup(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "add-user-signup";
	}

	@PostMapping("/signup/save")
	public String saveUserSignup(@Valid @ModelAttribute("user") User user, BindingResult binding,
			RedirectAttributes attr) {
		if (binding.hasErrors())
			return "add-user-signup";
		else if (restaurantService.doesUserNameExist(user)) {
			attr.addFlashAttribute("username", user.getUserName()).addFlashAttribute("message",
					" already exists. Please enter a different username");
			return "redirect:/restaurant/add";
		} else
			restaurantService.saveUser(user);
		attr.addFlashAttribute("username", user.getUserName()).addFlashAttribute("message",
				" created successfully. Please Login");
		return "redirect:/restaurant/login";
	}

	@PostMapping("/adminLoginManager/users/save")
	public String saveUser(@ModelAttribute("user") User user) {
		restaurantService.saveUser(user);
		return "redirect:/restaurant/adminLoginManager/users";
	}

	@GetMapping("/adminLoginManager/users/update")
	public String updateUser(@RequestParam("userId") int id, Model model) {
		User user = restaurantService.getUser(id);
		model.addAttribute("user", user);
		return "add-user";
	}

	@GetMapping("/adminLoginManager/users/delete")
	public String deleteUser(@RequestParam("userId") int id) {
		restaurantService.deleteUser(id);
		return "redirect:/restaurant/adminLoginManager/users";
	}

	@GetMapping("/adminLoginManager/veg")
	public String adminManageVeg(Model model) {
		model.addAttribute("veg", restaurantService.getAllVeg());
		return "admin-login-manager-veg";
	}

	@GetMapping("/adminLoginManager/veg/add")
	public String addVeg(Model model) {
		Veg veg = new Veg();
		model.addAttribute("veg", veg);
		return "add-veg";
	}

	@PostMapping("/adminLoginManager/veg/save")
	public String saveVeg(@ModelAttribute("veg") Veg veg) {
		restaurantService.saveVeg(veg);
		return "redirect:/restaurant/adminLoginManager/veg";
	}

	@GetMapping("/adminLoginManager/veg/update")
	public String updateVeg(@RequestParam("vegId") int id, Model model) {
		Veg veg = restaurantService.getVeg(id);
		model.addAttribute("veg", veg);
		return "add-veg";
	}

	@GetMapping("/adminLoginManager/veg/delete")
	public String deleteVeg(@RequestParam("vegId") int id) {
		restaurantService.deleteVeg(id);
		return "redirect:/restaurant/adminLoginManager/veg";
	}

	@GetMapping("/adminLoginManager/nonVeg")
	public String adminManageNonVeg(Model model) {
		model.addAttribute("nonveg", restaurantService.getAllNonVeg());
		return "admin-login-manager-non-veg";
	}

	@GetMapping("/adminLoginManager/nonVeg/add")
	public String addNonVeg(Model model) {
		NonVeg nonVeg = new NonVeg();
		model.addAttribute("nonveg", nonVeg);
		return "add-non-veg";
	}

	@PostMapping("/adminLoginManager/nonVeg/save")
	public String saveNonVeg(@ModelAttribute("nonveg") NonVeg nonVeg) {
		restaurantService.saveNonVeg(nonVeg);
		return "redirect:/restaurant/adminLoginManager/veg";
	}

	@GetMapping("/adminLoginManager/nonVeg/update")
	public String updateNonVeg(@RequestParam("nonVegId") int id, Model model) {
		NonVeg nonVeg = restaurantService.getNonVeg(id);
		model.addAttribute("nonveg", nonVeg);
		return "add-non-veg";
	}

	@GetMapping("/adminLoginManager/nonVeg/delete")
	public String deleteNonVeg(@RequestParam("nonVegId") int id) {
		restaurantService.deleteNonVeg(id);
		return "redirect:/restaurant/adminLoginManager/nonVeg";
	}

}
