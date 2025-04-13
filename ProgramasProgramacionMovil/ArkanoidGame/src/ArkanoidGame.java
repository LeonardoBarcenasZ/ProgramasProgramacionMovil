import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

// LEONARDO BARCENAS ZAVALA
public class ArkanoidGame extends JPanel implements MouseMotionListener, ActionListener{
    Timer timer;
    int ballX = 250;
    int ballY = 250;
    int ballWidth = 10;
    int ballHeight =10;
    int ballVelX = 2;
    int ballVelY = 2;
    int paddleX = 200;
    int paddleY = 500;
    int paddleWidth = 150;
    int paddleHeight = 40;
   
    Rectangle [][] blocks;
    int blockWidth = 60;
    int blockHeight = 20;
    int rows = 4, cols = 6;
   
    boolean inRunnig = true;
    boolean isGameOver = false;
   
    public ArkanoidGame(){
        setBackground(Color.BLACK);
        addMouseMotionListener(this);
       
        blocks = new Rectangle[rows][cols];
        for(int i = 0; i< rows; i++){
            for(int j = 0; j< cols; j++){
                blocks[i][j] = new Rectangle(j*(blockWidth+10)+30, i *(blockHeight+5)+30, blockWidth,blockHeight);
            }
        }
        timer = new Timer(5, this); // Intervalo de tiempo para el movimiento de la bolita
        timer.setInitialDelay(0); // Retraso inicial de 0 ms
        timer.start();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        paddleX = e.getX()-paddleWidth/2;
        if(paddleX<0) paddleX =0;
        if(paddleX>getWidth()-paddleWidth)paddleX=getWidth()-paddleWidth;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(isGameOver){
                return;
            }
            // Actualizar la posición de la bolita
            
            ballX +=ballVelX;
            ballY += ballVelY;
           
            //choque derecha
            if(ballX<=0 || ballX >= getWidth()-10){
                ballVelX = -ballVelX;
            }
            //choque arriba
            if(ballY<=0){
                ballVelY = -ballVelY;
            }
           
            //choque abajo
            // Si la bolita cae por debajo de la paleta, se termina el juego
            if(ballY >= getHeight()){
                isGameOver =true;
            }
           
            //choque paleta
            // Verificar si la bolita choca con la paleta
            Rectangle ballRect = new Rectangle(ballX, ballY, 10, 10); // Rectángulo de la bolita
            // Ajustar la posición de la paleta para que no se salga de los límites de la ventana
            Rectangle paddleRect = new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight); // Rectángulo de la paleta
            if (ballRect.intersects(paddleRect)) {
                ballVelY = -ballVelY; // Cambiar la dirección de la bolita
                // Ajustar la posición de la bolita para que esté justo encima de la paleta
                ballY = paddleY - 10; 
            }
           
           
           
            // Verificar si la bolita choca con los bloques
            // Recorremos la matriz de bloques y verificamos si la bolita choca con alguno de ellos
            for(int i = 0; i< rows; i++){
                for(int j = 0; j< cols;j++){            
                    if(blocks[i][j]!=null&&blocks[i][j].intersects(new Rectangle(ballX, ballY,10,10))){
                        ballVelY = -ballVelY;                    
                        blocks[i][j] = null;
                    }
                }                    
        }
            repaint();
    }
   
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //dibujar la bolita
        g.setColor(Color.red);
        g.fillOval(ballX, ballY,ballWidth, ballHeight);
        //dibujar la paleta
        g.setColor(Color.yellow);
        g.fillRect(paddleX,paddleY, paddleWidth, paddleHeight);
       
        //dibujar los bloques
        g.setColor(Color.green);
           for(int i = 0; i< rows; i++){
                for(int j = 0; j< cols;j++){
                    if(blocks[i][j] != null){
                        g.fillRect(blocks[i][j].x,blocks[i][j].y, blockWidth, blockHeight);
                    }
                }            
          }
           
            //dibujar el texto de Game Over
          if(isGameOver){
              g.setColor(Color.WHITE);
              g.setFont(new Font("Arial", Font.BOLD, 30));
              g.drawString("Game Over", getWidth()/2-100, getHeight()/2);
          }
    }
   
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arkanoid Game");        
        ArkanoidGame ag = new ArkanoidGame();
        frame.add(ag);
        frame.setSize(480,600);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);        
    }

    @Override
    public void mouseDragged(MouseEvent e) {}
}