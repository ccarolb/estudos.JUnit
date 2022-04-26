package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveSerDeTresPorCentoDoSalarioComDesempenhoADesejar() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Carol", LocalDate.now(), new BigDecimal(2000));

       reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("2060.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDeQuinzePorCentoDoSalarioComDesempenhoBom() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Carol", LocalDate.now(), new BigDecimal(2000));

        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("2300.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDeVintePorCentoDoSalarioComDesempenhoOtimo() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Carol", LocalDate.now(), new BigDecimal(2000));

        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("2400.00"), funcionario.getSalario());
    }
}
