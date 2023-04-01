 package com.xworkz.project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.project.entity.ProjectEntity;

import lombok.extern.slf4j.Slf4j;


@Repository
@Slf4j
public class ProjectRepositoryImpl implements ProjectRepository {
	
	@Autowired
	EntityManagerFactory factory;

	@Override
	public boolean save(ProjectEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;

	}

	@Override
	public List<ProjectEntity> uniqueCheck() {

		EntityManager manager = this.factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("fetchAll");
			List<ProjectEntity> list = query.getResultList();
			log.info("total list found in repo " + list.size());

			return list;
		} finally {
			manager.close();
		}
	}

}
