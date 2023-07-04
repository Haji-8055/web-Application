package com.xworkz.project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.project.entity.CarsEntity;
import com.xworkz.project.entity.ProjectEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CarsRepositoryImpl implements CarsRepository {
	
	@Autowired
	EntityManagerFactory factory;

	@Override
	public boolean save(CarsEntity entity) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;

	}

	@Override
	public List<CarsEntity> findCar(String param ,int id) {
		
		log.info("running findCar in ProjectRepositoryImpl.....");

		EntityManager manager = this.factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("onSearchCar");
			query.setParameter("param", param);
			query.setParameter("id", id);
			List<CarsEntity> list = query.getResultList();
			log.info("total list found in repo " + list.size());

			return list;
		} finally {
			manager.close();
		}
	}

}
