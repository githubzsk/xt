package com.xintong.solarpower.service.dao;

import com.xintong.solarpower.api.entity.Site;
import org.springframework.stereotype.Repository;

/**
 * @ClassName SiteDao
 * @Description TODO
 * @Author zsk
 * @Date 2020/3/3 13:25
 * @Version 1.0
 */
@Repository
public class SiteDao {
    public Site findSiteById(Integer siteId){
        return new Site(siteId,siteId,"siteName");
    }
}
