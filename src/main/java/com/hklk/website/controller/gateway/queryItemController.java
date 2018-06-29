package com.hklk.website.controller.gateway;

import com.hklk.website.controller.BaseController;
import com.hklk.website.entity.table.ItemContent;
import com.hklk.website.entity.table.ItemDetail;
import com.hklk.website.entity.vo.ItemVo;
import com.hklk.website.service.ItemDetailService;
import com.hklk.website.service.ItemService;
import com.hklk.website.util.StatusCode;
import com.hklk.website.util.StringUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/item")
@Controller
public class queryItemController extends BaseController {
    @Autowired
    ItemService itemService;
    @Autowired
    ItemDetailService itemDetailService;

    @RequestMapping(value = "/queryItem")
    public @ResponseBody
    String queryItem(@RequestBody String paramters, HttpServletRequest request,
                     HttpServletResponse response, HttpSession session) {
        try {
            List<ItemVo> result = new ArrayList<>();
            Map<Integer, ItemVo> result2 = new HashMap<>();
            List<ItemContent> itemContents = itemService.queryItemList(pageNum, pageSize).getObjList();
            for (ItemContent itemContent : itemContents) {
                List<ItemDetail> itemDetails = itemDetailService.queryItemDetailList(itemContent.getId(), pageNum, pageSize).getObjList();
                result2.put(itemContent.getId(), new ItemVo(itemContent, itemDetails));
                //result.add(new ItemVo(itemContent,itemDetails));
            }
            response.setHeader("Access-Control-Allow-Origin", "*");
            return ToolUtil.buildResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS), result2);
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildResultStr(StatusCode.SYS_ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR),
                    new Object());
        }
    }

    @RequestMapping(value = "/queryItemDetailByItemId")
    public @ResponseBody
    String queryItemDetailByItemId(@RequestBody String paramters, HttpServletRequest request,
                                   HttpServletResponse response, HttpSession session) {
        try {
            List<ItemDetail> itemDetails = itemDetailService.queryItemDetailList(StringUtil.paresInt(request.getParameter("itemId")),pageNum,pageSize).getObjList();
            response.setHeader("Access-Control-Allow-Origin", "*");
            return ToolUtil.buildResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS), itemDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildResultStr(StatusCode.SYS_ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR),
                    new Object());
        }
    }

    @RequestMapping(value = "/queryItemDetailById")
    public @ResponseBody
    String queryItemDetailById(@RequestBody String paramters, HttpServletRequest request,
                               HttpServletResponse response, HttpSession session) {
        try {
            ItemDetail itemDetail = itemDetailService.selectItemDetailById(StringUtil.paresInt(request.getParameter("id")));
            response.setHeader("Access-Control-Allow-Origin", "*");
            return ToolUtil.buildResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS), itemDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildResultStr(StatusCode.SYS_ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR),
                    new Object());
        }
    }
}
