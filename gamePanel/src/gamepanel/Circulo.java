/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Aluno
 */
public class Circulo implements Forma{

    private int raio=15;
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
        Image imagem4= new ImageIcon("Meteoro2.jpg").getImage();
        gdd.drawImage(imagem4, (int) getMx(), (int) getMy(), raio, raio, null);
        gdd.setColor(Color.pink);
        gdd.fillOval((int) getMx(), (int) getMy(),raio,raio);
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
    
}
