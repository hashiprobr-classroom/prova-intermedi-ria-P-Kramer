package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataHorarioTest {
    private DataHorario dataHorario;

    @BeforeEach
    void setUp(){
        Data dataFalsa = mock(Data.class);
        when(dataFalsa.getDia()).thenReturn(1);
        when(dataFalsa.getMes()).thenReturn(1);
        when(dataFalsa.getAno()).thenReturn(1970);
        dataHorario = new DataHorario(dataFalsa);
    }

    @Test
    void constroi(){
        assertEquals(0, dataHorario.getHora());
        assertEquals(0, dataHorario.getMinuto());
        assertEquals(0, dataHorario.minutos());
    }

    @Test
    void horarioBaixo(){
        dataHorario.atualiza(-1,-1);
        assertEquals(0, dataHorario.getHora());
        assertEquals(0, dataHorario.getMinuto());
        assertEquals(0, dataHorario.minutos());
    }

    @Test
    void horarioAlto(){
        dataHorario.atualiza(24,60);
        assertEquals(23, dataHorario.getHora());
        assertEquals(59, dataHorario.getMinuto());
        assertEquals(1439, dataHorario.minutos());
    }
}
