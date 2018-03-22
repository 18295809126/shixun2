package com.jk.service.house;

import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.house.HouseMapper;
import com.jk.model.Notice.Notice;
import com.jk.model.area.Area;
import com.jk.model.contract.Contract;
import com.jk.model.decorate.Decorate;
import com.jk.model.house.Community;
import com.jk.model.house.HouseResource;
import com.jk.model.housetype.HouseType;
import com.jk.model.login.Temp;
import com.jk.model.pic.HousePhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<HouseResource> getHouseResourceList(Integer page,Integer limit) {
        page=(page-1)*limit;
        return houseMapper.getHouseResourceList(page,limit);
    }

    @Override
    public void delHouseById(String id) {
        houseMapper.delHouseById(id);
    }

    @Override
    public HouseResource getHouseById(String id) {
        return houseMapper.getHouseById(id);
    }

    @Override
    public List<HousePhoto> getHousePhoto(String id) {
        return houseMapper.getHousePhoto(id);
    }

    @Override
    public void addHouseDatasource(HouseResource house, HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String emp_id = (String) request.getSession().getAttribute("id");
        house.setId(uuid);
        house.setEmp_id(emp_id);
        houseMapper.addHouseDatasource(house);
        //将房源ID存在session里
        request.getSession().setAttribute("houseid",house.getId());
    }

    /**
     * 新增图片
     * */
    @Override
    public void addPicToHousePhoto(HousePhoto housePhoto, HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String houseid = (String) request.getSession().getAttribute("houseid");
        housePhoto.setHouseId(houseid);
        housePhoto.setId(uuid);
        houseMapper.addPicToHousePhoto(housePhoto);
    }

    /**
     * 三级联动
     * @param pid
     * @return
     */
    @Override
    public List<Area> queryProvice(String pid) {
        return houseMapper.queryProvice(pid);
    }

    @Override
    public List<HouseType> selectRoomType() {
        return houseMapper.selectRoomType();
    }

    @Override
    public List<Decorate> selectDecorate() {
        return houseMapper.selectDecorate();
    }

    @Override
    public List<Community> selectCommunity() {
        return houseMapper.selectCommunity();
    }

    /**
     * 回显房源信息
     * @param id
     * @return
     */
    @Override
    public HouseResource queryHouseById(String id) {
        return houseMapper.queryHouseById(id);
    }

    /**
     * 修改房源信息
     * @param house
     * @param request
     */
    @Override
    public void updateHouseDatasource(HouseResource house,HttpServletRequest request) {
        String emp_id = (String) request.getSession().getAttribute("id");
        house.setEmp_id(emp_id);
        houseMapper.updateHouseDatasource(house);
    }

    @Override
    public String queryHouseList(Map<String, String> map) {
        long total = houseMapper.queryHouseList(map).size();
        List<HouseResource> list = houseMapper.queryHouseListPage(map);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", total);
        jsonObject.put("data", list);

        return jsonObject.toString();
    }

    @Override
    public List<HouseResource> getHouseResourceListByEmp(String eid,Integer page, Integer limit) {
        page=(page-1)*limit;
        return houseMapper.getHouseResourceListByEmp(eid,page,limit);
    }

    @Override
    public List<HouseResource> getCountHouseResourceListByEmp(String eid) {
        return houseMapper.getCountHouseResourceListByEmp(eid);
    }

	@Override
    public void addNotice(Notice notice) {
        houseMapper.addNotice(notice);
    }

    @Override
    public List<Notice> getNotice(Integer page, Integer limit) {
        page=(page-1)*limit;
        return houseMapper.getNotice(page,limit);
    }

    @Override
    public void updateFlag2(String id) {
        houseMapper.updateFlag2(id);
    }

    @Override
    public void updateFlagto3(String id) {
        houseMapper.updateFlagto3(id);
    }

    @Override
    public void updateFlagTo2(String id) {
        houseMapper.updateFlagTo2(id);
    }

    /**
     * 分页查询发布公告信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Notice> queryNotice(Integer page, Integer limit) {
        page = (page - 1) * limit;
        List<Notice> noticeList = houseMapper.queryNotice(page,limit);
        return noticeList;
    }

    @Override
    public List<Notice> getNoticeInfo(Integer page, Integer limit) {
        return houseMapper.getNoticeInfo(page,limit);
    }

    @Override
    public List<Notice> getNoticeById(String id) {
        return houseMapper.getNoticeById(id);
    }

    @Override
    public List<Temp> getEmpEmail(String id) {
        return houseMapper.getEmpEmail(id);
    }

	@Override
    public void addContract(Contract contract) {
        houseMapper.addContract(contract);
        try{
            houseMapper.updHouseFalg(contract.getHouse_id());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Contract> getContractList(Integer page, Integer limit) {
        return houseMapper.getContractList(page,limit);
    }

    @Override
    public void delContract(String code) {
        houseMapper.delContract(code);
    }
}
