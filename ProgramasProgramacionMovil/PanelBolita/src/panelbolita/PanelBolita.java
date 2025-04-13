/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panelbolita;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * //LEONARDO BARCENAS ZAVALA
 */
public class PanelBolita extends JPanel implements MouseMotionListener, MouseListener{
    int x = 100;
    int y = 100;
    JLabel labelCoordenadas;
    JLabel labelGanaste;
    boolean arrastrando = false;

    public PanelBolita(JLabel labelCoordenadas, JLabel g){
        this.labelCoordenadas = labelCoordenadas;
        this.labelGanaste = g;
        
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(arrastrando){
            g.setColor(Color.RED);
        }else{
            g.setColor(Color.GREEN);
        }
        g.fillOval(x,y,30,30);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        labelCoordenadas.setText("x="+ x + "y="+ y);
        if(x == 150){
            labelGanaste.setText("Ganaste");
        }else{
            //labelGanaste.setText(labelGanaste.getText()+"no");
            labelGanaste.setText("");
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        arrastrando = true;
        repaint();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        arrastrando = false;
        repaint();
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
}
