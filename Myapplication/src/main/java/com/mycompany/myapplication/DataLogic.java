/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapplication;

/**
 *
 * @author Akashk
 */
import java.sql.*;

/*
 *
 * @author sys-user
 */
public class DataLogic {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public DataLogic() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bikeonline3", "root", "akash");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     *
     */
    public boolean userdetail1(String userid, String username, String email, String pswrd) {
        try {
            ps = con.prepareStatement("insert into userdetail1(userid,username,email,pswrd)values(?,?,?,?)");
            ps.setString(1, userid);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, pswrd);
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public ResultSet viewData() {
        try {
            ps = con.prepareStatement("select * from customerdetail");
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
        return rs;
    }

    public ResultSet viewAppData(String mnumber) {
        try {
            ps = con.prepareStatement("select * from cservicedetail where mnumber=?");
            ps.setString(1, mnumber);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
        return rs;
    }

    public ResultSet finalDisplay() {
        try {
            ps = con.prepareStatement("select * from appointment");
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
        return rs;
    }

    public boolean adminDetail(String adminname, String pass) {
        try {
            ps = con.prepareStatement("Select * from admindetail where adminname=? and pass=?  ");
            ps.setString(1, adminname);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean customerDetail(String name, String mnumber, String email, String bikename) {
        try {
            ps = con.prepareStatement("insert into customerdetail(name,mnumber,email,bikename)values(?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, mnumber);
            ps.setString(3, email);
            ps.setString(4, bikename);
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean finalDetail(String name, String mnumber, String email, String servicename, String bikename, String problem, String dateappointment) {
        try {
            ps = con.prepareStatement("insert into appointment(name,mnumber,email,servicename,bikename,problem,dateappointment)values(?,?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, mnumber);
            ps.setString(3, email);
            ps.setString(4, servicename);
            ps.setString(5, bikename);
            ps.setString(6, problem);
            ps.setString(7, dateappointment);
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean addStaffDetail(String staffname, String exp, String rateing, String contact) {
        try {
            ps = con.prepareStatement("insert into staffdetail1(staffname,exp,rateing,contact)values(?,?,?,?)");
            ps.setString(1, staffname);
            ps.setString(2, exp);
            ps.setString(3, rateing);
            ps.setString(4, contact);
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean removeStaffDetail(String staffname) {
        try {
            ps = con.prepareStatement("delete from staffdetail1 where staffname=?");
            ps.setString(1, staffname);
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean removeCustomerDetail(String name) {
        try {
            ps = con.prepareStatement("delete from customerdetail where name=?");
            ps.setString(1, name);
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean removeAppointment(String sassistant, String datebooked) {
        try {
            ps = con.prepareStatement("delete from cservicedetail where sassistant=? and datebooked=?");
            ps.setString(1, sassistant);
            ps.setString(2, datebooked);
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean cservicedetail(String name, String mnumber, String sassistant, String problem, String datebooked) {
        try {
            ps = con.prepareStatement("insert into cservicedetail(name,mnumber,sassistant,problem,datebooked)values(?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, mnumber);
            ps.setString(3, sassistant);
            ps.setString(4, problem);
            ps.setString(5, datebooked);
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean existcustomer(String name, String mnumber, String email, String bikename) {
        try {
            ps = con.prepareStatement("insert into existcustomer(name,mnumber,email,bikename)values(?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, mnumber);
            ps.setString(3, email);
            ps.setString(4, bikename);
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public boolean userdetail1(String username, String pswrd) {
        try {
            ps = con.prepareStatement("Select * from userdetail1 where username=? and pswrd=?  ");
            ps.setString(1, username);
            ps.setString(2, pswrd);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    /*  public ResultSet staffcheck(String staffname){
        try{
            ps=con.prepareStatement("Select datebooked from cservicedetail where sassistant=? ");
            ps.setString(1,staffname);
            rs=ps.executeQuery();
        }
        catch(Exception e){
    }

    return rs;
}*/
    public ResultSet viewStaff() {
        try {
            ps = con.prepareStatement("select * from staffdetail1");
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
        return rs;
    }

    public ResultSet viewCustomer() {
        try {
            ps = con.prepareStatement("select * from customerdetail");
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
        return rs;
    }

    public ResultSet viewCustomerService() {
        try {
            ps = con.prepareStatement("select * from cservicedetail");
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
        return rs;
    }

    public ResultSet staffDetail() {
        try {
            ps = con.prepareStatement("select staffname,contact from staffdetail where staffname=?");
            //  ps.setString(1, staffname);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
        return rs;
    }

    public ResultSet excistCustomer(String mnumber) {
        try {
            ps = con.prepareStatement("select name,mnumber,email from customerdetail where mnumber=?");
            ps.setString(1, mnumber);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs;
            }
        } catch (Exception e) {
        }
        return rs;
    }

    public ResultSet selapp(String mnumber) {
        try {
            ps = con.prepareStatement("select * from cservicedetail where mnumber=?");
            ps.setString(1, mnumber);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs;
            }
        } catch (Exception e) {
        }
        return rs;
    }
    /*   public ResultSet viewStaff()
    {
        try
        {
            ps=con.prepareStatement("select * from staffDetail");
            rs=ps.executeQuery();
        }
        catch(Exception e)
                {
                    
        }
        return rs;
     */
}
