package com.hklk.website.controller;

import com.hklk.website.entity.table.OperatingUser;
import com.hklk.website.service.FeedBackService;
import com.hklk.website.service.ItemDetailService;
import com.hklk.website.service.ItemService;
import com.hklk.website.service.UserLoginService;
import com.hklk.website.util.StatusCode;
import com.hklk.website.util.StringUtil;
import com.hklk.website.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@Controller
public class LoginUserController {
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    ItemService itemService;
    @Autowired
    ItemDetailService itemDetailService;
    @Autowired
    FeedBackService feedBackService;

    @RequestMapping("/index")
    public String forWordIndex(HttpServletRequest request,
                               HttpServletResponse response, HttpSession session, Model model) {
        return "/jsp/index";
    }

    protected Model ajaxDone(Model result,String statusCode, String message, String forwardUrl){
        result.addAttribute("statusCode", statusCode);
        result.addAttribute("message", message);
        result.addAttribute("forwardUrl", forwardUrl);
        return result;
    }

    @RequestMapping("/loginUser")
    public String loginUser(HttpServletRequest request,
                     HttpServletResponse response, HttpSession session,Model model) {
        try {
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            OperatingUser result = userLoginService.userLogin(name, password);
            if (result != null) {
                session.setAttribute("user", result);
                ajaxDone(model,StatusCode.SUCCESS,StatusCode.getStatusMsg(StatusCode.SUCCESS),"index.jsp");
                return "/jsp/index";
            } else {
                ajaxDone(model,StatusCode.ERROR,"用户名或密码不正确","login.jsp");
                return "/jsp/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildResultStr(StatusCode.SYS_ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR),
                    new Object());
        }
    }


    @RequestMapping("/loginUserAjax")
    public @ResponseBody String loginUser(HttpServletRequest request,
                            HttpServletResponse response, HttpSession session) {
        try {
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            OperatingUser result = userLoginService.userLogin(name, password);
            if (result != null) {
                session.setAttribute("user", result);

                return ToolUtil.buildDWZResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS), "closeCurrent", "","_blank");
            } else {
                return ToolUtil.buildDWZResultStr(StatusCode.ERROR, StatusCode.getStatusMsg(StatusCode.ERROR), "", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildResultStr(StatusCode.SYS_ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR),
                    new Object());
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request,
                            HttpServletResponse response, HttpSession session,Model model) {

                session.setAttribute("user", null);
                ajaxDone(model,StatusCode.SUCCESS,StatusCode.getStatusMsg(StatusCode.SUCCESS),"index.jsp");
                return "/jsp/login";
    }

    @RequestMapping("/deleteFeedBackById")
    public @ResponseBody String deleteFeedBackById(HttpServletRequest request,
                                                   HttpServletResponse response, HttpSession session) {
        try {
            int result  = feedBackService.deleteByPrimaryKey(StringUtil.paresInt(request.getParameter("id")));
            return ToolUtil.buildDWZResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS),"","userFeed");

        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildResultStr(StatusCode.SYS_ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR),
                    new Object());
        }
    }

}
