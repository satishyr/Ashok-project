package com.sai.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

	Optional<Doctor> findByName(String name);
	
	@Query(nativeQuery=true,value="select id,name,specialization from doctor")
	List<Doctor> findAllDoctors();
	
}
