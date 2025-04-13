/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package galeria;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * //LEONARDO BARCENAS ZAVALA
 */
public class PanelImagen extends JPanel{
    Image imagenDada;
    ImageIcon icono;
    String ruta;
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        icono = new ImageIcon(ruta);
        imagenDada = icono.getImage();
        g.drawImage(imagenDada, 1, 1, getWidth(), getHeight(), this);
    }
}
