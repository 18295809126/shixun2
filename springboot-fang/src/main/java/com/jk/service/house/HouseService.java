package com.jk.service.house;

import com.jk.model.area.Area;
import com.jk.model.decorate.Decorate;
import com.jk.model.house.Community;
import com.jk.model.house.HouseResource;
import com.jk.model.housetype.HouseType;
import com.jk.model.pic.HousePhoto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface HouseService {

    List<HouseResource> getHouseResourceList(Integer page,Integer limit);

    void delHouseById(String id);

    HouseResource getHouseById(String id);

    List<HousePhoto> getHousePhoto(String id);
    /**
     * 新增房源信息
     * */
    void addHouseDatasource(HouseResource house, HttpServletRequest request);

    /**
     * 向房源图片表中上传图片
     * */
    void addPicToHousePhoto(HousePhoto housePhoto, HttpServletRequest request);

    /**
     * 查询省级、市级、县级 信息
     * */
    List<Area> queryProvice(String pid);

    /**
     * 查询房屋类型
     * */
    List<HouseType> selectRoomType();
    /**
     * 查询装修程度
     * */
    List<Decorate> selectDecorate();

    /**
     * 查询小区信息
     * @return
     */
    List<Community> selectCommunity();

    /**
     * 回显房源信息
     * @param id
     * @return
     */
    HouseResource queryHouseById(String id);

    /**
     * 修改房源信息
     * @param house
     */
    void updateHouseDatasource(HouseResource house,HttpServletRequest request);

    String queryHouseList(Map<String, String> map);

    List<HouseResource> getHouseResourceListByEmp(String eid,Integer page, Integer limit);

    List<HouseResource> getCountHouseResourceListByEmp(String eid);
}
