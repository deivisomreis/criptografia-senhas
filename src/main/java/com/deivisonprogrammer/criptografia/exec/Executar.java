package com.deivisonprogrammer.criptografia.exec;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.deivisonprogrammer.criptografia.dao.UserDAO;
import com.deivisonprogrammer.criptografia.model.User;

public class Executar {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {		
		UserDAO userDAO = new UserDAO();
		
		boolean statusLogin = userDAO.login("deivisomreis@gmail.com", "01021990");
		
		System.out.println(statusLogin ? "Usuario existente" : "Usuario não existe!");
	}
}
