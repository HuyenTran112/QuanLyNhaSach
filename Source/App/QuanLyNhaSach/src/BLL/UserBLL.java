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
    
}
