package com.nader1rm.boilerplate.services;

import com.nader1rm.boilerplate.Repo.TourPackageRepository;
import com.nader1rm.boilerplate.Repo.TourRepository;
import com.nader1rm.boilerplate.models.Difficulty;
import com.nader1rm.boilerplate.models.Region;
import com.nader1rm.boilerplate.models.Tour;
import com.nader1rm.boilerplate.models.TourPackage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@Service
public class TourService {

    private TourPackageRepository tourPackageRepository;
    private TourRepository tourRepository;

    @Autowired
    public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
        this.tourPackageRepository = tourPackageRepository;
        this.tourRepository = tourRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets, String keywords, String tourPackageName, Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);

        if (tourPackage != null) {
            return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
        } else {
            throw new RuntimeException("Tour package does not exist:" + tourPackageName);
        }
    }

    public Iterable<Tour> lookup() {
        return tourRepository.findAll();
    }

    public long total() {
        return tourRepository.count();
    }

    public List<Tour> getTourByPriceLessThan(Integer i) {
        return tourRepository.findByPriceLessThan(i);
    }

    public List<Tour> getTourByPriceGreaterThan(Integer i) {
        return tourRepository.findByPriceGreaterThan(i);
    }

}
