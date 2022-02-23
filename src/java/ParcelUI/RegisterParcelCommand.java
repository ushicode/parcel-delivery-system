package ParcelUI;

import DTO.ParcelDTO;
import Managers.ParcelManager;

public class RegisterParcelCommand implements ParcelCommand
{

    private final ParcelDTO parcelDTO;
    private final ParcelManager parcelMgr;

    public RegisterParcelCommand(ParcelDTO parcelDTO)
    {
        this.parcelDTO = parcelDTO;
        parcelMgr = new ParcelManager();
    }
    
    @Override
    public Object execute()
    {
         return parcelMgr.registerParcel(parcelDTO);
    }
}
