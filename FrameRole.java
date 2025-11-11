package form;

import pbo_2310010481.crud;
import javax.swing.JOptionPane;

/**
 * Frame untuk mengelola data Role
 * @author LENOVO LOQ
 */
public class FrameRole extends javax.swing.JFrame {
    
    crud objekku;

    /**
     * Creates new form FrameRole
     */
    public FrameRole() {
        initComponents();
        this.setLocationRelativeTo(null);
        objekku = new crud();
        tampilkanDataRole();
    }
    
    // Method untuk menampilkan data di JTable
    private void tampilkanDataRole() {
        jTable1.setModel(objekku.tabelRole());
    }
    
    // Method untuk mencari data di JTable
    private void cariDataRole() {
        jTable1.setModel(objekku.cariRole(TextPencarian.getText()));
    }
    
    // Method untuk mengosongkan field
    private void clearFields() {
        TextIdInt.setText("");
        TextRole.setText("");
        TextIdInt.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextIdInt = new javax.swing.JTextField();
        TextRole = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnHapus = new javax.swing.JButton();
        BtnUbah = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();
        TextPencarian = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Role");

        jLabel1.setText("Id Role");

        jLabel2.setText("Nama Role");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Role", "Nama Role"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BtnHapus.setText("Hapus");
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        BtnUbah.setText("Ubah");
        BtnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUbahActionPerformed(evt);
            }
        });

        BtnSimpan.setText("Simpan");
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        TextPencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextPencarianKeyReleased(evt);
            }
        });

        jLabel3.setText("Pencarian:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextIdInt)
                            .addComponent(TextRole, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(BtnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnHapus))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextPencarian))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextIdInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSimpan)
                    .addComponent(BtnUbah)
                    .addComponent(BtnHapus))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    // Event saat tombol SIMPAN diklik
    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Validasi input kosong
            if (TextIdInt.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Role tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                TextIdInt.requestFocus();
                return;
            }
            
            if (TextRole.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Role tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                TextRole.requestFocus();
                return;
            }
            
            // Ambil data dari field
            int id = Integer.parseInt(TextIdInt.getText().trim());
            String role = TextRole.getText().trim();
            
            // Simpan ke database
            objekku.simpanRole(id, role);
            
            // Refresh tabel dan clear fields
            tampilkanDataRole();
            clearFields();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Role harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            TextIdInt.requestFocus();
        }
    }

    // Event saat tombol UBAH diklik
    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Validasi input kosong
            if (TextIdInt.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (TextRole.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Role tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                TextRole.requestFocus();
                return;
            }
            
            // Konfirmasi
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Apakah Anda yakin ingin mengubah data ini?", 
                "Konfirmasi Ubah", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (confirm == JOptionPane.YES_OPTION) {
                // Ambil data dari field
                int id = Integer.parseInt(TextIdInt.getText().trim());
                String role = TextRole.getText().trim();
                
                // Update ke database
                objekku.ubahRole(id, role);
                
                // Refresh tabel dan clear fields
                tampilkanDataRole();
                clearFields();
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Role harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            TextIdInt.requestFocus();
        }
    }

    // Event saat tombol HAPUS diklik
    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Validasi input kosong
            if (TextIdInt.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Konfirmasi
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Apakah Anda yakin ingin menghapus data ini?\nData yang dihapus tidak dapat dikembalikan!", 
                "Konfirmasi Hapus", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (confirm == JOptionPane.YES_OPTION) {
                // Ambil ID
                int id = Integer.parseInt(TextIdInt.getText().trim());
                
                // Hapus dari database
                objekku.hapusRole(id);
                
                // Refresh tabel dan clear fields
                tampilkanDataRole();
                clearFields();
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Role harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Event saat baris JTable diklik
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int baris = jTable1.getSelectedRow();
        if (baris != -1) {
            TextIdInt.setText(jTable1.getValueAt(baris, 0).toString());
            TextRole.setText(jTable1.getValueAt(baris, 1).toString());
        }
    }

    // Event saat mengetik di kolom pencarian
    private void TextPencarianKeyReleased(java.awt.event.KeyEvent evt) {
        cariDataRole();
    }

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
            java.util.logging.Logger.getLogger(FrameRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameRole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JTextField TextIdInt;
    private javax.swing.JTextField TextPencarian;
    private javax.swing.JTextField TextRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}