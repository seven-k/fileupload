package com.ycl.fileupload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author yin.cl
 * @since 2019/5/13 21:23
 */
public interface FileService {

    String fileUpload(MultipartFile file, String fileBizType, String uploadedBy);
}
