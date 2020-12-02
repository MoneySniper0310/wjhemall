package com.wjh.wjhemall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wjh.wjhemall.bean.PmsSkuInfo;
import com.wjh.wjhemall.service.SkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class SkuController {

    @Reference
    SkuService skuService;

    @RequestMapping("saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {

        //spuId传递给productId
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());

        //处理默认图片
        String skuDefaultImag = pmsSkuInfo.getSkuDefaultImg();
        if (StringUtils.isBlank(skuDefaultImag)) {
//            pmsSkuInfo.setSkuDefaultImg("http://192.168.146.134/group1/M00/00/00/wKiShl-8PSeAXb-9AAAkEuWWxhE879.jpg");
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }

        skuService.saveSkuInfo(pmsSkuInfo);
        return "success";
    }
}
