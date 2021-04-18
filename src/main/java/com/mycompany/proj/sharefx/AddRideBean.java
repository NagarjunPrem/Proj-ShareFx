/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proj.sharefx;

/**
 *
 * @author Nagarjun Prem
 */
import java.io.Serializable;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
//import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.time.*;

@ManagedBean(name="addride")
@SessionScoped

public class AddRideBean implements Serializable {
    
        private int rid;
	private String rname;
	private String rdeparture;
        private String rdestination;
	private String rdate;
        private String rtime;
	private String rinfo;
        private int rcount;
	private String rcontact;

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

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
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
        
        public void setRides() throws ClassNotFoundException, SQLException
        {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
            HttpSession httpSession = request.getSession(false);
            String uid = httpSession.getAttribute("userId").toString(); 
            
            try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }

        Connection connect = null;
        
        try {
            connect
                    = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sharefx?"
                            + "user=student&password=student&useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false");

            // Do something with the Connection
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        PreparedStatement pstmt = connect
                .prepareStatement("insert into ride(rname, rdeparture, rdestination, rdate, rtime, rinfo, rcount, rcontact, uid) VALUES(?,?,?,?,?,?,?,?,?)");
        pstmt.setString(1, rname);
        pstmt.setString(2,rdeparture);
        pstmt.setString(3,rdestination);
        pstmt.setString(4, rdate);
        pstmt.setString(5, rtime);
        pstmt.setString(6,rinfo);
        pstmt.setInt(7,rcount);
        pstmt.setString(8,rcontact);
        pstmt.setString(9, uid);      
         
      
        pstmt.executeUpdate();
        
        pstmt.close();
        connect.close();
        
        }
        
        public String nav()
        {
            return "loginSuccess";
        }
}
