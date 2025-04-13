/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panelbolita;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * //LEONARDO BARCENAS ZAVALA
 */
public class Programa03 extends JFrame {
        private PanelBolita panelBolita;
        private JPanel panelInfo;
        private JPanel panelGanaste;
        private JLabel coordenadas;
        private JLabel ganaste;
        
        public Programa03(){
            setTitle("Bolita 01");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            panelInfo = new JPanel();
            coordenadas = new JLabel("x=100 y=100");
            panelInfo.add(coordenadas);
            
            panelGanaste = new JPanel();
            ganaste = new JLabel("no");
            panelGanaste.add(ganaste);
            
            panelBolita = new PanelBolita(coordenadas, ganaste);
            add(panelInfo,BorderLayout.NORTH);
            add(panelBolita, BorderLayout.CENTER);
            add(panelGanaste, BorderLayout.SOUTH);
        }
    
}
