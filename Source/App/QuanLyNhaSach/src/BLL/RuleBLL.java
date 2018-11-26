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
    
    public boolean UpdateRule(int MaxInventoryNum, int MinInventoryNum, float PriceRatio, int MaxStockNum, int MinStockNum, float VAT){
        return DAL.UpdateRule(MaxInventoryNum, MinInventoryNum, PriceRatio, MaxStockNum, MinStockNum, VAT);
    }
}
