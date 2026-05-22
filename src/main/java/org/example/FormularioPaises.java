package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FormularioPaises extends Application {

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Label lblPais = new Label("País:");
        ComboBox<String> comboPais = new ComboBox<>();
        comboPais.getItems().addAll("España", "Francia", "Italia", "Alemania", "Portugal");
        comboPais.setPromptText("Selecciona un país");
        comboPais.setMaxWidth(Double.MAX_VALUE);
        grid.add(lblPais, 0, 0);
        grid.add(comboPais, 1, 0);

        Label lblMensaje = new Label("");
        grid.add(lblMensaje, 1, 2);

        Button boton = new Button("Confirmar");
        boton.setMaxWidth(Double.MAX_VALUE);
        grid.add(boton, 1, 1);

        boton.setOnAction(event -> {
            String pais = comboPais.getValue();
            if (pais != null) {
                lblMensaje.setText("País seleccionado: " + pais);
            } else {
                lblMensaje.setText("Error: selecciona un país");
            }
        });

        Scene scene = new Scene(grid, 320, 150);
        stage.setTitle("Ejercicio 12 - Países");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}