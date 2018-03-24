package com.jk.service.house;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.pdf.BaseFont;
import com.jk.mapper.house.HouseMapper;
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
import com.jk.utils.CnNumberUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<HouseResource> getHouseResourceList(Integer page, Integer limit) {
        page = (page - 1) * limit;
        return houseMapper.getHouseResourceList(page, limit);
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
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String emp_id = (String) request.getSession().getAttribute("id");
        house.setId(uuid);
        house.setEmp_id(emp_id);
        houseMapper.addHouseDatasource(house);
        //将房源ID存在session里
        request.getSession().setAttribute("houseid", house.getId());
    }

    /**
     * 新增图片
     */
    @Override
    public void addPicToHousePhoto(HousePhoto housePhoto, HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String houseid = (String) request.getSession().getAttribute("houseid");
        housePhoto.setHouseId(houseid);
        housePhoto.setId(uuid);
        houseMapper.addPicToHousePhoto(housePhoto);
    }

    /**
     * 三级联动
     *
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
     *
     * @param id
     * @return
     */
    @Override
    public HouseResource queryHouseById(String id) {
        return houseMapper.queryHouseById(id);
    }

    /**
     * 修改房源信息
     *
     * @param house
     * @param request
     */
    @Override
    public void updateHouseDatasource(HouseResource house, HttpServletRequest request) {
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
    public List<HouseResource> getHouseResourceListByEmp(String eid, Integer page, Integer limit) {
        page = (page - 1) * limit;
        return houseMapper.getHouseResourceListByEmp(eid, page, limit);
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
        page = (page - 1) * limit;
        return houseMapper.getNotice(page, limit);
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
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Notice> queryNotice(Integer page, Integer limit) {
        page = (page - 1) * limit;
        List<Notice> noticeList = houseMapper.queryNotice(page, limit);
        return noticeList;
    }

    @Override
    public List<Notice> getNoticeInfo(Integer page, Integer limit) {
        return houseMapper.getNoticeInfo(page, limit);
    }

    @Override
    public List<Notice> getNoticeById(String id) {
        return houseMapper.getNoticeById(id);
    }

    @Override
    public List<Temp> getEmpEmail(String id) {
        return houseMapper.getEmpEmail(id);
    }

    /**
     * 新增合同方法
     * @param contract
     */
    @Override
    public Map<String,Object> addContract(Contract contract, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            houseMapper.updHouseFalg(contract.getHouse_id());
            HttpSession session = request.getSession();
            Temp attribute = (Temp) session.getAttribute(session.getId());
            contract.setEid(attribute.getId());
            houseMapper.addContract(contract);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @Override
    public List<Contract> getContractList(Integer page, Integer limit) {
        return houseMapper.getContractList(page, limit);
    }

    @Override
    public void delContract(String code) {
        houseMapper.delContract(code);
    }

    @Override
    public List<HouseResource> getHouseAndEmp() {
        return houseMapper.getHouseAndEmp();
    }

    @Override
    public List<Stages> getStagingType() {
        return houseMapper.getStagingType();
    }

    @Override
    public List<Payment> getPaymentType() {
        return houseMapper.getPaymentType();
    }

    @Override
    public List<HouseResource> getRent(String id) {
        return houseMapper.getRent(id);
    }

    /**
     * 生成word文档
     *
     * @param id
     */
    @Override
    public void toFreeWord(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Configuration configuration = new Configuration();
        String ftlpath = "D:\\practice\\fang";
        String htmlName = "account.ftl";
        Contract contract = houseMapper.queryContracById(id);
        try {
            configuration.setDirectoryForTemplateLoading(new File(ftlpath));
            Template template = configuration.getTemplate(htmlName);
            // 合并模板文件以及数据将其进行输出
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\practice\\fang\\contract.docx"), "utf-8"));
            //进行处理(往map里面存放数据)
            map.put("contract", contract);
            template.process(map, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成odf文档
     *
     * @param id
     */
    @Override
    public void toFreePdf(String id) throws Exception, TemplateException {
          //创建数据模型
        // 制造数据
        Contract contract = houseMapper.queryContracById(id);
        contract.setCnliquidateddamages(CnNumberUtils.toUppercase(contract.getLiquidated_damages()));//违约金
        contract.setCnrentmoney(CnNumberUtils.toUppercase(contract.getRent_money()));
        contract.setCndeposit_money(CnNumberUtils.toUppercase(contract.getDeposit_money()));
        contract.setCnonemoney(CnNumberUtils.toUppercase(contract.getOne_money()));
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("contract", contract);
         //创建配置
        Configuration cfg = new Configuration();
        // 指定模板存放的路径
        cfg.setDirectoryForTemplateLoading(new File("D:\\practice\\fang"));
        cfg.setDefaultEncoding("UTF-8");
        // 从上面指定的模板目录中加载对应的模板文件
        Template temp = cfg.getTemplate("contractPDF.ftl");

         //将生成的内容写入hello .html中
        String fileName = UUID.randomUUID().toString().replace("-", "");
        String file1 = "D:\\practice\\fang" + fileName + ".html";
        File file = new File(file1);
        if (!file.exists())
            file.createNewFile();
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "UTF-8"));
        temp.process(map, out);
        out.flush();

        String url = new File(file1).toURI().toURL().toString();
        String outputFile = "D:\\practice\\fang\\contractPDF" + fileName + ".pdf";
        OutputStream os = new FileOutputStream(outputFile);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        // 解决中文问题
        ITextFontResolver fontResolver = renderer.getFontResolver();
        try {
            fontResolver.addFont("D:\\practice\\fang\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        renderer.layout();
        try {
            renderer.createPDF(os);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("转换成功！");
        os.close();
    }

    @Override
    public List<HouseResource> getHouseAndEmpSell() {
        return houseMapper.getHouseAndEmpSell();
    }
}

