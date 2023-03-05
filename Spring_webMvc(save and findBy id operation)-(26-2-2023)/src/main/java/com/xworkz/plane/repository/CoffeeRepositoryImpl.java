package com.xworkz.plane.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.plane.entity.CoffeeEntity;

@Repository
public class CoffeeRepositoryImpl implements CoffeeRepository {

	public CoffeeRepositoryImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean save(CoffeeEntity entity) {
		

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(entity);
		entityTransaction.commit();
		entityManager.close();

		return true;

	}

	@Override
	public CoffeeEntity findById(int id) {

		System.out.println("find by id in method of repo.......... ");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CoffeeEntity fromDb = entityManager.find(CoffeeEntity.class, id);
		entityManager.close();
		return fromDb;

	}

	@Override
	public List<CoffeeEntity> findByCompanyName(String company) {
		System.out.println("running findByCompanyName in repository......");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("findByCompany");
		query.setParameter("com", company);
		List<CoffeeEntity> entities = query.getResultList();
		return entities;
	}

	@Override
	public boolean update(CoffeeEntity entity) {
		System.out.println("running update method in repository...........");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(entity);
		entityTransaction.commit();
		entityManager.close();
		return true;

	}

	@Override
	public boolean deleteById(int id) {

		System.out.println("running delete by id method in repository...........");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			CoffeeEntity entity = entityManager.find(CoffeeEntity.class, id);

			entityTransaction.begin();
			entityManager.remove(entity);
			entityTransaction.commit();
			System.out.println("deleting entity : " + entity);

		} finally {
			entityManager.close();
		}

		return true;
	}

}
