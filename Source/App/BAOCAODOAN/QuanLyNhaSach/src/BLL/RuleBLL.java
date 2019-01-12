/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.RuleDAL;
import Entity.Rule;
import java.util.ArrayList;
/**
 *
 * @author STIREN
 */
public class RuleBLL {
    RuleDAL DAL = new RuleDAL();
    public ArrayList <Rule> LoadRule(){
        return DAL.LoadRule();
    }
    
    public boolean UpdateRule(int MinInventoryNum, int MaxStockNum, int MinStockNum, float VAT){
        return DAL.UpdateRule(MinInventoryNum, MaxStockNum, MinStockNum, VAT);
    }
     public int getMaxInventoryNum()
    {
        return DAL.getMaxInventoryNum();
    }
      public int getMinInventoryNum()
    {
        return DAL.getMinInventoryNum();
    }
     
    public int getMaxStockNum()
    {
        return DAL.getMaxStockNum();
    }
    public int getMinStockNum()
    {
        return DAL.getMinStockNum();
    }
    public float getVAT()
    {
        return DAL.getVAT();
    }
      
}
