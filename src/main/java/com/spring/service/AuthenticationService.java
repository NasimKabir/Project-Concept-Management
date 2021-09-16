package com.spring.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.http.ResponseEntity;

import com.spring.resquest.LoginRequest;

public interface AuthenticationService {

	public ResponseEntity<?> login(LoginRequest loginRequest) throws InvalidKeySpecException, NoSuchAlgorithmException;

}
