package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Transfer mapRowToTransfer(SqlRowSet rs) {
        Transfer transfer=new Transfer();
        transfer.setTransfer_id(rs.getInt("transfer_id"));
        transfer.setTransfer_type_id(rs.getInt("transfer_type_id"));
        transfer.setTransfer_status_id(rs.getInt("transfer_status_id"));
        transfer.setAccount_from(rs.getInt("account_from"));
        transfer.setAccount_to(rs.getInt("account_to"));
        transfer.getAmount(rs.getBigDecimal("amount"));
        return transfer;
    }


    @Override
    public List<Transfer> allTransfers(int user_id) {
        List<Transfer> allTransfersByUserId=new ArrayList<>();
        String sql = "SELECT * FROM transfers JOIN accounts ON accounts.account_id = transfers.account_from WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user_id);
        while(results.next()){
            Transfer transfer =mapRowToTransfer(results);
            allTransfersByUserId.add(transfer);
        }
        return allTransfersByUserId;
    }


    @Override
    public List<Transfer> viewTransfers(int transfer_id) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfers WHERE transfer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transfer_id);
        while(results.next()) {
            Transfer transfer = mapRowToTransfer(results);
            transfers.add(transfer);
        }
        return transfers;
    }

    @Override
    public BigDecimal addMoney(int account_from, int account_to, BigDecimal amount) {

         String sql = "UPDATE accounts SET balance = ? WHERE user_id = ?";


        return null;
    }

    @Override
    public BigDecimal subtractMoney() {
        return null;
    }

}



