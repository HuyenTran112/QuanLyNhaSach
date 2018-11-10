/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CustomerDAL;
import Entity.Customer;
//import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author STIREN
 */
public class CustomerBLL {
    CustomerDAL DAL = new CustomerDAL();
    
    //Thêm khách hàng
    public boolean InsertCustomer(String NameCustomer, String AddressCustomer, String PhoneCustomer, String Birthday, String RegisDate)
    {
        return DAL.InsertCustomer(NameCustomer, AddressCustomer, PhoneCustomer, Birthday, RegisDate);
    }
    //Lấy danh sách khách hàng
    public ArrayList <Customer> LoadCustomer()
    {
        return DAL.LoadCustomer();
    }
    
    //Cập nhật khách hàng
    public boolean UpdateCustomer(int IDCustomer, String NameCustomer, String AddressCustomer, String PhoneCustomer, String BirthdayCustomer, String RegisdateCustomer)
    {
        return DAL.UpdateCustomer(IDCustomer, NameCustomer, AddressCustomer, PhoneCustomer, BirthdayCustomer, RegisdateCustomer);
    }
    
    //Tìm kiếm khách hàng
    public ArrayList<Customer> SearchCustomer(String key){
        return DAL.SearchCustomer(key);
    }
    //Lấy danh sách mã nhân viên
    public String getNameCustomerByID(int IDCustomer)
    {
        return DAL.getNameCustomerByID(IDCustomer);
    }
}
