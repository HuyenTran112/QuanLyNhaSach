/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.*;
import Entity.*;
import java.*;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class DiscountBLL {
    DiscountDAL DAL=new DiscountDAL();
    public ArrayList<Discount> LoadDiscount ()
    {
        return DAL.LoadDiscount();
    }
    public boolean  InsertDiscount(String NameDiscount , float Discount, float Money, String StartDate , String FinishDate)
    {
        return DAL.InsertDiscount(NameDiscount, Discount, Money, StartDate, FinishDate);
    }
    public boolean  UpdateDiscount(int IDDiscount,String NameDiscount , float Discount, float Money, String StartDate , String FinishDate)
    {
        return DAL.UpdateDiscount(IDDiscount, NameDiscount, Discount, Money, StartDate, FinishDate);
    }
    public boolean DeleteDiscount(int IDDiscount)
    {
        return DAL.DeleteDiscount(IDDiscount);
    }
    public ArrayList<Discount> SearchDiscount(String key )
    {
        return DAL.SearchDiscount(key);
    }
}
