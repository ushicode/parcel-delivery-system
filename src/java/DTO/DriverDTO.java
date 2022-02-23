/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ushi
 */
public class DriverDTO
{

    private String name;
    private String email;
    private String address;
    private String postcode;
    private String password;
    private String Cpassword;

    public DriverDTO(String name, String email, String address, String postcode, String password, String Cpassword)
    {
        this.name = name;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.password = password;
        this.Cpassword = Cpassword;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public String getPassword()
    {
        return password;
    }

    public String getCpassword()
    {
        return Cpassword;
    }


}
