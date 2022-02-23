/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeliveryUI;

import DTO.ParcelDTO;
import DTO.DeliveryDTO;
import javax.servlet.http.HttpServletRequest;

public class DeliveryCommandFactory
{

    public static final int TRACK_DELIVERY = 1;
    public static final int UPDATE_DELIVERY_STATUS = 2;
    public static final int SET_DELIVERY = 3;
    public static final int VIEW_ALL_DELIVERY = 4;
    public static final int VIEW_MY_DELIVERY = 5;
    public static final int SET_DELIVER_DRIVER = 6;

    public static DeliveryCommand createCommand(int commandType, String trackingCode, HttpServletRequest request)
    {
        switch (commandType)
        {
            case TRACK_DELIVERY:
                return new TrackDeliveryCommand(trackingCode, request);
            default:
                return null;
        }
    }

    public static DeliveryCommand createCommand(int commandType, ParcelDTO parcel, HttpServletRequest request)
    {
        switch (commandType)
        {
            case UPDATE_DELIVERY_STATUS:
                return new UpdateDeliveryStatusCommand(parcel, request);
            case SET_DELIVERY:
                return new SetDeliveryCommand(parcel, request);
            default:
                return null;
        }
    }

    public static DeliveryCommand createCommand(int commandType, HttpServletRequest request)
    {
        switch (commandType)
        {
            case VIEW_ALL_DELIVERY:
                return new ViewDeliveryCommand(request);
            case VIEW_MY_DELIVERY:
                return new ViewMyDeliveryCommand(request);
            default:
                return null;
        }
    }

    public static DeliveryCommand createCommand(int commandType, DeliveryDTO delivery, HttpServletRequest request)
    {
        switch (commandType)
        {
            case SET_DELIVER_DRIVER:
                return new SetDeliveryDriverCommand(delivery, request);
            default:
                return null;
        }
    }
}
