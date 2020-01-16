package com.ljt.springboot;

import com.ljt.springboot.entities.Provider;
import com.ljt.springboot.mapper.ProviderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBillApplicationTests {

    @Autowired
    ProviderMapper providerMapper;
    @Test
    public void contextLoads() {

        Provider p = new Provider();
        p.setProviderName("A货");
        List<Provider> providers = providerMapper.getProviders(p);
        System.out.println(providers.get(0));
    }

}
