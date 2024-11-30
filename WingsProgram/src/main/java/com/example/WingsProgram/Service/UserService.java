package com.example.WingsProgram.Service;

import com.example.WingsProgram.Model.BiddingModel;
import com.example.WingsProgram.Model.UserModel;
import com.example.WingsProgram.Repo.BiddingRepo;
import com.example.WingsProgram.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private BiddingRepo biddingRepo;

    @Autowired
    private UserRepo userRepo;



    public ResponseEntity<Object> postBidding(BiddingModel biddingModel){
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        if(biddingModel==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentails");
        }
        try{
            BiddingModel bModel = new BiddingModel(biddingModel.getBiddingId(),biddingModel.getBidAmount(),biddingModel.getYearsToComplete(),date,getBidderId());
            BiddingModel fModel = biddingRepo.save(bModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(fModel);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentails");
        }

    }

    private int getBidderId(){
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserModel user = userRepo.findByEmail(userDetails.getUsername());
            return user.getId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
