/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SenderUI;

import DTO.SenderDTO;
import Managers.SenderManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author ushi
 */
public class RegisterSenderCommandTest
{
    
    @Test
    public void RegisterSenderCommand()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        SenderDTO senderDTO
                = new SenderDTO(
                        "test",
                        "test@gmail.com",
                        "test",
                        "test",
                        "test",
                        "test");

        SenderManager result;
        result = new SenderManager(request);
        result.registerSender(senderDTO);

        assertNotNull(result);
    }
    
}
