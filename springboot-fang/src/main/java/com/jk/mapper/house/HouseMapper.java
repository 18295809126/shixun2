package com.jk.mapper.house;

import com.jk.model.area.Area;
import com.jk.model.decorate.Decorate;
import com.jk.model.house.Community;
import com.jk.model.house.House;
import com.jk.model.house.HouseResource;
import com.jk.model.housetype.HouseType;
import com.jk.model.pic.HousePhoto;
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
            " limit #{page},#{limit} ")
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
    @Insert("INSERT INTO t_sell_house_resource (id,emp_id,title,price,room,hall,toilet,house_area,community,province,city,county,building_time,room_type,room_direction,house_floor,decorate,unit_price,Monthly_payments,Selling_point,owner_mentality,community_complete,service_introduce,release_time,room_num) values(#{id},#{emp_id},#{title},#{price},#{room},#{hall},#{toilet},#{house_area},#{community},#{province},#{city},#{county},#{building_time},#{room_type},#{room_direction},#{house_floor},#{decorate},#{unit_price},#{monthly_payments},#{selling_point},#{owner_mentality},#{community_complete},#{service_introduce},#{release_time},#{room_num})")
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


    @SelectProvider(type = SqlProvider.class, method ="beanCount" )
    List<HouseResource> queryHouseList(Map<String, String> map);

    @SelectProvider(method = "bean",type = SqlProvider.class)
    List<HouseResource> queryHouseListPage(Map<String, String> map);

    @Select("SELECT shr.id,shr.emp_id,shr.title,shr.price,shr.room,shr.hall,shr.toilet,shr.house_area,co.name AS community,shr.province,shr.city,shr.county,shr.building_time,ht.name AS NAME,shr.room_direction,shr.house_floor,de.name AS decorate,shr.unit_price,shr.monthly_payments,shr.selling_point,shr.owner_mentality,shr.community_complete,shr.service_introduce,shr.release_time,shr.room_num FROM t_sell_house_resource shr\n" +
            "LEFT JOIN t_house_type ht ON shr.room_type=ht.id\n" +
            "LEFT JOIN t_decorate de ON shr.decorate=de.id\n" +
            "LEFT JOIN t_community co ON shr.community=co.id where shr.emp_id=#{eid}")
    List<HouseResource> getCountHouseResourceListByEmp(@Param("eid")String eid);

    @Select("SELECT shr.id,shr.emp_id,shr.title,shr.price,shr.room,shr.hall,shr.toilet,shr.house_area,co.name AS community,shr.province,shr.city,shr.county,shr.building_time,ht.name AS NAME,shr.room_direction,shr.house_floor,de.name AS decorate,shr.unit_price,shr.monthly_payments,shr.selling_point,shr.owner_mentality,shr.community_complete,shr.service_introduce,shr.release_time,shr.room_num FROM t_sell_house_resource shr\n" +
            "LEFT JOIN t_house_type ht ON shr.room_type=ht.id\n" +
            "LEFT JOIN t_decorate de ON shr.decorate=de.id\n" +
            "LEFT JOIN t_community co ON shr.community=co.id where shr.emp_id=#{eid}" +
            "limit #{page},#{limit}")
    List<HouseResource> getHouseResourceListByEmp(@Param("eid") String eid,@Param("page") Integer page,@Param("limit") Integer limit);
}
