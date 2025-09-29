package br.edu.insper.desagil.pi.freela;

public abstract class Momento {
    public int ajusta(int valor, int minimo, int maximo){
        if (valor<minimo){
            return minimo;
        } else if (valor>maximo) {
            return maximo;
        } else{
            return valor;
        }
    }

    public abstract int minutos();
}
