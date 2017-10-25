/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author paabl
 */
public class Normalizar {
   
    public double ndcx, ndcy,Xmax, Xmin, Ymax, Ymin, dcx, dcy;
    private int ndh, ndv;
    
    public Normalizar(int buffWidth, int buffHeight)
    {
        this.Xmax = (buffWidth / 2);
        this.Xmin = -(buffWidth/ 2);
        this.Ymax = (buffHeight / 2);
        this.Ymin = -(buffHeight / 2);
        this.ndh = buffWidth;
        this.ndv = buffHeight;
    }

    /*
        O método getCoordDispositivo() recebe como parâmetro um objeto que representa o ponto(x,y) no sistema de coordenadas do mundo 
        Retorna um objeto que representa o ponto(x,y) no sitema de coordenadas do dispositivo
    */
    public Ponto getCoordDispositivo(Ponto coordDoMundo) {
       
        userToNdc(coordDoMundo);
        Ponto coordDoDispositivo = ndcToDc();
        return coordDoDispositivo;      
    }

    
    private void userToNdc(Ponto coordDoMundo) {
        ndcy = ((coordDoMundo.getY() - Ymin) / (Ymax - Ymin));
        ndcx = ((coordDoMundo.getX() - Xmin) / (Xmax - Xmin));
    }

    private Ponto ndcToDc() {
        dcx = ndcx*(ndh-1);
        dcy = ndcy*(ndv-1);
        
        return new Ponto(dcx,dcy);
    }   
}
