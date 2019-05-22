package com.sinliede.spider.data.jpa.converter;

import com.sinliede.spider.data.jpa.model.HouseStatus;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;

/**
 * @author sinliede
 *
 * @date 19-5-9 上午10:38
 * @desc convert string into enum
 */
public class HouseStatusConverter implements AttributeConverter<HouseStatus, String> {
    @Override
    public String convertToDatabaseColumn(HouseStatus houseStatus) {
        return null == houseStatus ? null : houseStatus.name();
    }

    @Override
    public HouseStatus convertToEntityAttribute(String status) {
        return StringUtils.isEmpty(status) ? null : HouseStatus.valueOf(status);
    }
}
