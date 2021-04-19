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
@ManagedBean(name="hdetails")
@SessionScoped
public class HobbyDetailsBean implements Serializable{
    
    private List<Hobby> hobby;
    private List<HobbyComments> hobbycomments;

    
    private int hid;
    private String hname;
    private Date hdate;
    private Time htime;
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

     public List<Hobby> getHobby() throws ClassNotFoundException, SQLException { 
         
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String hobbyId = paramMap.get("hid");
       
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute("hid", hobbyId);
        
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
        
        hobby = new ArrayList<>();
        PreparedStatement pstmt = connect
                .prepareStatement("select * from hobby where hid=?");
        
        pstmt.setInt(1,Integer.parseInt(hobbyId));
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
           
            hobby.add(new Hobby((rs.getInt("hid")), (rs.getString("hname")), (rs.getDate("hdate")), (rs.getTime("htime")), (rs.getString("hinfo")), (rs.getString("hlocation")), (rs.getString("hcontact"))));
          
        }
        
        rs.close();
        pstmt.close();
        connect.close();
                                
        return hobby;
        
     }
     
     public List<HobbyComments> getHobbycomments() throws ClassNotFoundException, SQLException{
         
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String hobbyId = paramMap.get("hid");
       
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute("hid", hobbyId);
        
        
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

        hobbycomments = new ArrayList<>();
        PreparedStatement pstmt = connect
                .prepareStatement("select * from hcomments where hid=?");
        
        pstmt.setInt(1,Integer.parseInt(hobbyId));
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
           
            hobbycomments.add(new HobbyComments((rs.getInt("uid")),(rs.getString("username")),(rs.getString("comment"))));
          
        }

        // close resources
        rs.close();
        pstmt.close();
        connect.close();
        return hobbycomments;
    }
     
     
    /*
     public List<HobbyComments> getHobbyComments() throws ClassNotFoundException, SQLException {

       
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String hobbyId = paramMap.get("hid");
       
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute("hid", hobbyId);
        
        
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

        hobbycomments = new ArrayList<>();
        PreparedStatement pstmt = connect
                .prepareStatement("select * from hcomments where hid=?");
        
        pstmt.setInt(1,Integer.parseInt(hobbyId));
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
           
            hobbycomments.add(new HobbyComments((rs.getInt("uid")),(rs.getString("username")),(rs.getString("comment"))));
          
        }

        // close resources
        rs.close();
        pstmt.close();
        connect.close();
                                
        return hobbycomments;

    }
*/
    
}
