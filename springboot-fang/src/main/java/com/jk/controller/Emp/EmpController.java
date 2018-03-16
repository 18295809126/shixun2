package com.jk.controller.Emp;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.Emp.t_emp;
import com.jk.service.Emp.EmpService;
import com.jk.utils.OssClienUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "Emp")
public class EmpController {

    @RequestMapping(value = "toAddEmp")
    public String toAddEmp (){
        return "AddEmp";
    }

    @RequestMapping(value = "toEmp")
    public String toEmp (){

        return "Emp";
    }

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "showEmp")
    @ResponseBody
    public Map<String,Object> showEmp (Integer page, Integer rows){
        List<t_emp> list = empService.getEmp(page, rows);
       // System.out.println(list);
       // JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }


    /**
     * 图片上传
     * @param request
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "headImgUpload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> headImgUpload(HttpServletRequest request, MultipartFile file)throws Exception {
        System.out.println(file);
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
            System.out.println(imgUrl);
            map.put("success", true);
            map.put("path", imgUrl);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }


    @RequestMapping(value = "delEmp")
    @ResponseBody
    public Map delEmp(String id){
        HashMap<String, Object> map = new HashMap<>();
        try{
            empService.delEmp(id);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
        }
        return map;
    }

    @RequestMapping(value = "submitEmp")
    @ResponseBody
    public Map submitEmp(t_emp emp){

        if(StringUtils.isEmpty(emp.getId())){
            Map map = addEmp(emp);
            return map;
        }else {
            Map map = updEmp(emp);
            return map;
        }
    }

    @RequestMapping(value = "addEmp")
    @ResponseBody
    public Map addEmp(t_emp emp){
        emp.setId(UUID.randomUUID().toString().replaceAll("-",""));
        HashMap<String, Object> map = new HashMap<>();
        // System.out.println(emp);
        try{
            empService.addEmp(emp);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
        }
        return map;
    }

    //回显
    @RequestMapping("huixianById")
    @ResponseBody
    public ModelAndView huixianById(String id){
        ModelAndView mode = new ModelAndView("AddEmp");
        t_emp emp = empService.huixianById(id);
        mode.addObject("emp",emp);
        return mode;
    }

    @RequestMapping(value = "updEmp")
    @ResponseBody
    public Map updEmp(t_emp emp){
        HashMap<String, Object> map = new HashMap<>();
        try{
            empService.updEmp(emp);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
        }
        return map;
    }


}

