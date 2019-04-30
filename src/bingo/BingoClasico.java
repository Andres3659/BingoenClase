package bingo;

import java.util.ArrayList;
import java.util.Collections;

public class BingoClasico extends Bingo {
    private int restrincion;
    public BingoClasico(int limite) {
        super();
        bolaMayor = 90;
        this.restrincion= limite;
        tCarton = 15;
        carton.ensureCapacity(limite);
        cartonBingo.ensureCapacity(limite);
    }
    @Override
    public Carton generarCarton(){
        ArrayList<Integer> numerosPosibles = new ArrayList<>();
        ArrayList<Integer> numeros = new ArrayList<>();
        Carton o;
        do{
            for( int i=1;i<=bolaMayor;i++){
                numerosPosibles.add(i);    
            }
            Collections.shuffle(numerosPosibles);
           for( int i=1;i<=tCarton;i++){
                numeros.add(numerosPosibles.get(i));
            }
            o = new Carton(numeros);
        }while(esAceptable(o) && carton.contains(o));
        carton.add(o);
        return o;
    }
    @Override
    public boolean esAceptable(Carton o) {
        int a = o.getNumeros().get(0);
        for(int i = 1;i< o.getNumeros().size();i++){
            if(a + 1 == o.getNumeros().get(i)){
                return false;
            }
            a = o.getNumeros().get(i);
        }
        return true;
    }

    public int getFaltantes() {
        return restrincion-carton.size();
    }
    
}
