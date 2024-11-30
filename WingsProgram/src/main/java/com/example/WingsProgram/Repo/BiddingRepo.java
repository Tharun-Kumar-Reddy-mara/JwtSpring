package com.example.WingsProgram.Repo;

import com.example.WingsProgram.Model.BiddingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiddingRepo extends JpaRepository<BiddingModel,Integer> {
    BiddingRepo findByBidAmountGreaterThan(double bidAmount);
}
