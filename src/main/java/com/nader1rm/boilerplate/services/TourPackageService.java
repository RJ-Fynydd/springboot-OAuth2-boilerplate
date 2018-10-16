package com.nader1rm.boilerplate.services;

import com.nader1rm.boilerplate.Repo.TourPackageRepository;
import com.nader1rm.boilerplate.models.TourPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@Service
public class TourPackageService {

    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name) {
        if (!tourPackageRepository.existsById(code)) {
            TourPackage tp = new TourPackage(code, name);
            tourPackageRepository.save(tp);
            return tp;
        } else {
            return null;
        }
    }

    public Iterable<TourPackage> lookup() {
        return tourPackageRepository.findAll();
    }

    public long total() {
        return tourPackageRepository.count();
    }

}
