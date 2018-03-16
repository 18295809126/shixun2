package com.jk.service.Emp;

import com.jk.model.Emp.t_emp;

import java.util.List;

public interface EmpService {
    List<t_emp> getEmp(Integer page, Integer rows);

    void addEmp(t_emp emp);

    void delEmp(String id);

    void updEmp(t_emp emp);

    t_emp huixianById(String id);
}
