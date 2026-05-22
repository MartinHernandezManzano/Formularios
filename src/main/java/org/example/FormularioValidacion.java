package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FormularioValidacion extends Application {

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        // Columna 0: etiquetas — Columna 1: campos
        Label lblNombre = new Label("Nombre:");
        TextField campNombre = new TextField();
        campNombre.setPromptText("Tu nombre");
        grid.add(lblNombre, 0, 0);
        grid.add(campNombre, 1, 0);

        Label lblEmail = new Label("Email:");
        TextField campEmail = new TextField();
        campEmail.setPromptText("Tu email");
        grid.add(lblEmail, 0, 1);
        grid.add(campEmail, 1, 1);

        Label lblPassword = new Label("Contraseña:");
        // PasswordField es igual que TextField pero oculta el texto
        PasswordField campPassword = new PasswordField();
        campPassword.setPromptText("Tu contraseña");
        grid.add(lblPassword, 0, 2);
        grid.add(campPassword, 1, 2);

        // Label para mostrar el resultado de la validación
        Label lblMensaje = new Label("");
        grid.add(lblMensaje, 1, 4);

        Button boton = new Button("Enviar");
        boton.setMaxWidth(Double.MAX_VALUE);
        grid.add(boton, 1, 3);

        boton.setOnAction(event -> {
            String nombre   = campNombre.getText();
            String email    = campEmail.getText();
            String password = campPassword.getText();

            // isEmpty() devuelve true si el String está vacío
            if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
                lblMensaje.setText("Error: rellena todos los campos");
            } else {
                lblMensaje.setText("Formulario enviado correctamente");
            }
        });

        Scene scene = new Scene(grid, 350, 200);
        stage.setTitle("Ejercicio 11 - Formulario con validación");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}