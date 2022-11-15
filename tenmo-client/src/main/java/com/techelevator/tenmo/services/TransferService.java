package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class TransferService {
    public static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser currentUser;

    public TransferService(AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
    }

    public TransferService() {
    }

    public List<Transfer> transferList(){
        List<Transfer> allTransfersByUser =null;
        allTransfersByUser= restTemplate.getForObject(API_BASE_URL + "transfers/" + currentUser.getUser().getId(), List.class);
        System.out.println(Arrays.asList(allTransfersByUser));
        return allTransfersByUser;
    }

    private HttpEntity<Transfer> makeEntity(Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(transfer, headers);
    }

      /* List all reservations by hotel id.

    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            ResponseEntity<Reservation[]> response =
                    restTemplate.exchange(API_BASE_URL + "hotels/" + hotelId + "/reservations",
                            HttpMethod.GET, makeAuthEntity(), Reservation[].class);
            reservations = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }*/

}
