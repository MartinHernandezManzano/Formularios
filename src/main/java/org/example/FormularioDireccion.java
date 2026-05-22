package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FormularioDireccion extends Application {

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Label lblDireccion = new Label("Dirección:");
        TextField campDireccion = new TextField();
        campDireccion.setPromptText("Tu dirección completa");
        campDireccion.setPrefWidth(220);
        grid.add(lblDireccion, 0, 0);
        grid.add(campDireccion, 1, 0);

        Label lblMensaje = new Label("");
        grid.add(lblMensaje, 1, 2);

        Button boton = new Button("Confirmar dirección");
        boton.setMaxWidth(Double.MAX_VALUE);
        grid.add(boton, 1, 1);

        boton.setOnAction(event -> {
            String direccion = campDireccion.getText();
            if (direccion.isEmpty()) {
                lblMensaje.setText("Error: introduce una dirección");
            } else {
                lblMensaje.setText("Dirección confirmada: " + direccion);
            }
        });

        Scene scene = new Scene(grid, 380, 150);
        stage.setTitle("Ejercicio 13 - Dirección");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}