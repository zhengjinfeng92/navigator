package com.antiless.navigator.service;

import com.alibaba.fastjson.JSONObject;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import org.springframework.stereotype.Service;


@Service
public class NavigatorService {

    public String queryDate() throws AVException {
        String objectId = "5c950bd2fe88c2006d54ff32";
        AVQuery<AVObject> avQuery = new AVQuery<>("Navigator");
        AVObject avObj = avQuery.get(objectId);
        Object result = avObj.get("data");
        return JSONObject.toJSONString(result);
    }
}


