package com.example.WingsProgram;

import com.example.WingsProgram.Model.RoleModel;
import com.example.WingsProgram.Model.UserModel;
import com.example.WingsProgram.Repo.RoleRepo;
import com.example.WingsProgram.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WingsProgramApplication {

	public static void main(String[] args) {

		SpringApplication.run(WingsProgramApplication.class, args);
	}

}
