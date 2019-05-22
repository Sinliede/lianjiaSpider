package com.sinliede.spider.core.util;

import com.sinliede.spider.data.jpa.domain.District;
import com.sinliede.spider.data.jpa.domain.House;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * @author sinliede
 * @date 19-5-14 下午3:32
 * @since
 */
public class IDUtil {

    public static String getDistrictId(District district) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(district.getProvince())
                .append(district.getCity())
                .append(district.getDistrict())
                .append(district.getVillage());
        district.setId(DigestUtils.md5Hex(stringBuffer.toString()).toUpperCase());
        return district.getId();
    }

}
