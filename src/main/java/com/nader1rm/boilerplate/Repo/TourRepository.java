package com.nader1rm.boilerplate.Repo;

import com.nader1rm.boilerplate.models.Tour;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
public interface TourRepository extends CrudRepository<Tour, Integer> {

    List<Tour> findByPriceLessThan(Integer priceMax);

    List<Tour> findByPriceGreaterThan(Integer priceMin);

    @Query("SELECT t FROM Tour t WHERE t.price < ?1")
    List<Tour> getTourByPriceLessThan(Integer priceMax);
}
