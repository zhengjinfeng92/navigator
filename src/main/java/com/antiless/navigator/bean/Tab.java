package com.antiless.navigator.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Tab {
    /**
     * tab 名称
     */
    String tab_name;

    /**
     * website列表
     */
    List<WebSite> website_list;
}
