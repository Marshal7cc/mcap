package com.marshal.mcap.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/15
 * Time: 23:17
 * Description:
 */
public class AuthenticateSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final String loginOauthUrl = "/login?oauth";
    private final String loginUrl = "/login";
    private final String indexUrl = "/index";
    private final String refererStr = "Referer";
    private final String loginCasUrl = "/login/cas";


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String username = httpServletRequest.getParameter("username");
        /**
         * 在session中存入信息
         */
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("username",username);
        handle(httpServletRequest,httpServletResponse,authentication);
    }
}
