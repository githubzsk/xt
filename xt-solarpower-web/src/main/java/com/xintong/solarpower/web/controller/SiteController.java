package com.xintong.solarpower.web.controller;



import com.xintong.solarpower.api.entity.Site;
import com.xintong.solarpower.api.entity.User;
import com.xintong.solarpower.api.service.ISiteService;
import com.xintong.solarpower.api.service.IUserService;
import com.xintong.solarpower.api.utils.ResultMap;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName SiteController
 * @Description TODO
 * @Author zsk
 * @Date 2020/3/3 12:50
 * @Version 1.0
 */
@RestController
public class SiteController {

    @Reference(timeout = 100)
    private ISiteService siteService;


    @GetMapping("/siteUser")
    public ResultMap getSiteAndUser(){
        Site site = siteService.findSiteById(1);
        Map<String,Object> map = new HashMap<>();
        map.put("site",site);
        return ResultMap.success(map);
    }

    @GetMapping("/cleanCount")
    public ResultMap cleanCount(){
        int site = siteService.cleanCount();
        return ResultMap.success(site);
    }


}
