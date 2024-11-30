package com.example.WingsProgram.Controller;

import com.example.WingsProgram.Model.BiddingModel;
import com.example.WingsProgram.Model.UserModel;
import com.example.WingsProgram.Repo.BiddingRepo;
import com.example.WingsProgram.Repo.RoleRepo;
import com.example.WingsProgram.Repo.UserRepo;
import com.example.WingsProgram.Security.JwtService;
import com.example.WingsProgram.Service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private BiddingRepo biddingRepo;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('BIDDER')")
    @PostMapping("/bidding/add")
    private ResponseEntity<Object> addBidding(@RequestBody BiddingModel biddingModel){
         return userService.postBidding(biddingModel);
    }

    @GetMapping("/bidding/list")
    private ResponseEntity<Object> getBidding(@RequestParam("bidAmount") float bidAmount){
        return null;
    }
    @PreAuthorize("hasAuthority('APPROVER')")
    @PatchMapping("/bidding/update/{id}")
    private ResponseEntity<Object> updateBidding(@PathVariable int id,@RequestBody BiddingModel biddingModel){
        return null;
    }

    @DeleteMapping("/bidding/delete/{id}")
    private ResponseEntity<Object> deleteBidding(@PathVariable int id){
        return null;
    }

    @PostMapping("/login")
    private ResponseEntity<Object> login(@RequestBody UserModel userModel){


            String token = jwtService.GenerateToken(userModel.getEmail());
            return ResponseEntity.ok(token);


    }


    @GetMapping("/welcome")
    private ResponseEntity<Object> welcome() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Status","201");
        httpHeaders.set("message","Successfully fetched");
        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body("Hello User!");

    }

    @GetMapping("/getRoles")
    public List<UserModel> getRoles(){
        return userRepo.findAll();
    }

}
