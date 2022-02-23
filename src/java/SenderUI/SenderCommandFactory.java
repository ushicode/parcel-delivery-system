/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SenderUI;

import DTO.SenderDTO;
import javax.servlet.http.HttpServletRequest;

public class SenderCommandFactory
{

    public static final int REGISTER_SENDER = 1;
    public static final int LOGIN_SENDER = 2;
    public static final int LOGOUT_SENDER = 3;

    public static SenderCommand createCommand(int commandType, SenderDTO sender, HttpServletRequest request)
    {
        switch (commandType)
        {
            case REGISTER_SENDER:
                return new RegisterSenderCommand(sender, request);
            case LOGIN_SENDER:
                return new LoginSenderCommand(sender, request);
            case LOGOUT_SENDER:
                return new LogoutSenderCommand(sender, request);
            default:
                return null;
        }
    }
}
