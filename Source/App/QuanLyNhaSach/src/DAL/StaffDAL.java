/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import  Entity.Staff;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class StaffDAL extends  DataAccessHelper{
    //Hiện thị thông tin nhân viên
    public ArrayList<Staff> LoadStaff()
    {
        ArrayList<Staff> temp =new ArrayList<Staff>();
        String SQL="SELECT * FROM NHANVIEN";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
            {
                while(rs.next())
                {
                    Staff staff =new Staff();
                    staff.setID(rs.getInt("MANV"));
                    staff.setName(rs.getString("TENNV"));
                    staff.setBirthDay(rs.getDate("NGAYSINH"));
                    staff.setSex(rs.getString("GIOITINH"));
                    staff.setAddress(rs.getString("DIACHI"));
                    staff.setPhoneNumber(rs.getString("SODT"));
                    staff.setStartDate(rs.getDate("NGAYVL"));
                    staff.setStatus(rs.getInt("TRANGTHAI"));
                    temp.add(staff);
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm nhân viên
    public boolean  InsertStaff(String name ,String birthday , String sex ,String address , String phonenumber , String startdate,int status)
    {
        String SQL="SP_INSERTSTAFF N'"+name+"',N'"+birthday+"',N'"+sex+"',N'"+address+"',N'"+phonenumber+"',N'"+startdate+"','"+status+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs!=0)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    }
    //Cập nhật nhân viên
    public boolean UpdateStaff(int id , String name , String birthday ,String sex ,String address, String phonenumber , String startdate, int status)
    {
        String SQL="SP_UPDATESTAFF '"+id+"',N'"+name+"',N'"+birthday+"',N'"+sex+"',N'"+address+"',N'"+phonenumber+"',N'"+startdate+"','"+status+"'";
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
    //Tra cứu nhân viên
    public ArrayList<Staff> arrSearchStaff(String KEY)
    {
        ArrayList<Staff> temp =new ArrayList<Staff>();
        String SQL="EXEC SP_SEARCHSTAFF N'"+KEY+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
            {
                while(rs.next())
                {
                    Staff staff =new Staff();
                    staff.setID(rs.getInt("MANV"));
                    staff.setName(rs.getString("TENNV"));
                    staff.setBirthDay(rs.getDate("NGAYSINH"));
                    staff.setSex(rs.getString("GIOITINH"));
                    staff.setAddress(rs.getString("DIACHI"));
                    staff.setPhoneNumber(rs.getString("SODT"));
                    staff.setStartDate(rs.getDate("NGAYVL"));
                    staff.setStatus(rs.getInt("TRANGTHAI"));
                    temp.add(staff);
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    

   
}
