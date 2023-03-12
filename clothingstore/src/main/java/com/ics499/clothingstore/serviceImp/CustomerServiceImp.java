package com.ics499.clothingstore.serviceImp;

import java.util.List;
import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import com.ics499.clothingstore.model.Customer;
import com.ics499.clothingstore.service.CustomerService;

public class CustomerServiceImp implements CustomerService{

	private EntityManagerFactory emf = new EntityManagerFactory() {
		
		@Override
		public <T> T unwrap(Class<T> cls) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean isOpen() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Map<String, Object> getProperties() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public PersistenceUnitUtil getPersistenceUnitUtil() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Metamodel getMetamodel() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public CriteriaBuilder getCriteriaBuilder() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Cache getCache() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public EntityManager createEntityManager(SynchronizationType synchronizationType, Map map) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public EntityManager createEntityManager(SynchronizationType synchronizationType) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public EntityManager createEntityManager(Map map) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public EntityManager createEntityManager() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void close() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void addNamedQuery(String name, Query query) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public <T> void addNamedEntityGraph(String graphName, EntityGraph<T> entityGraph) {
			// TODO Auto-generated method stub
			
		}
	};
	EntityManager em = emf.createEntityManager();
	
	@Override
	public boolean isValid(String username, String password) {
		// TODO Auto-generated method stub
		
		//int customer = em.createQuery("SELECT Customer from Customer customer where customer.id = ?id").getFirstResult();
		System.out.println("Test Validation");
		/*
		 * logic- 
		 * 
		 * if ((Customer.getPassword.equals(password)&&(customer.getUsername = username))
		 * return true;
		 */		
		return false;
	}

}
