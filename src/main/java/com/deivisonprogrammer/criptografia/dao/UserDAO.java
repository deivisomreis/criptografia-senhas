package com.deivisonprogrammer.criptografia.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.deivisonprogrammer.criptografia.CriptografarMD5;
import com.deivisonprogrammer.criptografia.connection.ConnectionFactory;
import com.deivisonprogrammer.criptografia.model.User;

public class UserDAO {
	
	private EntityManager manager;
	
	public void insert(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		if(user != null){
			manager = ConnectionFactory.getEntityManager();
			
			user.setSenha(CriptografarMD5.criptografarSenha(user.getSenha()));
			
			try{
				manager.getTransaction().begin();
				manager.persist(user);
				manager.getTransaction().commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				manager.close();
			}
		}
	}
	
	public boolean login(String email, String senha){
		if(email != null && !email.isEmpty() && senha != null && !senha.isEmpty()){
			manager = ConnectionFactory.getEntityManager();
			
			try{
				Query query = manager.createQuery("from User where email=:email and senha=:senha");
				query.setParameter("email", email);
				query.setParameter("senha", CriptografarMD5.criptografarSenha(senha));
				
				if(query.getSingleResult() != null)
					return true;
				
				else
					return false;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				manager.close();
			}
		}
		
		return false;
	}
}
