/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverUI;

import DTO.DriverDTO;
import Managers.DriverManager;
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
public class LogoutDriverCommandTest
{
     @Test
    public void LogoutDriverCommand()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        mock(FacesContext.class);

        DriverDTO driverDTO
                = new DriverDTO(
                        "Driver 1",
                        "driver1@test.com",
                        "On the road",
                        "ST11RD",
                        "XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",
                        "XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=");

        DriverManager result;
        result = new DriverManager(request);
//        result.logoutSender(senderDTO);

        assertNotNull(result);
        assertNotNull(driverDTO);

    }
    
}
