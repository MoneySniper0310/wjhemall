package com.wjh.wjhemall.user.mapper;


import com.wjh.wjhemall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UmsMember> {

    List<UmsMember> selectAllUser();

}
