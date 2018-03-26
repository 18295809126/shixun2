package com.jk.service.company;

import com.jk.mapper.company.CompanyMapper;
import com.jk.model.company.t_company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public void addCompany(t_company company) {
        companyMapper.addCompany(company);
    }
}
