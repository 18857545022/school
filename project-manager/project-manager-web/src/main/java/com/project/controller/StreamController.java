package com.project.controller;

import com.project.service.interfaces.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class StreamController {

    @Autowired
    private StreamService streamService;

    @RequestMapping("/getStreamServiceByCameraIndexCodes")
    @ResponseBody
    public String getStreamByCode(String code){
        String result=streamService.getStreamServiceByCameraIndexCodes("33000000001310016872");
        return result;
    }
}
