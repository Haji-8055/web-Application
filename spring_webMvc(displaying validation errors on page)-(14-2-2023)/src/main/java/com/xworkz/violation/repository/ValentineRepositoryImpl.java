package com.xworkz.violation.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.violation.entity.ValentineEntity;

@Repository
public class ValentineRepositoryImpl implements ValentineRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ValentineRepositoryImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(ValentineEntity entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(entity);
		entityTransaction.commit();
		entityManager.close();

		return true;
	}

	@Override
	public ValentineEntity findById(int id) {

		System.out.println("find by id in method of repo.......... ");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ValentineEntity fromDb = entityManager.find(ValentineEntity.class, id);
		entityManager.close();
		return fromDb;
	}

}
