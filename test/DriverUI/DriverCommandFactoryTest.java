/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverUI;

import DTO.DriverDTO;
import DriverUI.DriverCommand;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author ushi
 */
public class DriverCommandFactoryTest
{

    @Test
    public void LoginDriver()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        DriverDTO driverDTO
                = new DriverDTO(
                        "Driver 1",
                        "driver1@test.com",
                        "On the road",
                        "ST11RD",
                        "XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",
                        "XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=");

        int commandType = DriverCommandFactory.LOGIN_DRIVER;
        DriverCommand result = DriverCommandFactory.createCommand(commandType, driverDTO, request);

        assertNotNull(result);
    }

    @Test
    public void LogoutDriver()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        DriverDTO driverDTO
                = new DriverDTO(
                        "Driver 1",
                        "driver1@test.com",
                        "On the road",
                        "ST11RD",
                        "XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",
                        "XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=");

        int commandType = DriverCommandFactory.LOGOUT_DRIVER;
        DriverCommand result = DriverCommandFactory.createCommand(commandType, driverDTO, request);

        assertNotNull(result);
    }
}
