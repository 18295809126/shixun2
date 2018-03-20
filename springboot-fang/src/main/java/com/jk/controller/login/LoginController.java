package com.jk.controller.login;


import com.jk.controller.login.readDat.IPSeeker;
import com.jk.model.Log.Log;
import com.jk.model.login.Temp;
import com.jk.service.login.LoginService;
import com.jk.utils.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "login")
public class LoginController {
   @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "login")
    @ResponseBody
    public Map<String,Object> login(Temp tmp, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        //判断前台传过来的对象是否为空
        if (tmp!= null) {
            //然后判断对象里是不是空的，不为空就直去判断密码，后登陆成功
            Temp temps = loginService.login(tmp.getLoginnumber());
            if (temps != null) {
                if (temps.getPassword().equals(tmp.getPassword())) {
                    map.put("success", true);
                    //登陆成功后将用户密码存到session中
                    HttpSession session = request.getSession();
                    session.setAttribute("temps", temps);
                    String ipAddr = IPUtil.getIpAddr(request);
                    System.out.println(ipAddr);
                    /*IPSeeker instance = IPSeeker.getInstance();
                    String address = instance.getAddress(ipAddr);
                    System.out.println(address);*/
                    //定义new日志的实体
                    Log log = new Log();
                    //将用户名存入日志
                    log.setUsername(tmp.getLoginnumber());
                    //将当前时间存入日志
                    log.setNewDate(new Date());
                    //将地址存进日志
                    log.setAddress(ipAddr);
                    //将登陆成功存入日志这几个大字
                    log.setFlag("登陆成功");
                    log.setIps(ipAddr);
                    mongoTemplate.save(log,"1708b");
                } else {
                    map.put("success", false);
                    map.put("mag", "密码错误");
                }
            } else {
                map.put("success", false);
                map.put("mag", "用户名不存在");
            }
            return map;
        }
        return null;
    }


    //日志记录
    @RequestMapping("getPerson")
    @ResponseBody
    public Map<String,Object> getPerson(){
        Query query = new Query();
        List<Log> find = mongoTemplate.find(query, Log.class,"1708b");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",find);
        map.put("msg","");
        map.put("code",0);
        map.put("count",find.size());
        return map;
    }
}


