/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.image.BufferedImage;
import src.Coordenada;

/**
 *
 * @author paabl
 */
public class PlotaPixel {
    private final BufferedImage bufferedImage;
    private Color color;
    
    
    public PlotaPixel(BufferedImage bufferedImage){
            this.bufferedImage = bufferedImage;
            color = new Color(255, 255, 255); // Color white   
    }
        
    public void setPixel(Coordenada c){
        int rgb = color.getRGB();
        try{
            bufferedImage.setRGB(c.getX(),c.getY(), rgb);
        }
        catch(Exception e){      
            // nada
        }
    }
   
}
