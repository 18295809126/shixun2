package com.jk.mapper.appointment;

import com.jk.model.appointment.Appointment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AppointmentMapper {
    /**
     * 新增预约信息
     * @param appointment
     */
    @Insert("insert into t_appointment (id,house_id,user_name,user_sex,user_phonenum,appointment_time) values (#{id},#{houseid},\n" +
            "#{userName},#{userSex},#{userPhonenum},#{appointmentTime})")
    void addAppointment(Appointment appointment);

    /**
     * 查询预约房源信息
     * @param page
     * @param limit
     * @return
     */
    @Select("SELECT tai.id,tai.user_name as userName,tai.user_sex as userSex,tai.user_phonenum as userPhonenum,tai.appointment_time as appointmentTime,tshr.title as title,tshr.community as community FROM t_appointment tai LEFT JOIN t_sell_house_resource tshr ON tai.house_id = tshr.id")
    List<Appointment> getAppointmentList(@Param("page") Integer page, @Param("limit")Integer limit);

    @Delete("delete from t_appointment where id=#{id}")
   void delAppointment(String id);
}
