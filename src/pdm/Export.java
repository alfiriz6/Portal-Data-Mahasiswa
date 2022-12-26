package pdm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Export {

    private String path;

    public Export() {
    }

    void setPath(String path) {
        this.path = path;
    }

    String getPath() {
        return path;
    }

    public void exportMahasiswa(String path) throws IOException, SQLException {
        setPath(path);
        try {
            //menghubungi database
            List<Mahasiswa> mhs = Database.getInstance().getListMahasiswa();
            //buat file kosong
            File csvOutput = new File(getPath());
            FileWriter filewriter = new FileWriter(csvOutput);

            //input header(nama kolom)
            insertMahasiswaHeader(filewriter);

            //input tiap record ke dalam file
            insertMahasiswaRow(mhs, filewriter);

            filewriter.close();
        } catch (IOException e) {
            throw e;
        } catch (SQLException e) {
            throw e;
        }

    }

    private void insertMahasiswaRow(List<Mahasiswa> mhs, FileWriter filewriter) {
        for (Mahasiswa m : mhs) {
            StringBuilder line = new StringBuilder();
            line.append(m.getNim());
            line.append(',');
            line.append(m.getNama());
            line.append(',');
            line.append(m.getJk());
            line.append(',');
            line.append(m.getProdi());
            line.append(',');
            line.append(m.getKelas());

            //buat baris baru untuk record berikutnya
            line.append("\n");
            try {
                filewriter.write(line.toString());
            } catch (IOException e) {
                Logger.getLogger(Export.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    //mmethod ontuk input header
    private void insertMahasiswaHeader(FileWriter filewriter) {
        StringBuilder line = new StringBuilder();

        line.append("nim");
        line.append(',');
        line.append("nama");
        line.append(',');
        line.append("jenis_kelamin");
        line.append(',');
        line.append("prodi");
        line.append(',');
        line.append("kelas");

        line.append("\n");
        try {
            filewriter.write(line.toString());
        } catch (IOException e) {
            Logger.getLogger(Export.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
