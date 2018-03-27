package com.jk.controller.house;

import com.jk.model.Notice.Notice;
import com.jk.model.area.Area;
import com.jk.model.company.t_company;
import com.jk.model.contract.Contract;
import com.jk.model.decorate.Decorate;
import com.jk.model.house.Community;
import com.jk.model.house.HouseResource;
import com.jk.model.housetype.HouseType;
import com.jk.model.login.Temp;
import com.jk.model.payment.Payment;
import com.jk.model.pic.HousePhoto;
import com.jk.model.stages.Stages;
import com.jk.service.house.HouseService;
import com.jk.utils.EmailUtil;
import com.jk.utils.OssClienUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        Integer housing_state = 1;
        try {
            //判断id是否为空 不为空走修改
            if (house.getId() != null && house.getId() != "") {
                map.put("success", true);
                houseService.updateHouseDatasource(house,request);
            }else{
                house.setHousing_state(housing_state);

                t_company company = (t_company) request.getSession().getAttribute("company");
                house.setCompanyName(company.getCompany_name());

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

	//新增图片（富文本）
    /**
     * 富文本编辑器图片上传
     * @param request
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "headNoticeImgUpload",method = RequestMethod.POST)
    @ResponseBody
    public HashMap upload(HttpServletRequest request, MultipartFile file) throws Exception {
        HashMap<String,Object> map = new HashMap<String, Object>();
        HashMap<String,Object> map2 = new HashMap<String, Object>();
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
            System.out.println(imgUrl);
            map2.put("src",imgUrl);//图片url
            map2.put("width","10px");//图片url
            map2.put("height","10px");//图片url
            map.put("code",0);//0表示成功，1失败
            map.put("msg","上传成功");//提示消息
            map.put("data",map2);
        }catch (Exception e){
            map.put("code",1);//0表示成功，1失败
            map.put("msg","上传失败");//提示消息
            e.printStackTrace();
        }
      /*  String result = new JSONObject(map).toString();*/
        return map;
    }
    @RequestMapping(value = "addNotice")
    @ResponseBody
    public Map<String,Object> addNotice(Notice notice, HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        try{
            HttpSession session = request.getSession();
            Temp emp = (Temp) session.getAttribute(session.getId());
            notice.setId(UUID.randomUUID().toString().replaceAll("-",""));
            notice.setEmpid(emp.getId());
            notice.setEmpname(emp.getName());
            notice.setAuditFlag(1);
            notice.setEmpnum(emp.getPhonenumer());
            notice.setReleasetime(new Date());
            houseService.addNotice(notice);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    /**
     * 查询公告
     * @return
     */
    @RequestMapping(value = "getNotice")
    @ResponseBody
    public Map<String,Object> getNotice(Integer page,Integer limit){
        Map<String,Object> map= new HashMap<String, Object>();
        List<Notice> notice = houseService.getNotice(page,limit);
        System.out.println(notice);
        map.put("data",notice);
        map.put("count",notice.size());
        map.put("msg","");
        map.put("code",0);
        return map;
    }

    /**
     * 修改发布公告为通过
     * @param id
     * @return
     */
    @RequestMapping("updateFlagto2")
    @ResponseBody
    public Map<String,Object> updateFlagto2(String id){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            houseService.updateFlag2(id);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    /**
     * 修改发布公告为通过
     * @param id
     * @return
     */
    @RequestMapping("updateFlagto3")
    @ResponseBody
    public Map<String,Object> updateFlagto3(String id){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            houseService.updateFlagto3(id);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

     /**
     * 修改发布公告为通过
     * @param id
     * @return
     */
    @RequestMapping("updateFlagTo2")
    @ResponseBody
    public Map<String,Object> updateFlagTo2(String id){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            houseService.updateFlagTo2(id);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }


    /**
     * 分页查询发布公告信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "queryNotice")
    @ResponseBody
    public Map<String,Object> queryNotice(Integer page,Integer limit){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Notice> noticeList = houseService.queryNotice(page,limit);
        map.put("data",noticeList);
        map.put("count",noticeList.size());
        map.put("msg","");
        map.put("code",0);
        return map;
    }

    /**
     * 查询公告
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "getNoticeInfo")
    @ResponseBody
    public Map<String,Object> getNoticeInfo(Integer page,Integer limit){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Notice> noticeList = houseService.getNoticeInfo(page,limit);
        map.put("data",noticeList);
        map.put("count",noticeList.size());
        map.put("msg","");
        map.put("code",0);
        return map;
    }

    @RequestMapping("getNoticeById")
    @ResponseBody
    public Map<String,Object> getNoticeById(String id){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Notice> noticeList = houseService.getNoticeById(id);
        ArrayList<String> list = new ArrayList<>();
        for (Notice notice : noticeList) {
            list.add(notice.getContent());
        }
        map.put("content",list);
        return map;
    }

    @RequestMapping("getEmpEmail")
    @ResponseBody
    public Map<String,Object> getEmpEmail(String id){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Temp> temp = houseService.getEmpEmail(id);
        System.out.println(temp);
        ArrayList<String> list = new ArrayList<>();
        for (Temp temp1 : temp) {
            list.add(temp1.getMail());
        }
        map.put("email",list);
        return map;
    }

    @RequestMapping("sendEmail")
    public void sendEmail(Notice notice){
        System.out.println(notice);
        try {
            ArrayList<File> files = new ArrayList<File>();
            for (int i = 0; i < 1; i++) {
                files.add(new File("C:\\Users\\xzkp\\Downloads\\b1cf771d3991e90ee9f9a749563b241b.jpg"));
            }
            EmailUtil.sendHtmlAndFailMail(notice.getMail(),notice.getHeadline(),"hello",files);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

	    /**
     * 新增合同
     * @param contract
     * @return
     */
   /* @RequestMapping("addContract")
    @ResponseBody
    public Map<String,Object> addContract(Contract contract, HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        try{
            String time = String.valueOf(new Date().getTime());
            contract.setCode(time);
            contract.setGeneration_time(new Date());
            houseService.addContract(contract,request);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }finally {
            try {
                //生成word
                houseService.toFreeWord(contract.getCode());
                System.out.println("生成word完成——");
                //生成pdf
                houseService.toFreePdf(contract.getCode());
                System.out.println("生成pdf完成——");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }*/

    /**
     * 查询合同信息
     * @return
     */
    @RequestMapping(value = "getContractList")
    @ResponseBody
    public Map<String,Object> getContractList(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Contract> appointmentList = houseService.getContractList(page,limit);
        map.put("data",appointmentList);
        map.put("count",appointmentList.size());
        map.put("msg","");
        map.put("code",0);
        return map;
    }

    /**
     * 删除合同
     * @param
     * @return
     */
    @RequestMapping(value = "delContract")
    @ResponseBody
    public Map<String,Object> delContract(String code){
        Map<String,Object> map= new HashMap<String, Object>();
        try{
            houseService.delContract(code);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    /**
     * 查询房源信息
     * @return
     */
    @RequestMapping("getHouseAndEmpSell")
    @ResponseBody
    public List<HouseResource> getHouseAndEmpSell(){
        return houseService.getHouseAndEmpSell();
    }



    /**
     * 查询分期
     * @return
     */
    @RequestMapping("getStagingType")
    @ResponseBody
    public List<Stages> getStagingType(){
        return houseService.getStagingType();
    }

    /**
     * 查询付款方式
     * @return
     */
    @RequestMapping("getPaymentType")
    @ResponseBody
    public List<Payment> getPaymentType(){
        return houseService.getPaymentType();
    }

    /**
     * 查询租金
     * @param id
     * @return
     */
    @RequestMapping("getRent")
    @ResponseBody
    public List<HouseResource> getRent(String id){
        return houseService.getRent(id);
    }

    /**
     * 跳转卖房合同
     * @return
     */
    @RequestMapping(value = "sellHosueContrct")
    public String sellHosueContrct(){
        return "/contract/addSellContract";
    }

    /**
     * 查询房源信息
     * @return
     */
    @RequestMapping("getSellHouseAndEmp")
    @ResponseBody
    public  Map<String,Object> getSellHouseAndEmp(Integer page,Integer limit){
        Map<String,Object> map = new HashMap<String, Object>();
        List<HouseResource> houseList = houseService.getSellHouseAndEmp(page,limit);
        map.put("data",houseList);
        map.put("count",houseList.size());
        map.put("msg","");
        map.put("code",0);
        return map;
    }


    /**
     * 计算钱
     * @param contract
     * @return
     */
    @RequestMapping(value = "calculateMonets")
    @ResponseBody
    public Map<String,Object> calculateMonets(Contract contract){
        System.out.println(contract);
        Map<String,Object> map=new HashMap<String, Object>();
        SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
        //计算违约金
        Double unit_price = contract.getUnit_price();
        Double liquidated_damages_ercentage = (contract.getLiquidated_damages_ercentage()*0.01);
        double liquidatedCamages = unit_price * liquidated_damages_ercentage;
        map.put("liquidatedCamages",liquidatedCamages);
        //结束

        //计算迁出时间
        Date date = new Date();
        long time = date.getTime();
        try {
            Date emigration_time = sim.parse(contract.getEmigration_time());
            long time1 = emigration_time.getTime();
            long ouOfDay = time1 - time;
            int ouOfDays = (int) (ouOfDay / (3600 * 24 * 1000));
            if (ouOfDays<0) {
                map.put("mags",false);
            }
            map.put("ouOfDays",ouOfDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //结束
        if(contract.getStaging_state()==1){
            double one_money = (contract.getRent_money() * 3) + contract.getDeposit_money();
            map.put("one_money",one_money);
            double two_money = contract.getRent_money() * 3;
            map.put("two_money",two_money);
        }
        if(contract.getStaging_state()==2){
            double one_money = (contract.getRent_money() * 6) + contract.getDeposit_money();
            map.put("one_money",one_money);
            double two_money = contract.getRent_money() * 6;
            map.put("two_money",two_money);
        }
        if(contract.getStaging_state()==3){
            double one_money = (contract.getRent_money() * 12) + contract.getDeposit_money();
            map.put("one_money",one_money);
        }
        return map;
    }


    /**
     * 新增合同
     * @param contract
     * @return
     */
    @RequestMapping("addContract")
    @ResponseBody
    public Map<String,Object> addContract(Contract contract){
        Map<String,Object> map=new HashMap<String, Object>();
        try{
            String time = String.valueOf(new Date().getTime());
            String code="6000";
            SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            ;
            String format = sim.format(date);
            Date parse = sim.parse(format);
            System.out.println(parse);
            String time2 = String.valueOf(parse.getTime());
            String i = String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
            System.out.println(code+time2+i);
            contract.setOrdernumber(code+time2+i);
            contract.setCode(time);
            contract.setGeneration_time(new Date());
            houseService.addContract(contract);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }


    /**
     * 查询房源信息
     * @return
     */
    @RequestMapping("getHouseAndEmp")
    @ResponseBody
    public  Map<String,Object> getHouseAndEmp(Integer page,Integer limit){
        Map<String,Object> map = new HashMap<String, Object>();
        List<HouseResource> houseList = houseService.getHouseAndEmp(page,limit);
        map.put("data",houseList);
        map.put("count",houseList.size());
        map.put("msg","");
        map.put("code",0);
        return map;
    }

}
