/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import  Entity.Distributor;
import DAL.DistributorDAL;
import java.util.ArrayList;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class DistributorBLL {
    DistributorDAL DAL =new DistributorDAL();
    //Load nhà cung cấp
    public ArrayList<Distributor> LoadDistributor()
    {
        return DAL.LoadDistributor();
    }
    //Thêm nhà cung cấp
    public boolean  InsertDistributor(String NameDistributor ,String Address , String PhoneNumber)
    {
        return DAL.InsertDistributor(NameDistributor, Address, PhoneNumber);
    }
    //Cập nhật nhà cung cấp
    public boolean  UpdateDistributor(int IDDistributor , String NameDistributor ,String Address , String PhoneNumber)
    {
        return DAL.UpdateDistributor(IDDistributor, NameDistributor, Address, PhoneNumber);
    }
    //Xóa nhà cung cấp
    public boolean  DeleteDistributor(int IDDistributor)
    {
        return DAL.DeleteDistributor(IDDistributor);
    }
    //Tìm kiếm nhà cung cấp
    public ArrayList<Distributor> SearchDistributor(String key)
    {
        return DAL.SearchDistributor(key);
    }
    //lấy mã nhà cung cấp theo tên
    public int getIDDistributor(String NameDistributor )
    {
        return DAL.getIDDistributor(NameDistributor);
    }
}
