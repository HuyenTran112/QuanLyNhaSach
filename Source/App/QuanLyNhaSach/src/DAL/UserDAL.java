/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class UserDAL extends  DataAccessHelper{
    //Load danh sách người dung
    public ArrayList<User> LoadUser()
    {
        ArrayList <User> temp= new ArrayList<>();
        String SQL="EXEC SP_LOADUSER";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    User user =new User();
                    user.setNameCategogy(rs.getString("TENNHOM"));
                    user.setNameStaff(rs.getString("TENNV"));
                    user.setUserName(rs.getString("TENDANGNHAP"));
                    user.setDisplayName(rs.getString("TENHIENTHI"));
                    user.setPassWord(rs.getString("MATKHAU"));
                    temp.add(user);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm người dùng
    public boolean  InsertUser(int IDCategogy ,int IDStaff)
    {
        String SQL="EXEC SP_INSERTUSER '"+IDCategogy+"','"+IDStaff+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    }
    //Cập nhật người dùng
    public boolean UpdateUser(int IDCategogy , int IDStaff ,String PassWord )
    {
        String SQL="EXEC SP_UPDATEUSER '"+IDCategogy+"','"+IDStaff+"',N'"+PassWord+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    }
    //Xóa người dùng
    public boolean DeleteUser(int IDStaff)
    {
        String SQL ="EXEC SP_DELETEUSER '"+IDStaff+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    }
    //Tìm người dùng theo mã nhân viên
      public ArrayList<User> SerachUser(String KEY)
    {
        ArrayList <User> temp= new ArrayList<>();
        String SQL="EXEC SP_SEAECHLOADUSER N'"+KEY+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    User user =new User();
                    user.setNameCategogy(rs.getString("TENNHOM"));
                    user.setNameStaff(rs.getString("TENNV"));
                    user.setUserName(rs.getString("TENDANGNHAP"));
                    user.setDisplayName(rs.getString("TENHIENTHI"));
                    user.setPassWord(rs.getString("MATKHAU"));
                    temp.add(user);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Đăng nhập
     public boolean Login(String username ,String password )
    {
        String SQL="EXEC SP_LOGIN N'"+username+"',N'"+password+"'";
        try {
            getConnect();
            PreparedStatement ps =conn.prepareStatement(SQL);
            ResultSet rs=ps.executeQuery();
            if(rs!=null)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    } 
     //Cập nhật tài khoản (mật khẩu)
      public boolean UpdateAccount(String username ,String password,String newpassword)
    {
        String SQL="EXEC SP_UPDATEPASSWORD N'"+username+"',N'"+password+"',N'"+newpassword+"'";
        try {
            getConnect();
            PreparedStatement ps =conn.prepareStatement(SQL);
            ResultSet rs=ps.executeQuery();
            if(rs!=null)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    } 
     //Lấy tên nhóm theo tên đăng nhập
     public String getCategogyUser(String username )
    {
        String SQL="EXEC SP_GETCATEGOGYUSER N'"+username+"'";
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null &&rs.next() )
                return rs.getString("TENNHOM");
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
