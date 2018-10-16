package com.nader1rm.boilerplate.Repo;

import com.nader1rm.boilerplate.models.Tour;
import java.util.List;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@RepositoryRestResource(collectionResourceRel = "tours", path = "tours")
public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
    
    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);
    Tour findByTitle(@Param("title") String title);
    List<Tour> findByPriceLessThan(Integer priceMax);
    List<Tour> findByPriceGreaterThan(Integer priceMin);

    @Query("SELECT t FROM Tour t WHERE t.price < ?1")
    List<Tour> getTourByPriceLessThan(Integer priceMax);

    @Override
    @RestResource(exported = false)
    public void deleteAll();

    @Override
    @RestResource(exported = false)
    public void deleteAll(Iterable<? extends Tour> itrbl);

    @Override
    @RestResource(exported = false)
    public void delete(Tour t);

    @Override
    @RestResource(exported = false)
    public void deleteById(Integer id);

    @Override
    @RestResource(exported = false)
    public <S extends Tour> Iterable<S> saveAll(Iterable<S> itrbl);

    @Override
    @RestResource(exported = false)
    public <S extends Tour> S save(S s);
    
    
}
