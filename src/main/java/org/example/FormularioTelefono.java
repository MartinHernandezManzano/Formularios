package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FormularioTelefono extends Application {

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Label lblTelefono = new Label("Teléfono:");
        TextField campTelefono = new TextField();
        campTelefono.setPromptText("10 dígitos");
        campTelefono.setPrefWidth(200);
        grid.add(lblTelefono, 0, 0);
        grid.add(campTelefono, 1, 0);

        Label lblMensaje = new Label("");
        grid.add(lblMensaje, 1, 2);

        Button boton = new Button("Validar");
        boton.setMaxWidth(Double.MAX_VALUE);
        grid.add(boton, 1, 1);

        boton.setOnAction(event -> {
            String telefono = campTelefono.getText();

            if (telefono.isEmpty()) {
                lblMensaje.setText("Error: introduce un teléfono");
                // matches() comprueba si el texto cumple la expresión regular
                // \\d significa dígito, {10} significa exactamente 10 veces
            } else if (!telefono.matches("\\d{10}")) {
                lblMensaje.setText("Error: el teléfono debe tener 10 dígitos");
            } else {
                lblMensaje.setText("Teléfono válido: " + telefono);
            }
        });

        Scene scene = new Scene(grid, 350, 150);
        stage.setTitle("Ejercicio 14 - Teléfono");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}