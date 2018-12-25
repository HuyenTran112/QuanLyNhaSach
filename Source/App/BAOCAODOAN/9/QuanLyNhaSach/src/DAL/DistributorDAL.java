/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import Entity.Distributor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class DistributorDAL extends  DataAccessHelper{
    //Lấy dữ liệu nhà cung cấp
    public ArrayList<Distributor> LoadDistributor()
    {
        ArrayList<Distributor>temp =new ArrayList<>();
        String SQL="EXEC SP_LOAD_DISTRIBUTOR";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery(SQL);
            if(rs!=null)
            {
                while(rs.next())
                {
                    Distributor distributor =new Distributor();
                    distributor.setIDDistributor(rs.getInt("MACTY"));
                    distributor.setNameDistributor(rs.getString("TENCTY"));
                    distributor.setAddress(rs.getString("DIACHI"));
                    distributor.setPhoneNumber(rs.getString("SODT"));
                    temp.add(distributor);
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm nhà cung cấp
    public boolean  InsertDistributor(String NameDistributor ,String Address, String PhoneNumber)
    {
        String SQL="EXEC SP_INSERTDISTRIBUTOR N'"+NameDistributor+"',N'"+Address+"','"+PhoneNumber+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Cập nhật nhà cung cấp
    public boolean  UpdateDistributor(int IDDistributor,String NameDistributor ,String Address , String PhoneNumber)
    {
        String SQL="EXEC SP_UPDATEDISTRIBUTOR '"+IDDistributor+"',N'"+NameDistributor+"',N'"+Address+"','"+PhoneNumber+"'";
        try {
            getConnect();
            Statement st = conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Xóa nhà cung cấp
    public boolean  DeleteDistributor(int IDDistributor)
    {
        String SQL="EXEC SP_DELETEDISTRIBUTOR '"+IDDistributor+"'";
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
    //Tìm nhà cung cấp
    public ArrayList<Distributor>  SearchDistributor(String key)
    {
        ArrayList<Distributor> temp =new ArrayList<>();
        String SQL="EXEC SP_SEARCHDISTRIBUTOR N'"+key+"'";
           try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery(SQL);
            if(rs!=null)
            {
                while(rs.next())
                {
                    Distributor distributor =new Distributor();
                    distributor.setIDDistributor(rs.getInt("MACTY"));
                    distributor.setNameDistributor(rs.getString("TENCTY"));
                    distributor.setAddress(rs.getString("DIACHI"));
                    distributor.setPhoneNumber(rs.getString("SODT"));
                    temp.add(distributor);
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
       
    }
    //lấy tên nhà cung cấp theo mã
    public String getNameDistributor(int IDNameDistributor)
    {
        String SQL="SELECT TENCTY FROM CONGTY WHERE MACTY='"+IDNameDistributor+"'";
        try {
            getConnect();
            PreparedStatement ps=conn.prepareStatement(SQL);
            ResultSet rs=ps.executeQuery();
            if(rs!=null && rs.next())
                return rs.getString("TENCTY");
            getClose();
        } catch (Exception e) {
        }
        return "";
    }
    //lấy mã nhà cung cấp theo tên nhà cung cấp
    public int getIDDistributor(String NameDistributor)
    {
        String SQL="SELECT MACTY FROM CONGTY WHERE TENCTY=N'"+NameDistributor+"'";
        try {
            getConnect();
            PreparedStatement ps=conn.prepareStatement(SQL);
            ResultSet rs =ps.executeQuery();
            if(rs!=null && rs.next())
                return rs.getInt("MACTY");
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //lấy địa chỉ nhà cung cấp
    public String getAddressDistributor(int IDNameDistributor)
    {
        String SQL="SELECT DIACHI FROM CONGTY WHERE MACTY='"+IDNameDistributor+"'";
        try {
            getConnect();
            PreparedStatement ps=conn.prepareStatement(SQL);
            ResultSet rs=ps.executeQuery();
            if(rs!=null && rs.next())
                return rs.getString("DIACHI");
            getClose();
        } catch (Exception e) {
        }
        return "";
    }
    //lấy số điện thoại nhà cung cấp
    public String getPhoneDistributor(int IDNameDistributor)
    {
        String SQL="SELECT SODT FROM CONGTY WHERE MACTY='"+IDNameDistributor+"'";
        try {
            getConnect();
            PreparedStatement ps=conn.prepareStatement(SQL);
            ResultSet rs=ps.executeQuery();
            if(rs!=null && rs.next())
                return rs.getString("SODT");
            getClose();
        } catch (Exception e) {
        }
        return "";
    }
}
