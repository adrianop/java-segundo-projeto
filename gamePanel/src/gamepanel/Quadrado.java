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
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Aluno
 */
public class Quadrado implements Forma{
    private int lado=15;
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
        Image imagem3= new ImageIcon("Meteoro1.jpg").getImage();

        gdd.setColor(Color.white);
        gdd.drawImage(imagem3,  (int) mx, (int) my , lado , lado, null);


        gdd.fillRect((int) mx, (int) my,lado,lado);

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
    
}
