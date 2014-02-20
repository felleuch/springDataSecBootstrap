package com.faiez.service;


import com.faiez.model.User;
import com.faiez.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	public User getUser(String login) {
		List<User> domainUserList = userRepository.findByLogin(login);
		return domainUserList.get(0);
	}

}
