/**
 * 
 */
package org.palaone.zeratul.server.repository;

import org.palaone.zeratul.server.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author palaone
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
