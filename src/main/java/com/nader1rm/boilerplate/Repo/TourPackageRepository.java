/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nader1rm.boilerplate.Repo;

import com.nader1rm.boilerplate.models.TourPackage;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

    TourPackage findByName(String name);
}
