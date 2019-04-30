package bingo;

import java.util.ArrayList;

public class Programa {

    public static void main(String[] args) {
        ArrayList<Bingo> bingos = new ArrayList<>();
        BingoClasico bingoClassic = new BingoClasico(5);
        BingoAmericano bingoAmerican = new BingoAmericano();
        bingos.add(bingoAmerican);
        bingos.add(bingoClassic);
        ArrayList<Carton> cartonesClassic = new ArrayList<>();
        ArrayList<Carton> cartonesAmerican = new ArrayList<>();
        for(int i = 0; i<bingos.size();i++){
            for(int k = 0; k<5;k++){
                if(bingos.get(i).getClass() == BingoClasico.class){
                    cartonesClassic.add(bingos.get(i).generarCarton());
                }else{
                    cartonesAmerican.add(bingos.get(i).generarCarton());
                }
            }
        }
        for(int i = 0; i<cartonesClassic.size();i++){
            System.out.println(cartonesClassic.get(i).toString());
        }
        for(int i = 0; i<cartonesAmerican.size();i++){
            System.out.println(cartonesClassic.get(i).toString());
        }
        for(int i = 0; i<bingos.size();i++){
            while(bingos.get(i).cFinalizadobingo){
                System.out.println(bingos.get(i).girarelBombo());
            }
        }
    }
    
}
