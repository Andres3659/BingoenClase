package bingo;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Bingo {
    protected int bolaMayor;
    protected ArrayList<Integer> bombo;
    protected ArrayList<Integer> bolasExtraidas;
    protected int ultimaBola;
    protected int tCarton; 
    protected boolean cFinalizadobingo;
    protected ArrayList<Carton> carton;
    protected ArrayList<Carton> cartonBingo;
    
    
    public Bingo() {
        this.bombo = new ArrayList<>();
        for( int i=1;i<=bolaMayor;i++){
            bombo.add(i);    
        }
        
        bolasExtraidas = new ArrayList<>();
        carton = new ArrayList<>();
        cartonBingo = new ArrayList<>();
        this.ultimaBola = 0;
        cFinalizadobingo = false;
    }
    public Carton generarCarton(){
        ArrayList<Integer> nPosibles = new ArrayList<>();
        ArrayList<Integer> primerosNumeros = new ArrayList<>();
        Carton o;
        do{
            for( int i=1;i<=bolaMayor;i++){
                nPosibles.add(i);    
            }
            Collections.shuffle(nPosibles);
            for( int i=1;i<=tCarton;i++){
                primerosNumeros.add(nPosibles.get(i));
            }
            o = new Carton(primerosNumeros);
            System.out.println(o.toString());
        }while(esAceptable(o) && carton.contains(o));
        carton.add(o);
        return o;
    }
    public abstract boolean esAceptable(Carton o);
    public int girarelBombo(){
        Collections.shuffle(bombo);
        ultimaBola = bombo.get(0);
        bolasExtraidas.add(bombo.get(0));
        bombo.remove(0);
        for(int i = 0; i<carton.size();i++){
            if(carton.get(i).comprobar(bolasExtraidas)){
                cartonBingo.add(carton.get(i));
                this.cFinalizadobingo = true;
            }
        }
        return ultimaBola;
    }

    public int getBolaMayor() {
        return bolaMayor;
    }

    public ArrayList<Integer> getBombo() {
        return bombo;
    }

    public ArrayList<Integer> getBolasExtraidas() {
        return bolasExtraidas;
    }

    public int getUltimaBola() {
        return ultimaBola;
    }

    public int getTamanioCarton() {
        return tCarton;
    }

    public ArrayList<Carton> getCartonesBingo() {
        return cartonBingo;
    }
    
}
