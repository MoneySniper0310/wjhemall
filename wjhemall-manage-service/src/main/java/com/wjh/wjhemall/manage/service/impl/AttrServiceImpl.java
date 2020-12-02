package com.wjh.wjhemall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wjh.wjhemall.bean.PmsBaseAttrInfo;
import com.wjh.wjhemall.bean.PmsBaseAttrValue;
import com.wjh.wjhemall.bean.PmsBaseSaleAttr;
import com.wjh.wjhemall.manage.mapper.PmsBaseAttrInfoMapper;
import com.wjh.wjhemall.manage.mapper.PmsBaseAttrValueMapper;
import com.wjh.wjhemall.manage.mapper.PmsBaseSaleAttrMapper;
import com.wjh.wjhemall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;


    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);

        for (PmsBaseAttrInfo baseAttrInfo: pmsBaseAttrInfos) {
//            List<PmsBaseAttrValue> baseAttrValueList = new ArrayList<>();
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(baseAttrInfo.getId());
            List<PmsBaseAttrValue> baseAttrValueList = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
            baseAttrInfo.setAttrValueList(baseAttrValueList);
        }
        return pmsBaseAttrInfos;
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        String id = pmsBaseAttrInfo.getId();
        if (StringUtils.isBlank(id)) {
            //id为空
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
            //存Value
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue attrValue : attrValueList) {
                attrValue.setAttrId(pmsBaseAttrInfo.getId());

                pmsBaseAttrValueMapper.insertSelective(attrValue);
            }
        }else {
            // id不空，修改
            // 属性修改
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());  //修改条件表达式
            pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);  //目标数据，原始数据(条件id)

            // 属性值修改
            // 按照属性id删除所有属性值
            PmsBaseAttrValue pmsBaseAttrValueDel = new PmsBaseAttrValue();
            pmsBaseAttrValueDel.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValueDel);

            // 删除后，将新的属性值插入
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }

        }
        return "sucess";
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> pmsBaseAttrValueList = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValueList;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }

}
