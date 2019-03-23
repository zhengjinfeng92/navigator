package com.antiless.navigator.service;

import com.alibaba.fastjson.JSONObject;
import com.antiless.navigator.bean.Module;
import com.antiless.navigator.bean.Navigator;
import com.antiless.navigator.bean.Tab;
import com.antiless.navigator.bean.WebSite;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.google.common.io.ByteStreams;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class NavigatorService {

    public Navigator buildNavigator() {
        List<WebSite> webSite = buildWebSiteList();
        List<Tab> tabSiteList = new ArrayList<>(1);
        Tab tab = new Tab();
        tab.setTab_name("压缩工具");
        tab.setWebsite_list(webSite);
        tabSiteList.add(tab);
        List<Module> moduleSiteList = new ArrayList<>(1);
        Module module = new Module();
        module.setTab_list(tabSiteList);
        module.setModule_name("在线工具");
        moduleSiteList.add(module);
        Navigator navigator = new Navigator();
        navigator.setModule_list(moduleSiteList);
        navigator.setName("设计");
        return navigator;
    }

    private List<WebSite> buildWebSiteList() {
        List<WebSite> webSiteList = new ArrayList<>(1);
        WebSite webSite = new WebSite();
        webSite.setName("dribbble2");
        webSite.setUrl("http://dribbble.com");
        webSite.setIcon("http://img1.imgtn.bdimg.com/it/u=998766967,514961766&fm=26&gp=0.jpg");
        webSiteList.add(webSite);
        return webSiteList;
    }

    public String queryDate() throws AVException {
            String objectId = "5c950bd2fe88c2006d54ff32";
            AVQuery<AVObject> avQuery = new AVQuery<>("Navigator");
            AVObject avObj = avQuery.get(objectId);
            Object result = avObj.get("data");
        return JSONObject.toJSONString(result);
    }

    /**
     * 保存初始化数据
     */
    public String saveData() throws IOException, AVException {
        AVObject avOb = new AVObject("Navigator");
//        Navigator navigator =  buildNavigator();
        InputStream stream = NavigatorService.class.getClassLoader().getResourceAsStream("file/result.json");
        String str = new String(ByteStreams.toByteArray(stream));
        if(StringUtils.isEmpty(str)){
            return null;
        }
        avOb.put("data",JSONObject.parse(str));
        avOb.save();
        return str;
    }
}
