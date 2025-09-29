package br.edu.insper.desagil.pi.freela;

public class DataHorario extends Momento{
    private int hora;
    private int minuto;
    private Data data;

    public DataHorario(Data data) {
        this.data = data;
        this.minuto = 0;
        this.hora = 0;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void atualiza(int novaHora, int novoMinuto){
        if (novaHora < 0 || novaHora >23){
            novaHora = super.ajusta(novaHora,0,23);
        }
        if (novoMinuto < 0 || novoMinuto > 59){
            novoMinuto = super.ajusta(novoMinuto,0,59);
        }
        this.hora = novaHora;
        this.minuto = novoMinuto;
    }

    @Override
    public int minutos(){
        int minutosPas = data.minutos();
        minutosPas+= (hora*60);
        minutosPas+= (minuto);
        return minutosPas;
    }
}
