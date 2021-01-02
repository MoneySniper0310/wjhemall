package com.wjh.wjhemall.manage.mapper;

import com.wjh.wjhemall.bean.PmsBaseAttrInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsBaseAttrInfoMapper extends Mapper<PmsBaseAttrInfo> {
    List<PmsBaseAttrInfo> selectByValueIdString(@Param("valueIdStr") String valueIdStr);
}
