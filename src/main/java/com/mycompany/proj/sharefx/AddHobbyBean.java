/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proj.sharefx;

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

/**
 *
 * @author Nagarjun Prem
 */

@ManagedBean(name="addhobby")
@SessionScoped
public class AddHobbyBean implements Serializable {
    
        private int hid;
	private String hname;
	private String hdate;
        private String htime;
	private String hinfo;
        private String hlocation;
	private String hcontact;

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

    public String getHdate() {
        return hdate;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    public String getHtime() {
        return htime;
    }

    public void setHtime(String htime) {
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

        
        public void setHobby() throws ClassNotFoundException, SQLException
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
                .prepareStatement("insert into hobby(hname, hdate, htime, hinfo, hlocation, hcontact, uid) VALUES(?,?,?,?,?,?,?)");
        pstmt.setString(1, hname);
        pstmt.setString(2, hdate);
        pstmt.setString(3, htime);
        pstmt.setString(4, hinfo);
        pstmt.setString(5, hlocation);
        pstmt.setString(6, hcontact);
        pstmt.setString(7, uid);      
         
      
        pstmt.executeUpdate();
        
        pstmt.close();
        connect.close();
        
        }
        
        public String nav()
        {
            return "loginSuccess";
        }
    
}
