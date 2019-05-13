package com.ycl.fileupload.controller;

import com.ycl.fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yin.cl
 * @since 2019/5/13 21:07
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, @RequestParam String fileBizType, @RequestParam String uploadedBy) {

        return fileService.fileUpload(file, fileBizType, uploadedBy);
    }

}
