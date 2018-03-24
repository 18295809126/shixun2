package com.jk.mapper.appointment;

import com.jk.model.appointment.Appointment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AppointmentMapper {
    /**
     * 查询预约房源信息
     * @param page
     * @param limit
     * @return
     */
    @Select("SELECT \n" +
            "tai.id,\n" +
            "tai.user_name AS userName,\n" +
            "tai.user_sex AS userSex,\n" +
            "tai.user_phonenum AS userPhonenum,\n" +
            "tai.appointment_time AS appointmentTime,\n" +
            "tai.reservations_time,\n" +
            "tshr.title AS title,\n" +
            "tshr.community AS community,\n" +
            "temp.name as name\n" +
            "FROM t_appointment tai \n" +
            "LEFT JOIN t_sell_house_resource tshr ON tai.house_id = tshr.id\n" +
            "LEFT JOIN t_emp temp ON tai.emp_id = temp.id")
    List<Appointment> getAppointmentList(@Param("page") Integer page, @Param("limit")Integer limit);

    @Delete("delete from t_appointment where id=#{id}")
   void delAppointment(String id);
}
