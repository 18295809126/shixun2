package com.jk.controller.trading;
/**
 * 安晓智
 * 房屋交易
 */

import com.jk.model.contract.Contract;
import com.jk.service.trading.TradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TradingController {
    @Autowired
    private TradingService tradingService;

    @RequestMapping(value = "tradinguser")
    @ResponseBody
    public Map<String,Object> tradinguser(Integer page, Integer limit){
        HashMap<String, Object> map = new HashMap<>();
        try{
            List<Contract> list =  tradingService.tradinguser(page,limit);
            map.put("count",list.size());
            map.put("data",list);
            map.put("code",0);
            map.put("msg","");
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
