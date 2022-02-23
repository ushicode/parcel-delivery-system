package DeliveryUI;

import Managers.DeliveryManager;
import javax.servlet.http.HttpServletRequest;

public class TrackDeliveryCommand implements DeliveryCommand
{

    private final DeliveryManager deliverlMgr;
    private final String trackingCode;
    
    public TrackDeliveryCommand(String trackingCode, HttpServletRequest request)
    {
        this.trackingCode = trackingCode;
        deliverlMgr = new DeliveryManager(request);
    }

    @Override
    public Object execute()
    {
        return deliverlMgr.getMyParcel(trackingCode);
    }
}
