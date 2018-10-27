/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.util.ArrayList;
import  DAL.*;
import  Entity.*;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookCategogyBLL {
    BookCategogyDAL DAL = new BookCategogyDAL();
    public ArrayList <BookCategogy> LoaBookCategogy()
    {
        return DAL.LoadBookCategogy();
    }
    public int getIDBookCategogy(String NameBookCategogy)
    {
        return DAL.getIDBookCategogy(NameBookCategogy);
    }
    public String getNameBookCategogy(int IDBookCategogy)
    {
        return DAL.getNameBookCategogy(IDBookCategogy);
    }
    public boolean InsertBookCategogy(String NameBookCategogy)
    {
        return DAL.InsertBookCategogy(NameBookCategogy);
    }
    public boolean  UpdateBookCategogy(int IDBookCategogy,String NameBookCategogy)
    {
        return DAL.UpdateBookCategogy(IDBookCategogy, NameBookCategogy);
    }
    public boolean DeleteBookCategogy(int IDBookCategogy)
    {
        return DAL.DeleteBookCategogy(IDBookCategogy);
    }
}
