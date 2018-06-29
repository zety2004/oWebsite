package com.hklk.website.controller;

import com.hklk.website.util.ToolUtil;
import com.hklk.website.util.editor.DateEditor;
import com.hklk.website.util.editor.DoubleEditor;
import com.hklk.website.util.editor.IntegerEditor;
import com.hklk.website.util.editor.LongEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public abstract class BaseController {
    protected int pageSize = 20;
    protected int pageNum = 1;

    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(int.class, new IntegerEditor());
        binder.registerCustomEditor(long.class, new LongEditor());
        binder.registerCustomEditor(double.class, new DoubleEditor());
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    public int getPageNum(Integer pageNum) {
        return pageNum == null ? 1 : pageNum;
    }

    public int getPageSize(Integer pageSize) {
        return pageSize == null ? 20 : pageSize;
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        request.setAttribute("exception", e);
        return ToolUtil.buildResultStr(9999, "程序错误请通知开发人员。");
    }
}
