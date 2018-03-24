package com.jk.service.trading;

import com.jk.mapper.trading.TradingMapper;
import com.jk.model.contract.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradingServiceImpl implements TradingService {
    @Autowired
    private TradingMapper tradingMapper;


    @Override
    public List<Contract> tradinguser(Integer page, Integer limit) {

        page=(page-1)*limit;
        return tradingMapper.tradinguser(page,limit);
    }
}
