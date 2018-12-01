/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.UserDAL;
import Entity.User;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class UserBLL {
    UserDAL DAL=new UserDAL();
    public ArrayList<User> LoadUser()
    {
        return DAL.LoadUser();
    }
    public boolean  InsertUser(int IDCategogy ,int IDStaff)
    {
        return DAL.InsertUser(IDCategogy, IDStaff);
    }
    public boolean UpdateUser(int IDCategogy , int IDStaff ,String PassWord)
    {
        return DAL.UpdateUser(IDCategogy, IDStaff, PassWord);
    }
    public boolean DeleteUser(int IDStaff)
    {
        return DAL.DeleteUser(IDStaff);
    }
    public ArrayList<User> SearchUser(String key)
    {
        return DAL.SerachUser(key);
    }
     public boolean Login(String username ,String password )
    {
        return DAL.Login(username, password);
    }
      public String getCategogyUser(String username )
    {
        return DAL.getCategogyUser(username);
    }
       public boolean UpdateAccount(String username ,String password,String newpassword)
    {
        return DAL.UpdateAccount(username, password, newpassword);
    }
}
