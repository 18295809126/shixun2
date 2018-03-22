package com.jk.mapper.house;

import com.jk.model.Notice.Notice;
import com.jk.model.area.Area;
import com.jk.model.contract.Contract;
import com.jk.model.decorate.Decorate;
import com.jk.model.house.Community;
import com.jk.model.house.HouseResource;
import com.jk.model.housetype.HouseType;
import com.jk.model.login.Temp;
import com.jk.model.payment.Payment;
import com.jk.model.pic.HousePhoto;
import com.jk.model.stages.Stages;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface HouseMapper {

    @Select("SELECT shr.id,shr.emp_id,shr.title,shr.price,shr.room,shr.hall,shr.toilet,shr.house_area,co.name AS community,shr.province,shr.city,shr.county,shr.building_time,ht.name AS NAME,shr.room_direction,shr.house_floor,de.name AS decorate,shr.unit_price,shr.monthly_payments,shr.selling_point,shr.owner_mentality,shr.community_complete,shr.service_introduce,shr.release_time,shr.room_num FROM t_sell_house_resource shr\n" +
            "LEFT JOIN t_house_type ht ON shr.room_type=ht.id\n" +
            "LEFT JOIN t_decorate de ON shr.decorate=de.id\n" +
            "LEFT JOIN t_community co ON shr.community=co.id " +
            " where shr.housing_state = 1 limit #{page},#{limit} ")
    List<HouseResource> getHouseResourceList(@Param("page")Integer page, @Param("limit")Integer limit);

    @Delete("delete from t_sell_house_resource where id=#{id}")
    void delHouseById(@Param("id") String id);

    @Select("SELECT shr.id,shr.emp_id,shr.title,shr.price,shr.room,shr.hall,shr.toilet,shr.house_area,co.name AS community,shr.province,shr.city,shr.county,shr.building_time,ht.name AS NAME,shr.room_direction,shr.house_floor,de.name AS decorate,shr.unit_price,shr.monthly_payments,shr.selling_point,shr.owner_mentality,shr.community_complete,shr.service_introduce,shr.release_time,shr.room_num FROM t_sell_house_resource shr\n" +
            "LEFT JOIN t_house_type ht ON shr.room_type=ht.id\n" +
            "LEFT JOIN t_decorate de ON shr.decorate=de.id\n" +
            "LEFT JOIN t_community co ON shr.community=co.id where shr.id=#{id}")
    HouseResource getHouseById(@Param("id") String id);

    @Select("SELECT hp.id,hp.house_id,hp.url,hp.type FROM t_sell_house_pic hp \n" +
            "LEFT JOIN t_sell_house_resource shr ON shr.id=hp.house_id\n" +
            "WHERE shr.id=#{id}")
    List<HousePhoto> getHousePhoto(@Param("id")String id);
    /**
     * 添加房源信息
     * */
    @Insert("INSERT INTO t_sell_house_resource (id,emp_id,title,price,room,hall,toilet,house_area,community,province,city,county,building_time,room_type,room_direction,house_floor,decorate,unit_price,Monthly_payments,Selling_point,owner_mentality,community_complete,service_introduce,release_time,room_num,housing_state,deposit_money,rent_money) values(#{id},#{emp_id},#{title},#{price},#{room},#{hall},#{toilet},#{house_area},#{community},#{province},#{city},#{county},#{building_time},#{room_type},#{room_direction},#{house_floor},#{decorate},#{unit_price},#{monthly_payments},#{selling_point},#{owner_mentality},#{community_complete},#{service_introduce},#{release_time},#{room_num},#{housing_state},#{deposit_money},#{rent_money})")
    void addHouseDatasource(HouseResource house);
    /**
     * 向房源图片表中上传图片
     * */
    @Insert("insert into t_sell_house_pic (id,house_id,url,type) values(#{id},#{houseId},#{url},#{type})")
    void addPicToHousePhoto(HousePhoto housePhoto);

    /**
     * 三级联动
     * @param pid
     * @return
     */
    @Select("SELECT * FROM xx_area WHERE parent = #{pid}")
    List<Area> queryProvice(String pid);

    /**
     * 查询房屋类型
     * @return
     */
    @Select("select * from t_house_type")
    List<HouseType> selectRoomType();
   /**
    * 装修程度
    * */
    @Select("select * from t_decorate")
    List<Decorate> selectDecorate();

    /**
     * 所在小区
     * */
    @Select("select * from t_community")
    List<Community> selectCommunity();

    /**
     * 回显房源信息
     * @param id
     * @return
     */
    @Select("select * from t_sell_house_resource tshr where tshr.id = #{id} ")
    HouseResource queryHouseById(String id);

    /**
     * 修改房源信息
     * @param house
     */
    @Update("update t_sell_house_resource set emp_id = #{emp_id},title = #{title},price = #{price},room = #{room},hall = #{hall},toilet = #{toilet},house_area = #{house_area},community = #{community},province = #{province},city = #{city},county = #{county},building_time = #{building_time},room_type = #{room_type},room_direction = #{room_direction},house_floor = #{house_floor},decorate = #{decorate},unit_price = #{unit_price},monthly_payments = #{monthly_payments},selling_point = #{selling_point},owner_mentality = #{owner_mentality},community_complete = #{community_complete},service_introduce = #{service_introduce},release_time = #{release_time},room_num = #{room_num} where id = #{id}")
    void updateHouseDatasource(HouseResource house);

    /**
     * 房源查看查看条数
     * @param map
     * @return
     */
    @SelectProvider(type = SqlProvider.class, method ="beanCount" )
    List<HouseResource> queryHouseList(Map<String, String> map);
    /**
     * 房源查看分页
     * @param map
     * @return
     */
    @SelectProvider(method = "bean",type = SqlProvider.class)
    List<HouseResource> queryHouseListPage(Map<String, String> map);

    /**
     * 我的发布查看条数
     * @param eid
     * @return
     */
    @Select("SELECT shr.id,shr.emp_id,shr.title,shr.price,shr.room,shr.hall,shr.toilet,shr.house_area,co.name AS community,shr.province,shr.city,shr.county,shr.building_time,ht.name AS NAME,shr.room_direction,shr.house_floor,de.name AS decorate,shr.unit_price,shr.monthly_payments,shr.selling_point,shr.owner_mentality,shr.community_complete,shr.service_introduce,shr.release_time,shr.room_num FROM t_sell_house_resource shr\n" +
            "LEFT JOIN t_house_type ht ON shr.room_type=ht.id\n" +
            "LEFT JOIN t_decorate de ON shr.decorate=de.id\n" +
            "LEFT JOIN t_community co ON shr.community=co.id where shr.emp_id=#{eid}")
    List<HouseResource> getCountHouseResourceListByEmp(@Param("eid")String eid);

    /**
     * 我的发布查看分页
     * @param eid
     * @param page
     * @param limit
     * @return
     */
    @Select("SELECT shr.id,shr.emp_id,shr.title,shr.price,shr.room,shr.hall,shr.toilet,shr.house_area,co.name AS community,shr.province,shr.city,shr.county,shr.building_time,ht.name AS NAME,shr.room_direction,shr.house_floor,de.name AS decorate,shr.unit_price,shr.monthly_payments,shr.selling_point,shr.owner_mentality,shr.community_complete,shr.service_introduce,shr.release_time,shr.room_num FROM t_sell_house_resource shr\n" +
            "LEFT JOIN t_house_type ht ON shr.room_type=ht.id\n" +
            "LEFT JOIN t_decorate de ON shr.decorate=de.id\n" +
            "LEFT JOIN t_community co ON shr.community=co.id where shr.emp_id=#{eid}" +
            "limit #{page},#{limit}")
    List<HouseResource> getHouseResourceListByEmp(@Param("eid") String eid,@Param("page") Integer page,@Param("limit") Integer limit);

    /**
     * 发布公告
     * @param notice
     */
	@Insert("insert into t_notice(id,empid,empnum,releasetime,content,headline,empname,auditFlag) values(#{id},#{empid},#{empnum},#{releasetime},#{content},#{headline},#{empname},#{auditFlag})")
    void addNotice(Notice notice);

    /**
     * 发布公告查看
     * @param page
     * @param limit
     * @return
     */
    @Select("select id,empid,empnum,releasetime,content,headline,empname,auditFlag from t_notice limit #{page},#{limit}")
    List<Notice> getNotice(@Param("page") Integer page, @Param("limit")Integer limit);

    /**
     * 修改审核状态为通过
     * @param id
     */
    @Update("update t_notice set auditFlag=2 where id=#{id} and auditFlag=1")
    void updateFlag2(String id);
    /**
     * 修改审核状态为不通过
     * @param id
     */
    @Update("update t_notice set auditFlag=3 where id=#{id} and auditFlag=2")
    void updateFlagto3(String id);
    /**
     * 修改审核状态为通过
     * @param id
     */
    @Update("update t_notice set auditFlag=2 where id=#{id} and auditFlag=3")
    void updateFlagTo2(String id);

    /**
     * 查看发布列表分页
     * @param page
     * @param limit
     * @return
     */
    @Select("select * from t_notice")
    List<Notice> queryNotice(@Param("page")Integer page, @Param("limit") Integer limit);

    /**
     * 查看发布列表分页审核状态为通过的
     * @param page
     * @param limit
     * @return
     */
    @Select("select id,empid,empnum,releasetime,content,headline,empname,auditFlag from t_notice where auditFlag=2 order by releasetime desc")
    List<Notice> getNoticeInfo(Integer page, Integer limit);

    /**
     * 查看发布通过ID
     * @param id
     * @return
     */
    @Select("select id,empid,empnum,releasetime,content,headline,empname,auditFlag from t_notice where id=#{id}")
    List<Notice> getNoticeById(String id);

    /**
     * 查询mail
     * @param id
     * @return
     */
    @Select("SELECT e.id,e.mail FROM t_emp e\n" +
            "LEFT JOIN t_notice n ON e.id=n.empid WHERE n.id=#{id}")
    List<Temp> getEmpEmail(String id);

	    /**
     * 新增合同
     * @param contract
     */
    @Select("INSERT INTO t_contract(code,lease_name,lessee_name,house_id,rent_time,finish_time,payment_method,staging_state,generation_time,mention_rent,liquidated_damages,one_money) " +
            "values(#{code},#{lease_name},#{lessee_name},#{house_id},#{rent_time},#{finish_time},#{payment_method},#{staging_state},#{generation_time},#{mention_rent},#{liquidated_damages},#{one_money})")
    void addContract(Contract contract);

    /**
     * 修改房源状态
     * @param house_id
     */
    @Update("update t_sell_house_resource set housing_state=2 where  id=#{house_id} and housing_state=1")
    void updHouseFalg(String house_id);

    /**
     * 查询合同信息
     * @param page
     * @param limit
     * @return
     */

    @Select("SELECT t.code,t.lease_name,t.lessee_name,h.title,t.rent_time,t.finish_time,h.rent_money,p.payment_name,d.name,h.deposit_money,t.generation_time,t.mention_rent,t.liquidated_damages,t.one_money FROM t_contract AS t LEFT JOIN t_sell_house_resource AS h ON t.house_id=h.id LEFT JOIN t_payment AS p ON t.payment_method =p.id LEFT JOIN t_stages AS d ON t.staging_state=d.id")
    List<Contract> getContractList(Integer page, Integer limit);

    /**
     * 删除合同
     * @param code
     */
    @Delete("delete from t_contract where code=#{code}")
    void delContract(String code);

    /**
     * 查询房源和员工名称
     * @return
     */
    @Select("SELECT shr.id,shr.title,e.name AS emp_id FROM t_sell_house_resource shr \n" +
            "LEFT JOIN t_emp e ON e.id=shr.emp_id")
    List<HouseResource> getHouseAndEmp();

    /**
     * 查询分期方式
     * @return
     */
    @Select("SELECT id,NAME FROM t_stages order by id asc")
    List<Stages> getStagingType();

    /**
     * 查询付款方式
     * @return
     */
    @Select("SELECT id,payment_name FROM t_payment")
    List<Payment> getPaymentType();

    /**
     * 查询租金
     * @param id
     * @return
     */
    @Select("SELECT shr.rent_money,shr.deposit_money,e.name AS NAME FROM t_sell_house_resource shr\n" +
            "LEFT JOIN t_emp e ON e.id=shr.emp_id where  shr.id=#{id}")
    List<HouseResource> getRent(String id);
}
