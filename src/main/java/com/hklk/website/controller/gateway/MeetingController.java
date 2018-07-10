package com.hklk.website.controller.gateway;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.hklk.website.controller.BaseController;
import com.hklk.website.entity.table.TempMeeting;
import com.hklk.website.service.TempMeetingService;
import com.hklk.website.util.ExcelUtils;
import com.hklk.website.util.StatusCode;
import com.hklk.website.util.ToolUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
            String uuid = ToolUtil.createId(10);
            params.setUuid(uuid);
            tempMeetingService.insertTempMeeting(params);

            TempMeeting result = tempMeetingService.selectByUuid(uuid);
            String resultString;
            if (result.getId() < 10) {
                resultString = "000" + result.getId();
            } else if (10 <= result.getId() && result.getId() < 100) {
                resultString = "00" + result.getId();
            } else if (100 <= result.getId() && result.getId() < 1000) {
                resultString = "0" + result.getId();
            } else {
                resultString = "" + result.getId();
            }

            System.out.println(result);
            return ToolUtil.buildResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS), resultString);
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildResultStr(StatusCode.SYS_ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR),
                    new Object());
        }
    }

    @RequestMapping("/exportExcelForStudent")
    @ResponseBody
    public String exportExcelForMeeting(HttpServletRequest request,
                                        HttpServletResponse response, HttpSession session) {
        String[] columnHeader = {"sNum", "fullName", "sex", "parentName", "parentPhone"};
        String[] fieldNames = {"序号", "申报码", "申报人姓名", "申报人联系方式", "申报人所在学校","直属领导姓名","直属领导电话","直属领导职务","共同体一","共同体一","共同体二","共同体三","共同体四","备注"};
        List<Map<String, Object>> result = tempMeetingService.queryMeeting();
        try {
            System.out.println("teacher export ----------------------");
            ServletOutputStream out = response.getOutputStream();
            response.setHeader("Content-disposition", "attachment; filename=data.xlsx");
            response.setContentType("application/msexcel");
            ExcelUtils.exportExcel(out, "xlsx", result, fieldNames, fieldNames);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ToolUtil.buildResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS));
    }
}
