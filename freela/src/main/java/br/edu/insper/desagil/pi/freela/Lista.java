package br.edu.insper.desagil.pi.freela;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    private List<Tarefa> tarefas;

    public Lista() {
        this.tarefas = new ArrayList<>();
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void atualiza(Tarefa tarefa){
        int idAtual = tarefa.getId();
        List<Integer> idsLista= new ArrayList<>();
        for (Tarefa tarefaDaLista: tarefas){
            idsLista.add(tarefaDaLista.getId());
        }
        if (!idsLista.contains(idAtual)){
            tarefas.add(tarefa);
        }
    }
}
