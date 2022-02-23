/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeliveryUI;

import DTO.DeliveryDTO;
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
public class TrackDeliveryCommandTest
{

    @Test
    public void TrackDeliveryCommand()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        String trackingCode = "iD5AOR92Ljrn";

        DeliveryManager result;
        result = new DeliveryManager(request);

        result.getMyParcel(trackingCode);

        assertNotNull(result);
        
    }

}
