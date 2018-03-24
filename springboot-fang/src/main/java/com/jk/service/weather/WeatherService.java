package com.jk.service.weather;

import com.jk.model.area.AllArea;
import com.jk.model.house.HouseResource;

import java.util.List;

public interface WeatherService {

    /**
     *查询房屋饼状图
     * @return
     */

    List<HouseResource> getHouse();

    List<AllArea> queryProvince();

    List<AllArea> queryCity(Integer id);

    List<AllArea> queryCountry(Integer id);

    List<HouseResource> getHouseTwo(HouseResource sellHouseResource);
}
