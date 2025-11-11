package com.mycompany.jadwalpiketkelas.model;

import java.time.LocalDate;

public class Model {
    private String namaPetugas;
    private String tugas;
    private LocalDate tanggal;

    public Model(String namaPetugas, String tugas, LocalDate tanggal) {
        this.namaPetugas = namaPetugas;
        this.tugas = tugas;
        this.tanggal = tanggal;
    }

    public String getNamaPetugas() { return namaPetugas; }
    public void setNamaPetugas(String namaPetugas) { this.namaPetugas = namaPetugas; }

    public String getTugas() { return tugas; }
    public void setTugas(String tugas) { this.tugas = tugas; }

    public LocalDate getTanggal() { return tanggal; }
    public void setTanggal(LocalDate tanggal) { this.tanggal = tanggal; }
}
