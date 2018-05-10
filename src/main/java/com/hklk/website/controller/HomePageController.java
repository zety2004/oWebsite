package com.hklk.website.controller;

import com.hklk.website.entity.table.ItemContent;
import com.hklk.website.entity.table.ItemDetail;
import com.hklk.website.entity.table.UserFeedBack;
import com.hklk.website.service.FeedBackService;
import com.hklk.website.service.ItemDetailService;
import com.hklk.website.service.ItemService;
import com.hklk.website.service.UserLoginService;
import com.hklk.website.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/homePage")
@Controller
public class HomePageController {
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    ItemService itemService;
    @Autowired
    ItemDetailService itemDetailService;
    @Autowired
    FeedBackService feedBackService;

    @RequestMapping("/queryItem")
    public String queryItem(HttpServletRequest request,
                            HttpServletResponse response, HttpSession session, Model model) {
        List<ItemContent> result = itemService.queryItemList();
        model.addAttribute("list", result);
        return "/jsp/operationItem";
    }

    @RequestMapping("/queryItemDetail")
    public String queryItemDetail(HttpServletRequest request,
                                  HttpServletResponse response, HttpSession session, Model model) {
        List<ItemDetail> itemDetails = itemDetailService.queryItemDetailList(StringUtil.paresInt(request.getParameter("id")));
        model.addAttribute("list", itemDetails);
        model.addAttribute("itemId", request.getParameter("id"));
        return "/jsp/operationItemDetail";
    }

    @RequestMapping("/deleteItem")
    public @ResponseBody
    String deleteItem(HttpServletRequest request,
                      HttpServletResponse response, HttpSession session) {
        try {
            int result = itemService.deleteByPrimaryKey(StringUtil.paresInt(request.getParameter("id")));
            return ToolUtil.buildDWZResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS), "", "ItemList");
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildDWZResultStr(StatusCode.ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR), "", "");
        }
    }

    @RequestMapping("/queryItemById")
    public String queryItemById(HttpServletRequest request,
                                HttpServletResponse response, HttpSession session, Model model) {

        if(!"add".equals(request.getParameter("method"))){
            ItemContent itemContent = itemService.selectItemById(StringUtil.paresInt(request.getParameter("id")));
            model.addAttribute("itemContent",itemContent);
        }
        return "/jsp/updateItem";
    }

    @RequestMapping("/queryItemDetailById")
    public String queryItemDetailById(HttpServletRequest request,
                                      HttpServletResponse response, HttpSession session, Model model) {
        ItemDetail result = new ItemDetail();
        if ("add".equals(request.getParameter("method"))) {
            result.setItemId(StringUtil.paresInt(request.getParameter("itemId")));
            model.addAttribute("item", result);
        } else {
            result = itemDetailService.selectItemDetailById(StringUtil.paresInt(request.getParameter("id")));
        }
        model.addAttribute("itemDetail", result);
        return "/jsp/updateItemDetail";
    }

    @RequestMapping("/addOrUpdateItem")
    public @ResponseBody
    String addOrUpdateItem(@RequestBody String param, HttpServletRequest request,
                           HttpServletResponse response, HttpSession session) {
        try {
            ItemContent itemContent = new ItemContent();
            if (!"".equals(request.getParameter("id"))) {
                itemContent.setId(StringUtil.paresInt(request.getParameter("id")));
            }
            itemContent.setItemName(request.getParameter("itemName"));
            itemContent.setOrderLev(StringUtil.paresInt(request.getParameter("orderLev")));
            itemContent.setIsTop(StringUtil.paresInt(request.getParameter("isTop")));
            if (itemContent.getId() != null) {
                itemService.updateByPrimaryKeySelective(itemContent);
            } else {
                itemService.insertSelective(itemContent);
            }
            return ToolUtil.buildDWZResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS), DWZUtil.CALLBACKTYPE_CLOSE, "");
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildDWZResultStr(StatusCode.ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR), "", "");
        }
    }

    @RequestMapping("/deleteItemDetail")
    public @ResponseBody
    String deleteItemDetail(HttpServletRequest request,
                            HttpServletResponse response, HttpSession session) {
        try {
            int result = itemDetailService.deleteByPrimaryKey(StringUtil.paresInt(request.getParameter("id")));
            return ToolUtil.buildDWZResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS), "", "opItemDetail");
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildDWZResultStr(StatusCode.ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR), "", "");
        }
    }

    @RequestMapping("/upload")
    public @ResponseBody
    String upload(HttpServletRequest request,
                  HttpServletResponse response, HttpSession session) {
        try {
            UploadUtils uploadUtils = new UploadUtils();
            String[] result = uploadUtils.uploadFile(request);
            return ToolUtil.buildXhEditorStr("", PropUtil.getProperty("serverAddress") + result[4]);
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildXhEditorStr("上传失败", "");
        }
    }

    @RequestMapping("/addOrUpdateItemDetail")
    public @ResponseBody
    String updateItem(HttpServletRequest request,
                      HttpServletResponse response, HttpSession session) {
        try {
            ItemDetail itemDetail = new ItemDetail();
            if (!"".equals(request.getParameter("id"))) {
                itemDetail.setId(StringUtil.paresInt(request.getParameter("id")));
            }
            itemDetail.setId(StringUtil.paresInt(request.getParameter("id")));
            itemDetail.setItemDetailName(request.getParameter("itemDetailName"));
            itemDetail.setItemId(StringUtil.paresInt(request.getParameter("itemId")));
            itemDetail.setOrderLevel(StringUtil.paresInt(request.getParameter("orderLevel")));
            itemDetail.setDes(request.getParameter("des"));
            itemDetail.setPic(request.getParameter("pic"));
            itemDetail.setSource(request.getParameter("source"));
            if (itemDetail.getId() != null) {
                itemDetailService.updateByPrimaryKeySelective(itemDetail);
            } else {
                itemDetailService.insertSelective(itemDetail);
            }
            return ToolUtil.buildDWZResultStr(StatusCode.SUCCESS, StatusCode.getStatusMsg(StatusCode.SUCCESS), DWZUtil.CALLBACKTYPE_CLOSE, "opItemDetail");
        } catch (Exception e) {
            e.printStackTrace();
            return ToolUtil.buildDWZResultStr(StatusCode.ERROR, StatusCode.getStatusMsg(StatusCode.SYS_ERROR), "", "");
        }
    }

    @RequestMapping("/queryFeedBack")
    public String queryFeedBack(HttpServletRequest request,
                                HttpServletResponse response, HttpSession session, Model model) {
        List<UserFeedBack> userFeedBackList = feedBackService.queryList();
        model.addAttribute("list", userFeedBackList);
        return "/jsp/userFeed";
    }
}
