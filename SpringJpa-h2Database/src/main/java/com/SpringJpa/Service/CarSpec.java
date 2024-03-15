package com.SpringJpa.Service;

import java.util.List;

import com.SpringJpa.Dto.CarDetailsDto;

public interface CarSpec {
	
	public String createCarDetails(CarDetailsDto carDetailsDto);
	
	public List<CarDetailsDto> listOCars();
	
	public CarDetailsDto getById(String carId);
	
	public String carUpdate(CarDetailsDto carDetails);
	
	public String deleteCarDetails(String carId);

}
