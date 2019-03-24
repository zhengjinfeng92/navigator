package com.antiless.navigator;

import cn.leancloud.LeanEngine;
import com.antiless.navigator.service.NavigatorService;
import com.avos.avoscloud.AVCloud;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.internal.impl.JavaRequestSignImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.antiless" })
public class NavigatorApplication {
    private static String appId = System.getenv("LEANCLOUD_APP_ID");
    private static String appKey = System.getenv("LEANCLOUD_APP_KEY");
    private static String appMasterKey = System.getenv("LEANCLOUD_APP_MASTER_KEY");
    private static String appEnv = System.getenv("LEANCLOUD_APP_ENV");
    private static String haveStaging = System.getenv("LEAN_CLI_HAVE_STAGING");

    public static void main(String[] args) {
        // 注册子类化
//        AVObject.registerSubclass(AVObject.class);

        if ("development".equals(appEnv) && "true".equals(haveStaging) || "stage".equals(appEnv)) {
            AVCloud.setProductionMode(false);
        }
        // 初始化AVOSCloud，请保证在整个项目中间只初始化一次
        LeanEngine.initialize(appId, appKey, appMasterKey);
        // 在请求签名中使用masterKey以激活云代码的最高权限
        JavaRequestSignImplementation.instance().setUseMasterKey(true);
        // 打开 debug 日志
        // AVOSCloud.setDebugLogEnabled(true);
        // 向云引擎注册云函数
//        LeanEngine.register(Cloud.class);
        SpringApplication.run(NavigatorApplication.class, args);
//        // 参数依次为 AppId、AppKey、MasterKey
//        // 启用北美节点
//        AVOSCloud.useAVCloudCN();
//        // 初始化参数依次为 AppId, AppKey, MasterKey
//        AVOSCloud.initialize("9JPbjM94QgkfD2CPK1dr4bN7-gzGzoHsz","zjCPTu6oEsDmW8k8kfl24WIn","imsuYV4hK6wRAnU79PVCKHfs");
////        AVOSCloud.setDebugLogEnabled(true);
    }

}
