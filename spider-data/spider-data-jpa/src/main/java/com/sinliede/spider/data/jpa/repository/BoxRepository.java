package com.sinliede.spider.data.jpa.repository;

import com.sinliede.spider.data.jpa.domain.Box;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author sinliede
 *
 * @date 19-5-9 上午11:10
 */
@Repository
public interface BoxRepository extends CrudRepository<Box, Integer> {

    List<Box> findByDistrictIdAndDateBetweenOrderByDate(String districtId, Date startDate, Date endDate);

}
