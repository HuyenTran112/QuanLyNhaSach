/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import Entity.*;
import java.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class DiscountDAL extends DataAccessHelper{
    public ArrayList<Discount> LoadDiscount()
    {
        ArrayList<Discount> temp=new ArrayList<>();
        String SQL="EXEC SP_LOADDISCOUNT";
        try {
            getConnect();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs!=null)
            {
                while(rs.next())
                {
                    Discount discount=new Discount();
                    discount.setIDDiscount(rs.getInt("MAKM"));
                    discount.setNameDiscount(rs.getString("TENKM"));
                    discount.setDiscount(rs.getFloat("HESOKM"));
                    discount.setMoney(rs.getFloat("MUCTIEN"));
                    discount.setStartDate(rs.getDate("NGAYBD"));
                    discount.setFinishDate(rs.getDate("NGAYKT"));
                    
                    temp.add(discount);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    //Thêm khuyến mãi
    public boolean  InsertDiscount(String NameDiscount , float Discount, float Money, String StartDate , String FinishDate)
    {
        String SQL="EXEC SP_INSERTDISCOUNT N'"+NameDiscount+"','"+Discount+"','"+Money+"','"+StartDate+"','"+FinishDate+"'";
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
    //Cập nhật khuyến mãi
    public boolean  UpdateDiscount(int IDDiscount,String NameDiscount , float Discount, float Money, String StartDate , String FinishDate)
    {
        String SQL="EXEC SP_UPDATEDISCOUNT '"+IDDiscount+"', N'"+NameDiscount+"','"+Discount+"','"+Money+"','"+StartDate+"','"+FinishDate+"'";
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
    //Xóa khuyến mãi
    public boolean  DeleteDiscount(int IDDiscount)
    {
        String SQL="EXEC SP_DELETEDISCOUNT '"+IDDiscount+"'";
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
            }
