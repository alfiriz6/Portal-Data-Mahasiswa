package pdm;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {

    public static Database instance;
    private final String DB_TYPE = "mysql";
    private final String DB_HOST = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "pbomysql";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    private Database() {
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void insertMahasiswa(Mahasiswa mahasiswa) throws SQLException {
        Connection c = getConnection();
        try {
            String sql = "INSERT INTO mhs (nim, nama, jk, prodi, kelas) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, mahasiswa.getNim());
            p.setString(2, mahasiswa.getNama());
            p.setString(3, mahasiswa.getJk());
            p.setString(4, mahasiswa.getProdi());
            p.setString(5, mahasiswa.getKelas());
            p.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    public List<Mahasiswa> getListMahasiswa() throws SQLException {
        List<Mahasiswa> mhsList = new ArrayList<>();
        Connection c = getConnection();
        try {
            String sql = "SELECT * FROM mhs order BY nim";
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNim(r.getString("nim"));
                mhs.setNama(r.getString("nama"));
                mhs.setJk(r.getString("jk"));
                mhs.setProdi(r.getString("prodi"));
                mhs.setKelas(r.getString("kelas"));
                mhsList.add(mhs);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return mhsList;
    }

    public void deleteMahasiswa(String nim) throws SQLException {
        Connection c = getConnection();
        try {
            String sql = "DELETE FROM mhs WHERE nim = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nim);
            p.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    public void editMahasiswa(Mahasiswa mhs, String nim) throws SQLException {
        Connection c = getConnection();
        try {
            String sql = "UPDATE mhs SET nama=?, jk=?, prodi=?, kelas=? WHERE nim = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, mhs.getNama());
            p.setString(2, mhs.getJk());
            p.setString(3, mhs.getProdi());
            p.setString(4, mhs.getKelas());
            p.setString(5, mhs.getNim());
            p.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    public void insertAkun(Akun akun) throws SQLException {
        Connection c = getConnection();
        try {
            String sql = "INSERT INTO akun (username, katasandi, role) VALUES (?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, akun.getUsername());
            p.setString(2, akun.getPassword());
            p.setString(3, akun.getRole());
            p.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    public List<Akun> getListAkun() throws SQLException {
        List<Akun> akunList = new ArrayList<>();
        Connection c = getConnection();
        try {
            String sql = "SELECT * FROM akun order BY username";
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Akun akun = new Akun();
                akun.setUsername(r.getString("username"));
                akun.setPassword(r.getString("katasandi"));
                akun.setRole(r.getString("role"));
                akunList.add(akun);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return akunList;
    }

    public void deleteAkun(String username) throws SQLException {
        Connection c = getConnection();
        try {
            String sql = "DELETE FROM akun WHERE username = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, username);
            p.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    public void editAkun(Akun akun, String username) throws SQLException {
        Connection c = getConnection();
        try {
            String sql = "UPDATE akun SET katasandi = ?, role = ? WHERE username = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, akun.getPassword());
            p.setString(2, akun.getRole());
            p.setString(3, akun.getUsername());
            p.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:" + DB_TYPE + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USER, DB_PASS);
    }

}
