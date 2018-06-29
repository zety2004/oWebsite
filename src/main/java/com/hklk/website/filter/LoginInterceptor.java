package com.hklk.website.filter;

import com.hklk.website.entity.table.OperatingUser;
import com.hklk.website.filter.repo.LoginRepository;
import com.hklk.website.util.StatusCode;
import com.hklk.website.util.ToolUtil;
import com.hklk.website.util.dwz.ServerInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginInterceptor implements HandlerInterceptor {

    private void responseJson(HttpServletResponse response, int code, String message) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpStatus.OK.value());
        PrintWriter writer = response.getWriter();
        writer.write(new StringBuilder().append("{\"resultCode\":").append(code).append(",\"resultMsg\":\"").append(message)
                .append("\"}").toString());
        writer.flush();
        writer.close();
    }


    //Action之前执行:
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoginRepository classAnnotation = handlerMethod.getBean().getClass().getAnnotation(LoginRepository.class);
        // 有 @LocalLoginRepository 注解，需要认证
        if (null != classAnnotation) {

            OperatingUser user = (OperatingUser) request.getSession().getAttribute("user");

            if (user == null) {
                if (ServerInfo.isAjax(request) || request.getParameter("ajax") != null) {
                    PrintWriter out = response.getWriter();
                    String json = ToolUtil.buildDWZResultStr(StatusCode.OVER_TIME, StatusCode.getStatusMsg(StatusCode.OVER_TIME), "", "", "", "", "");
                    out.print(json);
                } else {
                    response.sendRedirect("/jsp/login.jsp");
                }
                return false;
            }

        }
        return true;
    }


    //生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    //最后执行，可用于释放资源
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {
    }
}
