package entities;

public class Financing {

	// valor total financiado
	private Double totalAmount;
	// salario da pessoa
	private Double income;
	// quantidade de meses que realizar� o financiamento
	private Integer months;
	
	public Financing(Double totalAmount, Double income, Integer months) {
		// chama o m�todo de valida��o validadeFinancing(pega o valor total e retira os 20% da entrada, e entao divide por x meses).
		validateFinancing(totalAmount, income, months);
		this.totalAmount = totalAmount;
		this.income = income;
		this.months = months;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		// chama o m�todo de valida��o
		validateFinancing(totalAmount, income, months);
		this.totalAmount = totalAmount;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		// chama o m�todo de valida��o
		validateFinancing(totalAmount, income, months);
		this.income = income;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		// chama o m�todo de valida��o
		validateFinancing(totalAmount, income, months);
		this.months = months;
	}

	// funcao para calcular o valor de entrada que � 20% do total do financiamento
	public Double entry() {
		return totalAmount * 0.2;
	}

	// funcao para calcular o valor da parcela  que � o valor total financiado sobre o n� de meses. (j� dsecontado a entrada)
	public Double quota() {
		return (totalAmount - entry()) / months;
	}

	// funcao para verificar se o valor financiado � aceitavel
	// a regra �: aceitavel = o valor do total do financiamento - a entrada(entry) tem que ser <= a metade do salario(income)
	private void validateFinancing(Double totalAmount, Double income, Integer months) {
		if (totalAmount * 0.8 / months > income / 2.0) {
			throw new IllegalArgumentException("A parcela n�o pode ser maior que a metade da renda");
		}
	}
}
