package com.faiez.service;

import com.faiez.exception.BusinessException;
import com.faiez.model.Owner;

import com.faiez.model.Pet;
import com.faiez.repository.OwnersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Owner create(Owner owner) {
		Owner createdOwner = owner;
		return ownersRepository.save(createdOwner);
	}

	@Override
	@Transactional(rollbackFor = BusinessException.class)
	public Owner delete(int id) throws BusinessException {

		Owner ownerToDelete = ownersRepository.findOne(id);

		if (ownerToDelete == null)
			throw new BusinessException();

		ownersRepository.delete(ownerToDelete);
		return ownerToDelete;
	}

	@Override
	@Transactional
	public List<Owner> findAll() {

		return ownersRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = BusinessException.class)
	public Owner update(Owner owner) throws BusinessException {

		Owner ownerToupdate = ownersRepository.findOne(owner.getId());

		if (ownerToupdate == null)
			throw new BusinessException();

		ownerToupdate.setFirstname(owner.getFirstname());
		ownerToupdate.setLastname(owner.getLastname());
		ownerToupdate.setDescription(owner.getDescription());


		return ownerToupdate;
	}

	@Override
	public Owner findById(int id) {

		return ownersRepository.findOne(id);
	}
}
