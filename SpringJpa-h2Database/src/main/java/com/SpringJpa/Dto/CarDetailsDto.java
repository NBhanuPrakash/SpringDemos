package com.SpringJpa.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDetailsDto {

	private String carId;

	private String carName;

	private String carColor;

	private int carPrice;

}
