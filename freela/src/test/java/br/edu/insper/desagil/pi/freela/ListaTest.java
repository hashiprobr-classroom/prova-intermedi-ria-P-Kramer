package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListaTest {
    private Lista lista;

    @BeforeEach
    void setUp(){
        lista = new Lista();
    }

    @Test
    void constroi(){
        assertEquals(0, lista.getTarefas().size());
    }

    @Test
    void adicionaIguais(){
        lista.atualiza(tarefaFalsaComId(1));
        lista.atualiza(tarefaFalsaComId(1));
        assertEquals(1, lista.getTarefas().size());
    }

    @Test
    void adicionaDiferentes(){
        lista.atualiza(tarefaFalsaComId(1));
        lista.atualiza(tarefaFalsaComId(2));
        assertEquals(2, lista.getTarefas().size());
    }
    private Tarefa tarefaFalsaComId(int id){
        Tarefa tarefa = mock(Tarefa.class);
        when(tarefa.getId()).thenReturn(id);
        return tarefa;
    }
}
