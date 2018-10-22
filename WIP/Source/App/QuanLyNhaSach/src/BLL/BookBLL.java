/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.util.ArrayList;
import  DAL.*;
import Entity.*;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookBLL {
    BookDAL DAL=new BookDAL();
    //Lấy danh sách SACH
    public ArrayList<Book> layDanhSach()
    {
       //BookDAL DAL=new BookDAL();
        return DAL.layDanhSach();
    }
}
