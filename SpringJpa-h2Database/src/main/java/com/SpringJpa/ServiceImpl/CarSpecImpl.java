package com.SpringJpa.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringJpa.Builder.EntityToDTOConvert;
import com.SpringJpa.Dto.CarDetailsDto;
import com.SpringJpa.Entity.CarDetails;
import com.SpringJpa.Repo.CarRepository;
import com.SpringJpa.Service.CarSpec;

@Service
public class CarSpecImpl implements CarSpec {
	
	@Autowired
	CarRepository carRepository;
	


	@Override
	public String createCarDetails(CarDetailsDto carDetailsDto) {
		carDetailsDto.setCarId(UUID.randomUUID().toString().split("-")[0]);
		CarDetails dtotoEntity = EntityToDTOConvert.dtotoEntity(carDetailsDto);
		carRepository.save(dtotoEntity);
		return "Created";
	}

	@Override
	public List<CarDetailsDto> listOCars() {
		 List<CarDetails> findAll = carRepository.findAll();
		List<CarDetailsDto> entityToDtolist = EntityToDTOConvert.entityToDtolist(findAll);
		return entityToDtolist;
	}

	@Override
	public CarDetailsDto getById(String carId) {
		CarDetails carDetails = carRepository.findById(carId).get();
		CarDetailsDto entityToDto = EntityToDTOConvert.entityToDto(carDetails);
		return entityToDto;
	}

	@Override
	public String carUpdate(CarDetailsDto carDetailsDto) {
		CarDetails carDetails2 = carRepository.findById(carDetailsDto.getCarId()).get();
		if (carDetails2!=null) {
			carDetails2.setCarName(carDetailsDto.getCarName());
			carDetails2.setCarColor(carDetailsDto.getCarColor());
			carDetails2.setCarPrice(carDetailsDto.getCarPrice());
			carRepository.save(carDetails2);
		}
		
		return "Updated";
	}

	@Override
	public String deleteCarDetails(String carId) {
		carRepository.deleteById(carId);
		return carId+" car details are deleted " ;
	}

}
