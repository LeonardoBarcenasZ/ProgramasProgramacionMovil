package com.mycompany.programa01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//LEONARDO BARCENAS ZAVALA 
public class Programa01 extends JFrame implements ActionListener {

    JButton btnSaludar;
    JTextField texto01;
    JPanel panelPrincipal;

    public static void main(String[] args) {
        Programa01 p = new Programa01();
        p.setVisible(true);
    }

    public Programa01() {
        setTitle("");
        setSize(400, 200);
        setLocationRelativeTo(null); // Centrar ventana
        setResizable(false); // No permitir redimensionar
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel principal
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBackground(new Color(240, 248, 255)); // Azul claro

        // Crear etiqueta de título
        texto01 = new JTextField("Escribe tu nombre...");
        texto01.setFont(new Font("Arial", Font.PLAIN, 16));
        texto01.setHorizontalAlignment(JTextField.CENTER);

        // Crear botón de saludo
        // Cambiar el color de fondo del botón
        btnSaludar = new JButton("Saludar");
        btnSaludar.setFont(new Font("Arial", Font.BOLD, 16));
        btnSaludar.setBackground(new Color(173, 216, 230)); // Azul claro
        btnSaludar.addActionListener(this);

        // Cambiar el color de fondo del panel
        panelPrincipal.add(texto01, BorderLayout.CENTER);
        panelPrincipal.add(btnSaludar, BorderLayout.SOUTH);

        // Cambiar el color de fondo del panel
        add(panelPrincipal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = texto01.getText().trim();
        if (!texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hola " + texto + " 👋");
            texto01.setText(""); // Limpiar el campo de texto
        } else {
            JOptionPane.showMessageDialog(this, "Por favor escribe algo 😅");
        }
    }
}
