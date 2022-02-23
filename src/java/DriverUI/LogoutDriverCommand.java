package DriverUI;

import DTO.DriverDTO;
import Managers.DriverManager;
import javax.servlet.http.HttpServletRequest;

public class LogoutDriverCommand implements DriverCommand
{

    private final DriverDTO driverDTO;
    private final DriverManager driverMgr;

    public LogoutDriverCommand(DriverDTO driverDTO, HttpServletRequest request)
    {
        this.driverDTO = driverDTO;
        driverMgr = new DriverManager(request);
    }
    
    @Override
    public Object execute()
    {
         return driverMgr.logoutDriver(driverDTO);
    }
}
