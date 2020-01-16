package com.ljt.springboot.entities;

/**
 * 封装新的实体，因为账单列表还有详情都要有供应商的名称
 */
public class BillProvider extends Bill {

    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
