/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Rule;
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
                    rule.setMaxInventoryNum(rs.getInt("SOLUONGTONTOIDA"));
                    rule.setMinInventoryNum(rs.getInt("SOLUONGTONTOITHIEU"));
                    rule.setPriceRatio(rs.getFloat("TILETINHDONGIABAN"));
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
    public boolean UpdateRule(int MaxInventoryNum, int MinInventoryNum, float PriceRatio, int MaxStockNum, int MinStockNum, float VAT)
    {
        String SQL = "EXEC SP_UPDATERULE " + MaxInventoryNum + ", " + MinInventoryNum + ", " + PriceRatio + ", " + MaxStockNum + ", " + MinStockNum + ", " + VAT;
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
}
