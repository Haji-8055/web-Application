package com.xworkz.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xworkz.boot.entity.BootAppEntity;

public interface BootAppRepo extends JpaRepository<BootAppEntity, Integer> {

}
