package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    //Transforma variáveis duplicadas pra cada teste em atributos
    private ReajusteService reajusteService;
    private Funcionario funcionario;

    //Cria um método que inicializa instanciando os atributos requisitos de teste
    //Anota o método com @BeforeEach, que vai inicializar o método antes de cada teste.
    @BeforeEach
    public void inicializar() {
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Carol", LocalDate.now(), new BigDecimal(2000));
    }


    @Test
    public void reajusteDeveSerDeTresPorCentoDoSalarioComDesempenhoADesejar() {
       reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
       assertEquals(new BigDecimal("2060.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDeQuinzePorCentoDoSalarioComDesempenhoBom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("2300.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDeVintePorCentoDoSalarioComDesempenhoOtimo() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("2400.00"), funcionario.getSalario());
    }
}
