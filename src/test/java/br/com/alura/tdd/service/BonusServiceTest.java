package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {
    private BonusService bonusService;

    @BeforeEach
    public void inicializar() {
        this.bonusService = new BonusService();
    }

    @Test //Cenário 1: salario > 10000 => bônus = 0
    public void bonusDeveSerZeroParaSalarioAcimaDeDezMil() {
        try {
            bonusService.calcularBonus(new Funcionario("Carol", LocalDate.now(), new BigDecimal(12000)));
            fail("Não encontrou exceção");
        } catch (IllegalArgumentException illegalArgumentException) {
            assertEquals("Funcionário com salário acima de R$10.000,00 não pode receber bônus.", illegalArgumentException.getMessage());
        }
    }

    @Test //Cenário 1: salario < 10000 => bônus = 10% do salário
    public void bonusDeveSerDezPorCentoParaSalarioMenorQueDezMil() {
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Carol", LocalDate.now(), new BigDecimal(5000)));
        assertEquals(new BigDecimal(500), bonus);
    }

    @Test //Cenário 3: salario = 10000 => bônus = 10% do salário => 1000;
    public void bonusDeveSerMilParaSalarioIgualADezMil() {
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Carol", LocalDate.now(), new BigDecimal(10000)));
        assertEquals(new BigDecimal(1000), bonus);
    }


}
