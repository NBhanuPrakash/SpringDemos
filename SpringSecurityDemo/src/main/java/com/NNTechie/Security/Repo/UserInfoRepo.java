package com.NNTechie.Security.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NNTechie.Security.Entity.User;

@Repository
public interface UserInfoRepo extends JpaRepository<User, String> {

	Optional<com.NNTechie.Security.Entity.User> findByEmail(String username);

}
