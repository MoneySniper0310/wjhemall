package com.wjh.wjhemall.service;

import com.wjh.wjhemall.bean.PmsProductImage;
import com.wjh.wjhemall.bean.PmsProductInfo;
import com.wjh.wjhemall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductImage> spuImageList(String spuId);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

//    List<PmsProductSaleAttr> spuSaleAttrListBySku(String productId, String skuId);

    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId, String id);
}
