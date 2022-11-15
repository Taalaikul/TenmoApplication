package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class AccountService {
    public static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser currentUser;

    public AccountService(AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
    }

    public AccountService() {

    }

    public BigDecimal getBalance() {
        BigDecimal balance = BigDecimal.valueOf(0.0);
        balance = restTemplate.getForObject(API_BASE_URL  + "accounts/balance/"+ currentUser.getUser().getId(), BigDecimal.class);
        System.out.println("Your current account balance is: " + balance);
        return balance;
    }


    private HttpEntity makeAuthEntity(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity entity = new HttpEntity(headers);
        return entity;
    }


}
