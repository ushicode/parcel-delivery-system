/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SenderUI;

import DTO.SenderDTO;
import Managers.SenderManager;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
public class LogoutSenderCommandTest
{

    @Test
    public void LogoutSenderCommand()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        mock(FacesContext.class);

        SenderDTO senderDTO
                = new SenderDTO(
                        "",
                        "jdairsoft@gmail.com",
                        "",
                        "",
                        "XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",
                        "");

        SenderManager result;
        result = new SenderManager(request);
//        result.logoutSender(senderDTO);

        assertNotNull(result);
        assertNotNull(senderDTO);

    }
}
