package com.wjh.wjhemall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wjh.wjhemall.bean.PmsProductImage;
import com.wjh.wjhemall.bean.PmsProductInfo;
import com.wjh.wjhemall.bean.PmsProductSaleAttr;
import com.wjh.wjhemall.bean.PmsProductSaleAttrValue;
import com.wjh.wjhemall.manage.mapper.PmsProductImageMapper;
import com.wjh.wjhemall.manage.mapper.PmsProductInfoMapper;
import com.wjh.wjhemall.manage.mapper.PmsProductSaleAttrMapper;
import com.wjh.wjhemall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.wjh.wjhemall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {

        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfoList = pmsProductInfoMapper.select(pmsProductInfo);
        return pmsProductInfoList;
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {

        //保存商品信息
        pmsProductInfoMapper.insertSelective(pmsProductInfo);

        //生成商品主键
        String pmsProductId = pmsProductInfo.getId();

        //保存商品图片信息
        List<PmsProductImage> pmsProductImages = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : pmsProductImages) {
            pmsProductImage.setProductId(pmsProductId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }

        //保存商品销售属性
        List<PmsProductSaleAttr> spuSaleAttrs = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr spuSaleAttr : spuSaleAttrs) {
            spuSaleAttr.setProductId(pmsProductId);
            pmsProductSaleAttrMapper.insertSelective(spuSaleAttr);

            //保存商品销售属性值信息
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = spuSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : pmsProductSaleAttrValues) {
                pmsProductSaleAttrValue.setProductId(pmsProductId);
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        PmsProductImage pmsProductImage = new PmsProductImage();
        pmsProductImage.setProductId(spuId);
        List<PmsProductImage> pmsProductImages = pmsProductImageMapper.select(pmsProductImage);

        return pmsProductImages;
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {

        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);

        for (PmsProductSaleAttr productSaleAttr : pmsProductSaleAttrs) {
            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setProductId(spuId);
            pmsProductSaleAttrValue.setSaleAttrId(productSaleAttr.getSaleAttrId());// 销售属性id用的是系统的字典表中id，不是销售属性表的主键
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);
            productSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValues);
        }

        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId, String skuId) {

//        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
//        pmsProductSaleAttr.setProductId(productId);
//        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);
//
//        for (PmsProductSaleAttr pmsProductSaleAttr1 : pmsProductSaleAttrList) {
//            String saleAttrId = pmsProductSaleAttr1.getSaleAttrId();
//
//            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
//            pmsProductSaleAttrValue.setSaleAttrId(saleAttrId);
//            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);
//
//            pmsProductSaleAttr1.setSpuSaleAttrValueList(pmsProductSaleAttrValues);
//        }
//        return pmsProductSaleAttrList;
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.selectSpuSaleAttrListCheckBySku(productId,skuId);
        return pmsProductSaleAttrs;
    }

}
