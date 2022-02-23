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
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author ushi
 */
public class ViewDeliveryCommandTest
{

    @Test
    public void ViewDeliveryCommand()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);

        DeliveryManager result;
        result = new DeliveryManager(request);

        result.ViewAllParcels();

        assertNotNull(result);

    }
}
