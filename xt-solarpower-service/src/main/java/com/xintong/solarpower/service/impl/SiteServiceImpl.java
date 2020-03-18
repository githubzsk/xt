package com.xintong.solarpower.service.impl;


import com.xintong.solarpower.api.entity.Site;
import com.xintong.solarpower.api.service.ISiteService;
import com.xintong.solarpower.service.dao.SiteDao;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName SiteServiceImpl
 * @Description TODO
 * @Author zsk
 * @Date 2020/3/3 13:29
 * @Version 1.0
 */
@Service
public class SiteServiceImpl implements ISiteService {

    private static int count = 0;
    private LoadBalance l;



    @Autowired
    private SiteDao siteDao;
    @Override
    public void addSite(Site site) {
        HashMap map = new HashMap();
        map.put("",1);
    }

    @Override
    public void deleteSite(Integer siteId) {

    }

    @Override
    public void updateSite(Site site) {

    }

    @Override
    public Site findSiteById(Integer siteId) {
        System.out.println("come in right");
        return siteDao.findSiteById(siteId);
    }

    @Override
    public List<Site> findAllUser() {
        return null;
    }

    @Override
    public int cleanCount() {
        count = 0;
        System.out.println(count);
        return count;
    }
}
