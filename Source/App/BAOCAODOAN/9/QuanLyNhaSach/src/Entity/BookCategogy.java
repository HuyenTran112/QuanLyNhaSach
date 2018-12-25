/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookCategogy {
    private int IDBookCategogy;
    private String NameBookCategogy ;

    /**
     * @return the IDBookCategogy
     */
    public int getIDBookCategogy() {
        return IDBookCategogy;
    }

    /**
     * @param IDBookCategogy the IDBookCategogy to set
     */
    public void setIDBookCategogy(int IDBookCategogy) {
        this.IDBookCategogy = IDBookCategogy;
    }

    /**
     * @return the NameBookCategogy
     */
    public String getNameBookCategogy() {
        return NameBookCategogy;
    }

    /**
     * @param NameBookCategogy the NameBookCategogy to set
     */
    public void setNameBookCategogy(String NameBookCategogy) {
        this.NameBookCategogy = NameBookCategogy;
    }
    public BookCategogy()
    {
        IDBookCategogy=0;
        NameBookCategogy="";
    }
}
