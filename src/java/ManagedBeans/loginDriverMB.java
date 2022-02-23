/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DriverUI.DriverCommandFactory;
import javax.inject.Named;
import DTO.DriverDTO;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named(value = "loginDriverMB")

@SessionScoped
public class loginDriverMB implements Serializable
{

    private String email = null;
    private String password = null;
    boolean driverLoggedIn = false;

    public String loginDriver(HttpServletRequest request)
    {
        DriverDTO loginDriver
                = new DriverDTO(
                        "",
                        email,
                        "",
                        "",
                        password,
                        "");
        driverLoggedIn
                = (boolean) DriverCommandFactory
                        .createCommand(
                                DriverCommandFactory.LOGIN_DRIVER,
                                loginDriver, request)
                        .execute();

        HttpSession session = request.getSession();
        session.setAttribute("driverEmail", email);

        // test = (String) session.getAttribute("senderEmail");
        //test2 = (String) session.getAttribute("senderPassword");
        if (driverLoggedIn == false)
        {
            email = null;
            password = null;
            session.setAttribute("driverEmail", "");
        }
        else
        {
            return "myDriverAccount.xhtml";
        }

        return driverLoggedIn ? "index.xhtml" : "";
    }

    public String logOut(DriverDTO driver, HttpServletRequest request)
    {
        email = "";
        password = "";

        DriverDTO logoutDriver
                = new DriverDTO(
                        "",
                        email,
                        "",
                        "",
                        password,
                        "");
        driverLoggedIn
                = (boolean) DriverCommandFactory
                        .createCommand(
                                DriverCommandFactory.LOGOUT_DRIVER,
                                logoutDriver, request)
                        .execute();

        return "index.xhtml";
    }

    public boolean isDriverLoggedIn()
    {
        return driverLoggedIn;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void validateEmail(FacesContext context,
            UIComponent component,
            Object emailStr)
    {
        if (!((String) emailStr).contains("@"))
        {
            ((UIInput) component).setValid(false);
            context.addMessage(component.getClientId(), new FacesMessage("Error: Email is not valid"));
        }
    }

    public void setPassword(String password)
    {
        try
        {
            byte[] passHash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(password.getBytes(StandardCharsets.UTF_8));

            password = Base64.getEncoder().encodeToString(passHash);
        }
        catch (NoSuchAlgorithmException nsae)
        {

        }
        this.password = password;
    }
}
