package com.example.only.test.beanCopy;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.only.dto.CommonResponse;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * Author: created by liguoliang
 * Date: 2019/6/24 9:48 48
 * Version: 1.0
 * Function: 用于
 */
public class JSonUtilTest {
    @Test
    public  void normalTest() {
        Map paraMap = Maps.newHashMap();

        String jsonStr = "{\"code\":1,\"msg\":\"查询成功\"}";
        JSONObject hutoolJsonObject = JSONUtil.parseObj(jsonStr);
        CommonResponse hutoolJavaBean = hutoolJsonObject.toBean(CommonResponse.class);


    }

}
