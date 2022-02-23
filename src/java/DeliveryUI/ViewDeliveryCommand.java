package DeliveryUI;

import Managers.DeliveryManager;
import javax.servlet.http.HttpServletRequest;

public class ViewDeliveryCommand implements DeliveryCommand
{

    private final DeliveryManager deliveryMgr;
    
    public ViewDeliveryCommand(HttpServletRequest request)
    {
        deliveryMgr = new DeliveryManager(request);
    }

    @Override
    public Object execute()
    {
        return deliveryMgr.ViewAllParcels();
    }
}
