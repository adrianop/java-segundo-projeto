/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepanel;

import java.awt.Graphics2D;

/**
 *
 * @author Aluno
 */
public interface Forma {
    public double getMy();
    public double getMx();
    public void Desenha(Graphics2D gdd);
    public void Deslocamento(double x,double y,int limit_x,int limit_y);
    //public int Cod();
    
    
}