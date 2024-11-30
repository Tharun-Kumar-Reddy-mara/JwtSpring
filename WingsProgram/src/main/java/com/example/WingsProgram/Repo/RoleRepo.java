package com.example.WingsProgram.Repo;

import com.example.WingsProgram.Model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleModel,Integer> {
}
