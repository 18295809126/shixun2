package com.jk.service.Emp;

import com.jk.mapper.Emp.EmpMapper;
import com.jk.model.Emp.t_emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public List<t_emp> getEmp(Integer page, Integer rows) {
        List<t_emp> emp = empMapper.getEmp();
        return emp;
    }

    @Override
    public void addEmp(t_emp v) {

        String newPwd = null;
        try {
            //确定md5计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //获取base64转化编码的对象
            BASE64Encoder base64en = new BASE64Encoder();
            byte[] digest = md5.digest(v.getPassword().getBytes("utf-8"));
            //加密后的字符串
            newPwd = base64en.encode(md5.digest(v.getPassword().getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        v.setPassword(newPwd);


        empMapper.addEmp(v);
    }

    @Override
    public void delEmp(String id) {
        empMapper.delEmp(id);
    }

    @Override
    public void updEmp(t_emp emp) {

        empMapper.updEmp(emp);

    }

    @Override
    public t_emp huixianById(String id) {

        return empMapper.huixianById(id);
    }
}
