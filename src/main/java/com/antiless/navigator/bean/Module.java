package com.antiless.navigator.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Module {

    /**
     * 模块名称
     */
    String module_name;

    /**
     * tab 列表
     */
    List<Tab> tab_list;
}
