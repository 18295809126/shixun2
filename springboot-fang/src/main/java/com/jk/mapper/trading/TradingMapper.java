package com.jk.mapper.trading;

import com.jk.model.contract.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
@Mapper
public interface TradingMapper {

    @Select("SELECT c.code,e.name AS eidname,s.title AS roomname,c.generation_time,c.ordernumber,c.tradingType FROM t_contract AS c \n" +
            "LEFT JOIN t_sell_house_resource AS s ON c.house_id = s.id\n" +
            "LEFT JOIN t_emp AS e ON c.eid = e.id order by c.generation_time desc limit #{page},#{limit}" )
    List<Contract> tradinguser(@Param("page")Integer page, @Param("limit")Integer limit);
}
