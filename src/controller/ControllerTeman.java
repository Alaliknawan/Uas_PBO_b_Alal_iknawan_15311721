/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelTeman;
import util.Koneksi;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControllerTeman {
    Koneksi koneksi = new Koneksi();
    
    public void simpandata(ModelTeman mt){
        koneksi.koneksiDatabase();
        
       String query = "INSERT INTO tbl_teman(nama, nope, email) VALUES ('"+mt.getNama()+"','"+mt.getNope()+"','"+mt.getEmail()+"')";
        try {
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Berhasil Disimpan");
            System.err.println(""+e);
        }
        
    }
    
    public void hapusData(ModelTeman mt){
        try {
            koneksi.koneksiDatabase(); 
            String query = "delete from tbl_teman where id=('"+mt.getId()+"')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
    
    public void ubahData(ModelTeman mt){
        try {
            koneksi.koneksiDatabase();
            int id = mt.getId();
            String nama = mt.getNama();
            String nope = mt.getNope();
            String email = mt.getEmail();

            String query = "update tbl_teman "
                    + "set nama=('" + nama + "'),"
                    + "nope=('"+ nope +"'),"
                    + "email=('"+ email +"')"
                    + "where id=('" + id + "')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate..");
            
            
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }

}
