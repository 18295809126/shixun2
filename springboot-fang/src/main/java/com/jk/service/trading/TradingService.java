package com.jk.service.trading;

import com.jk.model.contract.Contract;

import java.util.List;

public interface TradingService {

    List<Contract> tradinguser(Integer page, Integer limit);
}
