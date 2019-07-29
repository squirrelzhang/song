package com.cskaoyan.wdjava.service.impl;

import com.cskaoyan.wdjava.bean.WdAdmin;
import com.cskaoyan.wdjava.bean.WdAdminExample;
import com.cskaoyan.wdjava.mapper.WdAdminMapper;
import com.cskaoyan.wdjava.service.WdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WdUserServiceImpl implements WdUserService {

    @Autowired
    WdAdminMapper wdAdminMapper;

    public WdAdmin queryAdmin(String username) {
        WdAdminExample wdAdminExample = new WdAdminExample();
        wdAdminExample.createCriteria().andUsernameEqualTo(username);
        List<WdAdmin> wdAdmins = wdAdminMapper.selectByExample(wdAdminExample);

        return wdAdmins.size() == 0 ? null : wdAdmins.get(0);
    }

}
