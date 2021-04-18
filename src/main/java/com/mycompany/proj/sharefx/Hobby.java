/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proj.sharefx;

import java.sql.Date;
import java.sql.Time;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Nagarjun Prem
 */
@ManagedBean
@RequestScoped

public class Hobby {
    
        private int hid;
	private String hname;
	private Date hdate;
        private Time htime;
	private String hinfo;
        private String hlocation;
	private String hcontact;

    public Hobby() {
    }

    public Hobby(int hid, String hname, Date hdate, Time htime, String hinfo, String hlocation, String hcontact) {
        this.hid = hid;
        this.hname = hname;
        this.hdate = hdate;
        this.htime = htime;
        this.hinfo = hinfo;
        this.hlocation = hlocation;
        this.hcontact = hcontact;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public Date getHdate() {
        return hdate;
    }

    public void setHdate(Date hdate) {
        this.hdate = hdate;
    }

    public Time getHtime() {
        return htime;
    }

    public void setHtime(Time htime) {
        this.htime = htime;
    }

    public String getHinfo() {
        return hinfo;
    }

    public void setHinfo(String hinfo) {
        this.hinfo = hinfo;
    }

    public String getHlocation() {
        return hlocation;
    }

    public void setHlocation(String hlocation) {
        this.hlocation = hlocation;
    }

    public String getHcontact() {
        return hcontact;
    }

    public void setHcontact(String hcontact) {
        this.hcontact = hcontact;
    }
        
        public String add()
    {
        if(hid !=0)
            return "login";
            return null;
    }
    
}

