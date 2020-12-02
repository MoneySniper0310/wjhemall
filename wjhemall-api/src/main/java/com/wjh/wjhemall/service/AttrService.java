package com.wjh.wjhemall.service;

import com.wjh.wjhemall.bean.PmsBaseAttrInfo;
import com.wjh.wjhemall.bean.PmsBaseAttrValue;
import com.wjh.wjhemall.bean.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();

}
