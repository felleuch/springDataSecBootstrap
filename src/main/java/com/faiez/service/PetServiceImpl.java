package com.faiez.service;

import com.faiez.exception.BusinessException;
import com.faiez.model.Pet;
import com.faiez.model.PetType;
import com.faiez.repository.PetsRepository;
import com.faiez.repository.PetsTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by faiez.elleuch on 19/02/14.
 */
@Service
public class PetServiceImpl implements PetService {

	@Resource
	private PetsRepository petsRepository;

	@Resource
	private PetsTypeRepository petsTypeRepository;

	@Override
	public Pet create(Pet pet) {
		Pet createdPet = pet;

		PetType pt = petsTypeRepository.findOne(5);

		createdPet.setPetType(pt);
		return petsRepository.save(createdPet);
	}

	@Override
	@Transactional(rollbackFor = BusinessException.class)
	public Pet delete(int id) throws BusinessException {
		Pet petToDelete = petsRepository.findOne(id);

		if (petToDelete == null)
			throw new BusinessException();

		petsRepository.delete(petToDelete);
		return petToDelete;
	}

	@Override
	@Transactional
	public List<Pet> findAll() {
		return petsRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = BusinessException.class)
	public Pet update(Pet pet) throws BusinessException {
		Pet petToupdate = petsRepository.findOne(pet.getId());

		if (petToupdate == null)
			throw new BusinessException();

		petToupdate.setName(pet.getName());
		petToupdate.setColor(pet.getColor());
		petToupdate.setPetType(pet.getPetType());

		return petToupdate;
	}

	@Override
	@Transactional
	public Pet findById(int id) {
		return petsRepository.findOne(id);
	}
}
