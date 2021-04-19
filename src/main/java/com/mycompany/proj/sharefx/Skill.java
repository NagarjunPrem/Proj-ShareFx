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

public class Skill {
    
        private int sid;
	private String sname;
	private Date sdate;
        private Time stime;
	private String sinfo;
        private String slocation;
	private String scontact;

    public Skill() {
    }

    public Skill(int sid, String sname, Date sdate, Time stime, String sinfo, String slocation, String scontact) {
        this.sid = sid;
        this.sname = sname;
        this.sdate = sdate;
        this.stime = stime;
        this.sinfo = sinfo;
        this.slocation = slocation;
        this.scontact = scontact;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Time getStime() {
        return stime;
    }

    public void setStime(Time stime) {
        this.stime = stime;
    }

    public String getSinfo() {
        return sinfo;
    }

    public void setSinfo(String sinfo) {
        this.sinfo = sinfo;
    }

    public String getSlocation() {
        return slocation;
    }

    public void setSlocation(String slocation) {
        this.slocation = slocation;
    }

    public String getScontact() {
        return scontact;
    }

    public void setScontact(String scontact) {
        this.scontact = scontact;
    }
        
        public String add()
    {
        if(sid !=0)
            return "login";
            return null;
    }
    
}
