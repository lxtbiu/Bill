package com.ljt.springboot.mapper;

import com.ljt.springboot.entities.Bill;
import com.ljt.springboot.entities.BillProvider;

import java.util.List;

public interface BillMapper {

    List<BillProvider> getBills(Bill bill);

    BillProvider getBillByBid(Integer bid);

    int addBill(Bill bill);

    int deleteBillByBid(Integer bid);

    int updateBill(Bill bill);

}
