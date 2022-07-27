/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import java.awt.geom.AffineTransform;

/**
 *
 * @author mauriferrandin
 */
class GamePanel extends JPanel{
    private List<Forma> Formas = Collections.synchronizedList(new LinkedList<>());
    
    private int perdidas = 0;
    private int coletadas = 0;
    private long tempo = 0;
    
    private int mx = 0;
    private boolean dragging = false;   

    public boolean isDragging() {
        return dragging;
    }

    public void setDragging(boolean draggin) {
        this.dragging = dragging;
    }

    public void setMx(int mx) {
        this.mx = mx;
    }

    public int getMx() {
        return mx;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public int getColetadas() {
        return coletadas;
    }

    public void setColetadas(int coletadas) {
        this.coletadas = coletadas;
    }

    public long getTempo() {
        return tempo;
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }
    
    public List<Forma> getFormas() {
        return Formas;
    }

    public void setFormas(List<Forma> Formas) {
        this.Formas = Formas;
    }   
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D gdd = (Graphics2D)g;
        Image imagem = new ImageIcon("fundojogo.jpg").getImage(); 
        Image imagem2 = new ImageIcon("Nave.jpg").getImage();
        
     
          
           gdd.drawImage(imagem2,3, 4 , null);
           gdd.drawImage(imagem, 0, 0, null);
        
        for (Forma forma: getFormas()){
            
            forma.Desenha(gdd);
           
        }
        
        //gdd.drawImage(imagem, 0, 0, null);
        gdd.drawString("Perdidas: " + perdidas, 20, 20);
        gdd.drawString("Coletadas: " + coletadas, 20, 40);
        gdd.drawString("Tempo: " + tempo/1000, 20, 60);
        
    }
 
}