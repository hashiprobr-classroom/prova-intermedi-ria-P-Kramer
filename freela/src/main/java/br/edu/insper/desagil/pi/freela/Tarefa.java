package br.edu.insper.desagil.pi.freela;

public class Tarefa {
    private int id;
    private String descricao;
    private Momento inicio;
    private Momento fim;

    public Tarefa(int id) {
        this.id = id;
        this.descricao = "";
        this.inicio = null;
        this.fim = null;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Momento getInicio() {
        return inicio;
    }

    public Momento getFim() {
        return fim;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void atualiza (Momento novoInicio, Momento novoFim){
        int minutosPasInicio = novoInicio.minutos();
        int minutosPasFim = novoFim.minutos();

        if (minutosPasFim<minutosPasInicio){
            throw new IllegalArgumentException("O início deve ser antes do fim!");
        }

        this.inicio = novoInicio;
        this.fim = novoFim;
    }
}
