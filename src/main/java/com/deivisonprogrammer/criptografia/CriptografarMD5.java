package com.deivisonprogrammer.criptografia;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografarMD5 {

	public static String criptografarSenha(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		if(text != null && !text.isEmpty()){
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] algoritmo = md5.digest(text.getBytes("UTF-8"));
			
			String senha = new String(algoritmo, "UTF-8");
			
			return senha;
		}
		
		else
			return null;
	}

}
