package com.xworkz.query.boot;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.query.entity.ForestEntity;

public class QueryRunner {

	public static void main(String[] args) {
		
		
		EntityManager entityManager=Persistence.createEntityManagerFactory("com.xworkz").createEntityManager();
		System.out.println("=====================================findByName=====================================");
		Query query1=entityManager.createNamedQuery("findByName");
		Object object1=query1.getSingleResult();
		ForestEntity entity1=(ForestEntity)object1;
		System.out.println("\n"+entity1);
		
		
		System.out.println("=====================================findByState=====================================");
		Query query2=entityManager.createNamedQuery("findByState");
		Object object2=query2.getSingleResult();
		ForestEntity entity2=(ForestEntity)object2;
		System.out.println("\n"+entity2);
		

		System.out.println("=====================================findByNameAndStateAndArea=====================================");
		Query query3=entityManager.createNamedQuery("findByNameAndStateAndArea");
		Object object3=query3.getSingleResult();
		ForestEntity entity3=(ForestEntity)object3;
		System.out.println("\n"+entity3);
	
		
		System.out.println("=====================================findAreaByName=====================================");
		Query query4=entityManager.createNamedQuery("findAreaByName");
		Object object4=query4.getSingleResult();
		String findAreaByName=(String)object4;
		System.out.println("\n"+findAreaByName);
		
		System.out.println("=====================================findIdByNameAndState=====================================");
		Query query5=entityManager.createNamedQuery("findIdByNameAndState");
		Object object5=query5.getSingleResult();
		int findIdByNameAndState=(int)object5;
		System.out.println("\n"+findIdByNameAndState);
		
		
		System.out.println("=====================================findNameById=====================================");
		Query query6=entityManager.createNamedQuery("findNameById");
		Object object6=query6.getSingleResult();
		String findNameById=(String)object6;
		System.out.println("\n"+findNameById);
		
		
		
		System.out.println("=====================================findStateByNameAndArea=====================================");
		Query query7=entityManager.createNamedQuery("findStateByNameAndArea");
		Object object7=query7.getSingleResult();
		String findStateByNameAndArea=(String)object7;
		System.out.println("\n"+findStateByNameAndArea);
		
		System.out.println("=====================================findCount=====================================");
		Query query8=entityManager.createNamedQuery("findCount");
		Object object8=query8.getSingleResult();
		long findCount=(long)object8;
		System.out.println("\n"+findCount);
		
		entityManager.close();
	}
}
