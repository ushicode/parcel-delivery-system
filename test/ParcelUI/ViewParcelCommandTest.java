/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcelUI;

import Managers.ParcelManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ushi
 */
public class ViewParcelCommandTest
{

    @Test
    public void SenderViewParcel()
    {
        String senderEmail = "jdairsoft@gmail.com";

        ParcelManager result;
        result = new ParcelManager();
        result.getParcelSummeries(senderEmail);

        assertNotNull(result);

    }
}
