package com.myorg.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myorg.ems.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//method Declaration
	public User findByEmail(String email);

}