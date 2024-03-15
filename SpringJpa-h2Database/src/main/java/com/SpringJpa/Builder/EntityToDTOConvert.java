package com.SpringJpa.Builder;

import java.util.ArrayList;
import java.util.List;

import com.SpringJpa.Dto.CarDetailsDto;
import com.SpringJpa.Entity.CarDetails;

public class EntityToDTOConvert {
	
	public static CarDetails dtotoEntity(CarDetailsDto carDetailsDto) {
		CarDetails carDetails = new CarDetails();
		carDetails.setCarId(carDetailsDto.getCarId());
		carDetails.setCarName(carDetailsDto.getCarName());
		carDetails.setCarColor(carDetailsDto.getCarColor());
		carDetails.setCarPrice(carDetailsDto.getCarPrice());
		return carDetails;
	}

	public static CarDetailsDto entityToDto(CarDetails carDetails) {
		CarDetailsDto carDetailsDto = new CarDetailsDto();
		carDetailsDto.setCarId(carDetails.getCarId());
		carDetailsDto.setCarName(carDetails.getCarName());
		carDetailsDto.setCarColor(carDetails.getCarColor());
		carDetailsDto.setCarPrice(carDetails.getCarPrice());
		return carDetailsDto;
	}
	
	public static List<CarDetailsDto> entityToDtolist(List<CarDetails> carDetails) {
		List<CarDetailsDto> list = new ArrayList<>();

		for (CarDetails carDetails2 : carDetails) {
			CarDetailsDto carDetailsDto = new CarDetailsDto();
			carDetailsDto.setCarId(carDetails2.getCarId());
			carDetailsDto.setCarName(carDetails2.getCarName());
			carDetailsDto.setCarColor(carDetails2.getCarColor());
			carDetailsDto.setCarPrice(carDetails2.getCarPrice());
			list.add(carDetailsDto);
		}
		return list;
	}

}
