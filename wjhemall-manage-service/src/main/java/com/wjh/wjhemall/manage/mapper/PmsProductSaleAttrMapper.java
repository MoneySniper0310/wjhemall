package com.wjh.wjhemall.manage.mapper;

import com.wjh.wjhemall.bean.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr> {

//    List<PmsProductSaleAttr> selectWithChecked(@Param("productId") String productId, @Param("skuId") String skuId);

    List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(@Param("productId") String productId, @Param("skuId") String skuId);
}
