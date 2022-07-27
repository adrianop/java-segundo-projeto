package gamepanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import static java.lang.Math.min;
import static java.lang.Math.random;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame {

    public Game() {
        
    }

    private static int limit_x=800;
    private static int limit_y=600;
    private static int sum;
    private static int cont = 1;
    private static int limitador = 1;   
    private static long elapsed=0;
   
    
    
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
    
        Game game = new Game();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setPreferredSize(new Dimension(limit_x, limit_y));
        
        GamePanel gamepanel = new GamePanel();
        gamepanel.setSize(limit_x, limit_y);
        
        game.add(gamepanel);
        
        PegaTudo c = new PegaTudo(0, limit_y - 40, 75, 15);
        gamepanel.getFormas().add(c);
        gamepanel.repaint();
        
        game.addMouseMotionListener(new MouseMotionListener() {
            
            public void keyPressed(KeyEvent e) {
                System.out.println(e.toString());
                if (e.getKeyCode() == 37) {
                    gamepanel.setMx(gamepanel.getMx() - 50);
                } else if (e.getKeyCode() == 39) {
                    gamepanel.setMx(gamepanel.getMx() + 50);
                }
                gamepanel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //panel.setDragging(false);
                if (e.getX() <= limit_x - c.getX()) {
                    c.setMx(e.getX());
                } else {
                    c.setMx(limit_x - c.getX());
                }
                game.repaint();
                sum = e.getX();

                //        System.out.println(e.getX() + "," + e.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        int i = 0;
        long inicio = 0;
        int num_menor = 40;
        int num_maior = 600;
        int x = 0;
        
        Thread thread = new Thread(new Runnable() {
            long inicio =0;
            int cont2 = 1;
            long ini= 0;
            long  time = 0;
            int contadorcolisao = 0;
            
            public void run() {
                
                while(true){
                    
                    if (inicio == 0) {
                        inicio = System.currentTimeMillis();
                    }   
                    time = System.currentTimeMillis() - ini;                                 
                    elapsed = System.currentTimeMillis() - inicio;

                    if (time>5000){
                        if(limitador >= 15){ limitador =15;}
                        else{
                        limitador += 2;
                        time = 0;
                        ini = System.currentTimeMillis();
                    }}

                    for (int i= 1; i < gamepanel.getFormas().size(); i++) {
                        if (gamepanel.getFormas().get(i).getMy() > 620 || (gamepanel.getFormas().get(i).getMx() > 850)) {
                            gamepanel.setPerdidas(gamepanel.getPerdidas()+1);
                            gamepanel.getFormas().remove(i);
                            cont = cont - 1;
                        }
                    }

                    if(gamepanel.getFormas().size()>1){
                        for (int con = 1; con < gamepanel.getFormas().size(); con++) {
                            for (int con2 = 0; con2 < 100; con2++) {
                                for(int cont2 = 0; cont2<30;cont2++){
                                    if((int)gamepanel.getFormas().get(con).getMx() + cont2 == (int)sum + con2){      
                                        if (gamepanel.getFormas().get(con).getMy() > 530) {
                                            gamepanel.getFormas().remove(con);
                                            cont -= 1;
                                            gamepanel.setColetadas(gamepanel.getColetadas()+1);
                                        }
                                    }
                                } 
                            }
                        }
                    }
                }
            }
        });
        
        thread.start();
        
        while (true) {
        double r2d2=0;
        double randon1= num_menor + (int)(Math.random() * (num_maior - num_menor));;
        double randon2= num_menor + (int)(Math.random() * (num_maior - num_menor));

            if (inicio == 0) {
                inicio = System.currentTimeMillis();
            }
            
            if (gamepanel.getFormas().size() - 1 < limitador) {
                cont += 2;
                gamepanel.getFormas().add(new Circulo((int) randon1,0));
                gamepanel.getFormas().add(new Quadrado((int) randon2, 0));
            }
            
            for (i = 1; i < gamepanel.getFormas().size(); i++) {
                double r = Math.random()*10;
                if(r2d2>=0 && i%4 == 0){
                    r=-r;
                }
                gamepanel.getFormas().get(i).Deslocamento(r, 10 * Math.random(), limit_x, limit_y);
                r2d2 = r;
            }
               
            gamepanel.setTempo(elapsed);
            gamepanel.repaint();
            game.pack();
            game.setVisible(true);
            game.setResizable(false);
             x = 100-(int)elapsed/1000;
             
            if(x<=1)x=1;
                Thread.sleep(x);
        }
    }
}
    
   

