package com.xintong.solarpower.api.service;

import com.xintong.solarpower.api.entity.Site;

import java.util.List;

/**
 * @ClassName ISiteService
 * @Description TODO
 * @Author zsk
 * @Date 2020/3/3 11:49
 * @Version 1.0
 */
public interface ISiteService {
    void addSite(Site site);
    void deleteSite(Integer siteId);
    void updateSite(Site site);
    Site findSiteById(Integer siteId);
    List<Site> findAllUser();
    int cleanCount();
}
