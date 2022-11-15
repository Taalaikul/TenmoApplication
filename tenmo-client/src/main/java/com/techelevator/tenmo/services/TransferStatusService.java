package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.TransferStatus;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class TransferStatusService {
    public static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser currentUser;

    public TransferStatusService(AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
    }

    public List<TransferStatus> pendingRequests (){
        List<TransferStatus> pendingRequestsByUser = null;
        pendingRequestsByUser = restTemplate.getForObject(API_BASE_URL + "transferstatuses/"+ currentUser.getUser().getId(), List.class);
        System.out.println(Arrays.asList(pendingRequestsByUser));
        return pendingRequestsByUser;
    }
}
