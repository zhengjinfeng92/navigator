package com.antiless.navigator;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.antiless" })
public class NavigatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(NavigatorApplication.class, args);
        // 参数依次为 AppId、AppKey、MasterKey
        // 启用北美节点
        AVOSCloud.useAVCloudCN();
        // 初始化参数依次为 AppId, AppKey, MasterKey
        AVOSCloud.initialize("9JPbjM94QgkfD2CPK1dr4bN7-gzGzoHsz","zjCPTu6oEsDmW8k8kfl24WIn","imsuYV4hK6wRAnU79PVCKHfs");
//        AVOSCloud.setDebugLogEnabled(true);
    }

}
