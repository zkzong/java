/*
 * Copyright (C) 2017 Zhejiang BYCDAO Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.bycdao.com.
 * Developer Web Site: http://open.bycdao.com.
 */

package org.example.knife4j.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.example.knife4j.common.RestMessage;
import org.example.knife4j.domain.UploadModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2017/09/04 21:19
 */
@Api(value = "文件上传", tags = "文件上传")
@Controller
@RequestMapping("/api/upload")
public class UploadController {

    @ApiOperation(value = "文件素材上传Model接口")
    @PostMapping("/uploadModel")
    public RestMessage uploadModel(UploadModel uploadModel) {
        return null;
    }


    private List<Map> upload(HttpServletRequest request, MultipartFile[] files) {
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File realFile = new File(realPath);
        if (!realFile.exists()) {
            realFile.mkdirs();
        }
        List<Map> uploadFiles = Lists.newArrayList();
        System.out.println("进入图片上传接口:" + files.length + "张");
        for (MultipartFile file : files) {
            File targetFile = new File(realFile, file.getOriginalFilename());
            FileOutputStream fileOutputStream = null;
            InputStream ins = null;
            try {
                fileOutputStream = new FileOutputStream(targetFile);
                int i = -1;
                byte[] bytes = new byte[1024 * 1024];
                ins = file.getInputStream();
                while ((i = ins.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, i);
                }
            } catch (IOException e) {
            } finally {
                closeQuilty(ins);
                closeQuilty(fileOutputStream);
            }
            Map fileInfo = Maps.newHashMap();
            fileInfo.put("id", UUID.randomUUID().toString());
            fileInfo.put("url", targetFile.getPath());
            fileInfo.put("original_name", targetFile.getName());
            uploadFiles.add(fileInfo);
        }
        return uploadFiles;
    }


    @Order(value = 3)
    @ApiOperation(value = "多文件MultipartFile上传")
    @ApiImplicitParams({@ApiImplicitParam(name = "file[]", value = "文件流对象,接收数组格式", required = true, dataType = "MultipartFile", allowMultiple = true),
            @ApiImplicitParam(name = "title", value = "title", required = true)}
    )
    @RequestMapping(value = "/uploadMaterial", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial(@RequestParam(value = "file[]", required = true) MultipartFile[] files, @RequestParam(value = "title") String title, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        List<Map> uploadFiles = upload(request, files);
        RestMessage rm = new RestMessage();
        rm.setData(uploadFiles);
        return rm;
    }

    @Order(value = 2)
    @ApiOperation(value = "单文件File上传")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", required = true, dataType = "__File"),
            @ApiImplicitParam(name = "title", value = "title", required = true)}
    )
    @RequestMapping(value = "/uploadMaterial2", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial2(@RequestParam(value = "file", required = true) MultipartFile file, @RequestParam(value = "title") String title, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        List<MultipartFile> a = Lists.newArrayList();
        a.add(file);
        List<Map> uploadFiles = upload(request, a.toArray(new MultipartFile[]{}));
        RestMessage rm = new RestMessage();
        rm.setData(uploadFiles);
        return rm;
    }

    @Order(value = 2)
    @ApiOperation(value = "单文件File上传-noArg")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", paramType = "form", required = true, dataType = "__File"),
            @ApiImplicitParam(name = "title", value = "title", required = true)}
    )
    @RequestMapping(value = "/uploadMaterial4", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial3(@RequestParam(value = "title") String title, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        /*List<MultipartFile> a=Lists.newArrayList();
        a.add(file);
        List<Map> uploadFiles= upload(request,a.toArray(new MultipartFile[]{}));
        RestMessage rm=new RestMessage();
        rm.setData(uploadFiles);
        return rm;*/
        return null;
    }

    @Order(value = 2)
    @ApiOperation(value = "多文件File上传")
    @ApiImplicitParams({@ApiImplicitParam(name = "file[]", value = "文件流对象,接收数组格式", required = true, dataType = "__File", allowMultiple = true),
            @ApiImplicitParam(name = "title", value = "title", required = true)}
    )
    @RequestMapping(value = "/uploadMaterial1", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial1(@RequestParam(value = "file[]", required = true) MultipartFile[] files, @RequestParam(value = "title") String title, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        List<Map> uploadFiles = upload(request, files);
        RestMessage rm = new RestMessage();
        rm.setData(uploadFiles);
        return rm;
    }

    private void closeQuilty(InputStream ins) {
        if (ins != null) {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void closeQuilty(OutputStream out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
