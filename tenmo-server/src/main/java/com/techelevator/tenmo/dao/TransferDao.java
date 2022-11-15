package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {
    List<Transfer> allTransfers(int account_id);

    public List<Transfer> viewTransfers(int transfer_id);

    BigDecimal addMoney();

    BigDecimal subtractMoney();

}
