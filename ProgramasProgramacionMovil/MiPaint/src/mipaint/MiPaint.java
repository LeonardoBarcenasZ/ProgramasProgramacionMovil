/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mipaint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * //LEONARDO BARCENAS ZAVALA 
 */
public class MiPaint extends JFrame{
    JComboBox<String>comboColores;
    JButton btnLimpiar;
    DibujoPanel panelDibujo;
    Color colorSeleccionado = Color.BLACK;
    
    public MiPaint(){
        setTitle("MiPaint");
        setSize(400,400);
        setDefaultCloseOperation(3);
        
        String[] colores = {"Negro","Rojo", "Azul", "Amarillo"};
        comboColores = new JComboBox<>(colores);
        comboColores.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String colorSeleccionadoTexto = (String)comboColores.getSelectedItem();
                
                switch(colorSeleccionadoTexto){
                    case "Negro":
                        colorSeleccionado = Color.BLACK;
                        break;
                    case "Rojo":
                        colorSeleccionado = Color.RED;
                        break;
                    case "Azul":
                        colorSeleccionado = Color.BLUE;
                        break;
                    case "Amarillo":
                        colorSeleccionado = Color.YELLOW;
                        break;
                    default:
                        break;
                }
            };
        });
        panelDibujo = new DibujoPanel();
        
        JPanel panel01 = new JPanel();
        panel01.add(comboColores);
        
        add(panel01, BorderLayout.NORTH);
        add(panelDibujo, BorderLayout.CENTER);
    }
    class DibujoPanel extends JPanel {
        ArrayList<Point> puntos = new ArrayList<>();
        public DibujoPanel(){
            setBackground(Color.WHITE);
            addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                puntos.add(e.getPoint());
                repaint();
                }        
            });
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(colorSeleccionado);
            for(Point punto: puntos){
                g.fillOval(punto.x,punto.y,5,5);
            }
        }
        public void limpiar(){
            puntos.clear();
            repaint();
        }
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
            new MiPaint().setVisible(true);
            }
        });        
    }
}
