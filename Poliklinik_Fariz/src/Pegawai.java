/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import report.laporan_pegawai;

/**
 *
 * @author Ahmad Fariz
 */
public class Pegawai extends javax.swing.JFrame {

    /**
     * Creates new form Pegawai
     */
    public Pegawai() {
        initComponents();
        tabel.setModel(tblModel);
        Tabel(tabel, new int[]{100,180,200,300,150,150,100});
        setDefaultTable();
        
        nip.setEnabled(false);
        nama.setEnabled(false);
        alamat.setEnabled(false);
        telp.setEnabled(false);
        tgl_lahir.setEnabled(false);
        jenkel.setEnabled(false);
        tambah.setEnabled(true);
        simpan.setEnabled(false);
        ubah.setEnabled(false);
        hapus.setEnabled(false);
        keluar.setEnabled(true);
        batal.setEnabled(false);
        this.setSize(1060,540);
        this.setLocationRelativeTo(null);
    }
    
    public void setDefaultTable(){
        String hubung = "jdbc:mysql://localhost:3306/poliklinik_fariz";
        try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection kon = DriverManager.getConnection(hubung,"root","");
        Statement stt = kon.createStatement();
        String SQL = "Select * from pegawai";
        ResultSet res = stt.executeQuery(SQL);
        while(res.next()) {
            data[0] = res.getString(1);
            data[1] = res.getString(2);
            data[2] = res.getString(3);
            data[3] = res.getString(4);
            data[4] = res.getString(5);
            data[5] = res.getString(6);
            tblModel.addRow(data);
            }
                res.close();
                stt.close();
                kon.close();
            }catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }
    
    String data[] = new String[6];
            private javax.swing.table.DefaultTableModel tblModel = getDefaultTabelModel();
            private void Tabel(javax.swing.JTable tb,int lebar[]) {
            tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            int kolom = tb.getColumnCount();
            for(int i=0;i<kolom;i++) {
            javax.swing.table.TableColumn tbc = tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
            tb.setRowHeight(20);
        }
    }
            
    private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
    return new javax.swing.table.DefaultTableModel(
            new Object [][]{},
            new String []{"NIP/NIK","Nama Pegawai","Alamat","No Telp","Tanggal Lahir","Jenis Kelamin"}
            ){
            boolean[] canEdit = new boolean []{
            false,false,false,false,false,false
                };
                public boolean isCellEditable(int rowIndex,int columnIndex){
                return canEdit[columnIndex];
            }
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        nip = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        telp = new javax.swing.JTextField();
        tgl_lahir = new uz.ncipro.calendar.JDateTimePicker();
        jenkel = new javax.swing.JComboBox<>();
        pencarian = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        tambah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        laporan = new javax.swing.JButton();
        cari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NIP/NIK", "Nama Pegawai", "Alamat", "No Telp", "Tanggal Lahir", "Jenis Kelamin"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(450, 90, 590, 280);
        getContentPane().add(nip);
        nip.setBounds(250, 50, 140, 40);
        getContentPane().add(nama);
        nama.setBounds(250, 100, 140, 40);
        getContentPane().add(telp);
        telp.setBounds(250, 220, 140, 40);

        tgl_lahir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2021-11-09" }));
        tgl_lahir.setDisplayFormat("yyyy-MM-dd");
        getContentPane().add(tgl_lahir);
        tgl_lahir.setBounds(250, 270, 140, 40);

        jenkel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenis Kelamin", "Laki - Laki", "Perempuan" }));
        getContentPane().add(jenkel);
        jenkel.setBounds(250, 320, 140, 40);
        getContentPane().add(pencarian);
        pencarian.setBounds(835, 37, 140, 40);

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane2.setViewportView(alamat);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(250, 150, 150, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1054, 502);

        tambah.setText("jButton1");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        getContentPane().add(tambah);
        tambah.setBounds(30, 430, 100, 50);

        simpan.setText("jButton1");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan);
        simpan.setBounds(150, 433, 100, 50);

        hapus.setText("jButton1");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus);
        hapus.setBounds(273, 430, 100, 50);

        ubah.setText("jButton1");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        getContentPane().add(ubah);
        ubah.setBounds(390, 430, 100, 50);

        batal.setText("jButton1");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal);
        batal.setBounds(510, 430, 100, 50);

        keluar.setText("jButton1");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        getContentPane().add(keluar);
        keluar.setBounds(630, 430, 100, 50);

        laporan.setText("jButton1");
        laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanActionPerformed(evt);
            }
        });
        getContentPane().add(laporan);
        laporan.setBounds(853, 430, 100, 50);

        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        getContentPane().add(cari);
        cari.setBounds(983, 30, 50, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
    String np=nip.getText();
        String n=nama.getText();
        String a=alamat.getText();
        String t=telp.getText().toString();
        String tl=tgl_lahir.getSelectedItem().toString();
        String jk=jenkel.getSelectedItem().toString(); 
        
        if((np.isEmpty())|(n.isEmpty())|(a.isEmpty())|(t.isEmpty())|(tl.isEmpty())|(jk.isEmpty())){
        JOptionPane .showMessageDialog(null,"Masih Ada nilai yang kosong,silahkan dilengkapi!");
        nip.requestFocus();
            }
                else{
                    Object[]options = {"YA","TIDAK"};
                        int Konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda Yakin Ingin Menyimpan Data??","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        if(Konfirmasi==JOptionPane.YES_OPTION){
        }
            try {
                String hubung = "jdbc:mysql://localhost:3306/poliklinik_fariz";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection kon = DriverManager.getConnection(hubung,"root","");
                tgl_lahir.setDisplayFormat("yyyy-MM-dd");
                Statement stt = kon.createStatement();
                String SQL = "insert into pegawai values('"+nip.getText()+"','"+nama.getText()+"','"+alamat.getText()+"','"+telp.getText()+"','"+tgl_lahir.getSelectedItem()+"','"+jenkel.getSelectedItem()+"')";
                stt.executeUpdate(SQL);
                
            data[0] = nip.getText().toString();
            data[1] = nama.getText();
            data[2] = alamat.getText();
            data[3] = telp.getText();
            data[4] = tgl_lahir.getSelectedItem().toString();
            data[5] = jenkel.getSelectedItem().toString();
            tblModel.insertRow(0, data);
            nip.setText("");
            nama.setText("");
            alamat.setText("");
            telp.setText("");
            tgl_lahir.setSelectedItem("dd/MM/yyyy");
            jenkel.setSelectedItem("");
            stt.close();
            kon.close();
            
        }catch(Exception exc){
            System.err.println(exc.getMessage());
            }
            
            nip.setEnabled(false);
            nama.setEnabled(false);
            alamat.setEnabled(false);
            telp.setEnabled(false);
            tgl_lahir.setEnabled(false);
            jenkel.setEnabled(false);
            simpan.setEnabled(false);
            batal.setEnabled(false);
            ubah.setEnabled(false);
            hapus.setEnabled(false);
            tambah.setEnabled(true);
            keluar.setEnabled(true);
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        tambah();
    }//GEN-LAST:event_tambahActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        tabel_tampil();
        if(evt.getClickCount()==1){
        Tampil();
        tambah.setEnabled(false);
        simpan.setEnabled(false);
        ubah.setEnabled(true);
        hapus.setEnabled(true);
        keluar.setEnabled(true);
        nip.setEnabled(true);
        nama.setEnabled(true);
        alamat.setEnabled(true);
        telp.setEnabled(true);
        tgl_lahir.setEnabled(true);
        jenkel.setEnabled(true);
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        ubah();
    }//GEN-LAST:event_ubahActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        batal();
        jenkel.setSelectedItem(null);
    }//GEN-LAST:event_batalActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        Object[]options = {"YA","TIDAK"};
        int konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda Yakin Ingin Keluar?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if(konfirmasi==JOptionPane.YES_OPTION){
        dispose();
        }
    }//GEN-LAST:event_keluarActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_hapusActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        try{
        String hubung ="jdbc:mysql://localhost:3306/poliklinik_fariz";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection kon = DriverManager.getConnection(hubung,"root","");
        String cari = pencarian.getText();
        Statement stt = kon.createStatement();
        String sql ="Select * from pegawai where nip like '"+cari+"'";
        ResultSet rs= stt.executeQuery(sql);
        if(rs.next()){
        nip.setText(rs.getString(1));
        nama.setText(rs.getString(2));
        alamat.setText(rs.getString(3));
        telp.setText(rs.getString(4));
        tgl_lahir.setSelectedItem(rs.getString(5));
        jenkel.setSelectedItem(rs.getString(6));
        nip.setEnabled(false);
        nama.setEnabled(true);
        alamat.setEnabled(true);
        telp.setEnabled(true);
        tgl_lahir.setEnabled(true);
        jenkel.setEnabled(true);
            }
            else{
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
                stt.close();
                kon.close();
                }
            catch(Exception e){
        System.out.println("ERROR."+e);}
        pencarian.setText("");
        tambah.setEnabled(false);
        simpan.setEnabled(false);
        ubah.setEnabled(true);
        hapus.setEnabled(true);
        keluar.setEnabled(true);
    }//GEN-LAST:event_cariActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
        // TODO add your handling code here:
        new laporan_pegawai().setVisible(true);
    }//GEN-LAST:event_laporanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pegawai().setVisible(true);
            }
        });
    }
    
    int row = 0;
    public void Tampil(){
    row = tabel.getSelectedRow();
    nip.setText(tblModel.getValueAt(row,0).toString());
    nama.setText(tblModel.getValueAt(row,1).toString());
    alamat.setText(tblModel.getValueAt(row,2).toString());
    telp.setText(tblModel.getValueAt(row, 3).toString());
    tgl_lahir.setSelectedItem(tblModel.getValueAt(row, 4).toString());
    jenkel.setSelectedItem(tblModel.getValueAt(row, 5).toString());
    }
    
    public void tabel_tampil() {
    tambah.setEnabled(false);
    simpan.setEnabled(false);
    hapus.setEnabled(true);
    ubah.setEnabled(true);
    batal.setEnabled(true);
    nip.setEnabled(true);
    nama.setEnabled(true);
    alamat.setEnabled(true);
    telp.setEnabled(true);
    tgl_lahir.setEnabled(true);
    jenkel.setEnabled(true);
    }
    
    public void tambah(){
    nip.setText("");
    nip.setEnabled(true);
    nama.setText("");
    nama.setEnabled(true);
    alamat.setText("");
    alamat.setEnabled(true);
    telp.setText("");
    telp.setEnabled(true);
    tgl_lahir.setSelectedItem("");
    tgl_lahir.setEnabled(true);
    jenkel.setSelectedItem("");
    jenkel.setEnabled(true);
    hapus.setEnabled(false);
    simpan.setEnabled(true);
    ubah.setEnabled(false);
    keluar.setEnabled(true);
    batal.setEnabled(true);
    tabel.setEnabled(true);
    nip.requestFocus();
    }
    
    public void batal() {
    nip.setEnabled(false);
    nama.setEnabled(false);
    alamat.setEnabled(false);
    telp.setEnabled(false);
    tgl_lahir.setEnabled(false);
    jenkel.setEnabled(false);
    nip.setText("");
    nama.setText("");
    alamat.setText("");
    telp.setText("");
    tgl_lahir.setSelectedItem("");
    jenkel.setSelectedItem("");
    tambah.setEnabled(true);
    simpan.setEnabled(false);
    hapus.setEnabled(false);
    ubah.setEnabled(false);
    batal.setEnabled(false);
    }
    
    public void hapus(){
    Object[]options = {"YA","TIDAK"};
    int konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda Ingin HapusData?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
    if(konfirmasi==JOptionPane.YES_OPTION){
    }
    try {
    String hubung = "jdbc:mysql://localhost:3306/poliklinik_fariz";
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection kon = DriverManager.getConnection(hubung,"root","");
    Statement stt = kon.createStatement();
    String SQL = "delete from pegawai where nip='"+nip.getText()+"'";
    stt.executeUpdate(SQL);
    tblModel.removeRow(row);
    data[0] = nip.getText();
    data[1] = nama.getText();
    data[2] = alamat.getText();
    data[3] = telp.getText();
    data[4] = tgl_lahir.getSelectedItem().toString();
    data[5] = jenkel.getSelectedItem().toString();
    nip.setText("");
    nama.setText("");
    alamat.setText("");
    telp.setText("");
    tgl_lahir.setSelectedItem("");
    jenkel.setSelectedItem("");
    stt.close();
    kon.close();
        }catch(Exception exc) {
        System.err.println(exc.getMessage());
        }
    nip.setText("");
    nama.setText("");
    alamat.setText("");
    telp.setText("");
    tgl_lahir.setSelectedItem("");
    jenkel.setSelectedItem("");
    nip.setEnabled(false);
    nama.setEnabled(false);
    alamat.setEnabled(false);
    telp.setEnabled(false);
    tgl_lahir.setEnabled(false);
    jenkel.setEnabled(false);
    simpan.setEnabled(false);
    ubah.setEnabled(false);
    hapus.setEnabled(false);
    tambah.setEnabled(true);
    keluar.setEnabled(true);
    }
    
    public void ubah(){
Object[]options = {"YA","TIDAK"};
            int konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda Ingin Ubah Data?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
         if(konfirmasi==JOptionPane.YES_OPTION){
            }
                try{
                    String hubung = "jdbc:mysql://localhost:3306/poliklinik_fariz";
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection kon = DriverManager.getConnection(hubung,"root","");
                    tgl_lahir.setDisplayFormat("yyyy-MM-dd");
                    Statement stt = kon.createStatement();
                    String SQL = "update pegawai set nip = '"+nip.getText()+"',"+"nama='"+nama.getText()+"',"+"alamat='"+alamat.getText()+"',"+"telp='"+telp.getText()+"',"+"tgl_lahir='"+tgl_lahir.getSelectedItem()+"',"+"jenkel='"+jenkel.getSelectedItem()+"' where nip = '"+nip.getText()+"'";
 
                stt.executeUpdate(SQL);
                 data[0] = nip.getText();
                 data[1] = nama.getText();
                 data[2] = alamat.getText();
                 data[3] = telp.getText();
                 data[4] = tgl_lahir.getSelectedItem().toString();
                 data[5] = jenkel.getSelectedItem().toString();
                 tblModel.removeRow(row);
                 tblModel.insertRow(row, data);
                 nip.setText("");
                 nama.setText("");
                 alamat.setText("");
                 telp.setText("");
                 tgl_lahir.setSelectedItem("dd/MM/yyyy");
                jenkel.setSelectedItem("");
                simpan.setEnabled(false);
 
            stt.close();
            kon.close();
                }catch(Exception exc){
                    System.err.println(exc.getMessage());
            }
                nip.setText("");
                nama.setText("");
                alamat.setText("");
                telp.setText("");
                tgl_lahir.setDisplayFormat("dd/MM/yyyy");
                jenkel.setSelectedItem("");
                nip.setEnabled(false);
                nama.setEnabled(false);
                alamat.setEnabled(false);
                telp.setEnabled(false);
                tgl_lahir.setEnabled(false);
                jenkel.setEnabled(false);
                simpan.setEnabled(false);
                ubah.setEnabled(false);
                hapus.setEnabled(false);
                tambah.setEnabled(true);
                keluar.setEnabled(true);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JButton batal;
    private javax.swing.JButton cari;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jenkel;
    private javax.swing.JButton keluar;
    private javax.swing.JButton laporan;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nip;
    private javax.swing.JTextField pencarian;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField telp;
    private uz.ncipro.calendar.JDateTimePicker tgl_lahir;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
