package bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Carton {
    private ArrayList<Integer> numeros;
    private int tamanio;

    public Carton(ArrayList<Integer> numeros) {
        this.numeros = (ArrayList<Integer>) numeros.clone();
        Collections.sort(numeros);
        this.tamanio = numeros.size();
    }
    
    public boolean comprobar(ArrayList<Integer> bolasUsadas) {
        return numeros.containsAll(bolasUsadas); 
     }
    @Override
    public String toString(){
        String texto;
        texto = numeros.toString();
        return texto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carton other = (Carton) obj;
        if (this.tamanio != other.tamanio) {
            return false;
        }
        return numeros.containsAll(other.numeros);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numeros);
        hash = 47 * hash + this.tamanio;
        return hash;
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public int getTamano() {
        return tamanio;
    }
    
}
