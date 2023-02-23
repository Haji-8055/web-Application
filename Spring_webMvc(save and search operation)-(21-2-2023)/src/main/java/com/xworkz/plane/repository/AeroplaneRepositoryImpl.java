package com.xworkz.plane.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.plane.entity.AeroplaneEntity;

@Repository
public class AeroplaneRepositoryImpl implements AeroplaneRepository {

	public AeroplaneRepositoryImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean save(AeroplaneEntity entity) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(entity);
		entityTransaction.commit();
		entityManager.close();

		return true;

	}

	@Override
	public AeroplaneEntity findById(int id) {

		System.out.println("find by id in method of repo.......... ");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		AeroplaneEntity fromDb = entityManager.find(AeroplaneEntity.class, id);
		entityManager.close();
		return fromDb;

	}

}
