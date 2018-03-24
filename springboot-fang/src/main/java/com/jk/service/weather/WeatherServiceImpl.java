package com.jk.service.weather;

import com.jk.mapper.appointment.AppointmentMapper;
import com.jk.mapper.weather.WeatherMapper;
import com.jk.model.area.AllArea;
import com.jk.model.house.HouseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherMapper weatherMapper;

    /**
     * 查询房屋饼状图
     * @return
     */
    @Override
    public List<HouseResource> getHouse() {
        return weatherMapper.getHouse();
    }

    @Override
    public List<AllArea> queryProvince() {
        return weatherMapper.queryProvince();
    }

    @Override
    public List<AllArea> queryCity(Integer id) {
        return weatherMapper.queryCity(id);
    }

    @Override
    public List<AllArea> queryCountry(Integer id) {
        return weatherMapper.queryCountry(id);
    }

    @Override
    public List<HouseResource> getHouseTwo(HouseResource sellHouseResource) {
        return weatherMapper.getHouseTwo(sellHouseResource);
    }



}
