package com.wjh.wjhemall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wjh.wjhemall.bean.PmsBaseAttrInfo;
import com.wjh.wjhemall.bean.PmsBaseAttrValue;
import com.wjh.wjhemall.bean.PmsBaseSaleAttr;
import com.wjh.wjhemall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
public class AttrController {

    @Reference
    AttrService attrService;

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        String  sucess = attrService.saveAttrInfo(pmsBaseAttrInfo);
        return sucess;
    }

    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(){

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = attrService.baseSaleAttrList();
        return pmsBaseSaleAttrs;
    }

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){

        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrService.attrInfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){

        List<PmsBaseAttrValue> pmsBaseAttrValueList = attrService.getAttrValueList(attrId);
        return pmsBaseAttrValueList;
    }
}
