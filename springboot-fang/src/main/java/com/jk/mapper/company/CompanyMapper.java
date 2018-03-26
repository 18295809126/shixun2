package com.jk.mapper.company;

import com.jk.model.company.t_company;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CompanyMapper {
    @Insert("insert into t_company(id,company_name,company_logo,company_introduction,company_homepage,alipay_img,wx_img,accounts) values(#{id},#{company_name},#{company_logo},#{company_introduction},#{company_homepage},#{alipay_img},#{wx_img},#{accounts})")
    void addCompany(t_company company);
}
