package com.ycl.fileupload.service.impl;

import com.google.common.collect.Maps;
import com.ycl.fileupload.service.FileService;
import com.ycl.fileupload.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author yin.cl
 * @since 2019/5/13 21:24
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    private HttpClientUtil httpClientUtil;

    @Override
    public String fileUpload(MultipartFile file, String fileBizType, String uploadedBy) {
//        Map<String, Object> param = Maps.newHashMap();
//        param.put("file", file);
//        param.put("fileBizType", fileBizType);
//        param.put("uploadedBy", uploadedBy);
        String url = "https://";
        return httpClientUtil.post3(url, file,fileBizType,uploadedBy);
    }
}
