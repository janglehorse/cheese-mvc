package org.launchcode.models.Data;

import org.launchcode.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by adminbackup on 4/4/17.
 */
@Repository
@Transactional
public interface CheeseDao extends CrudRepository<Cheese, Integer> {



}
