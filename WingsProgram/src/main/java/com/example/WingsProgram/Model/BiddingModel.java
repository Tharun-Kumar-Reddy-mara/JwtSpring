package com.example.WingsProgram.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiddingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private int biddingId;

    private final String projectName = "Metro Phase V 2024";

    private double bidAmount;
    private double yearsToComplete;
    private String dateOfBidding;
    private String status = "pending";
    private int bidderId;

    public BiddingModel(int biddingId, double bidAmount, double yearsToComplete, String dateOfBidding, int bidderId) {
        this.biddingId = biddingId;
        this.bidAmount = bidAmount;
        this.yearsToComplete = yearsToComplete;
        this.dateOfBidding = dateOfBidding;
        this.bidderId = bidderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBiddingId() {
        return biddingId;
    }

    public void setBiddingId(int biddingId) {
        this.biddingId = biddingId;
    }

    public String getProjectName() {
        return projectName;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public double getYearsToComplete() {
        return yearsToComplete;
    }

    public void setYearsToComplete(double yearsToComplete) {
        this.yearsToComplete = yearsToComplete;
    }

    public String getDateOfBidding() {
        return dateOfBidding;
    }

    public void setDateOfBidding(String dateOfBidding) {
        this.dateOfBidding = dateOfBidding;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBidderId() {
        return bidderId;
    }

    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }

    @Override
    public String toString() {
        return "BiddingModel{" +
                "id=" + id +
                ", biddingId=" + biddingId +
                ", projectName='" + projectName + '\'' +
                ", bidAmount=" + bidAmount +
                ", yearsToComplete=" + yearsToComplete +
                ", dateOfBidding='" + dateOfBidding + '\'' +
                ", status='" + status + '\'' +
                ", bidderId=" + bidderId +
                '}';
    }
}
