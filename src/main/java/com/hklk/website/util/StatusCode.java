package com.hklk.website.util;

import java.util.HashMap;
import java.util.Map;

public class StatusCode {
    //成功
    public static final int SUCCESS = 200;//成功
    //失败
    public static final int ERROR = 300;    //操作失败

    public static final int OVER_TIME = 301;     //超时

    //操作失败
    public static final int SYS_ERROR = 9999;

    //登录名或者密码错误
    public static final int LOGIN_NAME_OR_PWD_ERROR = 10001;

    //登录账号错误
    public static final int LOGIN_NAME_ERROR = 10002;

    //用户不存在
    public static final int USER_NOT_EXISTS = 10003;

    //未登录
    public static final int USER_NO_LOGIN = 10004;

    //非法参数
    public static final int PARAMTER_ERROR = 10005;


    public static String getStatusMsg(int code) {

        Map<Integer, String> map = new HashMap();
        map.put(SUCCESS, "成功");
        map.put(ERROR, "操作失败，请重试！");
        map.put(OVER_TIME, "Session Timeout! Please re-sign in！");
        map.put(SYS_ERROR, "系统错误,请通知开发人员！");
        map.put(LOGIN_NAME_OR_PWD_ERROR, "登录名或者密码错误");
        map.put(LOGIN_NAME_ERROR, "登录账号错误");
        map.put(USER_NOT_EXISTS, "用户不存在");
        map.put(USER_NO_LOGIN, "未登陆");
        map.put(PARAMTER_ERROR, "非法参数");

        return map.get(code);
    }
}

