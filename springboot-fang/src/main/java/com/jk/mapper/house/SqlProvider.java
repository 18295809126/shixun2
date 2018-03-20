package com.jk.mapper.house;


import java.util.Date;
import java.util.Map;

public class SqlProvider {

    /*
    * 分页
    * SQL
    */
    public String bean(Map<String , Object> map){
        StringBuffer house = new StringBuffer();
        try {


        /**
         * Sql省
         */
        final Integer province = (Integer)map.get("province");
        /**
         * Sql市
         */
        final Integer city = (Integer)map.get("city");
        /**
         * Sql县
         */
        final Integer county = (Integer)map.get("county");
        /**
         * Sql标题
         */
        final String title = (String)map.get("title");
        /**
         * Sql最小面积
         */
        final Double house_areaMin= (Double)map.get("house_areaMin");
        /**
         * Sql最大面积
         */
        final Double house_areaMax = (Double)map.get("house_areaMax");

        final Integer price_min = (Integer)map.get("price_min");

        final Integer price_max = (Integer)map.get("price_max");
        /**
         * Sql年代
         */
        final String building_time = (String) map.get("building_time");
        /**
         *Sql室
         */
        final Integer room =(Integer)map.get("room");
        /**
         *Sql厅
         */
        final Integer hall =(Integer)map.get("hall");
        /**
         *Sql卫生间
         */
        final Integer toilet =(Integer)map.get("toilet");
        /**
         * Sql装修情况
         */
        final String decorate = (String)map.get("decorate");


        house.append("SELECT shr.id,shr.emp_id,shr.title,shr.price,shr.room,shr.hall,shr.toilet,shr.house_area,co.name AS community,shr.province,shr.city,shr.county,shr.building_time,ht.name AS NAME,shr.room_direction,shr.house_floor,de.name AS decorate,shr.unit_price,shr.monthly_payments,shr.selling_point,shr.owner_mentality,shr.community_complete,shr.service_introduce,shr.release_time,shr.room_num FROM t_sell_house_resource shr\n" +
                "LEFT JOIN t_house_type ht ON shr.room_type=ht.id\n" +
                "LEFT JOIN t_decorate de ON shr.decorate=de.id\n" +
                "LEFT JOIN t_community co ON shr.community=co.id " );
        house.append("   WHERE 1=1");
        if( province != null && province != -1 ){
            house.append("  and");
            house.append("  shr.province = #{province}");
        }
        if(city != null && city != -1 ){
            house.append("  and");
            house.append("  shr.city = #{city}");
        }
        if( county != null && county != -1 ){
            house.append("  and");
            house.append("  shr.county = #{county}");
        }

         if(title != null && title != ""){
             house.append("  and");
             house.append("  shr.title LIKE '%"+ title+ "%' ");
         }
         if( room != null && room != 0){
             house.append("  and");
             house.append("  shr.room = #{room}");
         }
         if( hall != null && hall != 0){
             house.append("  and");
             house.append("  shr.hall = #{hall}");
         }
         if( toilet != null && toilet != 0 ){
             house.append("  and");
             house.append("  shr.toilet = #{toilet}");
         }
         if( decorate != null && decorate != ""){
             house.append("  and");
             house.append("  shr.decorate = #{decorate}");
         }
            if(price_min != null && price_min != 0){
                house.append("  and");
                house.append("  shr.price >= #{price_min}");
            }
            if(price_max != null && price_max != 0){
                house.append("  and");
                house.append("  shr.price <= #{price_max}");
            }
         if(house_areaMin != null && house_areaMin != 0){
             house.append("  and");
             house.append("  shr.house_area >= #{house_areaMin}");
         }
         if(house_areaMax != null && house_areaMax != 0){
             house.append("  and");
             house.append("  shr.house_area <= #{house_areaMax}");
         }
         if(price_min != null && price_min != 0){
             house.append("  and");
             house.append("  shr.price >= #{price_min}");
         }
         if(price_max != null && price_max != 0){
             house.append("  and");
             house.append("  shr.price <= #{price_max}");
         }
         if(building_time != null&& building_time != ""){
             house.append("  and");
             house.append("  shr.building_time LIKE '%"+ building_time+ "%' ");
         }

        house.append("   LIMIT #{page},#{limit}");

        }catch (Exception e){

            e.printStackTrace();
        }
        return house.toString();
    }

    /*
    * 查询所有
    *   SQL
    */
    public String beanCount(Map<String , Object> map){
        StringBuffer house = new StringBuffer();
        try {

            /**
             * Sql省
             */
            final Integer province = (Integer)map.get("province");
            /**
             * Sql市
             */
            final Integer city = (Integer)map.get("city");
            /**
             * Sql县
             */
            final Integer county = (Integer)map.get("county");
            /**
             * Sql标题
             */
            final String title = (String)map.get("title");
            /**
             * Sql最小面积
             */
            final Double house_areaMin= (Double)map.get("house_areaMin");
            /**
             * Sql最大面积
             */
            final Double house_areaMax= (Double)map.get("house_areaMax");

            final Integer price_min = (Integer)map.get("price_min");
            final Integer price_max = (Integer)map.get("price_max");
            /**
             * Sql年代
             */
            final String building_time = (String) map.get("building_time");
            /**
             *Sql室
             */
            final Integer room =(Integer)map.get("room");
            /**
             *Sql厅
             */
            final Integer hall =(Integer)map.get("hall");
            /**
             *Sql卫生间
             */
            final Integer toilet =(Integer)map.get("toilet");
            /**
             * Sql装修情况
             */
            final String decorate = (String)map.get("decorate");

            house.append("SELECT shr.id,shr.emp_id,shr.title,shr.price,shr.room,shr.hall,shr.toilet,shr.house_area,co.name AS community,shr.province,shr.city,shr.county,shr.building_time,ht.name AS NAME,shr.room_direction,shr.house_floor,de.name AS decorate,shr.unit_price,shr.monthly_payments,shr.selling_point,shr.owner_mentality,shr.community_complete,shr.service_introduce,shr.release_time,shr.room_num FROM t_sell_house_resource shr\n" +
                    "LEFT JOIN t_house_type ht ON shr.room_type=ht.id\n" +
                    "LEFT JOIN t_decorate de ON shr.decorate=de.id\n" +
                    "LEFT JOIN t_community co ON shr.community=co.id " );
            house.append(" WHERE 1=1");
            if( province != null && province != -1 ){
                house.append("  and");
                house.append("  shr.province = #{province}");
            }
            if(city != null && city != -1 ){
                house.append("  and");
                house.append("  shr.city = #{city}");
            }
            if( county != null && county != -1 ){
                house.append("  and");
                house.append("  shr.county = #{county}");
            }

            if(title != null && title != ""){
                house.append("  and");
                house.append("  shr.title LIKE '%"+ title+ "%' ");
            }
            if( room != null && room != 0){
                house.append("  and");
                house.append("  shr.room = #{room}");
            }
            if( hall != null && hall != 0){
                house.append("  and");
                house.append("  shr.hall = #{hall}");
            }
            if( toilet != null && toilet != 0 ){
                house.append("  and");
                house.append("  shr.toilet = #{toilet}");
            }
            if( decorate != null && decorate != ""){
                house.append("  and");
                house.append("  shr.decorate = #{decorate}");
            }
            if(house_areaMin != null && house_areaMin != 0){
                house.append("  and");
                house.append("  shr.house_area >= #{house_areaMin}");
            }
            if(house_areaMax != null && house_areaMax != 0){
                house.append("  and");
                house.append("  shr.house_area <= #{house_areaMax}");
            }
            if(building_time != null && building_time !=""){
                house.append("  and");
                house.append("  shr.building_time LIKE '%"+ building_time+ "%'");
            }

            System.out.println(house.toString());

        }catch (Exception e){

            e.printStackTrace();
        }
        return house.toString();
    }

}
