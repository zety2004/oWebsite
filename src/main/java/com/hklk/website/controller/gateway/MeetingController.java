package com.hklk.website.controller.gateway;

import com.hklk.website.controller.BaseController;
import com.hklk.website.entity.table.TempMeeting;
import com.hklk.website.service.TempMeetingService;
import com.hklk.website.util.StatusCode;
import com.hklk.website.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/meeting")
@Controller
public class MeetingController extends BaseController {

    @Autowired
    TempMeetingService tempMeetingService;
    @ResponseBody
    @RequestMapping("/addRecord")
    public String addRecord(TempMeeting params, HttpServletRequest request,
                            HttpServletResponse response, HttpSession session) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            if (params == null) {
                ToolUtil.buildResultStr(StatusCode.PARAMTER_ERROR, StatusCode.getStatusMsg(StatusCode.PARAMTER_ERROR));
            }
            tempMeetingService.insertTempMeeting(params);
            return ToolUtil.buildResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS));
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildResultStr(StatusCode.SYS_ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR),
                    new Object());
        }
    }


}
