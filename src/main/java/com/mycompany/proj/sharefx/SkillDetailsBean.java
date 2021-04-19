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
@ManagedBean(name="sdetails")
@SessionScoped
public class SkillDetailsBean implements Serializable{
    
    private List<Skill> skill;
    private List<SkillComments> skillcomments;
    
    private int sid;
    private String sname;
    private Date sdate;
    private Time stime;
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

    public List<Skill> getSkill() throws ClassNotFoundException, SQLException {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String skillId = paramMap.get("sid");
       
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute("sid", skillId);
        
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
        
        skill = new ArrayList<>();
        PreparedStatement pstmt = connect
                .prepareStatement("select * from skill where sid=?");
        
        pstmt.setInt(1,Integer.parseInt(skillId));
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
           
            skill.add(new Skill((rs.getInt("sid")), (rs.getString("sname")), (rs.getDate("sdate")), (rs.getTime("stime")), (rs.getString("sinfo")), (rs.getString("slocation")), (rs.getString("scontact"))));
          
        }
        
        rs.close();
        pstmt.close();
        connect.close();
                                
        return skill;
    }
    
     public List<SkillComments> getSkillcomments() throws ClassNotFoundException, SQLException{
         
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String skillId = paramMap.get("sid");
       
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute("sid", skillId);
        
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
        
        skillcomments = new ArrayList<>();
        PreparedStatement pstmt = connect
                .prepareStatement("select * from scomments where sid=?");
        
        pstmt.setInt(1,Integer.parseInt(skillId));
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
           
            skillcomments.add(new SkillComments((rs.getInt("uid")),(rs.getString("username")),(rs.getString("comment"))));
          
        }
        
         // close resources
        rs.close();
        pstmt.close();
        connect.close();
        return skillcomments;
         
     }
    
    
}
