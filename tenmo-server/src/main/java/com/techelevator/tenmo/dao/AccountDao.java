package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

public interface AccountDao {

    public BigDecimal retrieveBalance(int userId);

    BigDecimal updateReceiverAccountBalance(int userId, BigDecimal transferAmount );

    BigDecimal updateSenderAccountBalance(int userId, BigDecimal transferAmount );
}
