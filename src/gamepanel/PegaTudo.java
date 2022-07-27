
package gamepanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class PegaTudo implements Forma {

    private boolean status =true;    
    private double mx = 0;
    private double my = 0;
    private int x = 0;  //tamanho da forma
    private int y = 0;
    private Shape s;
    
    public Shape getS() {
        return s;
    }

    public void setS(Shape s) {
        this.s = s;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PegaTudo(int mx, int my, int x, int y) {
        this.mx = mx;
        this.my = my;
        this.x = x;
        this.y = y;
        
        s= new Rectangle2D.Double(this.mx,this.my,this.x,this.y);
    }

    public double getMx() {
        return mx;
    }

    /**
     * @param px the px to set
     */
    public void setMx(int mx) {
        this.mx = mx;
    }

    /**
     * @return the py
     */
    @Override
    public double getMy() {
        return my;
    }

    /**
     * @param py the py to set
     */
    public void setMy(int my) {
        this.my = my;
    }

    /**
     * @return the tamx
     */
    public int getX() {
        return x;
    }

    /**
     * @param tamx the tamx to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the tamy
     */
    public int getY() {
        return y;
    }

    /**
     * @param tamy the tamy to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public void Desenha(Graphics2D gdd) {
        File imagesrc= new File ("Nave.png");
        BufferedImage imagem2 = null;
         
        try {
            imagem2 = ImageIO.read(imagesrc);
        } catch (IOException ex) {
            Logger.getLogger(Quadrado.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
        
        gdd.setColor(Color.white);
        gdd.fillRect((int) getMx(),(int) getMy(), getX() -75, getY() -75 );
        gdd.drawImage(imagem2,  (int) getMx(), (int) getMy() ,getX(), getY(), null);
        
       
    }

    @Override
    public void Deslocamento(double x, double y, int limit_x, int limit_y) {
    }

    @Override
    public int cod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Shape toShape() {
         Shape s1 = new Rectangle ((int)mx,(int) my, x, y);  
        return s1;
    }
}   
    


