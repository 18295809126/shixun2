package com.jk.service.appointment;

import com.jk.model.appointment.Appointment;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AppointmentService {
    /**
     * 查询预约房源信息  分页展示
     * @param page
     * @param limit
     * @return
     */
    List<Appointment> getAppointmentList(Integer page, Integer limit);

    void delAppointment(String id);
}
