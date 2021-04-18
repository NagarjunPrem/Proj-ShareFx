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
public class HobbyBean {
    
    private static final long serialVersionUID = 6081417964063918994L;
    
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

        List<Hobby> hobby = new ArrayList<Hobby>();
        PreparedStatement pstmt = connect
                .prepareStatement("select * from hobby");
        //select rid, rtitle, pub_title, pub_url, summary, post_negt, maj_points, min_points, recommendation, rev_name from reviews
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
           
            hobby.add(new Hobby((rs.getInt("hid")), (rs.getString("hname")), (rs.getDate("hdate")), (rs.getTime("htime")), (rs.getString("hinfo")), (rs.getString("hlocation")), (rs.getString("hcontact"))));
          
        }
        
         // close resources
        rs.close();
        pstmt.close();
        connect.close();

        return hobby;

    }
    
}
