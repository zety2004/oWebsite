package com.hklk.website.controller.gateway;

import com.hklk.website.controller.BaseController;
import com.hklk.website.entity.table.TempMeeting;
import com.hklk.website.entity.table.TempMeetingDetail;
import com.hklk.website.entity.table.UserFeedBack;
import com.hklk.website.service.FeedBackService;
import com.hklk.website.service.TempMeetingService;
import com.hklk.website.util.StatusCode;
import com.hklk.website.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/meeting")
@Controller
public class MeetingController extends BaseController {

    @Autowired
    TempMeetingService tempMeetingService;

    @RequestMapping("/addRecord")
    public @ResponseBody
    String addRecord(@RequestBody String paramters, HttpServletRequest request,
                     HttpServletResponse response, HttpSession session) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            TempMeeting tempMeeting = new TempMeeting();
            List<TempMeetingDetail> tempMeetingDetails = new ArrayList<>();
            tempMeetingService.insertTempMeeting(tempMeeting, tempMeetingDetails);
            return ToolUtil.buildResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS));
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildResultStr(StatusCode.SYS_ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR),
                    new Object());
        }
    }
}
