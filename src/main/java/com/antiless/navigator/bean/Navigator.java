package com.antiless.navigator.bean;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Navigator {

    /**
     * 名称
     */
    String name;

    /**
     * module 列表
     */
    List<Module> module_list;
}
