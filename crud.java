package pbo_2310010481;

import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 * Class CRUD untuk mengelola operasi database
 * @author LENOVO LOQ
 */
public class crud {
    
    private String database = "pbo_2310010481";
    private String username = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost/" + database;
    private Connection koneksidb;
    
    public crud() {
        try {
            Driver driverkoneksi = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driverkoneksi);
            koneksidb = DriverManager.getConnection(url, username, password);
            System.out.println("Berhasil koneksi ke database");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi error koneksi:\n" + e.getMessage());
        }
    }
    
    // ==================== CRUD ANGGOTA ====================
    public void simpanAnggotaPST(String id, String nm, String sts, String tlp) {
        try {
            String sql = "INSERT INTO anggota (IDAnggota, Nama, status, telp) VALUES (?, ?, ?, ?)";
            String checkPrimary = "SELECT * FROM anggota WHERE idanggota=?";
            
            PreparedStatement checkdata = koneksidb.prepareStatement(checkPrimary);
            checkdata.setString(1, id);
            ResultSet data = checkdata.executeQuery();
            
            if (data.next()) {
                String isi = "\nNama: " + data.getString("Nama") +
                            "\nStatus: " + data.getString("status") +
                            "\nTelpon: " + data.getString("telp");
                JOptionPane.showMessageDialog(null, "IDAnggota sudah terdaftar" + isi);
                return;
            }
            
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, nm);
            perintah.setString(3, sts);
            perintah.setString(4, tlp);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    // ==================== CRUD ROLE ====================
    public void simpanRole(int id, String role) {
        try {
            String sql = "INSERT INTO role (id_role, nama_role) VALUES (?, ?)";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setInt(1, id);
            perintah.setString(2, role);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Role berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error simpan role: " + e.getMessage());
        }
    }
    
    public void ubahRole(int id, String role) {
        try {
            String sql = "UPDATE role SET nama_role=? WHERE id_role=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, role);
            perintah.setInt(2, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Role berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ubah role: " + e.getMessage());
        }
    }
    
    public void hapusRole(int id) {
        try {
            String sql = "DELETE FROM role WHERE id_role=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setInt(1, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Role berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error hapus role: " + e.getMessage());
        }
    }
    
    public DefaultTableModel tabelRole() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Role");
        tabel.addColumn("Nama Role");
        
        try {
            String sql = "SELECT * FROM role";
            Statement perintah = koneksidb.createStatement();
            ResultSet data = perintah.executeQuery(sql);
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getInt("id_role"),
                    data.getString("nama_role")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error load role: " + e.getMessage());
        }
        return tabel;
    }
    
    public DefaultTableModel cariRole(String keyword) {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Role");
        tabel.addColumn("Nama Role");
        
        try {
            String sql = "SELECT * FROM role WHERE id_role LIKE ? OR nama_role LIKE ?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, "%" + keyword + "%");
            perintah.setString(2, "%" + keyword + "%");
            ResultSet data = perintah.executeQuery();
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getInt("id_role"),
                    data.getString("nama_role")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cari role: " + e.getMessage());
        }
        return tabel;
    }
    
    // ==================== CRUD USER ====================
    public void simpanUser(String id, String name, String username, String email, String password, int idRole) {
        try {
            String sql = "INSERT INTO user (id_user, name, username, email, password, id_role) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, name);
            perintah.setString(3, username);
            perintah.setString(4, email);
            perintah.setString(5, password);
            perintah.setInt(6, idRole);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data User berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error simpan user: " + e.getMessage());
        }
    }
    
    public void ubahUser(String id, String name, String username, String email, String password, int idRole) {
        try {
            String sql = "UPDATE user SET name=?, username=?, email=?, password=?, id_role=? WHERE id_user=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, name);
            perintah.setString(2, username);
            perintah.setString(3, email);
            perintah.setString(4, password);
            perintah.setInt(5, idRole);
            perintah.setString(6, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data User berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ubah user: " + e.getMessage());
        }
    }
    
    public void hapusUser(String id) {
        try {
            String sql = "DELETE FROM user WHERE id_user=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data User berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error hapus user: " + e.getMessage());
        }
    }
    
    public DefaultTableModel tabelUser() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID User");
        tabel.addColumn("Name");
        tabel.addColumn("Username");
        tabel.addColumn("Email");
        tabel.addColumn("Password");
        tabel.addColumn("ID Role");
        
        try {
            String sql = "SELECT * FROM user";
            Statement perintah = koneksidb.createStatement();
            ResultSet data = perintah.executeQuery(sql);
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getString("id_user"),
                    data.getString("name"),
                    data.getString("username"),
                    data.getString("email"),
                    data.getString("password"),
                    data.getInt("id_role")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error load user: " + e.getMessage());
        }
        return tabel;
    }
    
    public DefaultTableModel cariUser(String keyword) {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID User");
        tabel.addColumn("Name");
        tabel.addColumn("Username");
        tabel.addColumn("Email");
        tabel.addColumn("Password");
        tabel.addColumn("ID Role");
        
        try {
            String sql = "SELECT * FROM user WHERE id_user LIKE ? OR name LIKE ? OR username LIKE ? OR email LIKE ?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            String cari = "%" + keyword + "%";
            perintah.setString(1, cari);
            perintah.setString(2, cari);
            perintah.setString(3, cari);
            perintah.setString(4, cari);
            ResultSet data = perintah.executeQuery();
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getString("id_user"),
                    data.getString("name"),
                    data.getString("username"),
                    data.getString("email"),
                    data.getString("password"),
                    data.getInt("id_role")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cari user: " + e.getMessage());
        }
        return tabel;
    }
    
    // ==================== CRUD TUGAS ====================
    public void simpanTugas(String id, String deskripsi, String status, String idUser) {
        try {
            String sql = "INSERT INTO tugas (id_tugas, deskripsi, status, id_user) VALUES (?, ?, ?, ?)";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, deskripsi);
            perintah.setString(3, status);
            perintah.setString(4, idUser);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Tugas berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error simpan tugas: " + e.getMessage());
        }
    }
    
    public void ubahTugas(String id, String deskripsi, String status, String idUser) {
        try {
            String sql = "UPDATE tugas SET deskripsi=?, status=?, id_user=? WHERE id_tugas=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, deskripsi);
            perintah.setString(2, status);
            perintah.setString(3, idUser);
            perintah.setString(4, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Tugas berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ubah tugas: " + e.getMessage());
        }
    }
    
    public void hapusTugas(String id) {
        try {
            String sql = "DELETE FROM tugas WHERE id_tugas=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Tugas berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error hapus tugas: " + e.getMessage());
        }
    }
    
    public DefaultTableModel tabelTugas() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Tugas");
        tabel.addColumn("Deskripsi");
        tabel.addColumn("Status");
        tabel.addColumn("ID User");
        
        try {
            String sql = "SELECT * FROM tugas";
            Statement perintah = koneksidb.createStatement();
            ResultSet data = perintah.executeQuery(sql);
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getString("id_tugas"),
                    data.getString("deskripsi"),
                    data.getString("status"),
                    data.getString("id_user")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error load tugas: " + e.getMessage());
        }
        return tabel;
    }
    
    public DefaultTableModel cariTugas(String keyword) {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Tugas");
        tabel.addColumn("Deskripsi");
        tabel.addColumn("Status");
        tabel.addColumn("ID User");
        
        try {
            String sql = "SELECT * FROM tugas WHERE id_tugas LIKE ? OR deskripsi LIKE ? OR status LIKE ?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            String cari = "%" + keyword + "%";
            perintah.setString(1, cari);
            perintah.setString(2, cari);
            perintah.setString(3, cari);
            ResultSet data = perintah.executeQuery();
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getString("id_tugas"),
                    data.getString("deskripsi"),
                    data.getString("status"),
                    data.getString("id_user")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cari tugas: " + e.getMessage());
        }
        return tabel;
    }
    
    // ==================== CRUD PEMUPUKAN ====================
    public void simpanPemupukan(String id, String tanggal, String jenisPupuk, String idUser, String keterangan) {
        try {
            String sql = "INSERT INTO pemupukan (id_pemupukan, tanggal, jenis_pupuk, id_user, keterangan) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, tanggal);
            perintah.setString(3, jenisPupuk);
            perintah.setString(4, idUser);
            perintah.setString(5, keterangan);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Pemupukan berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error simpan pemupukan: " + e.getMessage());
        }
    }
    
    public void ubahPemupukan(String id, String tanggal, String jenisPupuk, String idUser, String keterangan) {
        try {
            String sql = "UPDATE pemupukan SET tanggal=?, jenis_pupuk=?, id_user=?, keterangan=? WHERE id_pemupukan=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, tanggal);
            perintah.setString(2, jenisPupuk);
            perintah.setString(3, idUser);
            perintah.setString(4, keterangan);
            perintah.setString(5, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Pemupukan berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ubah pemupukan: " + e.getMessage());
        }
    }
    
    public void hapusPemupukan(String id) {
        try {
            String sql = "DELETE FROM pemupukan WHERE id_pemupukan=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Pemupukan berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error hapus pemupukan: " + e.getMessage());
        }
    }
    
    public DefaultTableModel tabelPemupukan() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Pemupukan");
        tabel.addColumn("Tanggal");
        tabel.addColumn("Jenis Pupuk");
        tabel.addColumn("ID User");
        tabel.addColumn("Keterangan");
        
        try {
            String sql = "SELECT * FROM pemupukan";
            Statement perintah = koneksidb.createStatement();
            ResultSet data = perintah.executeQuery(sql);
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getString("id_pemupukan"),
                    data.getString("tanggal"),
                    data.getString("jenis_pupuk"),
                    data.getString("id_user"),
                    data.getString("keterangan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error load pemupukan: " + e.getMessage());
        }
        return tabel;
    }
    
    public DefaultTableModel cariPemupukan(String keyword) {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Pemupukan");
        tabel.addColumn("Tanggal");
        tabel.addColumn("Jenis Pupuk");
        tabel.addColumn("ID User");
        tabel.addColumn("Keterangan");
        
        try {
            String sql = "SELECT * FROM pemupukan WHERE id_pemupukan LIKE ? OR jenis_pupuk LIKE ? OR keterangan LIKE ?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            String cari = "%" + keyword + "%";
            perintah.setString(1, cari);
            perintah.setString(2, cari);
            perintah.setString(3, cari);
            ResultSet data = perintah.executeQuery();
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getString("id_pemupukan"),
                    data.getString("tanggal"),
                    data.getString("jenis_pupuk"),
                    data.getString("id_user"),
                    data.getString("keterangan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cari pemupukan: " + e.getMessage());
        }
        return tabel;
    }
    
    // ==================== CRUD HASIL PANEN ====================
    public void simpanHasilPanen(String id, String tanggal, double jumlah, String catatan, String idUser) {
        try {
            String sql = "INSERT INTO hasil_panen (id_panen, tanggal, jumlah, catatan, id_user) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, tanggal);
            perintah.setDouble(3, jumlah);
            perintah.setString(4, catatan);
            perintah.setString(5, idUser);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Hasil Panen berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error simpan hasil panen: " + e.getMessage());
        }
    }
    
    public void ubahHasilPanen(String id, String tanggal, double jumlah, String catatan, String idUser) {
        try {
            String sql = "UPDATE hasil_panen SET tanggal=?, jumlah=?, catatan=?, id_user=? WHERE id_panen=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, tanggal);
            perintah.setDouble(2, jumlah);
            perintah.setString(3, catatan);
            perintah.setString(4, idUser);
            perintah.setString(5, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Hasil Panen berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ubah hasil panen: " + e.getMessage());
        }
    }
    
    public void hapusHasilPanen(String id) {
        try {
            String sql = "DELETE FROM hasil_panen WHERE id_panen=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Hasil Panen berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error hapus hasil panen: " + e.getMessage());
        }
    }
    
    public DefaultTableModel tabelHasilPanen() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Panen");
        tabel.addColumn("Tanggal");
        tabel.addColumn("Jumlah");
        tabel.addColumn("Catatan");
        tabel.addColumn("ID User");
        
        try {
            String sql = "SELECT * FROM hasil_panen";
            Statement perintah = koneksidb.createStatement();
            ResultSet data = perintah.executeQuery(sql);
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getString("id_panen"),
                    data.getString("tanggal"),
                    data.getDouble("jumlah"),
                    data.getString("catatan"),
                    data.getString("id_user")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error load hasil panen: " + e.getMessage());
        }
        return tabel;
    }
    
    public DefaultTableModel cariHasilPanen(String keyword) {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Panen");
        tabel.addColumn("Tanggal");
        tabel.addColumn("Jumlah");
        tabel.addColumn("Catatan");
        tabel.addColumn("ID User");
        
        try {
            String sql = "SELECT * FROM hasil_panen WHERE id_panen LIKE ? OR catatan LIKE ?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            String cari = "%" + keyword + "%";
            perintah.setString(1, cari);
            perintah.setString(2, cari);
            ResultSet data = perintah.executeQuery();
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getString("id_panen"),
                    data.getString("tanggal"),
                    data.getDouble("jumlah"),
                    data.getString("catatan"),
                    data.getString("id_user")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cari hasil panen: " + e.getMessage());
        }
        return tabel;
    }
    
    // ==================== CRUD PEMELIHARAAN ====================
    public void simpanPemeliharaan(String id, String tanggal, String idUser, String jenisTindakan, String deskripsi) {
        try {
            String sql = "INSERT INTO pemeliharaan (id_pemeliharaan, tanggal, id_user, jenis_tindakan, deskripsi) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, tanggal);
            perintah.setString(3, idUser);
            perintah.setString(4, jenisTindakan);
            perintah.setString(5, deskripsi);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Pemeliharaan berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error simpan pemeliharaan: " + e.getMessage());
        }
    }
    
    public void ubahPemeliharaan(String id, String tanggal, String idUser, String jenisTindakan, String deskripsi) {
        try {
            String sql = "UPDATE pemeliharaan SET tanggal=?, id_user=?, jenis_tindakan=?, deskripsi=? WHERE id_pemeliharaan=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, tanggal);
            perintah.setString(2, idUser);
            perintah.setString(3, jenisTindakan);
            perintah.setString(4, deskripsi);
            perintah.setString(5, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Pemeliharaan berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ubah pemeliharaan: " + e.getMessage());
        }
    }
    
    public void hapusPemeliharaan(String id) {
        try {
            String sql = "DELETE FROM pemeliharaan WHERE id_pemeliharaan=?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Pemeliharaan berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error hapus pemeliharaan: " + e.getMessage());
        }
    }
    
    public DefaultTableModel tabelPemeliharaan() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Pemeliharaan");
        tabel.addColumn("Tanggal");
        tabel.addColumn("ID User");
        tabel.addColumn("Jenis Tindakan");
        tabel.addColumn("Deskripsi");
        
        try {
            String sql = "SELECT * FROM pemeliharaan";
            Statement perintah = koneksidb.createStatement();
            ResultSet data = perintah.executeQuery(sql);
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getString("id_pemeliharaan"),
                    data.getString("tanggal"),
                    data.getString("id_user"),
                    data.getString("jenis_tindakan"),
                    data.getString("deskripsi")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error load pemeliharaan: " + e.getMessage());
        }
        return tabel;
    }
    
    public DefaultTableModel cariPemeliharaan(String keyword) {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Pemeliharaan");
        tabel.addColumn("Tanggal");
        tabel.addColumn("ID User");
        tabel.addColumn("Jenis Tindakan");
        tabel.addColumn("Deskripsi");
        
        try {
            String sql = "SELECT * FROM pemeliharaan WHERE id_pemeliharaan LIKE ? OR jenis_tindakan LIKE ? OR deskripsi LIKE ?";
            PreparedStatement perintah = koneksidb.prepareStatement(sql);
            String cari = "%" + keyword + "%";
            perintah.setString(1, cari);
            perintah.setString(2, cari);
            perintah.setString(3, cari);
            ResultSet data = perintah.executeQuery();
            
            while (data.next()) {
                tabel.addRow(new Object[]{
                    data.getString("id_pemeliharaan"),
                    data.getString("tanggal"),
                    data.getString("id_user"),
                    data.getString("jenis_tindakan"),
                    data.getString("deskripsi")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cari pemeliharaan: " + e.getMessage());
        }
        return tabel;
    }
}