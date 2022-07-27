
package gamepanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
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
        Image imagem2 = new ImageIcon("Nave.jpg").getImage();
      
         
        
        gdd.setColor(Color.white);
        gdd.drawImage(imagem2,  (int) getMx(), (int) getMy() ,getX(), getY(), null);
        gdd.fillRect((int) getMx(),(int) getMy(), getX(), getY());
       
    }

    @Override
    public void Deslocamento(double x, double y, int limit_x, int limit_y) {
    }

}
