package testsEntity;

import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// nome da classe que estou testando, com sufixo tests
public class FinancingTests {

    // teste de construtor para dados validos
    @Test
    public void ConstructorShouldCreateObjectWhenValidData() {

        //arrange
        //act
        Financing f = new Financing(100000.0, 2000.0, 80);

        //assert
        Assertions.assertEquals(100000.0, f.getTotalAmount());
        Assertions.assertEquals(2000.0, f.getIncome());
        Assertions.assertEquals(80, f.getMonths());
    }

    // teste de construtor para dados invalidos
    @Test
    public void ConstructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {

        //para excecoes faz isso //poe o class para o nome da excecao //no meio das chaves coloco a chamada do metodo nesse caso o construtor
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 20);
        });
    }

    // teste para setTotalAmount quando tem dados validos
    @Test
    public void setTotalAmountShouldSetDataWhenValidData(){

        //arrange
        Financing f = new Financing(100000.0, 2000.0, 80);

        //act. valor menor que cem mil passa no teste, pois é possível financiar.
        f.setTotalAmount(90000.0);

        //assert
        Assertions.assertEquals(90000.0, f.getTotalAmount());
    }

    // teste para setTotalAmount para dados inválidos
    @Test
    public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData(){

        // valor limite pra aceitar o financiamento é cem mil. se colocar 110 mil não vai aprovar
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 80);
            f.setTotalAmount(110000.0);
        });
    }

    // teste setIncome quando tem dados validos
    @Test
    public void setIncomeShouldSetDataWhenValidData(){

        //arrange. 2000 é um salario ok e baixo para ter financiamento, acima disso vai financiar facil
        Financing f = new Financing(100000.0, 2000.0, 80);

        //act. 3000 é mais facil ainda para fazer o financiamento, pois o salário fica mais alto
        f.setIncome(3000.0);

        //assert
        Assertions.assertEquals(3000.0, f.getIncome());
    }
    // teste setIncome para valores inválidos
    @Test
    public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData(){

        // 2000 é salario mais baixo pra ter o financiamento
        // vou setar o valor abaixo no salario, para nao aceitar o financiamento
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 80);
            f.setIncome(1000.0);
        });
    }

    // teste setMonths para valores válidos
    @Test
    public void setMonthsShouldSetDataWhenValidData(){

        //arrange. 80 é o n° mínimo de meses para o financiamento ser aprovado
        Financing f = new Financing(100000.0, 2000.0, 80);

        //act. 100 é maior que 80 entao vai aceitar o financiamento
        f.setMonths(81);

        //assert
        Assertions.assertEquals(81, f.getMonths());
    }

    // teste setMonths para dados inválidos
    @Test
    public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData(){

        // 80 é o n° mínimo de meses para ter financiamento
        // 60 meses esta abaixo do mínimo para aceitar o financiamento
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 80);
            f.setMonths(60);
        });
    }

    // teste entry para dados validos
    @Test
    public void entryShouldCalculateEntryCorrectly(){ //valor de entrada é 20% do total do financiamento

        //arrange. 2mil é o salário mínimo para ter financiamento
        Financing f = new Financing(100000.0, 2000.0, 80);

        //act
        // não tem act, pois o método é chamado direto no assert. o método entry é auxiliar, não é método de atributo da classe.

        //assert. esse método entry() não é um get Entry pois ele não é método de atributo da classe.
        Assertions.assertEquals(20000.0, f.entry());
    }

    // teste quota para dados válidos
    @Test
    public void quotaShouldCalculateQuotaCorrectly(){

        //arrange
        Financing f = new Financing(100000.0, 2000.0, 80);

        //act
        // não tem act. o método quota é um método auxiliar. não é método de atributo da classe.

        //assert
        Assertions.assertEquals(1000.0, f.quota());
    }
}
