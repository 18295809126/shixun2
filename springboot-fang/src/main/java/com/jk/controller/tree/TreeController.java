package com.jk.controller.tree;

import com.jk.model.login.Temp;
import com.jk.model.tree.Tree;
import com.jk.service.tree.TreeService;
import com.jk.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    /**
     *跳转到新增房源页面
     * */
    @RequestMapping(value = "toAddHouseMessage")
    public String toAddHouseMessage(){
        return "house/addHouse";
    }

    /**
     * 跳转查看房源信息列表
     * @return
     */
    @RequestMapping(value = "toShowHouse")
    public String toShowHouse(){
        return "showHouse";
    }

    /**
     * house 树
     */
    @RequestMapping(value = "queryTree")
    @ResponseBody
    public List<Map<String,Object>> getTree(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        String id = session.getId();
        if(!StringUtils.isEmpty(session.getAttribute(id))){
            Temp emp = (Temp) session.getAttribute(session.getId());
            List<Tree> list = treeService.getTree(emp.getId());
            List<Map<String, Object>> maps = printTree(list, 0);
            //String s = JsonUtil.entityToJson(maps);
            return maps;

        }
        else{

            return null;
        }

    }
    /**
     * 整理菜单
     * @return
     */
    public List<Map<String,Object>> printTree(List<Tree> list,Integer pid){
        List<Map<String,Object>> li = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < list.size(); i++) {
            Map<String,Object> map = null;
            Tree houseTree = list.get(i);
            if(houseTree.getPid() == pid){
                map = new HashMap<String,Object>();
                map.put("id", houseTree.getId());
                map.put("title", houseTree.getTitle());
                map.put("href", houseTree.getHref());
                map.put("spread", houseTree.getSpread());
                map.put("icon", houseTree.getIcon());
                map.put("pid", houseTree.getPid());
                map.put("children", printTree(list,houseTree.getId()));
            }
            if(map != null){
                List<Map<String,Object>> l = (List<Map<String, Object>>)map.get("children");
                if(l.size() == 0){
                    map.remove("children");
                }
                li.add(map);
            }
        }
        return li;

    }

    /**
     * 跳转我的发布
     * @return
     */
    @RequestMapping(value = "toShowMyPublish")
    public String toShowMyPublish(){
        return "/showMyPublish";
    }
    //跳日志管理
    @RequestMapping(value = "getkaka")
    public String getkaka(){
        return "log";
    }

	/**
     * 跳转发布公告页面
     * @return
     */
    @RequestMapping(value = "toAddNotice")
    public String toAddNotice(){
        return "notice/addNotice";
    }

    /**
     * 跳转公告查看页面
     * @return
     */
    @RequestMapping(value = "toShowNotice")
    public String toShowNotice(){
        return "notice/showNotice";
    }

    /**
     * 跳转到登录员工发布的公告页面
     */
    @RequestMapping(value = "toQueryNotice")
    public String toQueryNotice(){
        return "notice/showEmpNotice";
    }

    /**
     * 跳转到预览合同页面
     * @return
     */
    @RequestMapping(value = "toPreviewContract")
    public String toPreviewContract(){
        return "contract/previewContract";
    }
}
