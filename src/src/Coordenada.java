package src;


public class Coordenada {
    private final int vertical;
    private final int horizontal;
    
    public Coordenada(int x, int y ){
        horizontal = x;    
        vertical = y;
    }
    
    public int getX(){
        return horizontal;
    }
    
    public int getY(){
        return vertical;
    }
}
