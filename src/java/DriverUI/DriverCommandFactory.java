/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverUI;

import DTO.DriverDTO;
import javax.servlet.http.HttpServletRequest;

public class DriverCommandFactory
{

    public static final int LOGIN_DRIVER = 1;
    public static final int LOGOUT_DRIVER = 2;

    public static DriverCommand createCommand(int commandType, DriverDTO driver, HttpServletRequest request)
    {
        switch (commandType)
        {
            case LOGIN_DRIVER:
                return new LoginDriverCommand(driver, request);
            case LOGOUT_DRIVER:
                return new LogoutDriverCommand(driver, request);
            default:
                return null;
        }
    }
}
