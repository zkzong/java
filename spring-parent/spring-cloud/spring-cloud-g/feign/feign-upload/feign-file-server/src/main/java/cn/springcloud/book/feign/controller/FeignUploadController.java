package cn.springcloud.book.feign.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FeignUploadController {

    @PostMapping(value = "/uploadFile/server", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUploadServer(MultipartFile file) throws Exception {
        return file.getOriginalFilename();
    }

    @PostMapping(value = "/uploadMultiFile/server", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUploadServer(MultipartFile[] files) throws Exception {
        String name = "";
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            name += originalFilename + ", ";
        }
        return name;
    }

}
