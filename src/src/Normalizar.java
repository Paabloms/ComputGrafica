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
   
    private double ndcx, ndcy,Xmax, Xmin, Ymax, Ymin;
    private int ndh, ndv, dcx, dcy;
    
    public Normalizar(int buffWidth, int buffHeight)
    {
        this.Xmax = (buffWidth / 2);
        this.Xmin = -(buffWidth/ 2);
        this.Ymax = (buffHeight / 2);
        this.Ymin = -(buffHeight / 2);
        this.ndh = buffWidth;
        this.ndv = buffHeight;
    }

    public Coordenada getDcxDcy(double mundoX, double mundoY) {
       
        userToNdc(mundoX,mundoY);
        return ndcToDc();      
    }

    private void userToNdc(double mundoX, double mundoY) {
        ndcy = ((mundoY - Ymin) / (Ymax - Ymin));
        ndcx = ((mundoX - Xmin) / (Xmax - Xmin));
    }

    private Coordenada ndcToDc() {
        dcx = (int) Math.round(ndcx*(ndh-1));
        dcy = (int) Math.round(ndcy*(ndv-1));
        
        return new Coordenada(dcx,dcy);
    }   
}
