package com.jk.mapper.tree;

import com.jk.model.tree.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TreeMapper {

    @Select("SELECT e.id,e.href,e.pid,e.title FROM \n" +
            "t_emp a LEFT JOIN t_emp_power b ON a.power = b.uid \n" +
            "LEFT JOIN t_power c ON b.pid = c.id\n" +
            "LEFT JOIN t_power_tree d ON c.id = d.pid\n" +
            "LEFT JOIN t_tree0 e ON d.tid = e.id\n" +
            "WHERE a.id  = #{id}")
    List<Tree> getTree(String id);

    @Select("SELECT e.href FROM \n" +
            "t_emp a LEFT JOIN t_emp_power b ON a.power = b.uid \n" +
            "LEFT JOIN t_power c ON b.pid = c.id\n" +
            "LEFT JOIN t_power_tree d ON c.id = d.pid\n" +
            "LEFT JOIN t_tree0 e ON d.tid = e.id\n" +
            "WHERE a.id = #{id} AND e.href IS NOT NULL\n" +
            "UNION ALL\n" +
            "SELECT f.url FROM \n" +
            "t_emp a LEFT JOIN t_emp_power b ON a.power = b.uid \n" +
            "LEFT JOIN t_power c ON b.pid = c.id\n" +
            "LEFT JOIN t_power_tree d ON c.id = d.pid\n" +
            "LEFT JOIN t_tree0 e ON d.tid = e.id\n" +
            "LEFT JOIN t_menu f ON e.id = f.tid\n" +
            "WHERE a.id = #{id} AND f.url IS NOT NULL")
    List<Tree> getUrl(String id);
}
