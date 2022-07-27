/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepanel;

import java.awt.Color;
import java.awt.Font;
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
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;

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
        
     
          
          gdd.drawImage(imagem, 0, 0, null);
        
     
        for (int i = 0; i < getFormas().size();i++){
            Forma f = getFormas().get(i);
            f.Desenha(gdd);
            
        }
        
        
        
        
        
        gdd.setColor(Color.WHITE);
        gdd.drawString("Pontuação :", 20, 20);
        gdd.drawString("Perdidas: " + perdidas, 20, 40);
        gdd.drawString("Coletadas: " + coletadas, 20, 60);
        gdd.drawString("Tempo: " + tempo/1000, 20, 80);
        
        gdd.setFont(new Font("defaut",Font.BOLD,35));
        gdd.drawString("Missão: Salvar os Engenheiros!!!!!", 200, 35);
              
        
        
    }
 
}