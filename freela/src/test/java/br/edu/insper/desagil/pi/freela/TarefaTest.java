package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TarefaTest {
    private Tarefa tarefa;

    @BeforeEach
    void setup(){
        tarefa = new Tarefa(1);
    }

    @Test
    void constroi(){
        assertEquals(1, tarefa.getId());
        assertEquals("", tarefa.getDescricao());
        assertNull(tarefa.getInicio());
        assertNull(tarefa.getFim());
    }

    @Test
    void mudaDescricao(){
        tarefa.setDescricao("Olá, essa é a nova descrição!");
        assertEquals("Olá, essa é a nova descrição!", tarefa.getDescricao());
    }

    @Test
    void momentosValidos(){
        Data inicio =  dataFalsaComMinutos(0);
        Data fim = dataFalsaComMinutos(500000);

        tarefa.atualiza(inicio,fim);
        assertEquals(inicio,tarefa.getInicio());
        assertEquals(fim, tarefa.getFim());
    }

    @Test
    void momentosInvalidos(){
        Data inicio =  dataFalsaComMinutos(500000);
        Data fim = dataFalsaComMinutos(0);

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,()->{
                    tarefa.atualiza(inicio,fim);
                });
        assertEquals("O início deve ser antes do fim!", e.getMessage());

    }

    private Data dataFalsaComMinutos(int min){
        Data data = mock(Data.class);
        when(data.minutos()).thenReturn(min);
        return data;
    }
}
