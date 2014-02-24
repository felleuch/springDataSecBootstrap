package com.faiez.service;

import com.faiez.exception.BusinessException;
import com.faiez.model.Owner;
import com.faiez.model.Pet;

import java.util.List;

/**
 * Created by faiez.elleuch on 24/02/14.
 */
public interface OwnerService {


	public Pet create(Owner owner);
	public Owner delete(int id) throws BusinessException;
	public List<Owner> findAll();
	public Owner update(Owner pet) throws BusinessException;
	public Owner findById(int id);
}
