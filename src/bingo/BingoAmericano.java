package bingo;

import java.util.Collections;

public class BingoAmericano extends Bingo{
    public BingoAmericano() {
        super();
        
        bolaMayor = 75;
        tCarton = 25;
    }
    @Override
    public int girarelBombo(){
        int bola;
        do{
            Collections.shuffle(bombo);
            bola = ultimaBola;
            ultimaBola = bombo.get(0);
        }while(bola+1 != ultimaBola);
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
    @Override
    public boolean esAceptable(Carton o) {
        Integer suma = 0;
        for(int i = 0 ; i < o.getNumeros().size();i++){
            suma += o.getNumeros().get(i);
        }
        suma = suma/o.getNumeros().size();
        return (suma <=50);
    }
}
