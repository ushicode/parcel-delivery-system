/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SenderUI;

import DTO.SenderDTO;
import Managers.SenderManager;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author ushi
 */
public class SenderCommandFactoryTest
{

    @Test
    public void RegisterSender()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        SenderDTO senderDTO = new SenderDTO("BlueWhales", "jdairsoft@gmail.com", "55 road lake, cannock", "B449XH", "password", "password");

        int commandType = SenderCommandFactory.REGISTER_SENDER;
        SenderCommand result = SenderCommandFactory.createCommand(commandType, senderDTO, request);

        assertNotNull(result);
    }

    @Test
    public void LoginSender()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        
        SenderDTO senderDTO = new SenderDTO("BlueWhales", "jdairsoft@gmail.com", "55 road lake, cannock", "B449XH", "pass", "pass");

        int commandType = SenderCommandFactory.LOGIN_SENDER;
        SenderCommand result = SenderCommandFactory.createCommand(commandType, senderDTO, request);

        assertNotNull(result);
    }

    @Test
    public void LogoutSender()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        SenderDTO senderDTO = new SenderDTO("BlueWhales", "jdairsoft@gmail.com", "55 road lake, cannock", "B449XH", "pass", "pass");

        int commandType = SenderCommandFactory.LOGOUT_SENDER;
        SenderCommand result = SenderCommandFactory.createCommand(commandType, senderDTO, request);

        assertNotNull(result);
    }

}
