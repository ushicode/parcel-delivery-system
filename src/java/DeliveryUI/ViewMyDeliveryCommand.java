package DeliveryUI;

import DTO.DeliveryDTO;

import Managers.DeliveryManager;
import javax.servlet.http.HttpServletRequest;

public class ViewMyDeliveryCommand implements DeliveryCommand
{

    private final DeliveryManager deliveryMgr;
    
    public ViewMyDeliveryCommand(HttpServletRequest request)
    {
        deliveryMgr = new DeliveryManager(request);
    }

    @Override
    public Object execute()
    {
        return deliveryMgr.ViewMyDeliveries();
    }
}
