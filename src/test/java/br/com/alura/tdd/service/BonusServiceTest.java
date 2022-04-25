package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @Test //Cenário 1: salario > 10000 => bônus = 0
    public void bonusDeveSerZeroParaSalarioAcimaDeDezMil() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Carol", LocalDate.now(), new BigDecimal(12000));

        BigDecimal bonus = bonusService.calcularBonus(funcionario);

        assertEquals(BigDecimal.ZERO, bonus);

    }

    @Test //Cenário 1: salario < 10000 => bônus = 10% do salário
    public void bonusDeveSerZeroParaSalarioMenorQueDezMil() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Carol", LocalDate.now(), new BigDecimal(2000));

        BigDecimal bonus = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal(200), bonus);


    }


}
