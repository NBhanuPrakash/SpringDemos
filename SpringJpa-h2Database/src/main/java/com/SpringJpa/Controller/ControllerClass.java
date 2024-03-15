package com.SpringJpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJpa.Dto.CarDetailsDto;
import com.SpringJpa.Service.CarSpec;


@RestController
@RequestMapping("/h2datbase/")
public class ControllerClass {

	@Autowired
	CarSpec carSpec;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createData(@RequestBody CarDetailsDto carDetailsDto) {
		String createCarDetails = carSpec.createCarDetails(carDetailsDto);
		return createCarDetails;
	}

	@GetMapping
	public List<CarDetailsDto> listOfCars() {
		List<CarDetailsDto> listOCars = carSpec.listOCars();
		return listOCars;
	}

	@GetMapping("/{carId}")
	public CarDetailsDto getById(@PathVariable String carId) {
		CarDetailsDto byId = carSpec.getById(carId);
		return byId;
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public String updateData(@RequestBody CarDetailsDto carDetailsDto) {
		String carUpdate = carSpec.carUpdate(carDetailsDto);
		return carUpdate;
	}
	
	@DeleteMapping("/detele/{carId}")
	public String deleteData(@PathVariable String carId) {
		String deleteCarDetails = carSpec.deleteCarDetails(carId);
		return deleteCarDetails;
	}

}
