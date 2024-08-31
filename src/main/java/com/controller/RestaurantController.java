package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.RestaurantEntity;
import com.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;

	@GetMapping("/newrestaurant")
	public String newrestro() {

		return "NewResturant";
	}

	@PostMapping("/saverestautant")
	public String saverestro(@Validated RestaurantEntity restaurantentity, BindingResult result, Model model) {

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("restaurant", restaurantentity);
			model.addAttribute("result", result);
			return "NewResturant";
		} else {
			restaurantRepository.save(restaurantentity);
			return "Success";
		}

	}

	@GetMapping("/listrestaurants")
	public String listrestro(Model model) {
		List<RestaurantEntity> restaurants = restaurantRepository.findAll();
		model.addAttribute("restaurants", restaurants);

		return "ListRestaurant";
	}

	@GetMapping("/deleterestaurant")
	public String deleterestro(@RequestParam int rid) {

		System.out.println(rid);
		restaurantRepository.deleteById(rid);

		return "redirect:/listrestaurants";
	}

	@GetMapping("/editrestaurant")
	public String editrestro(@RequestParam int id, Model model) {

		System.out.println(id);
		Optional<RestaurantEntity> restaurants = restaurantRepository.findById(id);

		if (restaurants.isEmpty()) {
			return "Error";
		} else {
			model.addAttribute("restaurants", restaurants.get());
			return "EditRestaurant";
		}
	}

	@PostMapping("/editrestaurant")
	public String editedrestro(RestaurantEntity restroentity) {
		restaurantRepository.save(restroentity);
		return "redirect:/listrestaurants";
	}

}
