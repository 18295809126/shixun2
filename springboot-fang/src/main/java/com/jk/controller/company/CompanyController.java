package com.jk.controller.company;

import com.jk.model.company.t_company;
import com.jk.service.company.CompanyService;
import com.jk.utils.OssClienUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "Company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //跳公司信息页面
    @RequestMapping(value = "toAddCompany")
    public String toAddEmp (){
        return "company/AddCompany";
    }

    //新增公司信息
    @RequestMapping(value = "addCompany")
    @ResponseBody
    public Map addEmp(t_company company, HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        try{
            companyService.addCompany(company);
            request.getSession().setAttribute("company",company);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
        }
        return map;
    }

    /**
     * 图片上传
     * @param request
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "companyImgUpload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> companyImgUpload(HttpServletRequest request, MultipartFile file)throws Exception {
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
}
