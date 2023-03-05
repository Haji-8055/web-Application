package com.xworkz.query.boot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.query.entity.ForestEntity;

public class StoreDataRunner {

	public static void main(String[] args) {

		ForestEntity entity1 = new ForestEntity(1, "Sundarbans", "West Bengal", "3260km^2", "Tropical evergreen");
		ForestEntity entity2 = new ForestEntity(2, "Annekal Reserved Forest", "Western Ghats", "666km^2", "Thorny bushes");
		ForestEntity entity3 = new ForestEntity(3, "Baikunthapur Forest", "West Bengal", "774km^2", "deciduous forest");
		ForestEntity entity4 = new ForestEntity(4, "Bandipur", "Karnataka", "874km^2", "Tiger Reserves");
		ForestEntity entity5 = new ForestEntity(5, "Bhitarkanika	", "West Bengal", "874km^2", "Mangrove");
		ForestEntity entity6 = new ForestEntity(6, "Bondla", "goa", "8km^2", "Thorny bushes");
		ForestEntity entity7 = new ForestEntity(7, "Gir National Park", "Gujarat", "1412km^2", "deciduous forest");
		ForestEntity entity8 = new ForestEntity(8, "Kanha", "Madhya Pradesh", "874km^2", "Mangrove");
		ForestEntity entity9 = new ForestEntity(9, "Shettihalli", "karnataka", "395km^2", "Thorny bushes");
		ForestEntity entity10 = new ForestEntity(10, "Tadoba", "maharashtra", "174km^2", "Tropical evergreen");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
//		manager.persist(entity1);
		manager.persist(entity2);
		manager.persist(entity3);
		manager.persist(entity4);
		manager.persist(entity5);
		manager.persist(entity6);
		manager.persist(entity7);
		manager.persist(entity8);
		manager.persist(entity9);
		manager.persist(entity10);
		transaction.commit();
		manager.close();
	}

}
