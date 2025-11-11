package com.mycompany.jadwalpiketkelas.controller;

import com.mycompany.jadwalpiketkelas.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HomePageController {

    @FXML private TextField txtNamaPetugas;
    @FXML private TextField txtTugas;
    @FXML private DatePicker dateTanggal;
    @FXML private TableView<Model> tabelPiket;
    @FXML private TableColumn<Model, String> colNama;
    @FXML private TableColumn<Model, String> colTugas;
    @FXML private TableColumn<Model, String> colTanggal;

    private final ObservableList<Model> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colNama.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNamaPetugas()));
        colTugas.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTugas()));
        colTanggal.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTanggal().toString()));
        tabelPiket.setItems(data);
    }

    @FXML
    private void tambahPiket() {
        if (txtNamaPetugas.getText().isEmpty() || txtTugas.getText().isEmpty() || dateTanggal.getValue() == null) {
            showAlert("Semua input harus diisi!");
            return;
        }
        data.add(new Model(txtNamaPetugas.getText(), txtTugas.getText(), dateTanggal.getValue()));
        clearInput();
    }

    @FXML
    private void ubahPiket() {
        Model selected = tabelPiket.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setNamaPetugas(txtNamaPetugas.getText());
            selected.setTugas(txtTugas.getText());
            selected.setTanggal(dateTanggal.getValue());
            tabelPiket.refresh();
            clearInput();
        } else {
            showAlert("Pilih data yang ingin diubah!");
        }
    }

    @FXML
    private void hapusPiket() {
        Model selected = tabelPiket.getSelectionModel().getSelectedItem();
        if (selected != null) {
            data.remove(selected);
        } else {
            showAlert("Pilih data yang ingin dihapus!");
        }
    }

    private void clearInput() {
        txtNamaPetugas.clear();
        txtTugas.clear();
        dateTanggal.setValue(null);
    }

    private void showAlert(String pesan) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Peringatan");
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }
}
