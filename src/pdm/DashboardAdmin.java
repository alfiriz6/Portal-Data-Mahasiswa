package pdm;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DashboardAdmin extends javax.swing.JFrame {

    private DefaultTableModel modelMahasiswa;
    private DefaultTableModel modelAkun;

    boolean isPasswordViewable = true;

    public void loadTableData() {
        while (modelMahasiswa.getRowCount() > 0) {
            modelMahasiswa.removeRow(0);
        }
        try {
            //isi tabel
            for (Mahasiswa mhs : Database.getInstance().getListMahasiswa()) {
                modelMahasiswa.addRow(new Object[]{mhs.getNim(), mhs.getNama(), mhs.getJk(), mhs.getProdi(), mhs.getKelas()});

            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(this, "Gagal memuat data", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadTableAkun() {
        while (modelAkun.getRowCount() > 0) {
            modelAkun.removeRow(0);
        }
        try {
            //isi tabel
            for (Akun akun : Database.getInstance().getListAkun()) {
                modelAkun.addRow(new Object[]{akun.getUsername(), akun.getPassword(), akun.getRole()});

            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(this, "Gagal memuat data", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearFormInput() {
        txNim.setText("");
        txNama.setText("");
        cbJk.setSelectedIndex(-1);
        txKelas.setText("");
    }

    public void clearFormAkun() {
        txUsername.setText("");
        txPassword.setText("");
        cbRole.setSelectedIndex(-1);
    }

    public void filterTableData() {
        String cariMahasiswa = txCariData.getText();
        DefaultTableModel tabelModelMahasiswa = new DefaultTableModel();

        tabelModelMahasiswa.addColumn("NIM");
        tabelModelMahasiswa.addColumn("Nama Mahasiswa");
        tabelModelMahasiswa.addColumn("Jenis Kelamin");
        tabelModelMahasiswa.addColumn("Program Studi");
        tabelModelMahasiswa.addColumn("Kelas");

        try {
            String sql = "SELECT * FROM mhs WHERE concat(nim, nama, jk, prodi, kelas) LIKE '%" + cariMahasiswa + "%'";
            PreparedStatement p = Config.getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                tabelModelMahasiswa.addRow(new Object[]{
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getString(4),
                    r.getString(5),});
            }
            tableMahasiswa.setModel(tabelModelMahasiswa);
            loadTableData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Cari data mahasiswa error.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filterTableAkun() {
        String cariAkun = txCariAkun.getText();
        DefaultTableModel tabelModelAkun = new DefaultTableModel();

        tabelModelAkun.addColumn("Username");
        tabelModelAkun.addColumn("Password");
        tabelModelAkun.addColumn("Role");

        try {
            String sql = "SELECT * FROM akun WHERE concat(username, katasandi, role) LIKE '%" + cariAkun + "%'";
            PreparedStatement p = Config.getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                tabelModelAkun.addRow(new Object[]{
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),});
            }
            tableAkun.setModel(tabelModelAkun);
            loadTableAkun();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Cari data akun error.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates new form DashboardAdmin
     */
    public DashboardAdmin() {
        initComponents();

        modelMahasiswa = new DefaultTableModel();
        tableMahasiswa.setModel(modelMahasiswa);
        modelMahasiswa.addColumn("NIM");
        modelMahasiswa.addColumn("Nama Mahasiswa");
        modelMahasiswa.addColumn("Jenis Kelamin");
        modelMahasiswa.addColumn("Program Studi");
        modelMahasiswa.addColumn("Kelas");

        modelAkun = new DefaultTableModel();
        tableAkun.setModel(modelAkun);
        modelAkun.addColumn("Username");
        modelAkun.addColumn("Password");
        modelAkun.addColumn("Role");

        loadTableData();
        loadTableAkun();

        clearFormInput();
        clearFormAkun();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBarAdmin = new javax.swing.JPanel();
        titleDashboard = new javax.swing.JLabel();
        buttonExit = new javax.swing.JLabel();
        buttonMinimize = new javax.swing.JLabel();
        buttonLogout = new javax.swing.JLabel();
        menuInput = new javax.swing.JPanel();
        titleInput = new javax.swing.JPanel();
        titleInputDataMahasiswa = new javax.swing.JLabel();
        panelInput = new javax.swing.JPanel();
        labelNim = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        labelJk = new javax.swing.JLabel();
        labelKelas = new javax.swing.JLabel();
        txNim = new javax.swing.JTextField();
        txNama = new javax.swing.JTextField();
        cbJk = new javax.swing.JComboBox<>();
        txKelas = new javax.swing.JTextField();
        buttonSimpan = new javax.swing.JLabel();
        buttonEdit = new javax.swing.JLabel();
        buttonHapus = new javax.swing.JLabel();
        buttonReset = new javax.swing.JLabel();
        menuAkunBaru = new javax.swing.JPanel();
        titleAkunBaru = new javax.swing.JPanel();
        titleBuatAkunBaru = new javax.swing.JLabel();
        panelAkunBaru = new javax.swing.JPanel();
        iconUsername = new javax.swing.JLabel();
        txUsername = new javax.swing.JTextField();
        iconPassword = new javax.swing.JLabel();
        txPassword = new javax.swing.JPasswordField();
        viewPassword = new javax.swing.JLabel();
        iconRole = new javax.swing.JLabel();
        cbRole = new javax.swing.JComboBox<>();
        buttonSignup = new javax.swing.JLabel();
        buttonEditUser = new javax.swing.JLabel();
        buttonHapusAkun = new javax.swing.JLabel();
        buttonClear = new javax.swing.JLabel();
        menuData = new javax.swing.JPanel();
        titleData = new javax.swing.JPanel();
        titleDataMahasiswa = new javax.swing.JLabel();
        panelData = new javax.swing.JPanel();
        txCariData = new javax.swing.JTextField();
        buttonPrint = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMahasiswa = new javax.swing.JTable();
        menuAkun = new javax.swing.JPanel();
        titleAkun = new javax.swing.JPanel();
        titleDataAkun = new javax.swing.JLabel();
        panelAkun = new javax.swing.JPanel();
        txCariAkun = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAkun = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard Administrator");
        setUndecorated(true);

        menuBarAdmin.setBackground(new java.awt.Color(0, 0, 0));
        menuBarAdmin.setPreferredSize(new java.awt.Dimension(360, 40));
        menuBarAdmin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuBarAdminMouseDragged(evt);
            }
        });

        titleDashboard.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleDashboard.setForeground(new java.awt.Color(255, 255, 255));
        titleDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleDashboard.setText("Dashboard Administrator");

        buttonExit.setFont(new java.awt.Font("Waree", 1, 26)); // NOI18N
        buttonExit.setForeground(new java.awt.Color(255, 255, 255));
        buttonExit.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\close.png")); // NOI18N
        buttonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonExitMouseClicked(evt);
            }
        });

        buttonMinimize.setFont(new java.awt.Font("Waree", 1, 26)); // NOI18N
        buttonMinimize.setForeground(new java.awt.Color(255, 255, 255));
        buttonMinimize.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\minimize.png")); // NOI18N
        buttonMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMinimizeMouseClicked(evt);
            }
        });

        buttonLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonLogout.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\logout.png")); // NOI18N
        buttonLogout.setToolTipText("Logout");
        buttonLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuBarAdminLayout = new javax.swing.GroupLayout(menuBarAdmin);
        menuBarAdmin.setLayout(menuBarAdminLayout);
        menuBarAdminLayout.setHorizontalGroup(
            menuBarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarAdminLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(buttonLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit))
        );

        menuBarAdminLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonExit, buttonLogout, buttonMinimize});

        menuBarAdminLayout.setVerticalGroup(
            menuBarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(buttonMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(titleDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        titleInput.setBackground(java.awt.Color.green);

        titleInputDataMahasiswa.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleInputDataMahasiswa.setForeground(java.awt.Color.darkGray);
        titleInputDataMahasiswa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleInputDataMahasiswa.setText("Input Data Mahasiswa");

        javax.swing.GroupLayout titleInputLayout = new javax.swing.GroupLayout(titleInput);
        titleInput.setLayout(titleInputLayout);
        titleInputLayout.setHorizontalGroup(
            titleInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleInputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleInputDataMahasiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titleInputLayout.setVerticalGroup(
            titleInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleInputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleInputDataMahasiswa)
                .addContainerGap())
        );

        panelInput.setBackground(new java.awt.Color(255, 255, 255));

        labelNim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNim.setText("NIM");

        labelNama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNama.setText("Nama Lengkap");

        labelJk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelJk.setText("Jenis Kelamin");

        labelKelas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelKelas.setText("Kelas");

        txNim.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        txNama.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        cbJk.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cbJk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        txKelas.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        buttonSimpan.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\save.png")); // NOI18N
        buttonSimpan.setToolTipText("Simpan Data");
        buttonSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSimpanMouseClicked(evt);
            }
        });

        buttonEdit.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\edit.png")); // NOI18N
        buttonEdit.setToolTipText("Edit Data");
        buttonEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEditMouseClicked(evt);
            }
        });

        buttonHapus.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\delete.png")); // NOI18N
        buttonHapus.setToolTipText("Hapus Data");
        buttonHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonHapusMouseClicked(evt);
            }
        });

        buttonReset.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\empty.png")); // NOI18N
        buttonReset.setToolTipText("Kosongkan Isian");
        buttonReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelInputLayout = new javax.swing.GroupLayout(panelInput);
        panelInput.setLayout(panelInputLayout);
        panelInputLayout.setHorizontalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInputLayout.createSequentialGroup()
                        .addComponent(buttonSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEdit)
                        .addGap(18, 18, 18)
                        .addComponent(buttonHapus)
                        .addGap(18, 18, 18)
                        .addComponent(buttonReset))
                    .addGroup(panelInputLayout.createSequentialGroup()
                        .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addComponent(labelKelas)
                                .addGap(18, 18, 18)
                                .addComponent(txKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addComponent(labelJk)
                                .addGap(18, 18, 18)
                                .addComponent(cbJk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addComponent(labelNama)
                                .addGap(18, 18, 18)
                                .addComponent(txNama, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addComponent(labelNim)
                                .addGap(18, 18, 18)
                                .addComponent(txNim, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );

        panelInputLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelJk, labelKelas, labelNama, labelNim});

        panelInputLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonEdit, buttonHapus, buttonReset, buttonSimpan});

        panelInputLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbJk, txKelas, txNim});

        panelInputLayout.setVerticalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNim)
                    .addComponent(txNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNama)
                    .addComponent(txNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJk)
                    .addComponent(cbJk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKelas)
                    .addComponent(txKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonEdit)
                    .addComponent(buttonHapus)
                    .addComponent(buttonReset))
                .addGap(20, 20, 20))
        );

        panelInputLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbJk, labelJk, labelKelas, labelNama, labelNim, txKelas, txNama, txNim});

        panelInputLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonEdit, buttonHapus, buttonReset, buttonSimpan});

        javax.swing.GroupLayout menuInputLayout = new javax.swing.GroupLayout(menuInput);
        menuInput.setLayout(menuInputLayout);
        menuInputLayout.setHorizontalGroup(
            menuInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuInputLayout.setVerticalGroup(
            menuInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuInputLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titleInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titleAkunBaru.setBackground(java.awt.Color.cyan);

        titleBuatAkunBaru.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleBuatAkunBaru.setForeground(java.awt.Color.darkGray);
        titleBuatAkunBaru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleBuatAkunBaru.setText("Input Data Akun Baru");

        javax.swing.GroupLayout titleAkunBaruLayout = new javax.swing.GroupLayout(titleAkunBaru);
        titleAkunBaru.setLayout(titleAkunBaruLayout);
        titleAkunBaruLayout.setHorizontalGroup(
            titleAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleAkunBaruLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleBuatAkunBaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titleAkunBaruLayout.setVerticalGroup(
            titleAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleAkunBaruLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleBuatAkunBaru)
                .addContainerGap())
        );

        panelAkunBaru.setBackground(new java.awt.Color(255, 255, 255));

        iconUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconUsername.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\user.png")); // NOI18N
        iconUsername.setToolTipText("Username");

        txUsername.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txUsername.setToolTipText("Username");

        iconPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconPassword.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\password.png")); // NOI18N
        iconPassword.setToolTipText("Password");

        txPassword.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txPassword.setToolTipText("Password");

        viewPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewPassword.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\show.png")); // NOI18N
        viewPassword.setToolTipText("Show Password");
        viewPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewPasswordMouseClicked(evt);
            }
        });

        iconRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconRole.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\userrole.png")); // NOI18N
        iconRole.setToolTipText("Role");

        cbRole.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Student" }));
        cbRole.setToolTipText("Role");

        buttonSignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSignup.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\signup.png")); // NOI18N
        buttonSignup.setToolTipText("Sign Up");
        buttonSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSignupMouseClicked(evt);
            }
        });

        buttonEditUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonEditUser.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\edituser.png")); // NOI18N
        buttonEditUser.setToolTipText("Edit Akun");
        buttonEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEditUserMouseClicked(evt);
            }
        });

        buttonHapusAkun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonHapusAkun.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\delete-user.png")); // NOI18N
        buttonHapusAkun.setToolTipText("Hapus Akun");
        buttonHapusAkun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonHapusAkunMouseClicked(evt);
            }
        });

        buttonClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonClear.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\clear.png")); // NOI18N
        buttonClear.setToolTipText("Clear Field");
        buttonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAkunBaruLayout = new javax.swing.GroupLayout(panelAkunBaru);
        panelAkunBaru.setLayout(panelAkunBaruLayout);
        panelAkunBaruLayout.setHorizontalGroup(
            panelAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAkunBaruLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAkunBaruLayout.createSequentialGroup()
                        .addComponent(iconUsername)
                        .addGap(18, 18, 18)
                        .addComponent(txUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAkunBaruLayout.createSequentialGroup()
                        .addGroup(panelAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconPassword)
                            .addComponent(iconRole))
                        .addGap(18, 18, 18)
                        .addGroup(panelAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAkunBaruLayout.createSequentialGroup()
                                .addComponent(buttonClear)
                                .addGap(18, 18, 18)
                                .addComponent(buttonHapusAkun)
                                .addGap(18, 18, 18)
                                .addComponent(buttonEditUser)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSignup))
                            .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(viewPassword)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAkunBaruLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {iconPassword, iconRole, iconUsername, viewPassword});

        panelAkunBaruLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbRole, txPassword, txUsername});

        panelAkunBaruLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonClear, buttonEditUser, buttonHapusAkun, buttonSignup});

        panelAkunBaruLayout.setVerticalGroup(
            panelAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAkunBaruLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconUsername)
                    .addComponent(txUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconPassword)
                    .addComponent(txPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconRole)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSignup)
                    .addComponent(buttonClear)
                    .addComponent(buttonEditUser)
                    .addComponent(buttonHapusAkun))
                .addGap(20, 20, 20))
        );

        panelAkunBaruLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonClear, buttonEditUser, buttonHapusAkun, buttonSignup, cbRole, iconPassword, iconRole, iconUsername, txPassword, txUsername, viewPassword});

        javax.swing.GroupLayout menuAkunBaruLayout = new javax.swing.GroupLayout(menuAkunBaru);
        menuAkunBaru.setLayout(menuAkunBaruLayout);
        menuAkunBaruLayout.setHorizontalGroup(
            menuAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleAkunBaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAkunBaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuAkunBaruLayout.setVerticalGroup(
            menuAkunBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAkunBaruLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titleAkunBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelAkunBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        titleData.setBackground(java.awt.Color.yellow);

        titleDataMahasiswa.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleDataMahasiswa.setForeground(java.awt.Color.darkGray);
        titleDataMahasiswa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDataMahasiswa.setText("Data Mahasiswa");

        javax.swing.GroupLayout titleDataLayout = new javax.swing.GroupLayout(titleData);
        titleData.setLayout(titleDataLayout);
        titleDataLayout.setHorizontalGroup(
            titleDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleDataMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        titleDataLayout.setVerticalGroup(
            titleDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleDataMahasiswa)
                .addContainerGap())
        );

        panelData.setBackground(new java.awt.Color(255, 255, 255));
        panelData.setForeground(new java.awt.Color(255, 255, 255));

        txCariData.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txCariData.setToolTipText("Cari Data");
        txCariData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCariDataKeyTyped(evt);
            }
        });

        buttonPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonPrint.setIcon(new javax.swing.ImageIcon("C:\\Users\\FRIDAY\\Documents\\NetBeansProjects\\PDM\\src\\img\\print.png")); // NOI18N
        buttonPrint.setToolTipText("Print to .CSV");
        buttonPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPrintMouseClicked(evt);
            }
        });

        tableMahasiswa = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableMahasiswa.setFocusable(false);
        tableMahasiswa.getTableHeader().setReorderingAllowed(false);
        tableMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMahasiswa);

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txCariData, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPrint)
                .addGap(20, 20, 20))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txCariData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPrint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        panelDataLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonPrint, txCariData});

        javax.swing.GroupLayout menuDataLayout = new javax.swing.GroupLayout(menuData);
        menuData.setLayout(menuDataLayout);
        menuDataLayout.setHorizontalGroup(
            menuDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuDataLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(menuDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        menuDataLayout.setVerticalGroup(
            menuDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuDataLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titleData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titleAkun.setBackground(java.awt.Color.magenta);
        titleAkun.setPreferredSize(new java.awt.Dimension(118, 40));

        titleDataAkun.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleDataAkun.setForeground(java.awt.Color.darkGray);
        titleDataAkun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDataAkun.setText("Data Akun");

        javax.swing.GroupLayout titleAkunLayout = new javax.swing.GroupLayout(titleAkun);
        titleAkun.setLayout(titleAkunLayout);
        titleAkunLayout.setHorizontalGroup(
            titleAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleAkunLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titleDataAkun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        titleAkunLayout.setVerticalGroup(
            titleAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleDataAkun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelAkun.setBackground(new java.awt.Color(255, 255, 255));
        panelAkun.setForeground(new java.awt.Color(255, 255, 255));

        txCariAkun.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txCariAkun.setToolTipText("Cari Akun");
        txCariAkun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCariAkunKeyTyped(evt);
            }
        });

        tableAkun = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableAkun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableAkun.setFocusable(false);
        tableAkun.getTableHeader().setReorderingAllowed(false);
        tableAkun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAkunMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableAkun);

        javax.swing.GroupLayout panelAkunLayout = new javax.swing.GroupLayout(panelAkun);
        panelAkun.setLayout(panelAkunLayout);
        panelAkunLayout.setHorizontalGroup(
            panelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAkunLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txCariAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        panelAkunLayout.setVerticalGroup(
            panelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAkunLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txCariAkun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout menuAkunLayout = new javax.swing.GroupLayout(menuAkun);
        menuAkun.setLayout(menuAkunLayout);
        menuAkunLayout.setHorizontalGroup(
            menuAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAkunLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(menuAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAkun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleAkun, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)))
        );
        menuAkunLayout.setVerticalGroup(
            menuAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAkunLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titleAkun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelAkun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuAkunBaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuAkun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuBarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(menuAkunBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuAkun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_buttonExitMouseClicked

    private void buttonMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(1);
    }//GEN-LAST:event_buttonMinimizeMouseClicked

    private void menuBarAdminMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBarAdminMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x, y);
    }//GEN-LAST:event_menuBarAdminMouseDragged

    private void buttonSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSimpanMouseClicked
        // TODO add your handling code here:
        String nim = txNim.getText();
        String nama = txNama.getText();
        String jk = (String) cbJk.getSelectedItem();
        String kelas = txKelas.getText().toUpperCase();
        String prodi = "";
        if (kelas.contains("D3")) {
            prodi = "D-III Statistika";
        } else if (kelas.contains("ST")) {
            prodi = "D-IV Statistika";
        } else if (kelas.contains("KS")) {
            prodi = "D-IV Komputasi Statistik";
        }

        String ErrorMessage = "";
        if (nim.equals("") || nama.equals("") || jk == null || kelas.equals("")) {
            ErrorMessage += "Data Mahasiswa tidak boleh kosong.\n";
        } else if (!nim.matches("[0-9]{9}")) {
            ErrorMessage += "NIM harus 9 digit angka.\n";
        } else if (nama.length() > 50) {
            ErrorMessage += "Nama Mahasiswa tidak boleh lebih dari 50 karakter.\n";
        } else if (kelas.length() > 5) {
            ErrorMessage += "Isian Kelas tidak boleh lebih dari 5 karakter.\nContoh: 2KS5 atau 2ST10.\n";
        } else if (prodi.equals("")) {
            ErrorMessage += "Kesalahan isian Kelas, Program Studi tidak ditemukan.";
        }

        if (ErrorMessage.isEmpty()) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(nim);
            mhs.setNama(nama);
            mhs.setJk(jk);
            mhs.setProdi(prodi);
            mhs.setKelas(kelas);
            try {
                Database.getInstance().insertMahasiswa(mhs);
                loadTableData();
                JOptionPane.showMessageDialog(this, "Berhasil menyimpan data", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                clearFormInput();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan data.\n Pesan error: " + e.getMessage(), "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, ErrorMessage, "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonSimpanMouseClicked

    private void buttonEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEditMouseClicked
        // TODO add your handling code here:
        int i = tableMahasiswa.getSelectedRow();
        if (i == -1) {
            return;
        }

        String nim = (String) modelMahasiswa.getValueAt(i, 0);

        String nama = txNama.getText();
        String jk = (String) cbJk.getSelectedItem();
        String kelas = txKelas.getText().toUpperCase();
        String prodi = "";
        if (kelas.contains("D3")) {
            prodi = "D-III Statistika";
        } else if (kelas.contains("ST")) {
            prodi = "D-IV Statistika";
        } else if (kelas.contains("KS")) {
            prodi = "D-IV Komputasi Statistik";
        }

        String ErrorMessage = "";
        if (nim.equals("") || nama.equals("") || jk == null || kelas.equals("")) {
            ErrorMessage += "Data Mahasiswa tidak boleh kosong.\n";
        } else if (!nim.matches("[0-9]{9}")) {
            ErrorMessage += "NIM harus 9 digit angka.\n";
        } else if (nama.length() > 50) {
            ErrorMessage += "Nama Mahasiswa tidak boleh lebih dari 50 karakter.\n";
        } else if (kelas.length() > 5) {
            ErrorMessage += "Isian Kelas tidak boleh lebih dari 5 karakter.\nContoh: 2KS5 atau 2ST10.\n";
        } else if (prodi.equals("")) {
            ErrorMessage += "Kesalahan isian Kelas, Program Studi tidak ditemukan.";
        }

        if (ErrorMessage.isEmpty()) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(nim);
            mhs.setNama(nama);
            mhs.setJk(jk);
            mhs.setProdi(prodi);
            mhs.setKelas(kelas);
            try {
                Database.getInstance().editMahasiswa(mhs, nim);
                loadTableData();
                JOptionPane.showMessageDialog(this, "Berhasil menyimpan perubahan data", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                clearFormInput();
                txNim.setEnabled(true);
                buttonSimpan.setVisible(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan perubahan data", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, ErrorMessage, "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonEditMouseClicked

    private void buttonHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHapusMouseClicked
        // TODO add your handling code here:
        int i = tableMahasiswa.getSelectedRow();
        if (i == -1) {
            return;
        }

        String nim = (String) modelMahasiswa.getValueAt(i, 0);
        int question = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data yang dipilih?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (question == JOptionPane.OK_OPTION) {
            try {
                Database.getInstance().deleteMahasiswa(nim);
                loadTableData();
                clearFormInput();
                txNim.setEnabled(true);
                buttonSimpan.setVisible(true);
                JOptionPane.showMessageDialog(this, "Berhasil menghapus data", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data", "Gagal", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (question == JOptionPane.CANCEL_OPTION) {
            loadTableData();
            clearFormInput();
            txNim.setEnabled(true);
            buttonSimpan.setVisible(true);
        }
    }//GEN-LAST:event_buttonHapusMouseClicked

    private void buttonResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonResetMouseClicked
        // TODO add your handling code here:
        loadTableData();
        clearFormInput();
        txNim.setEnabled(true);
        buttonSimpan.setVisible(true);
    }//GEN-LAST:event_buttonResetMouseClicked

    private void tableMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMahasiswaMouseClicked
        // TODO add your handling code here:
        boolean editableTable = tableMahasiswa.isEditing();

        if (editableTable == false) {
            txNim.setEnabled(false);
            buttonSimpan.setVisible(false);

            int i = tableMahasiswa.getSelectedRow();
            if (i == -1) {
                return;
            }

            String nim = (String) modelMahasiswa.getValueAt(i, 0);
            txNim.setText(nim);
            String nama = (String) modelMahasiswa.getValueAt(i, 1);
            txNama.setText(nama);
            String jk = (String) modelMahasiswa.getValueAt(i, 2);
            if (jk.equals("Laki-laki")) {
                cbJk.setSelectedIndex(0);
            } else if (jk.equals("Perempuan")) {
                cbJk.setSelectedIndex(1);
            }
            String kelas = (String) modelMahasiswa.getValueAt(i, 4);
            txKelas.setText(kelas);
        }
    }//GEN-LAST:event_tableMahasiswaMouseClicked

    private void viewPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPasswordMouseClicked
        // TODO add your handling code here:

        // Menampilkan dan menyembunyikan Password yang diketik
        if (isPasswordViewable) {
            txPassword.setEchoChar((char) 0);
            isPasswordViewable = !isPasswordViewable;
            viewPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hide.png")));
            viewPassword.setToolTipText("Hide Password");
        } else {
            txPassword.setEchoChar('*');
            isPasswordViewable = !isPasswordViewable;
            viewPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/show.png")));
            viewPassword.setToolTipText("Show Password");
        }
    }//GEN-LAST:event_viewPasswordMouseClicked

    private void buttonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClearMouseClicked
        // TODO add your handling code here:
        loadTableAkun();
        clearFormAkun();
        txUsername.setEnabled(true);
        buttonSignup.setVisible(true);
    }//GEN-LAST:event_buttonClearMouseClicked

    private void buttonHapusAkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHapusAkunMouseClicked
        // TODO add your handling code here:
        int i = tableAkun.getSelectedRow();
        if (i == -1) {
            return;
        }

        String username = (String) modelAkun.getValueAt(i, 0);
        int question = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data yang dipilih?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (question == JOptionPane.OK_OPTION) {
            try {
                Database.getInstance().deleteAkun(username);
                loadTableAkun();
                clearFormAkun();
                txUsername.setEnabled(true);
                buttonSignup.setVisible(true);
                JOptionPane.showMessageDialog(this, "Berhasil menghapus akun", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus akun", "Gagal", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (question == JOptionPane.CANCEL_OPTION) {
            loadTableAkun();
            clearFormAkun();
            txUsername.setEnabled(true);
            buttonSignup.setVisible(true);
        }
    }//GEN-LAST:event_buttonHapusAkunMouseClicked

    private void buttonEditUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEditUserMouseClicked
        // TODO add your handling code here:
        int i = tableAkun.getSelectedRow();
        if (i == -1) {
            return;
        }

        String username = (String) modelAkun.getValueAt(i, 0);

        String password = txPassword.getText();
        String role = (String) cbRole.getSelectedItem();

        String regex = "^[a-z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);

        String ErrorMessage = "";
        if (username.equals("") || password.equals("") || role == null) {
            ErrorMessage += "Data Akun tidak boleh kosong.\n";
        } else if (matcher.matches() == false) {
            ErrorMessage += "Username harus huruf kecil atau angka.\n";
        } else if (username.length() > 10) {
            ErrorMessage += "Username tidak boleh lebih dari 10 karakter.\n";
        } else if (password.length() < 6) {
            ErrorMessage += "Password harus 6 karakter atau lebih.\n";
        }

        if (ErrorMessage.isEmpty()) {
            Akun akun = new Akun();
            akun.setUsername(username);
            akun.setPassword(password);
            akun.setRole(role);
            try {
                Database.getInstance().editAkun(akun, username);
                loadTableAkun();
                JOptionPane.showMessageDialog(this, "Berhasil mengubah data akun", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                clearFormAkun();
                txUsername.setEnabled(true);
                buttonSignup.setVisible(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal mengubah data akun.\n Pesan error: " + e.getMessage(), "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, ErrorMessage, "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonEditUserMouseClicked

    private void buttonSignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSignupMouseClicked
        // TODO add your handling code here:
        String username = txUsername.getText();
        String password = txPassword.getText();
        String role = (String) cbRole.getSelectedItem();

        String regex = "^[a-z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);

        String ErrorMessage = "";
        if (username.equals("") || password.equals("") || role == null) {
            ErrorMessage += "Data Akun tidak boleh kosong.\n";
        } else if (matcher.matches() == false) {
            ErrorMessage += "Username harus huruf kecil atau angka.\n";
        } else if (username.length() > 10) {
            ErrorMessage += "Username tidak boleh lebih dari 10 karakter.\n";
        } else if (password.length() < 6) {
            ErrorMessage += "Password harus 6 karakter atau lebih.\n";
        }

        if (ErrorMessage.isEmpty()) {
            PreparedStatement p;
            ResultSet r;
            String sql;
            try {
                sql = "SELECT * FROM akun WHERE username = ?";
                p = Config.getConnection().prepareStatement(sql);
                p.setString(1, username);
                r = p.executeQuery();
                if (r.next()) {
                    clearFormAkun();
                    throw new SQLException("Username telah terdaftar");
                } else {
                    Akun akun = new Akun();
                    akun.setUsername(username);
                    akun.setPassword(password);
                    akun.setRole(role);
                    try {
                        Database.getInstance().insertAkun(akun);
                        loadTableAkun();
                        JOptionPane.showMessageDialog(this, "Berhasil membuat akun baru", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        clearFormAkun();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "Gagal membuat akun baru.\n Pesan error: " + e.getMessage(), "Gagal", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, ErrorMessage, "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonSignupMouseClicked

    private void tableAkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAkunMouseClicked
        // TODO add your handling code here:
        txUsername.setEnabled(false);
        buttonSignup.setVisible(false);

        int i = tableAkun.getSelectedRow();
        if (i == -1) {
            return;
        }

        String username = (String) modelAkun.getValueAt(i, 0);
        txUsername.setText(username);
        String password = (String) modelAkun.getValueAt(i, 1);
        txPassword.setText(password);
        String role = (String) modelAkun.getValueAt(i, 2);
        if (role.equals("Admin")) {
            cbRole.setSelectedIndex(0);
        } else if (role.equals("Student")) {
            cbRole.setSelectedIndex(1);
        }
    }//GEN-LAST:event_tableAkunMouseClicked

    private void buttonPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPrintMouseClicked
        // TODO add your handling code here:
        Export export = new Export();
        try {
            export.exportMahasiswa("Portal_Data_Mahasiswa.csv");
            JOptionPane.showMessageDialog(this, "Sukses mengekspor file");
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mengekspor file");
        }
    }//GEN-LAST:event_buttonPrintMouseClicked

    private void buttonLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLogoutMouseClicked
        // TODO add your handling code here:
        clearFormInput();
        clearFormAkun();
        txCariData.setText("");
        txCariAkun.setText("");
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_buttonLogoutMouseClicked

    private void txCariDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCariDataKeyTyped
        // TODO add your handling code here:
        filterTableData();
    }//GEN-LAST:event_txCariDataKeyTyped

    private void txCariAkunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCariAkunKeyTyped
        // TODO add your handling code here:
        filterTableAkun();
    }//GEN-LAST:event_txCariAkunKeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DashboardAdmin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buttonClear;
    private javax.swing.JLabel buttonEdit;
    private javax.swing.JLabel buttonEditUser;
    private javax.swing.JLabel buttonExit;
    private javax.swing.JLabel buttonHapus;
    private javax.swing.JLabel buttonHapusAkun;
    private javax.swing.JLabel buttonLogout;
    private javax.swing.JLabel buttonMinimize;
    private javax.swing.JLabel buttonPrint;
    private javax.swing.JLabel buttonReset;
    private javax.swing.JLabel buttonSignup;
    private javax.swing.JLabel buttonSimpan;
    private javax.swing.JComboBox<String> cbJk;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JLabel iconPassword;
    private javax.swing.JLabel iconRole;
    private javax.swing.JLabel iconUsername;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelJk;
    private javax.swing.JLabel labelKelas;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelNim;
    private javax.swing.JPanel menuAkun;
    private javax.swing.JPanel menuAkunBaru;
    private javax.swing.JPanel menuBarAdmin;
    private javax.swing.JPanel menuData;
    private javax.swing.JPanel menuInput;
    private javax.swing.JPanel panelAkun;
    private javax.swing.JPanel panelAkunBaru;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelInput;
    private javax.swing.JTable tableAkun;
    private javax.swing.JTable tableMahasiswa;
    private javax.swing.JPanel titleAkun;
    private javax.swing.JPanel titleAkunBaru;
    private javax.swing.JLabel titleBuatAkunBaru;
    private javax.swing.JLabel titleDashboard;
    private javax.swing.JPanel titleData;
    private javax.swing.JLabel titleDataAkun;
    private javax.swing.JLabel titleDataMahasiswa;
    private javax.swing.JPanel titleInput;
    private javax.swing.JLabel titleInputDataMahasiswa;
    private javax.swing.JTextField txCariAkun;
    private javax.swing.JTextField txCariData;
    private javax.swing.JTextField txKelas;
    private javax.swing.JTextField txNama;
    private javax.swing.JTextField txNim;
    private javax.swing.JPasswordField txPassword;
    private javax.swing.JTextField txUsername;
    private javax.swing.JLabel viewPassword;
    // End of variables declaration//GEN-END:variables
}
