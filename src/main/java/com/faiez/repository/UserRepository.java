package com.faiez.repository;


import com.faiez.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by faiez.elleuch on 20/02/14.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

	public List<User> findByLogin(String login);
}
