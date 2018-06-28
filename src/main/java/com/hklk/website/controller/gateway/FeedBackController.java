package com.hklk.website.controller.gateway;

import com.hklk.website.controller.BaseController;
import com.hklk.website.entity.table.UserFeedBack;
import com.hklk.website.service.FeedBackService;
import com.hklk.website.util.StatusCode;
import com.hklk.website.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/feedBack")
@Controller
public class FeedBackController extends BaseController {

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
