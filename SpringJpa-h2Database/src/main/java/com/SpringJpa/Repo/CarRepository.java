package com.SpringJpa.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringJpa.Entity.CarDetails;

@Repository
public interface CarRepository extends JpaRepository<CarDetails, String> {

}
