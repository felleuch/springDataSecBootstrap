package com.faiez.service;


import com.faiez.model.Role;
import com.faiez.repository.RoleRepository;
import com.faiez.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	


	@Resource
	private RoleRepository roleRepository;

	public Role getRole(int id) {
		return roleRepository.findOne(id)  ;
	}

}
