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
@ManagedBean(name="addskill")
@SessionScoped
public class AddSkillBean implements Serializable {
    
        private int sid;
	private String sname;
	private String sdate;
        private String stime;
	private String sinfo;
        private String slocation;
	private String scontact;

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

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
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
        
        public void setSkill() throws ClassNotFoundException, SQLException
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
                .prepareStatement("insert into skill(sname, sdate, stime, sinfo, slocation, scontact, uid) VALUES(?,?,?,?,?,?,?)");
        pstmt.setString(1, sname);
        pstmt.setString(2, sdate);
        pstmt.setString(3, stime);
        pstmt.setString(4, sinfo);
        pstmt.setString(5, slocation);
        pstmt.setString(6, scontact);
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
