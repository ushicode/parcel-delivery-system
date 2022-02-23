/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeliveryUI;

import DTO.ParcelDTO;
import Managers.DeliveryManager;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author ushi
 */
public class ViewMyDeliveryCommandTest
{

    @Test
    public void ViewMyDeliveryCommand()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        when(request.getSession().getAttribute("driverID")).thenReturn(1);

        DeliveryManager result;
        result = new DeliveryManager(request);
        result.ViewMyDeliveries();

        assertNotNull(result);

    }
}
