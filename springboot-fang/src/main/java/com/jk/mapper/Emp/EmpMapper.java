package com.jk.mapper.Emp;

import com.jk.model.Emp.t_emp;
import com.jk.model.tree.Tree;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EmpMapper {

    @Select("select * from t_emp")
    List<t_emp> getEmp();

    @Insert("insert into t_emp(id,name,weixin,photo,phonenumer,loginnumber,password) values(#{id},#{name},#{weixin},#{photo},#{phonenumer},#{loginnumber},#{password})")
    void addEmp(t_emp emp);

    @Delete("delete from t_emp where id = #{id}")
    void delEmp(String id);

    @Update("update t_emp set name=#{name},weixin=#{weixin},photo=#{photo},phonenumer=#{phonenumer},loginnumber=#{loginnumber},password=#{password} where id=#{id}")
    void updEmp(t_emp emp);

    @Select("select * from t_emp where id = #{id}")
    t_emp huixianById(String id);

}
