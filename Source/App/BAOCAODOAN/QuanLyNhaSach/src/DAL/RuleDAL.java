/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Rule;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author STIREN
 */
public class RuleDAL extends DataAccessHelper{
    //Lấy thông tin quy định
    public ArrayList<Rule> LoadRule()
    {
        ArrayList<Rule> temp =new ArrayList<Rule>();
        String SQL = "EXEC SP_LOADRULE";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
            {
                while(rs.next())
                {
                    Rule rule = new Rule();
                    rule.setMinInventoryNum(rs.getInt("SOLUONGTONTOITHIEU"));
                    rule.setMaxStockNum(rs.getInt("SOLUONGNHAPTOIDA"));
                    rule.setMinStockNum(rs.getInt("SOLUONGNHAPTOITHIEU"));
                    rule.setVAT(rs.getFloat("VAT"));
                    
                    temp.add(rule);
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Cập nhật quy định
    public boolean UpdateRule(int MinInventoryNum,  int MaxStockNum, int MinStockNum, float VAT)
    {
        String SQL = "EXEC SP_UPDATERULE  " + MinInventoryNum + ", " + MaxStockNum + ", " + MinStockNum + ", " + VAT;
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
    public int getMaxInventoryNum()
    {
        String SQL = "SELECT SOLUONGTONTOIDA  FROM THAMSO";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("SOLUONGTONTOIDA");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    
    }
    public int getMinInventoryNum()
    {
        String SQL = "SELECT SOLUONGTONTOITHIEU FROM THAMSO";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("SOLUONGTONTOITHIEU");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    
   
    public int getMaxStockNum()
    {
        String SQL = "SELECT SOLUONGNHAPTOIDA  FROM THAMSO";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("SOLUONGNHAPTOIDA");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    public int getMinStockNum()
    {
        String SQL = "SELECT SOLUONGNHAPTOITHIEU FROM THAMSO";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("SOLUONGNHAPTOITHIEU");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    public float getVAT()
    {
        String SQL = "SELECT VAT FROM THAMSO";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getFloat("VAT");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    
}
