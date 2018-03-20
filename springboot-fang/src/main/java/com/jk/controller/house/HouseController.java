package com.jk.controller.house;

import com.jk.model.area.Area;
import com.jk.model.decorate.Decorate;
import com.jk.model.house.Community;
import com.jk.model.house.HouseResource;
import com.jk.model.housetype.HouseType;
import com.jk.model.login.Temp;
import com.jk.model.pic.HousePhoto;
import com.jk.service.house.HouseService;
import com.jk.utils.OssClienUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "house")
public class HouseController {

    @Autowired
    private HouseService houseService;

//    /**
//     * 查询房源信息
//     * @return houseResourceList
//     */
//    @RequestMapping(value = "getHouseResourceList")
//    @ResponseBody
//    public Map<String,Object> getHouseResourceList(Integer page,Integer limit){
//        Map<String,Object> map= new HashMap<String, Object>();
//        List<HouseResource> houseResourceList = houseService.getHouseResourceList(page,limit);
//        System.out.println(houseResourceList);
//        map.put("data",houseResourceList);
//        map.put("count",houseResourceList.size());
//        map.put("msg","");
//        map.put("code",0);
//        return map;
//    }




    /**
     * 查询房源信息分页
     * @return houseResourceList
     */
    @RequestMapping(value = "getHouseResourceList")
    @ResponseBody
    public String getHouseResourceList(HouseResource houseResource, Integer page, Integer limit) {

        page =(page-1)* limit;
        Map map = new HashMap();
        map.put("page", page);
        map.put("limit",limit);
        map.put("city",houseResource.getCity());
        map.put("county",houseResource.getCounty());
        map.put("title",houseResource.getTitle());
        map.put("house_areaMin",houseResource.getHouse_areaMin());
        map.put("house_areaMax",houseResource.getHouse_areaMax());
        map.put("building_time",houseResource.getBuilding_time());
        map.put("room",houseResource.getRoom());
        map.put("hall",houseResource.getHall());
        map.put("toilet",houseResource.getToilet());
        map.put("decorate",houseResource.getDecorate());
        map.put("price_min",houseResource.getPrice_min());
        map.put("price_max",houseResource.getPrice_max());
        return queryHouseList(map);
    }

    /**
     * 条件查询房源信息
     * @param map
     * @return
     */
    private String queryHouseList(Map<String,String> map) {
        String booklist="";
        try {
            System.out.println(map);
            booklist=houseService.queryHouseList(map);
            return  booklist;
        }catch (Exception e){
            e.printStackTrace();
        }
        return booklist;
    }


    /**
     * 删除房源信息
     * @param id
     * @return
     */
    @RequestMapping(value = "delHouseById")
    @ResponseBody
    public Map<String,Object> delHouseById(String id){
        Map<String,Object> map= new HashMap<String, Object>();
        try{
            houseService.delHouseById(id);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    /**
     * 跳转详情页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "showHouseInfo")
    public String showHouseInfo(String id, Model model){
        HouseResource houseById = houseService.getHouseById(id);
        System.out.println(houseById);
        model.addAttribute("house",houseById);
        return "showHouseInfo";
    }

    /**
     * 获取房源图
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "getHousePhoto")
    @ResponseBody
    public  Map<String,Object>  getHousePhoto(String id, Model model){
        Map<String,Object> map= new HashMap<String, Object>();
        List<HousePhoto> housePhoto = houseService.getHousePhoto(id);
        System.out.println(housePhoto);
        ArrayList<String> list = new ArrayList<>();
        for (HousePhoto photo : housePhoto) {
            list.add(photo.getUrl());
        }
        map.put("url",list);
        System.out.println(map);
        return map;
    }

    /**
     * 新增房源
     * @param house
     * @param request
     * @return
     */
    @RequestMapping(value = "addHouseDatasource")
    @ResponseBody
    public Map<String,Object> addHouseDatasource(HouseResource house, HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //判断id是否为空 不为空走修改
            if (house.getId() != null && house.getId() != "") {
                map.put("success", true);
                houseService.updateHouseDatasource(house,request);
            }else{
                houseService.addHouseDatasource(house,request);
                map.put("success", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("fail", false);
        }
        return map;
    }

    @RequestMapping(value = "queryHouseById")
    @ResponseBody
    public ModelAndView queryHouseById(String id){
        ModelAndView mv = new ModelAndView();
        HouseResource houseResource = houseService.queryHouseById(id);
        mv.addObject("houseResource",houseResource);
        mv.setViewName("house/updateHouse");
        return mv;
    }

    @RequestMapping(value = "queryHouseByIds")
    @ResponseBody
    public ModelAndView queryHouseByIds(String id){
        ModelAndView mv = new ModelAndView();
        HouseResource houseResource = houseService.queryHouseById(id);
        mv.addObject("houseResource",houseResource);
        mv.setViewName("house/updateMyHouse");
        return mv;
    }
    /**
     * 图片上传
     * @param request
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/headImgUpload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> headImgUpload(HttpServletRequest request, MultipartFile file)throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            if (file == null || file.getSize() <= 0) {
                throw new Exception("图片不能为空");
            }
            String  nameHz= file.getOriginalFilename(); //上传的文件名 + 后缀    如  asd.png
            String type = "";
            if(nameHz.contains(".png") || nameHz.contains(".jpg")){
                type="img";
            }
            if(nameHz.contains(".mp4") || nameHz.contains(".ogv")){
                type="video";
            }else {
                type="file";
            }
            OssClienUtils ossClient = new OssClienUtils();
            String keyName = ossClient.uploadImg2Oss(file,type);
            String imgUrl = ossClient.getImgUrl(keyName);
            //新增房源图到房源图表
            HousePhoto housePhoto = new HousePhoto();
            housePhoto.setUrl(imgUrl);
            housePhoto.setType(1);
            houseService.addPicToHousePhoto(housePhoto,request);

            map.put("success", true);
            map.put("path", imgUrl);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    /**
     * 查询省级、市级、县级信息   三级联动
     * @param pid
     * @param request
     * @return
     */
    @RequestMapping(value = "selectProvince")
    @ResponseBody
    public List<Area> selectProvince(String pid,HttpServletRequest request){

        List<Area> list = houseService.queryProvice(pid);
        return  list;
    }

    /**
     * 查询房屋类型
     * @return
     */
    @RequestMapping(value = "selectRoomType")
    @ResponseBody
   public List<HouseType> selectRoomType(){
        List<HouseType> houseTypeList = houseService.selectRoomType();
        return  houseTypeList;
   }

    /**
     * 查询装修程度
     * @return
     */
   @RequestMapping(value = "selectDecorate")
   @ResponseBody
   public List<Decorate> selectDecorate(){
       List<Decorate> decorateList = houseService.selectDecorate();
       return  decorateList;
   }

    /**
     * 查询所在小区
     * @return
     */
    @RequestMapping(value = "selectCommunity")
    @ResponseBody
   public List<Community> selectCommunity(){
       List<Community> communityList = houseService.selectCommunity();
       return communityList;
   }

    /**
     * 新增完成以后跳转到房源展示页面
     * @return
     */
   @RequestMapping(value = "toShowHouse")
   public String toShowHouse(){
        return "showHouse";
   }/**

     * 新增完成以后跳转到房源展示页面
     * @return
     */
   @RequestMapping(value = "toShowMyHouse")
   public String toShowMyHouse(){
        return "showMyPublish";
   }

   @RequestMapping("addMyHouse")
   public String addMyHouse(){
       return "house/addMyHouse";
   }




    /**
     * 我的发布
     * @param request
     * @return
     */
    @RequestMapping(value = "getHouseResourceListByEmp")
    @ResponseBody
    public Map<String,Object> getHouseResourceListByEmp(HttpServletRequest request,Integer page,Integer limit){
        Map<String,Object> map = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        Temp temp = (Temp) session.getAttribute(session.getId());
        System.out.println(temp.getId());
        List<HouseResource> tempList =  houseService.getHouseResourceListByEmp(temp.getId(),page,limit);
        System.out.println(tempList);
        map.put("data",tempList);
        map.put("msg","");
        map.put("code",0);
        map.put("count",houseService.getCountHouseResourceListByEmp(temp.getId()).size());
        return map;
    }

    @RequestMapping(value = "addHouse")
    public String addHouse(){
        return "house/addHouse";
    }
}
