/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ManagedBeans.LoginSenderMB;
import ManagedBeans.loginDriverMB;

/**
 *
 * @author ushi
 */
//@WebFilter(filterName = "CheckLoggedIn", urlPatterns =
//{
//    "/*"
//})
public class CheckLoggedIn implements Filter
{

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    @Inject
    LoginSenderMB loginSenderMB;

    @Inject
    loginDriverMB loginDriverMB;

    public CheckLoggedIn()
    {
    }

    /*
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/faces/index.xhtml";
        String registerURI = request.getContextPath() + "/faces/registerSender.xhtml";

        boolean SenderloggedIn = loginSenderMB.isSenderLoggedIn();
        boolean DriverloggedIn = loginDriverMB.isDriverLoggedIn();
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean registerRequest = request.getRequestURI().equals(registerURI);

        if (SenderloggedIn || loginRequest || registerRequest || DriverloggedIn)
        {
            chain.doFilter(request, response);
        }
        else
        {
            response.sendRedirect(loginURI);
        }
    }

    /*
     * Destroy method for this filter
     */
    @Override
    public void destroy()
    {
        this.filterConfig = null;
    }

    /*
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    public void log(String msg)
    {
        filterConfig.getServletContext().log(msg);
    }
}
