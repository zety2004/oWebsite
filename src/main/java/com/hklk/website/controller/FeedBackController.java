package com.hklk.website.controller;

import com.hklk.website.entity.table.ItemContent;
import com.hklk.website.entity.table.ItemDetail;
import com.hklk.website.entity.table.OperatingUser;
import com.hklk.website.entity.table.UserFeedBack;
import com.hklk.website.service.FeedBackService;
import com.hklk.website.service.ItemDetailService;
import com.hklk.website.service.ItemService;
import com.hklk.website.service.UserLoginService;
import com.hklk.website.service.impl.FeedBackServiceImpl;
import com.hklk.website.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/feedBack")
@Controller
public class FeedBackController{

    @Autowired
    FeedBackService feedBackService;

    @RequestMapping("/addUserFeedBack")
    public @ResponseBody String addUserFeedBack(HttpServletRequest request,
                                                   HttpServletResponse response, HttpSession session) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            UserFeedBack userFeedBack = new UserFeedBack();
            userFeedBack.setUserName(request.getParameter("username"));
            userFeedBack.setUserPhone(request.getParameter("userphone"));
            userFeedBack.setDes(request.getParameter("des"));
            int result  = feedBackService.insertSelective(userFeedBack);
            return ToolUtil.buildResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS),result);
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildResultStr(StatusCode.SYS_ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR),
                    new Object());
        }
    }
}
