package com.jk.mapper.weather;

import com.jk.model.area.AllArea;
import com.jk.model.house.HouseResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Component
public interface WeatherMapper {

/*
    @Select("SELECT sh.flag AS NAME,sh.flag AS VALUE FROM t_sell_house_resource sh\n" + "LEFT JOIN t_hetong ht ON sh.id= ht.houseid")
*/
    @Select("SELECT sh.house_type AS NAME,COUNT(sh.house_type) AS VALUE  FROM t_sell_house_resource sh LEFT JOIN t_contract ht ON sh.id= ht.code GROUP BY sh.house_type")
    List<HouseResource> getHouse();

    @Select("select id,name,full_name from xx_area where parent=0")
    List<AllArea> queryProvince();
    @Select("select id,name,full_name from xx_area where parent=#{id}")
    List<AllArea> queryCity(Integer id);
    @Select("select id,name,full_name from xx_area where parent=#{id}")
    List<AllArea> queryCountry(Integer id);

    @Select("SELECT sh.house_type AS NAME,sh.house_type AS VALUE  FROM t_sell_house_resource sh\n" +
            "LEFT JOIN t_contract ht ON sh.id= ht.code\n" +
            "WHERE  sh.areaprovince=#{areaprovince} AND sh.areacity=#{areacity} ")
    List<HouseResource> getHouseTwo(HouseResource sellHouseResource);
}

