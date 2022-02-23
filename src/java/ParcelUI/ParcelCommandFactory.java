/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcelUI;

import DTO.ParcelDTO;

public class ParcelCommandFactory
{

    public static final int REGISTER_PARCEL = 1;
    public static final int UPDATE_PARCELS = 2;
    public static final int VIEW_PARCELS = 3;
    public static final int DELETE_PARCELS = 4;

    public static ParcelCommand createCommand(int commandType, ParcelDTO parcel)
    {
        switch (commandType)
        {
            case REGISTER_PARCEL:
                return new RegisterParcelCommand(parcel);
            case UPDATE_PARCELS:
                return new UpdateParcelCommand(parcel);
            case DELETE_PARCELS:
                return new DeleteParcelCommand(parcel);
            default:
                return null;
        }
    }

    public static ParcelCommand createCommand(int commandType, String senderEmail)
    {
        switch (commandType)
        {
            case VIEW_PARCELS:
                return new ViewParcelCommand(senderEmail);
            default:
                return null;
        }
    }
}
