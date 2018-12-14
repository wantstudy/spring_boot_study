package com.example.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author weiwei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: 文件上传
 * @date 2018/12/1221:38
 */
@RestController
@RequestMapping(value = "/file")
public class FileUploadCtrl {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String upload(HttpServletRequest request,MultipartFile file){
        try{
            String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
            execUploadFile(uploadDir,file);
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }


    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    public @ResponseBody String uploads(HttpServletRequest request,MultipartFile[] files){
        try{
            String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
            for (int i = 0; i < files.length; i++) {
                if(files[i] != null){
                    execUploadFile(uploadDir,files[i]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    private void execUploadFile(String uploadDir, MultipartFile file) throws Exception{


        File dir = new File(uploadDir);
        if(!dir.exists()){
            dir.mkdir();
        }

        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")),
                fileName = UUID.randomUUID()+suffix;
        File serverFile = new File(uploadDir + fileName);
        file.transferTo(serverFile);

    }

}
