/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proj.sharefx;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@ManagedBean
@SessionScoped
public class SkillBean {
    
    private static final long serialVersionUID = 6081417964063918994L;
    
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
        
        List<Skill> skill = new ArrayList<Skill>();
        PreparedStatement pstmt = connect
                .prepareStatement("select * from skill");
        
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
           
            skill.add(new Skill((rs.getInt("sid")), (rs.getString("sname")), (rs.getDate("sdate")), (rs.getTime("stime")), (rs.getString("sinfo")), (rs.getString("slocation")), (rs.getString("scontact"))));
          
        }
        
         // close resources
        rs.close();
        pstmt.close();
        connect.close();

        return skill;
    }
    
}
