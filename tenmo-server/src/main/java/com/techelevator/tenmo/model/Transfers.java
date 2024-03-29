package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfers {

    private long transferId;

    private int receiverId;

    private BigDecimal transferAmount;

    private int senderId;

    private String transferTypeId;

    private String transferStatusId;

    private String transferFromName;

    private String transferToName;


    public Transfers(){ }


    public long getTransferId() {
        return transferId;
    }

    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(String transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public String getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(String transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public String getTransferFromName() {
        return transferFromName;
    }

    public void setTransferFromName(String transferFromName) {
        this.transferFromName = transferFromName;
    }

    public String getTransferToName() {
        return transferToName;
    }

    public void setTransferToName(String transferToName) {
        this.transferToName = transferToName;
    }

    @Override
    public String toString() {
        return "Transfers{" +
                "receiverId=" + receiverId +
                ", transferAmount=" + transferAmount +
                ", senderId=" + senderId +
                '}';
    }
}
