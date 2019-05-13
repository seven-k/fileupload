package com.ycl.fileupload.utils;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author yin.cl
 * @since 2019/5/13 21:13
 */
@Slf4j
@Component
public class HttpClientUtil {

    private HttpClient httpClient = HttpClients.createDefault();

    /**
     * Http get method
     *
     * @param url request url
     * @return result
     */
    public String get(String url) {
        HttpGet httpGet = new HttpGet(url);
        String result = null;
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "utf-8");
        } catch (Exception ex) {
            log.info("Http Get Method Exception:" + ex);
        } finally {
            httpGet.releaseConnection();
        }
        return result;
    }

    /**
     * http post method
     *
     * @param url   request url
     * @param param param
     * @return result
     */
    public String post(String url, JSONObject param) {
        HttpPost post = new HttpPost(url);
        //添加文档类型和参数
        post.addHeader("contentType", "application/json");
        post.setEntity(new StringEntity(JSONObject.toJSONString(param), "utf-8"));
        String msg = null;
        try {
            HttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            msg = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            log.info("Http Post Method Exception:" + e);
        }
        return msg;
    }

    public String post1(String url, Map<String,Object> param) {
        HttpPost post = new HttpPost(url);
        post.addHeader("contentType", "application/x-www-form-urlencoded");
        post.setEntity(new StringEntity(param.toString(), "utf-8"));
        String msg = null;
        try {
            HttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            msg = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            log.info("Http Post Method Exception:" + e);
        }
        log.info("result={}",msg);
        return msg;
    }
}
