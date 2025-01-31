package testsEntity;

import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinancingTests { //nome da classe que estou testando, com sufixo tests

    //test1
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
    //test2
    @Test
    public void ConstructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {

        //para excecoes faz isso //poe o class para o nome da excecao //no meio das chaves coloco a chamada do metodo nesse caso o construtor
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 20);
        });
    }

    //test3
    @Test
    public void setTotalAmountShouldSetDataWhenValidData(){

        //arrange
        Financing f = new Financing(100000.0, 2000.0, 80);

        //act //nesse test o exemplo é menor do que os cem mil, pq ja daria pra financiar sem problemas, testo um valor menor que cem mil, nao deve dar erro
        f.setTotalAmount(90000.0);

        //assert
        Assertions.assertEquals(90000.0, f.getTotalAmount());
    }
    //test4
    @Test
    public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 80); //valor limite pra aceitar o financiamento
            f.setTotalAmount(110000.0); //vou setar o valor acima, justamente pra nao aceitar o financiamento
        });
    }

    //test5
    @Test
    public void setIncomeShouldSetDataWhenValidData(){

        //arrange
        Financing f = new Financing(100000.0, 2000.0, 80); //2000 é o salario mais baixo ter financiamento

        //act
        f.setIncome(3000.0);//3000 é mais facil ainda dele conseguir financiamento

        //assert
        Assertions.assertEquals(3000.0, f.getIncome());
    }
    //test6
    @Test
    public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 80); //2000 é salario limite pra ter o financiamento
            f.setIncome(1000.0); //vou setar o valor abaixo no salario justamente pra nao aceitar o financiamento
        });
    }

    //test7
    @Test
    public void setMonthsShouldSetDataWhenValidData(){

        //arrange
        Financing f = new Financing(100000.0, 2000.0, 80); //80 é o tempo minimo pra ter financiamento

        //act
        f.setMonths(81);//100 é maior que 80 entao vai aceitar o financiamento

        //assert
        Assertions.assertEquals(81, f.getMonths());
    }
    //test8
    @Test
    public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing f = new Financing(100000.0, 2000.0, 80); //80 é o tempo minimo pra ter financiamento
            f.setMonths(60); //60 sao poucos meses pra aceitar o financiamento, é menos que os 80
        });
    }

    //test9
    @Test
    public void entryShouldCalculateEntryCorrectly(){ //valor de entrada é 20% do total do financiamento

        //arrange
        Financing f = new Financing(100000.0, 2000.0, 80);

        //act

        //assert
        Assertions.assertEquals(20000.0, f.entry());
    }

    //test10
    @Test
    public void quotaShouldCalculateQuotaCorrectly(){

        //arrange
        Financing f = new Financing(100000.0, 2000.0, 80);

        //act

        //assert
        Assertions.assertEquals(1000.0, f.quota());
    }


}
