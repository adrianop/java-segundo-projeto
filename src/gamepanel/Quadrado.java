/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Aluno
 */
public class Quadrado implements Forma{
    private int lado=1;
    private double mx;
    private double my;
    private Shape s;
    private int cont=0;
    private double esp = Math.random()*10;

    public double getMx() {
        return mx;
    }

    public void setMx(double mx) {
        this.mx = mx;
    }

    public double getMy() {
        return my;
    }

    public void setMy(double my) {
        this.my = my;
    }

    public Quadrado(int mx, int my) {
        this.mx = mx;
        this.my = my;
        s= new Rectangle2D.Double(this.mx,this.my,this.lado,this.lado);
   
    }
    
    public void Desenha(Graphics2D gdd) {
        
        File imagesrc= new File ("meteoro1.png");
        BufferedImage imagem3 = null;
         
        try {
            imagem3 = ImageIO.read(imagesrc);
        } catch (IOException ex) {
            Logger.getLogger(Quadrado.class.getName()).log(Level.SEVERE, null, ex);
        }
         

      ///  gdd.setColor(Color.white);
         gdd.fillRect((int) mx, (int) my,lado,lado);

        gdd.drawImage(imagem3,  (int) mx, (int) my , lado +30 , lado +30 , null);


       
    }
    
    public float calculaArea() {
        return (float)Math.pow(lado, 2);
    }

    /**
     * @return the lado
     */
    public float getLado() {
        return lado;
    }

    /**
     * @param lado the lado to set
     */
    public void setLado(int lado) {
        this.lado = lado;
    }
    
    public void Deslocamento(double x, double y, int limit_x, int limit_y) {
        
            if (y <= limit_y) {
                 this.my+=y;

            }

            if(this.mx + esp <= limit_x-60 && this.mx - esp >10){
                if(cont ==0){
                    this.mx = (float) (this.mx + esp);
                }else{
                    this.mx = (float) (this.mx - esp);
                }
            }
            else {
                this.mx = (float) (this.mx - esp);
                cont++;
            }
    }

    @Override
    public int cod() {
        return 2;
    }
    @Override
       public Shape toShape() {
         Shape s1 = new Rectangle ((int)mx,(int) my, lado, lado);  
        return s1;
    }
}   

