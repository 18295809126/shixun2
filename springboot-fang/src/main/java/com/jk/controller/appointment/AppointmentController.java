package com.jk.controller.appointment;

import com.jk.model.appointment.Appointment;
import com.jk.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    /**
     * 跳转到预约房源信息页面
     * @return
     */
    @RequestMapping(value = "toQueryAppointment")
    public String toQueryAppointment(){
        return "appointment/queryAppointment";
    }

    /**
     * 查询预约信息
     * @return
     */
    @RequestMapping(value = "getAppointmentList")
    @ResponseBody
    public Map<String,Object> getAppointmentList(Integer page,Integer limit){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Appointment> appointmentList = appointmentService.getAppointmentList(page,limit);
        map.put("data",appointmentList);
        map.put("count",appointmentList.size());
        map.put("msg","");
        map.put("code",0);
        return map;
    }

    /**
     * 删除预约信息
     * @param id
     * @return
     */
    @RequestMapping(value = "delAppointment")
    @ResponseBody
    public Map<String,Object> delAppointment(String id){
        Map<String,Object> map= new HashMap<String, Object>();
        try{
            appointmentService.delAppointment(id);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

}
