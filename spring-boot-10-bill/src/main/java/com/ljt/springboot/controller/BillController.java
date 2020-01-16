package com.ljt.springboot.controller;

import com.ljt.springboot.entities.Bill;
import com.ljt.springboot.entities.BillProvider;
import com.ljt.springboot.entities.Provider;
import com.ljt.springboot.mapper.BillMapper;
import com.ljt.springboot.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class BillController {


    @Autowired
    ProviderMapper providerMapper;

    @Autowired
    BillMapper billMapper;

    @GetMapping("/bills")
    public String list(Map<String,Object> map, Bill bill){
        //列表查询
        List<BillProvider> billProviders = billMapper.getBills(bill);

        //获取所有的供应商
        List<Provider> providers = providerMapper.getProviders(null);
        map.put("billProviders",billProviders);
        map.put("providers",providers);
        //用户搜索回显数据
        map.put("billName",bill.getBillName());
        map.put("pid",bill.getPid());
        map.put("pay",bill.getPay());
        return "bill/list";
    }

    /***
     * type = null 进入查看详情页界面view.html
     * type = update，则是进入update.html
     */
    @GetMapping("/bill/{bid}")
    public String view(@PathVariable("bid") Integer bid ,@RequestParam(value = "type",defaultValue = "view") String type, Map<String,Object> map){
        BillProvider billProvider = billMapper.getBillByBid(bid);
        if ("update".equals(type)) {
            List<Provider> providers = providerMapper.getProviders(null);
            map.put("providers",providers);
        }

        map.put("billProvider",billProvider);
        //如果type = null进入 view。html，type = update，则是进入update.html
        return "bill/"+ type;
    }
    //修改操作
    @PutMapping("/bill")
    public String update(Bill bill){
        //更新操作
        billMapper.updateBill(bill);
        return "redirect:bills";
    }

    //前往添加页面
    @GetMapping("/bill")
    public String toAddPage(Map<String,Object> map){
        List<Provider> providers = providerMapper.getProviders(null);
        map.put("providers",providers);
        return "bill/add";
    }

    //添加数据
    @PostMapping("/bill")
    public String add(Bill bill){

        //保存数据操作
        billMapper.addBill(bill);
        return "redirect:/bills";
    }

    //删除数据
    @DeleteMapping("/bill/{bid}")
    public String delete(@PathVariable("bid") Integer bid){

        billMapper.deleteBillByBid(bid);
        return "redirect:/bills";
    }
}
