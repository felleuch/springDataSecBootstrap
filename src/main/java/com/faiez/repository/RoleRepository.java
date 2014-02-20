package com.faiez.repository;


import com.faiez.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by faiez.elleuch on 20/02/14.
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
