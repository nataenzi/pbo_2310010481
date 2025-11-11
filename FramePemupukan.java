package form;

import pbo_2310010481.crud;

public class FramePemupukan extends javax.swing.JFrame {
    
    crud objekku;

    public FramePemupukan() {
        initComponents();
        this.setLocationRelativeTo(null);
        objekku = new crud();
        tampilkanDataPemupukan();
    }
    
    private void tampilkanDataPemupukan() {
        jTable1.setModel(objekku.tabelPemupukan());
    }
    
    private void cariDataPemupukan() {
        jTable1.setModel(objekku.cariPemupukan(TextPencarian.getText()));
    }
    
    private void clearFields() {
        TextId.setText("");
        TextTanggal.setText("");
        TextJenisPupuk.setText("");
        TextIdUser.setText("");
        TextKeterangan.setText("");
        TextId.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextId = new javax.swing.JTextField();
        TextTanggal = new javax.swing.JTextField();
        TextJenisPupuk = new javax.swing.JTextField();
        TextIdUser = new javax.swing.JTextField();
        TextKeterangan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TextPencarian = new javax.swing.JTextField();
        BtnHapus = new javax.swing.JButton();
        BtnUbah = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Id");
        jLabel2.setText("Tanggal");
        jLabel3.setText("Jenis Pupuk");
        jLabel4.setText("Id User");
        jLabel5.setText("Keterangan");

        TextJenisPupuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextJenisPupukActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Tanggal", "Jenis Pupuk", "ID User", "Keterangan"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        TextPencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextPencarianKeyReleased(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextJenisPupuk, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TextId)
                                            .addComponent(TextTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextIdUser)
                                    .addComponent(TextKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
                            .addComponent(TextPencarian)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(BtnHapus)
                        .addGap(40, 40, 40)
                        .addComponent(BtnUbah)
                        .addGap(41, 41, 41)
                        .addComponent(BtnSimpan)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(TextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(TextTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextJenisPupuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnHapus)
                    .addComponent(BtnUbah)
                    .addComponent(BtnSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void TextJenisPupukActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        String id = TextId.getText();
        String tanggal = TextTanggal.getText();
        String jenisPupuk = TextJenisPupuk.getText();
        String idUser = TextIdUser.getText();
        String keterangan = TextKeterangan.getText();
        
        objekku.simpanPemupukan(id, tanggal, jenisPupuk, idUser, keterangan);
        tampilkanDataPemupukan();
        clearFields();
    }

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {
        String id = TextId.getText();
        String tanggal = TextTanggal.getText();
        String jenisPupuk = TextJenisPupuk.getText();
        String idUser = TextIdUser.getText();
        String keterangan = TextKeterangan.getText();
        
        objekku.ubahPemupukan(id, tanggal, jenisPupuk, idUser, keterangan);
        tampilkanDataPemupukan();
        clearFields();
    }

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        String id = TextId.getText();
        objekku.hapusPemupukan(id);
        tampilkanDataPemupukan();
        clearFields();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int baris = jTable1.getSelectedRow();
        TextId.setText(jTable1.getValueAt(baris, 0).toString());
        TextTanggal.setText(jTable1.getValueAt(baris, 1).toString());
        TextJenisPupuk.setText(jTable1.getValueAt(baris, 2).toString());
        TextIdUser.setText(jTable1.getValueAt(baris, 3).toString());
        TextKeterangan.setText(jTable1.getValueAt(baris, 4).toString());
    }

    private void TextPencarianKeyReleased(java.awt.event.KeyEvent evt) {
        cariDataPemupukan();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePemupukan().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JTextField TextId;
    private javax.swing.JTextField TextIdUser;
    private javax.swing.JTextField TextJenisPupuk;
    private javax.swing.JTextField TextKeterangan;
    private javax.swing.JTextField TextPencarian;
    private javax.swing.JTextField TextTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}