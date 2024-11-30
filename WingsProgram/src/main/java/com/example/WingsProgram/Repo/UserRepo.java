package com.example.WingsProgram.Repo;

import com.example.WingsProgram.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {
     UserModel findByEmail(String email);
}
