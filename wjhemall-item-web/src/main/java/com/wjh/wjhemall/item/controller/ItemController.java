package com.wjh.wjhemall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.wjh.wjhemall.bean.PmsProductSaleAttr;
import com.wjh.wjhemall.bean.PmsSkuAttrValue;
import com.wjh.wjhemall.bean.PmsSkuInfo;
import com.wjh.wjhemall.bean.PmsSkuSaleAttrValue;
import com.wjh.wjhemall.service.SkuService;
import com.wjh.wjhemall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class ItemController {

    @Reference
    SkuService skuService;   //有 就不用写ItemService了   面向服务！！！！！！！！

    @Reference
    SpuService spuService;

    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId,ModelMap map){

        PmsSkuInfo pmsSkuInfo = skuService.getSkuById(skuId);

        //sku对象
        map.put("skuInfo",pmsSkuInfo);
        //销售属性列表
        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(),pmsSkuInfo.getId());
        map.put("spuSaleAttrListCheckBySku",pmsProductSaleAttrs);

        // 查询当前sku的spu的其他sku的集合的hash表
        Map<String, String> skuSaleAttrHash = new HashMap<>();
        List<PmsSkuInfo> pmsSkuInfos = skuService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());

        for (PmsSkuInfo skuInfo : pmsSkuInfos) {
            String k = "";
            String v = skuInfo.getId();
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                k += pmsSkuSaleAttrValue.getSaleAttrValueId() + "|";// "239|245"
            }
            skuSaleAttrHash.put(k,v);
        }

        // 将sku的销售属性hash表放到页面
        String skuSaleAttrHashJsonStr = JSON.toJSONString(skuSaleAttrHash);
        map.put("skuSaleAttrHashJsonStr",skuSaleAttrHashJsonStr);


        return "item";
    }
}
