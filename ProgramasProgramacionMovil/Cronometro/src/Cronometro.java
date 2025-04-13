import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * //LEONARDO BARCENAS ZAVALA
 */
public class Cronometro extends JFrame implements ActionListener{
    JLabel etiquetaContador;
    JButton btnIniciar, btnReiniciar;
    int Contador;
    boolean btnActivo = false;
    HiloContador hc;
    
    public Cronometro(){
        JFrame ventana = new JFrame();
        ventana.setTitle("Cronometro");
        ventana.setSize(300, 300);
        ventana.setDefaultCloseOperation(3);
        
        hc = new HiloContador();
        JPanel p = new JPanel(new GridLayout(3, 1));
        
        etiquetaContador = new JLabel("0");
        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(this);
        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.addActionListener(this);
        p.add(etiquetaContador);
        p.add(btnIniciar);
        p.add(btnReiniciar);
        ventana.setVisible(true);
        ventana.add(p);
    }
    
    public static void main(String[] args){
        Cronometro c = new Cronometro();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnIniciar)){
            btnActivo = true;
            hc = new HiloContador();
            hc.start();
        }
        
        if(e.getSource().equals(btnReiniciar)){
            btnActivo = false;
            Contador = 0;
            etiquetaContador.setText(Contador + "");
            
        }

    }
    
    private class HiloContador extends Thread{
        public void run(){
            while(true){
                try{
                    if(btnActivo){
                        Contador++;
                        etiquetaContador.setText(Contador + "");
                        Thread.sleep(1000);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
}
