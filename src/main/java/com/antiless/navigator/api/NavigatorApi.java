package com.antiless.navigator.api;

import com.antiless.navigator.service.NavigatorService;
import com.avos.avoscloud.AVException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NavigatorApi {

    @Autowired
    NavigatorService navigatorService;

    private static final String PRE = "/api/v1";
    @GetMapping(PRE +"/navigator")
    public String getNavigator() throws AVException {
        return navigatorService.queryDate();
    }
}
