package com.jk.mapper.login;
import com.jk.model.login.Temp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Component
public interface LoginMapper {
    @Select("SELECT * FROM t_emp WHERE loginnumber=#{loginnumber}")
    Temp login(String loginnumber);
}
