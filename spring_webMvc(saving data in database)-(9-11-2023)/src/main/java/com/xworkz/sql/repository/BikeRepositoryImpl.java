package com.xworkz.sql.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.sql.dto.BikeDTO;

@Repository
public class BikeRepositoryImpl implements BikeRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public BikeRepositoryImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(BikeDTO dto) {
		System.out.println("running save method of BikeRepositoryImpl..........");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(dto);
		entityTransaction.commit();
		entityManager.close();
		return true;
	}

	
}
