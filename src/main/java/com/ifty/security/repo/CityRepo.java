package com.ifty.security.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ifty.security.model.City;
@Repository
public interface CityRepo extends PagingAndSortingRepository<City, Integer> {
//
	@Query("from City as c where c.countrycode =:citycode AND c.name =:population")
	 Page<City> getww(@Param("citycode") String citycod,@Param("population") String population ,Pageable page);

	@Query("from City as c where  c.countrycode in (:cityList)")
	 Page<City> getww(Pageable page ,List<String> cityList);

}
