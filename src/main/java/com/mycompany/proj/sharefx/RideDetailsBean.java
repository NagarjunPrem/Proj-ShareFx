/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proj.sharefx;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nagarjun Prem
 */
@ManagedBean(name="rdetails")
@SessionScoped
public class RideDetailsBean implements Serializable{
    
        private List<Rides> rides;        
        private List<RideComments> ridecomments;
        
        private int rid;
	private String rname;
	private String rdeparture;
        private String rdestination;
	private Date rdate;
        private Time rtime;
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
        
    public List<Rides> getRides() throws ClassNotFoundException, SQLException {    
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String rideId = paramMap.get("rid");
       
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute("rid", rideId);
        
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
         

        rides = new ArrayList<>();
        PreparedStatement pstmt = connect
                .prepareStatement("select * from ride where rid=?");
        
        pstmt.setInt(1,Integer.parseInt(rideId));
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
           
            rides.add(new Rides((rs.getInt("rid")), (rs.getString("rname")), (rs.getString("rdeparture")), (rs.getString("rdestination")), (rs.getDate("rdate")), (rs.getTime("rtime")), (rs.getString("rinfo")), (rs.getInt("rcount")), (rs.getString("rcontact"))));
          
        }

        // close resources
        rs.close();
        pstmt.close();
        connect.close();
                                
        return rides;
    }
    
    public List<RideComments> getRideComments() throws ClassNotFoundException, SQLException {

       
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String rideId = paramMap.get("rid");
       
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute("rid", rideId);
        
        
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

        ridecomments = new ArrayList<>();
        PreparedStatement pstmt = connect
                .prepareStatement("select * from rcomments where rid=?");
        
        pstmt.setInt(1,Integer.parseInt(rideId));
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
           
            ridecomments.add(new RideComments((rs.getInt("uid")),(rs.getString("username")),(rs.getString("comment"))));
          
        }

        // close resources
        rs.close();
        pstmt.close();
        connect.close();
                                
        return ridecomments;

    }
    
}

