package com.xintong.solarpower.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Site
 * @Description TODO
 * @Author zsk
 * @Date 2020/3/3 11:37
 * @Version 1.0
 */
@Data
public class Site implements Serializable {
    private static final long serialVersionUID = 7674335943939631606L;
    private Integer id;
    private Integer siteId;
    private String siteName;

    public Site(Integer id, Integer siteId, String siteName) {
        this.id = id;
        this.siteId = siteId;
        this.siteName = siteName;
    }
}
