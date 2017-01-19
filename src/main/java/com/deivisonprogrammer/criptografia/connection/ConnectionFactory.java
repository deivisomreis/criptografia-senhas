package com.deivisonprogrammer.criptografia.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	private static EntityManagerFactory factory;
	
	public static void startConnection(){
		if(factory == null || !factory.isOpen())
			factory = Persistence.createEntityManagerFactory("criptografarsenha");
	}
	
	public static void stopConnection(){
		if(factory != null && factory.isOpen())
			factory.close();
	}
	
	public static EntityManager getEntityManager(){
		startConnection();
		
		return factory.createEntityManager();
	}
}
