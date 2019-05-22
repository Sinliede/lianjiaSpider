package com.sinliede.spider.data.jpa.repository;

import com.sinliede.spider.data.jpa.domain.House;
import com.sinliede.spider.data.jpa.model.HouseStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author sinliede
 *
 * @date 19-5-9 上午11:19
 */
@Repository
public interface HouseRepository extends CrudRepository<House, String> {

}
