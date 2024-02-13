package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfers;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Transfers mapRowToTransfer(SqlRowSet rs) {
        Transfers transfers = new Transfers();
        transfers.setTransferId(rs.getLong("transfer_id"));
        transfers.setSenderId(rs.getInt("account_from"));
        transfers.setReceiverId(rs.getInt("account_to"));
        transfers.setTransferAmount(rs.getBigDecimal("amount"));
        return transfers;
    }


    @Override
    public boolean addToTransfersTable(User accountFrom, User accountTo, BigDecimal amount) {
        return false;
    }

    @Override
    public List<Transfers> getTransferIdOfSender(String username) {
        return null;
    }

    @Override
    public List<Transfers> getTransferIdOfReceiver(String username) {
        return null;
    }
}



