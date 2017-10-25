/*
 * Classe reponsável por plotar um pixel na imagem passada por parâmetro no construtor da classe.
 */
package src;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author paabl
 */
public class Plota {
    
    // Esse método recebe um objeto que representa a coordenada do dispositivo e um objeto que representa uma imagem.  
    // Realiza a plotagem do ponto na imagem passada.
    public static void setPixel(BufferedImage bufferedImage, Ponto coordDispositivo){
       
        Color color = new Color(255, 255, 255); // Color white   
        int rgb = color.getRGB();
        try{ 
            bufferedImage.setRGB((int)coordDispositivo.getX(),(int)coordDispositivo.getY(), rgb);
        }
        catch(Exception e){      
            System.out.println(e.getMessage());
        }
    } 
    
    public static void drawLineDDA(BufferedImage bufferedImage, Ponto pInicial, Ponto pFinal){
            
        int length, i;
        double x,y,xInc,yInc;
        
        length = Math.abs((int)(pFinal.getX() - pInicial.getX()));
        
        if(Math.abs((int)(pFinal.getY() - pInicial.getY())) > length){
            length = Math.abs((int)(pFinal.getY() - pInicial.getY()));
        }
        
        xInc = (pFinal.getX() - pInicial.getX())/length;  
        yInc = (pFinal.getY() - pInicial.getY())/length;
        
        x = pInicial.getX();
        y = pInicial.getY();
        
        setPixel(bufferedImage, new Ponto(x,y).round());
        
        if(x < pFinal.getX()){
            while(x < pFinal.getX()){
            x +=  xInc;
            y +=  yInc;
            
            setPixel(bufferedImage, new Ponto(x,y).round());
            }
        }
        else if (x > pFinal.getX() ){
            while(x > pFinal.getX()){
                x -= -xInc;
                y += yInc;
                
                setPixel(bufferedImage, new Ponto(x,y).round());
            }
        }
        else{
            
            if(y < pFinal.getY()){
                while(y < pFinal.getY()){
                    y += yInc;
                    setPixel(bufferedImage, new Ponto(x,y).round());
                }
            return;    
            }        
            while(y > pFinal.getY()){
                y -= -yInc;
                setPixel(bufferedImage, new Ponto(x,y).round());
            }
        }
    }
    
    public static void drawLinePontoMedio(BufferedImage bufferedImage, Ponto pInicial, Ponto pFinal){
        
        
    
    }
    
}
