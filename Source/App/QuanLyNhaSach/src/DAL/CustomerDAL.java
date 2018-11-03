/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Customer;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STIREN
 */
public class CustomerDAL extends  DataAccessHelper{
    //Lấy thông tin tất cả khách hàng
    public ArrayList<Customer> LoadCustomer()
    {
        ArrayList<Customer> temp = new ArrayList<>();
        String SQL = "EXEC SP_LOADCUSTOMER";
        
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery();
            if(rs != null)
            {
                while(rs.next())
                {
                    Customer customer = new Customer();
                    customer.setIDCustomer(rs.getInt("MAKH"));
                    customer.setNameCustomer(rs.getString("TENKH"));
                    customer.setAddressCustomer(rs.getString("DIACHI"));
                    customer.setPhoneCustomer(rs.getString("SODT"));
                    customer.setBirthdayCutomer(rs.getDate("NGAYSINH"));
                    customer.setRegisDateCutomer(rs.getDate("NGAYDKY"));                  
                    customer.setTurnoverCustomer(rs.getDouble("DOANHSO"));
                    temp.add(customer);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
        
    //Thêm khách hàng
    //@TENKH NVARCHAR(100), @DIACHI NVARCHAR(200), @SODT NVARCHAR(10), @NGAYSINH SMALLDATETIME, @NGAYDKY SMALLDATETIME
    public boolean InsertCustomer(String NameCustomer, String AddressCustomer, String PhoneCustomer, String Birthday, String RegisDate)
    {
        String SQL = "EXEC SP_INSERTCUSTOMER N'" + NameCustomer +"', N'" + AddressCustomer + "', N'" + PhoneCustomer + "','" + Birthday + "', '" + RegisDate + "'";
        try {
            getConnect();
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(SQL);
            if(rs > 0)
                return true;
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Cập nhật khách hàng   
    public boolean UpdateCustomer(int IDCustomer, String NameCustomer, String AddressCustomer, String PhoneCustomer, String BirthdayCustomer, String RegisdateCustomer)
    {
        String SQL = "EXEC SP_UPDATECUSTOMER " + IDCustomer + ", N'" + NameCustomer + "', N'" + AddressCustomer + "', N'" + PhoneCustomer + "', '" + BirthdayCustomer + "', '" + RegisdateCustomer + "'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    //Tìm kiếm khách hàng theo tên
    public ArrayList <Customer> SearchCustomer(String key)
    {
        ArrayList<Customer> temp = new ArrayList<>();
        String SQL = "EXEC SP_SEARCHCUSTOMER N'" + key +"'";
        try{
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next()){
                    Customer customer = new Customer();
                    customer.setIDCustomer(rs.getInt("MAKH"));
                    customer.setNameCustomer(rs.getString("TENKH"));
                    customer.setAddressCustomer(rs.getString("DIACHI"));
                    customer.setPhoneCustomer(rs.getString("SODT"));
                    customer.setBirthdayCutomer(rs.getDate("NGAYSINH"));
                    customer.setRegisDateCutomer(rs.getDate("NGAYDKY"));                  
                    customer.setTurnoverCustomer(rs.getDouble("DOANHSO"));
                    
                    temp.add(customer);
                }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return temp;
    }
}

