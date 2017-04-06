package org.launchcode.models.Data;

import org.launchcode.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by adminbackup on 4/5/17.
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

}
