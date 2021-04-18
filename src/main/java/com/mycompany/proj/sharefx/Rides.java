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
public class Rides {
    
        private int rid;
	private String rname;
	private String rdeparture;
        private String rdestination;
	private Date rdate;
        private Time rtime;
	private String rinfo;
        private int rcount;
	private String rcontact;

    public Rides() {
    }

    public Rides(int rid, String rname, String rdeparture, String rdestination, Date rdate, Time rtime, String rinfo, int rcount, String rcontact) {
        this.rid = rid;
        this.rname = rname;
        this.rdeparture = rdeparture;
        this.rdestination = rdestination;
        this.rdate = rdate;
        this.rtime = rtime;
        this.rinfo = rinfo;
        this.rcount = rcount;
        this.rcontact = rcontact;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdeparture() {
        return rdeparture;
    }

    public void setRdeparture(String rdeparture) {
        this.rdeparture = rdeparture;
    }

    public String getRdestination() {
        return rdestination;
    }

    public void setRdestination(String rdestination) {
        this.rdestination = rdestination;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public Time getRtime() {
        return rtime;
    }

    public void setRtime(Time rtime) {
        this.rtime = rtime;
    }

    public String getRinfo() {
        return rinfo;
    }

    public void setRinfo(String rinfo) {
        this.rinfo = rinfo;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public String getRcontact() {
        return rcontact;
    }

    public void setRcontact(String rcontact) {
        this.rcontact = rcontact;
    }
        
    public String add()
    {
        if(rid !=0)
            return "login";
            return null;
    }
           
}
