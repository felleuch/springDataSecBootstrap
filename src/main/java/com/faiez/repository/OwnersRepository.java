package com.faiez.repository;

import com.faiez.model.Owner;
import com.faiez.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by faiez.elleuch on 21/02/14.
 */
public interface OwnersRepository extends JpaRepository<Owner,Integer>{


}
