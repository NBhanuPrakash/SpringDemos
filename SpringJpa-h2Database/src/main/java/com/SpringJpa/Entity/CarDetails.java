package com.SpringJpa.Entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CarDetails {
	
	@jakarta.persistence.Id
	private String carId;
	
	private String carName;
	
	private String carColor;
	
	private int carPrice;

}
