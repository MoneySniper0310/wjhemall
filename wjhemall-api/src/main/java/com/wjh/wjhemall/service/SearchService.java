package com.wjh.wjhemall.service;

import com.wjh.wjhemall.bean.PmsSearchParam;
import com.wjh.wjhemall.bean.PmsSearchSkuInfo;

import java.util.List;

public interface SearchService {


    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
