package com.jk.service.house;

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

	void addNotice(Notice notice);

    List<Notice> getNotice(Integer page, Integer limit);

    void updateFlag2(String id);

    void updateFlagto3(String id);

    void updateFlagTo2(String id);

    List<Notice> queryNotice(Integer page, Integer limit);

    List<Notice> getNoticeInfo(Integer page, Integer limit);

    List<Notice> getNoticeById(String id);

    List<Temp> getEmpEmail(String id);

    Map<String,Object> addContract(Contract contract, HttpServletRequest request);

    List<Contract> getContractList(Integer page, Integer limit);

    void delContract(String code);

    List<HouseResource> getHouseAndEmp();

    List<Stages> getStagingType();

    List<Payment> getPaymentType();

    List<HouseResource> getRent(String id);

    void toFreeWord(String code);

    void toFreePdf(String code) throws Exception;

    List<HouseResource> getHouseAndEmpSell();
}

