/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simtravel.form;

import simtravel.utils.DBUtils;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import simtravel.utils.EncryptionUtils;
import simtravel.utils.RegexUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *
 * @author nursalim
 */
public class FrmTambahJamaah extends javax.swing.JDialog {

    /**
     * Creates new form FrmDaftar
     */
    
    private Connection con;
    private PreparedStatement ps;
    private String userId;
    private String action;
    private Date today;
    private java.sql.Date sqlDate;
    File f = null;
    String path = null;
    
    public FrmTambahJamaah(java.awt.Frame parent, boolean modal, Map data) {
        super(parent, modal);
        con = new DBUtils().getKoneksi();
        userId = (String) data.get("userId");
        action = (String) data.get("action");
        String kode = (String) data.get("userId");
        String nama = (String) data.get("userName");
        String email = (String) data.get("email");
        String level = (String) data.get("level");
        initComponents();
        setLocationRelativeTo(null);
        
        if(action.equals("edit")){
            judulLabel.setText("Update Pengguna");
            kodeField.setText(kode);
            namaField.setText(nama);
            emailField.setText(email);
            levelCB.setSelectedItem(level);
            kodeField.setBackground(Color.LIGHT_GRAY);
            kodeField.setEditable(false);
            emailField.setEditable(false);
            emailField.setBackground(Color.LIGHT_GRAY);
            TempatLahirField.setEditable(false);
            TempatLahirField.setBackground(Color.LIGHT_GRAY);
        }
        
        today = new Date();
        
    }
    
    public boolean validasiTambah(){
        if(kodeField.getText() == null || kodeField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "ID Pengguna tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(namaField.getText() == null || namaField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Kategori tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(emailField.getText() == null ||emailField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(TempatLahirField.getText() == null || TempatLahirField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Konfirm Password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(!emailField.getText().equals(TempatLahirField.getText())){
            JOptionPane.showMessageDialog(null, "Password dan Konfirmasi Password harus sama", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // validate email format
        
        if(emailField.getText() != null && !emailField.getText().equals("")){
            if(!new RegexUtils().validateEmail(emailField.getText())){
                JOptionPane.showMessageDialog(null, "Format Alamat Email salah", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        return true;
    }
    
        public boolean validasiUpdate(){
        if(kodeField.getText() == null || kodeField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "ID Pengguna tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(namaField.getText() == null || namaField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Kategori tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    
    
    public void tambahRecord(){
        String sql = "INSERT INTO tbl_user(user_id, user_name, password, email, level, created_by, created_dt) VALUES (?, ?, ?, ?, ?, ?, ?) ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, kodeField.getText());
            ps.setString(2, namaField.getText());
            ps.setString(3, namaField.getText());
            ps.setString(4, emailField.getText());
            ps.setString(5, levelCB.getSelectedItem().toString());
            ps.setString(6, userId);
            ps.setDate(7, new java.sql.Date(System.currentTimeMillis()));
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil di tambahkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
    }
    
    public void updateRecord(){
        String sql = "UPDATE tbl_user SET user_name = ?, level = ? WHERE user_id = ? ";
        con = new DBUtils().getKoneksi();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, namaField.getText());
            ps.setString(2, levelCB.getSelectedItem().toString());
            ps.setString(3, kodeField.getText());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil di update", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        judulLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        namaField = new javax.swing.JTextField();
        kodeField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        levelCB = new javax.swing.JComboBox<>();
        TempatLahirField = new javax.swing.JPasswordField();
        TanggalLahir = new com.toedter.calendar.JDateChooser();
        emailField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AlamatField = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        NoTelpField = new javax.swing.JTextField();
        LabelFoto = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        levelCB1 = new javax.swing.JComboBox<>();
        btnFoto = new java.awt.Button();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistem Informasi Travel Umrah & Haji - PT. Ismata Nusantara Abadi");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        judulLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        judulLabel.setForeground(new java.awt.Color(255, 255, 255));
        judulLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simtravel/image/user-32.png"))); // NOI18N
        judulLabel.setText("Tambah Jamaah");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(judulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("No KTP");

        jLabel2.setText("Nama Jamaah");

        jLabel5.setText("Tempat/Tanggal Lahir ");

        jLabel6.setText("Alamat Jamaah");

        jLabel3.setText("Alamat Email");

        jLabel4.setText("Jenis Kelamin");

        levelCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));

        AlamatField.setColumns(20);
        AlamatField.setLineWrap(true);
        AlamatField.setRows(1);
        jScrollPane1.setViewportView(AlamatField);

        jLabel7.setText("No Telp");

        LabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelFoto.setText("FOTO");
        LabelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Gol Darah");

        levelCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "A", "B", "AB", "O" }));

        btnFoto.setActionCommand("Browser Foto");
        btnFoto.setLabel("Browser Foto");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(NoTelpField)
                    .addComponent(emailField)
                    .addComponent(namaField)
                    .addComponent(kodeField)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(levelCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(levelCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TempatLahirField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(kodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(levelCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(levelCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)))))
                            .addComponent(LabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(TempatLahirField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(NoTelpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simtravel/image/simpan-16.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simtravel/image/cancel-16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simtravel/image/Clear-icon-16.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnClear))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(action.equals("tambah")){
            if(validasiTambah()){
                int pilih = JOptionPane.showConfirmDialog(null, "Apakah Data yang Anda masukkan sudah benar?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
                if(pilih == JOptionPane.OK_OPTION){
                    tambahRecord();
                    dispose();
                    new FrmDaftarPengguna(null, true).setVisible(true);
                }
            }
        }else{
            if(validasiUpdate()){
                int pilih = JOptionPane.showConfirmDialog(null, "Apakah Data yang Anda masukkan sudah benar?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
                if(pilih == JOptionPane.OK_OPTION){
                    updateRecord();
                    dispose();
                    new FrmDaftarPengguna(null, true).setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        if(action.equals("edit")){
            namaField.setText("");
            emailField.setText("");
            levelCB.setSelectedItem(null);
        }else{
        
        kodeField.setText("");
        namaField.setText("");
        emailField.setText("");
        levelCB.setSelectedItem(null);
       // passwordField.setText("");
        TempatLahirField.setText("");
        }
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        //Only search for images with these extensions.
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(null);
        //If open button has being clicked.
        if (load == fileChooser.APPROVE_OPTION) {
            f = fileChooser.getSelectedFile();
            //Store image path in a string.
            path = f.getAbsolutePath();
            //Show image path in the textfield.
            NoTelpField.setText(path);
            ImageIcon ii = new ImageIcon(path);
            //Resize image to fit jlabel.
            Image img = ii.getImage().getScaledInstance(LabelFoto.getWidth(), LabelFoto.getHeight(), Image.SCALE_SMOOTH);
            //display image on jpanel
            LabelFoto.setIcon(new ImageIcon(img));
        }
 
    }//GEN-LAST:event_btnFotoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmTambahJamaah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTambahJamaah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTambahJamaah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTambahJamaah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmTambahJamaah dialog = new FrmTambahJamaah(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AlamatField;
    private javax.swing.JLabel LabelFoto;
    private javax.swing.JTextField NoTelpField;
    private com.toedter.calendar.JDateChooser TanggalLahir;
    private javax.swing.JPasswordField TempatLahirField;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private java.awt.Button btnFoto;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField emailField;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JTextField kodeField;
    private javax.swing.JComboBox<String> levelCB;
    private javax.swing.JComboBox<String> levelCB1;
    private javax.swing.JTextField namaField;
    // End of variables declaration//GEN-END:variables
}
