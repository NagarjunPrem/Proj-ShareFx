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

@ManagedBean
@SessionScoped
public class RideBean {
    
    private static final long serialVersionUID = 6081417964063918994L;

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

        List<Rides> rides = new ArrayList<Rides>();
        PreparedStatement pstmt = connect
                .prepareStatement("select * from ride");
        //select rid, rtitle, pub_title, pub_url, summary, post_negt, maj_points, min_points, recommendation, rev_name from reviews
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
    
}
