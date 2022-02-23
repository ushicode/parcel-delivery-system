/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import SenderUI.SenderCommandFactory;
import javax.inject.Named;
import DTO.SenderDTO;
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

@Named(value = "loginSenderMB")

@SessionScoped
public class LoginSenderMB implements Serializable
{

    private String email = null;
    private String password = null;
    boolean senderLoggedIn = false;

    public String loginSender(HttpServletRequest request)
    {
        SenderDTO loginSender
                = new SenderDTO(
                        "",
                        email,
                        "",
                        "",
                        password,
                        "");
        senderLoggedIn
                = (boolean) SenderCommandFactory
                        .createCommand(
                                SenderCommandFactory.LOGIN_SENDER,
                                loginSender, request)
                        .execute();

        HttpSession session = request.getSession();
        session.setAttribute("senderEmail", email);

        // test = (String) session.getAttribute("senderEmail");
        //test2 = (String) session.getAttribute("senderPassword");
        if (senderLoggedIn == false)
        {
            email = null;
            password = null;
            session.setAttribute("senderEmail", "");
        }
        else
        {
            return "myAccount.xhtml";
        }

        return senderLoggedIn ? "index.xhtml" : "";
    }

    public String logOut(SenderDTO sender, HttpServletRequest request)
    {
        email = "";
        password = "";

        SenderDTO loginSender
                = new SenderDTO(
                        "",
                        email,
                        "",
                        "",
                        password,
                        "");
        senderLoggedIn
                = (boolean) SenderCommandFactory
                        .createCommand(
                                SenderCommandFactory.LOGOUT_SENDER,
                                loginSender, request)
                        .execute();

        return "index.xhtml";
    }

    public boolean isSenderLoggedIn()
    {
        return senderLoggedIn;
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
