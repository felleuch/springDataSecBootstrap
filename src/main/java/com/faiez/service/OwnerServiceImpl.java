package com.faiez.service;

import com.faiez.exception.BusinessException;
import com.faiez.model.Owner;
import com.faiez.model.Pet;
import com.faiez.repository.OwnersRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by faiez.elleuch on 24/02/14.
 */
@Service
public class OwnerServiceImpl implements OwnerService{

	@Resource
	private OwnersRepository ownersRepository;

	@Override
	public Pet create(Owner owner) {
		return null;
	}

	@Override
	public Owner delete(int id) throws BusinessException {
		return null;
	}

	@Override
	public List<Owner> findAll() {
		return ownersRepository.findAll();
	}

	@Override
	public Owner update(Owner pet) throws BusinessException {
		return null;
	}

	@Override
	public Owner findById(int id) {
		return null;
	}
}
