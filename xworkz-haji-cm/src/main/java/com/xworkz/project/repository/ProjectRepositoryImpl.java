package com.xworkz.project.repository;

import java.time.LocalTime;
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
		log.info("running save in ProjectRepositoryImpl.....");

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;

	}

	@Override
	public List<ProjectEntity> fetchAllEntities() {
		log.info("running fetchAllEntities in ProjectRepositoryImpl.....");

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

	@Override
	public ProjectEntity findByUserID(String userId) {

		log.info("running findByUserID in ProjectRepositoryImpl.....");

		EntityManager manager = this.factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("SignInCheck");
			query.setParameter("user", userId);
			Object obj = query.getSingleResult();
			ProjectEntity entity = (ProjectEntity) obj;

			return entity;
		} catch (Exception e) {
			log.info("no data found for !!!!!" + userId);
			return null;
		}

		finally {
			manager.close();
		}

	}

	@Override
	public boolean updateEntity(ProjectEntity entity) {
		log.info("running updateEntity in ProjectRepositoryImpl.....");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public void expireOTP() {

//		log.info("running expireOTP in ProjectRepositoryImpl.....");

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createNamedQuery("expireOTP");
		query.setParameter("boolean", true);
		query.setParameter("currentTime", LocalTime.now());
		query.executeUpdate();
		transaction.commit();
		manager.close();

	}

	@Override
	public ProjectEntity findByEmailId(String email) {
		log.info("running findByEmailId in ProjectRepositoryImpl.....");

		EntityManager manager = this.factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByEmailId");
			query.setParameter("email", email);
			Object obj = query.getSingleResult();
			ProjectEntity entity = (ProjectEntity) obj;

			return entity;
		} catch (Exception e) {
			log.info("no data found for !!!!!" + email);
			return null;
		}

		finally {
			manager.close();
		}

	}

}
