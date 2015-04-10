/**
 * 
 */
package org.palaone.zeratul.server.repository;

import org.palaone.zeratul.server.domain.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author palaone
 *
 */
public interface RatingRepository extends CrudRepository<Rating, Long> {

	@Query("Select AVG(r.rate) From Rating r Where r.ratee.id = ?")
	float averageRatingByRateeId(long id);
}
