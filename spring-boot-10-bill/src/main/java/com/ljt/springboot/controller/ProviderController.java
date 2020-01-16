package com.ljt.springboot.controller;

import com.ljt.springboot.dao.ProviderDao;
import com.ljt.springboot.entities.Provider;
import com.ljt.springboot.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/***
 * 供应商的控制层
 */
@Controller
public class ProviderController {

    @Autowired
    ProviderDao providerDao;

    @Autowired
    ProviderMapper providerMapper;

    @GetMapping("/providers")
    public String list(Map<String,Object> map,Provider provider){
        //供应商列表查询
        List<Provider> providers = providerMapper.getProviders(provider);
        map.put("providers",providers);
        map.put("providerName",provider.getProviderName());
        return "provider/list";
    }

    /***
     * type = null 进入查看详情页界面view.html
     * type = update，则是进入update.html
     * @param pid 供应商id
     * @param type
     * @param map
     * @return
     */
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid ,@RequestParam(value = "type",defaultValue = "view") String type, Map<String,Object> map){
        Provider provider = providerMapper.getProviderByPid(pid);
        map.put("provider",provider);
        //如果type = null进入 view。html，type = update，则是进入update.html
        return "provider/"+ type;
    }
    //修改供应商操作
    @PutMapping("/provider")
    public String update(Provider provider){
        //更新操作
        providerMapper.updateProvider(provider);
        return "redirect:providers";
    }

    //前往添加页面
    @GetMapping("/provider")
    public String toAddPage(){
        return "provider/add";
    }

    //添加数据
    @PostMapping("/provider")
    public String add(Provider provider){
        //保存数据操作
        providerMapper.addProvider(provider);
        return "redirect:/providers";
    }

    //删除供应商数据
    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid){

        providerMapper.deleteProviderByPid(pid);
        return "redirect:/providers";
    }
}
