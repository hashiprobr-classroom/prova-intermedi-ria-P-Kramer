package br.edu.insper.desagil.pi.freela;

import java.util.HashMap;
import java.util.Map;

public class Data extends Momento{

    private int ano;
    private int mes;
    private int dia;
    private Map<Integer,Integer> limite;

    public Data() {
        this.ano = 1970;
        this.mes = 1;
        this.dia = 1;
        Map<Integer, Integer> limite = new HashMap<>();
        limite.put(1, 31);
        limite.put(2, 28);
        limite.put(3, 31);
        limite.put(4, 30);
        limite.put(5, 31);
        limite.put(6, 30);
        limite.put(7, 31);
        limite.put(8, 31);
        limite.put(9, 30);
        limite.put(10, 31);
        limite.put(11, 30);
        limite.put(12, 31);
        this.limite = limite;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public void atualiza(int novoAno, int novoMes, int novoDia){
        if (novoAno<1970 || novoAno>2070){
            novoAno = super.ajusta(novoAno,1970,2070);
        }
        if (novoMes<1 || novoMes>12){
            novoMes = super.ajusta(novoMes,1,12);
        }
        if (novoDia<1 || novoDia> limite.get(novoMes)){
            novoDia = super.ajusta(novoDia,1, limite.get(novoMes));
        }
        this.ano = novoAno;
        this.mes = novoMes;
        this.dia = novoDia;
    }

    @Override
    public int minutos(){
        int minutosPas = 0;
        int horasPas = 0;
        int diasPas = 0;
        int mesesPas =0;
        int anosPas=0;

        anosPas = ano - 1970;
        mesesPas = mes - 1;
        diasPas = dia - 1;

        diasPas+= (anosPas*365);

        for (int i = 1; i<=mesesPas;i++){
            diasPas+= limite.get(i);
        }
        horasPas = diasPas*24;
        minutosPas = horasPas*60;

        return  minutosPas;
    }
}


