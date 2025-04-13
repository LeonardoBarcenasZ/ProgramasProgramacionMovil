/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.awt.Font;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * //LEONARDO BARCENAS ZAVALA 
 */
public class Calculadora_class extends JFrame implements ActionListener{
    JTextField pantalla;
    //JTextField pantalla;
    //JTextField pantalla = new JTextField(300);
    JButton []numeros;
    JButton bsuma, bresta, bmul, bdiv,
            bpunto, bigual,bclear, bbackspace;
    String op1, op2;
    boolean vsuma,vresta,vmul, vdiv, vpunto;
    double resultado;
    public Calculadora_class(){
        setTitle("casio");
        setSize(400,700);
        setDefaultCloseOperation(3);
        setLayout(null);
        
        //pantalla = new JTextField(300)
        //pantalla.setBounds(1,1,380,80);
        
        Font f = new Font("Arial",Font.PLAIN,60);
        
        pantalla = new JTextField();
        pantalla.setBounds(1, 20, 380, 80);
        pantalla.disable();
        pantalla.setFont(f);
        // setComponentOrientation(ComponentOrientation)
        pantalla.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(pantalla);
       
        int x=1, y=420;
        numeros = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numeros[i] = new JButton(String.valueOf(i));
            numeros[i].setBounds(x, y, 80, 80);
            numeros[i].setFont(f);
            numeros[i].addActionListener(this);
            add(numeros[i]);
            x += 100;
            if ((i + 1) % 3 == 0) {
                y -= 100;
                x = 1;
            }
        }

        bsuma = new JButton("+");
        bsuma.setBounds(301, 120, 80, 80);
        bsuma.setFont(f);
        bsuma.addActionListener(this);
        add(bsuma);

        bresta = new JButton("-");
        bresta.setBounds(301, 220, 80, 80);
        bresta.setFont(f);
        bresta.addActionListener(this);
        add(bresta);

        bmul = new JButton("*");
        bmul.setBounds(301, 320, 80, 80);
        bmul.setFont(f);
        bmul.addActionListener(this);
        add(bmul);

        bdiv = new JButton("/");
        bdiv.setBounds(301, 420, 80, 80);
        bdiv.setFont(f);
        bdiv.addActionListener(this);
        add(bdiv);

        bigual = new JButton("=");
        bigual.setBounds(301, 520, 80, 80);
        bigual.setFont(f);
        bigual.addActionListener(this);
        add(bigual);

        bpunto = new JButton(".");
        bpunto.setBounds(201, 520, 80, 80);
        bpunto.setFont(f);
        bpunto.addActionListener(this);
        add(bpunto);
        

        bbackspace = new JButton("B"); // Borra un dígito
        bbackspace.setBounds(201, 120, 80, 80);
        bbackspace.setFont(f);
        bbackspace.addActionListener(this);
        add(bbackspace);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        JButton botonPresionado = (JButton) e.getSource();
        if (botonPresionado == bsuma || botonPresionado == bresta || botonPresionado == bmul || botonPresionado == bdiv) {
            op1 = pantalla.getText();
            pantalla.setText("");
            vsuma = botonPresionado == bsuma;
            vresta = botonPresionado == bresta;
            vmul = botonPresionado == bmul;
            vdiv = botonPresionado == bdiv;
            vpunto = true;
        } else if (botonPresionado == bigual) {
            op2 = pantalla.getText();
            double num1 = Double.parseDouble(op1);
            double num2 = Double.parseDouble(op2);
            if (vsuma) {
                resultado = num1 + num2;
            } else if (vresta) {
                resultado = num1 - num2;
            } else if (vmul) {
                resultado = num1 * num2;
            } else if (vdiv) {
                resultado = num1 / num2;
            }
            pantalla.setText(String.valueOf(resultado));
            vsuma = vresta = vmul = vdiv = false;
        } else if (botonPresionado == bpunto) {
            if (vpunto) {
                pantalla.setText(pantalla.getText() + ".");
                vpunto = false;
            }
        } else if (botonPresionado == bclear) {
            pantalla.setText(""); // Borra toda la pantalla
            vsuma = vresta = vmul = vdiv = false;
            vpunto = true;
        } else if (botonPresionado == bbackspace) {
            String textoActual = pantalla.getText();
            if (!textoActual.isEmpty()) {
                pantalla.setText(textoActual.substring(0, textoActual.length() - 1)); // Borra el último dígito
            }
        } else {
            pantalla.setText(pantalla.getText() + botonPresionado.getText());
        }
    }
}
