package com.atlandes.auth.shiro.filter;

import com.atlandes.common.util.PropertiesUtil;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by XD.Wang on 2017/6/6.
 * 角色校验
 */
public class RoleFilter extends AccessControlFilter {

    static final String BASE_ULR = PropertiesUtil.getMercuryBaseUrl();
    static final String LOGIN_URL = BASE_ULR + "/user/open/toLogin.shtml";
    static final String UNAUTHORIZED_URL = BASE_ULR + "/unauthorized.html";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        String[] arr = (String[]) mappedValue;
        Subject subject = getSubject(request, response);
        for (String role : arr) {
            if (subject.hasRole("role:" + role)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {

        Subject subject = getSubject(request, response);
        // 表示没有登录，重定向到登录页面
        if (subject.getPrincipal() == null) {
            saveRequest(request);
            WebUtils.issueRedirect(request, response, LOGIN_URL);
        } else {
            if (StringUtils.hasText(UNAUTHORIZED_URL)) {
                // 如果有未授权页面跳转过去
                WebUtils.issueRedirect(request, response, UNAUTHORIZED_URL);
            } else {
                // 否则返回401未授权状态码
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        return false;
    }

}
