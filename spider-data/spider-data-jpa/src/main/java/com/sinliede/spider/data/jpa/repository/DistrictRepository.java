package com.sinliede.spider.data.jpa.repository;

import com.sinliede.spider.data.jpa.domain.District;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sinliede
 *
 * @date 19-5-9 上午11:19
 */
@Repository
public interface DistrictRepository extends CrudRepository<District, String> {

    District findDistinctFirstByProvinceAndCityAndDistrictAndVillage(String province, String city, String district, String village);
}
