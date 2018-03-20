package com.jk.service.appointment;

import com.jk.mapper.appointment.AppointmentMapper;
import com.jk.model.appointment.Appointment;
import com.jk.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    /**
     * 新增预约房源信息
     * @param appointment
     */
    @Override
    public void addAppointment(Appointment appointment) {
        appointment.setId(UUIDUtils.UUID());
        appointment.setAppointmentTime(new Date());
        appointmentMapper.addAppointment(appointment);
    }

    /**
     * 查询预约房源信息   分页展示
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Appointment> getAppointmentList(Integer page, Integer limit) {
        page = (page - 1) * limit;
        List<Appointment> appointmentList = appointmentMapper.getAppointmentList(page,limit);
        return appointmentList;
    }

    @Override
    public void delAppointment(String id) {
        appointmentMapper.delAppointment(id);
    }
}
