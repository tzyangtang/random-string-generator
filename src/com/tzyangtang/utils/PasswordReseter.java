package com.tzyangtang.utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Base64;

public class PasswordReseter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reset();
	}

	public static void reset() {
		String salt = "-----------------";
		String newPwd = "-----------------";
		byte[] hash = null;
		try {
			hash = getHashedValue(Base64.decodeBase64(salt), newPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New hashed password: "
				+ Base64.encodeBase64String(hash));
	}

	private static byte[] getHashedValue(byte[] salt, String value)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeySpec spec = new PBEKeySpec(value.toCharArray(), salt, 65536, 128);
		SecretKeyFactory f = null;
		f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		// generate hashed password
		byte[] hash = null;
		hash = f.generateSecret(spec).getEncoded();
		return hash;
	}

}
