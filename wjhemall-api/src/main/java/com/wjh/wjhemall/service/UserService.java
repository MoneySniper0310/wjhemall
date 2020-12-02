package com.wjh.wjhemall.service;



import com.wjh.wjhemall.bean.UmsMember;
import com.wjh.wjhemall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

}
