/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author STIREN
 */
public class Rule {
    private int MaxInventoryNum;
    private int MinInventoryNum;
    private float PriceRatio;
    private int MaxStockNum;
    private int MinStockNum;
    private float VAT;

    public Rule() {
        this.MaxInventoryNum = 0;
        this.MinInventoryNum = 0;
        this.PriceRatio = 0;
        this.MaxStockNum = 0;
        this.MinStockNum = 0;
        this.VAT = 0;
    }

    public int getMaxInventoryNum() {
        return MaxInventoryNum;
    }

    public int getMinInventoryNum() {
        return MinInventoryNum;
    }

    public float getPriceRatio() {
        return PriceRatio;
    }

    public int getMaxStockNum() {
        return MaxStockNum;
    }

    public int getMinStockNum() {
        return MinStockNum;
    }

    public float getVAT() {
        return VAT;
    }

    public void setMaxInventoryNum(int MaxInventoryNum) {
        this.MaxInventoryNum = MaxInventoryNum;
    }

    public void setMinInventoryNum(int MinInventoryNum) {
        this.MinInventoryNum = MinInventoryNum;
    }

    public void setPriceRatio(float PriceRatio) {
        this.PriceRatio = PriceRatio;
    }

    public void setMaxStockNum(int MaxStockNum) {
        this.MaxStockNum = MaxStockNum;
    }

    public void setMinStockNum(int MinStockNum) {
        this.MinStockNum = MinStockNum;
    }

    public void setVAT(float VAT) {
        this.VAT = VAT;
    } 
}
