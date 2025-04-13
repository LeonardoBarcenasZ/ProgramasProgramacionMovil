/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package galeria;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 //LEONARDO BARCENAS ZAVALA 
 */
public class Galeria extends JFrame implements ActionListener{

    PanelImagen pi; JPanel pbotones;
    JButton btnatras, btnadelante;
    String nuevaImagen;
    int contador = 1;
    
    
    public static void main(String[] args) {
        Galeria galeria = new Galeria();
        galeria.setVisible(true);
    }
    public Galeria(){
        setTitle("Galeria Imagenes");
        setSize(400, 400);
        setDefaultCloseOperation(3);
        nuevaImagen = "gato" + contador + ".jpg";
        pi = new PanelImagen();
        pi.ruta = nuevaImagen;
        pi.setSize(400 ,350);
        pbotones = new JPanel();
        btnatras = new JButton("atras");
        btnadelante = new JButton("adelante");
        btnatras.addActionListener(this);
        btnadelante.addActionListener(this);
        pbotones.add(btnatras);
        pbotones.add(btnadelante);
        add(pi);
        add(pbotones, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnatras)){
            if(contador <= 1){
                contador = 3;
            }else{
                contador = contador - 1;
            }
        }
        if(e.getSource().equals(btnadelante)){
            if(contador >= 3){
                contador = 1;
            }else{
                contador = contador + 1;
            }
        }
        System.out.println("contador" + contador);
        nuevaImagen = "gato" + contador + ".jpg";
        pi.ruta = nuevaImagen;
        pi.repaint();
    }
}
