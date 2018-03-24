package com.jk.controller.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.jk.model.area.AllArea;
import com.jk.model.house.HouseResource;
import com.jk.service.weather.WeatherService;
import com.jk.utils.HttpClient;
import com.jk.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "getWeather")
    @ResponseBody
    public Map getWeather(){
        //总数据源
        HashMap<String, Object> map = new HashMap<String, Object>();
        //所有日期
        List<String> weekList = new ArrayList<String>();
        //所有温度
        List<String> temperatureList = new ArrayList<String>();
        //所有低温
        List<String> LowList = new ArrayList<String>();
        String url = "http://wthrcdn.etouch.cn/weather_mini";
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("city", " ");
        String s = HttpClient.get(url, params);
        //System.out.println(s);
        JsonNode jsonNode = null;
        try {
            jsonNode = JsonUtil.jsonToJsonNode(s);
            JsonNode data = jsonNode.get("data");
            JsonNode forecast = data.get("forecast");
            for (JsonNode node : forecast) {
                String qqq = node.get("high").asText().replace("℃","");
                String xxx = node.get("low").asText().replace("℃","");
                weekList.add(node.get("date").asText().substring(3));
                temperatureList.add(qqq.substring(3));
                LowList.add(xxx.substring(3));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("weekList",weekList);
        map.put("temperatureList",temperatureList);
        map.put("LowList",LowList);
        if(map!=null){
            redisTemplate.opsForHash().putAll("数据",map);
            redisTemplate.expire("天气数据",60, TimeUnit.MINUTES);
        }
        return map;
    }

    //饼状图
    @RequestMapping(value = "getHouse")
    @ResponseBody
    public List getHouse(HouseResource resource){
        System.out.println("地址--"+resource);
        List<HouseResource> house = weatherService.getHouse();
        return house;
    }

    //带条件查询饼状
    @RequestMapping(value = "getHouseTwo")
    @ResponseBody
    public List getHouseTwo(HouseResource sellHouseResource){
        System.out.println("条件查询"+sellHouseResource);
        List<HouseResource> house = weatherService.getHouseTwo(sellHouseResource);
        System.out.println("查询出来的结果"+house);
        return house;
    }

    //三级联动 省
    @RequestMapping("queryProvince")
    @ResponseBody
    public  List<AllArea> queryProvince(){
        return weatherService.queryProvince();
    }

    //三级联动 市
    @RequestMapping("queryCity")
    @ResponseBody
    public List<AllArea> queryCity(Integer id){
        return weatherService.queryCity(id);
    }

    //三级联动 县
    @RequestMapping("queryCountry")
    @ResponseBody
    public List<AllArea> queryCountry(Integer id){
        return weatherService.queryCountry(id);
    }

}
