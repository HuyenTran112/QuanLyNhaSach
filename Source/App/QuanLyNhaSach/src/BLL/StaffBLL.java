/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.StaffDAL;
import Entity.Staff;
import java.util.ArrayList;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class StaffBLL {
    StaffDAL DAL =new StaffDAL();
    //Hiện thị danh sách nhân viên
    public ArrayList <Staff> LoadStaff()
    {
        return DAL.LoadStaff();
    }
    //Thêm nhân viên
    public boolean InsertStaff(String name ,String birthday , String sex ,String address , String phonenumber , String startdate)
    {
        return  DAL.InsertStaff(name, birthday, sex, address, phonenumber, startdate);
    }
    //Cập nhật nhân viên
    public boolean UpdateStaff(int id,String name ,String birthday , String sex ,String address , String phonenumber , String startdate)
    {
        return DAL.UpdateStaff(id, name, birthday, sex, address, phonenumber, startdate);
    }
    //Xóa nhân viên
    public boolean DeleteStaff(int id)
    {
        return DAL.DeleteStaff(id);
    }
    //Tra cứu thông tin nhân viên
    public ArrayList<Staff> arrSearchStaff(String KEY)
    {
        return DAL.arrSearchStaff(KEY);
    }
}
