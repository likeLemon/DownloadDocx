package com.zff.downdocx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class DownloadFile {
    HttpServletRequest request;
    HttpServletResponse response;
    @Autowired
    DownService down;

    @GetMapping("/download")
    public void download(@RequestParam(value = "ID",defaultValue ="1")String ID){
        String filepath = null;
        String number = null;
        ID=number+filepath;
        number=ID.split("^\\d{3,}$").toString();
        System.out.println(number);
        filepath=ID.split("^[A-Za-z]+$").toString();
        System.out.println(filepath);
        down.doExport(number,filepath,request,response);
    }
}
