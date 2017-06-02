package com.Reg.Reg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kenhike on 29/5/17.
 */
@Entity

public class RegPojo
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String name;
    private String password;
    private String email;
    private String address;
    protected RegPojo()
    {

    }
    public RegPojo(String name,String password,String email,String address)
    {

        this.name=name;
        this.password=password;
        this.email=email;
        this.address=address;
    }
    @Override
    public String toString()
    {
        return String.format("RegPojo[id=%d,name='%s',password='%s',email='%s',address='%s']",id,name,password,email,address);
    }

}
