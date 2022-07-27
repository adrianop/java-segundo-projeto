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
import java.awt.geom.Ellipse2D;
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
public class Circulo implements Forma{

    private int raio=1;
    private float mx;
    private float my;
    private double esp = Math.random()*10;
    private float cont;
    private Shape s;
    
    public Circulo(int mx,int my) {
        this.mx = mx;
        this.my = my;
        s = new Ellipse2D.Double(this.mx,this.my,raio,raio);    
 
    }
    
    public double getMx() {
        return mx;
    }

    public void setMx(float mx) {
        this.mx = mx;
    }

    /**
     *
     * @return
     */
    @Override
    public double getMy() {
        return my;
    }

    public void setMy(float my) {
        this.my = my;
    }
    
    public float calculaArea() {
        return (float)(Math.PI * Math.pow(raio, 2));
    }



    /**
     * @return the raio
     */
    public int getRaio() {
        return raio;
    }

    /**
     * @param raio the raio to set
     */
    public void setRaio(int raio) {
        this.raio = raio;
    }
    
    public void Desenha(Graphics2D gdd) {
         File imagesrc= new File ("boneco.png");
        BufferedImage imagem4 = null;
         
        try {
            imagem4 = ImageIO.read(imagesrc);
        } catch (IOException ex) {
            Logger.getLogger(Quadrado.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
         gdd.fillOval((int) getMx(), (int) getMy(),raio ,raio);
         gdd.drawImage(imagem4, (int) getMx(), (int) getMy(), raio + 30, raio + 30, null);
      
       
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
       return 1;
    }

    @Override
    public Shape toShape() {
        
        Shape s1 = new Rectangle ((int)mx,(int) my, raio, raio);  
        return s1;
        
        
        
    }
    
    
}
