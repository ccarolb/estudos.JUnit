package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test //Cenário 1: salario > 10000 => bônus = 0
    public void bonusDeveSerZeroParaSalarioAcimaDeDezMil() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Carol", LocalDate.now(), new BigDecimal(12000));

        //Verifica se o método calcularBonus de bonusService lança uma exceção IllegalArgumentException caso o bonus for para funcionário c/ salário > 10k
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));

    }

    @Test //Cenário 1: salario < 10000 => bônus = 10% do salário
    public void bonusDeveSerZeroParaSalarioMenorQueDezMil() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Carol", LocalDate.now(), new BigDecimal(2000));

        BigDecimal bonus = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal(200), bonus);


    }

    @Test //Cenário 3: salario = 10000 => bônus = 10% do salário => 1000;
    public void bonusDeveSerMilParaSalarioIgualADezMil() {
        BonusService bonusService = new BonusService();

        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Carol", LocalDate.now(), new BigDecimal(10000)));

        assertEquals(new BigDecimal(1000), bonus);
    }


}
