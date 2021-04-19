/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proj.sharefx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nagarjun Prem
 */
@ManagedBean(name="addSCom")
@SessionScoped
public class AddSkillCom {
    
    private List<SCom> skillcomList = new ArrayList<>() ;
    private String name;
    private String comment; 

    public List<SCom> getSkillcomList() {
        return skillcomList;
    }

    public void setSkillcomList(List<SCom> skillcomList) {
        this.skillcomList = skillcomList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public void setCom() throws ClassNotFoundException, SQLException
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
        String skillId1 = (String) sessionMap.get("sid");
        Integer uid1 = (Integer)sessionMap.get("userid");
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
                .prepareStatement("INSERT INTO scomments(uid, sid, username, comment) VALUES(?,?,?,?);");


        pstmt.setInt(1,uid1);
        pstmt.setInt(2, Integer.parseInt(skillId1));
        pstmt.setString(3, name);
        pstmt.setString(4, comment); 
        pstmt.executeUpdate();

        pstmt.close();
        connect.close();
    }
    
}
