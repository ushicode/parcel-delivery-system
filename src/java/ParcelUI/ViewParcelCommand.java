package ParcelUI;

import DTO.ParcelDTO;
import Managers.ParcelManager;

public class ViewParcelCommand implements ParcelCommand
{

    private final ParcelManager parcelMgr;
    private final String senderEmail;
    
    public ViewParcelCommand(String senderEmail)
    {
        this.senderEmail = senderEmail;
        parcelMgr = new ParcelManager();
    }

    @Override
    public Object execute()
    {
        return parcelMgr.getParcelSummeries(senderEmail);
    }
}
