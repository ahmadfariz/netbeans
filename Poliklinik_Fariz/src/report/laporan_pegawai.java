 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Administrator
 */
public class laporan_pegawai extends javax.swing.JFrame {
    private JPanel contentPane;
    private JButton btnKeluar;

    /**
     * Creates new form laporan_pegawai
     */
    public laporan_pegawai() {
        initComponents();
        
            setTitle("Report Data User");
            setResizable(false);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setBounds(0, 0, 927, 757);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
                
            btnKeluar = new JButton("Keluar");
            btnKeluar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent act){
                    dispose();
                }
            });
            btnKeluar.setBounds(445, 8, 70, 25);
            contentPane.add(btnKeluar);
                
        try{
            String filename="src/report/laporan_pegawai.jasper";
            
            @SuppressWarnings("rawtypes")
            HashMap param = new HashMap();
            Class.forName("com.mysql.jdbc.Driver");
            String koneksi="jdbc:mysql://localhost:3306/poliklinik_fariz";
            Connection konek=DriverManager.getConnection(koneksi, "root", "");
            
            @SuppressWarnings("unused")
            Statement state = konek.createStatement();
            JasperPrint JPrint = JasperFillManager.fillReport(filename, param, konek);
            JRViewer viewer=new JRViewer(JPrint);
            getContentPane().add(viewer);
            viewer.setBounds(10,7,900,715);
            setVisible(true);
        }
                catch(Exception ex){
            System.out.println(ex);
	} 
    }
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     
        // TODO add your handling code here:
        this.setLocationRelativeTo(null);
    }  


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(laporan_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan_pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}