package entities;

public class Financing {

	private Double totalAmount;
	private Double income;
	private Integer months;
	
	public Financing(Double totalAmount, Double income, Integer months) {
		validateFinancing(totalAmount, income, months);
		this.totalAmount = totalAmount;
		this.income = income;
		this.months = months;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		validateFinancing(totalAmount, income, months);
		this.totalAmount = totalAmount;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		validateFinancing(totalAmount, income, months);
		this.income = income;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		validateFinancing(totalAmount, income, months);
		this.months = months;
	}

	//funcao para o valor de entrada //entrada é de 20% do valor total do financiamento
	public Double entry() {
		return totalAmount * 0.2;
	}

	//funcao para o valor da parcela //parcela é o valor da total do financiamento ja descontado os 20% dividido pelo numero de meses
	public Double quota() {
		return (totalAmount - entry()) / months;
	}

	//funcao para ver se o valor financiado é aceitavel //é o valor do total do financiamento menos os 20%, isso tem que ser menor do que a metade do salario dele, para ser aceito o financiamento
	private void validateFinancing(Double totalAmount, Double income, Integer months) {
		if (totalAmount * 0.8 / months > income / 2.0) {
			throw new IllegalArgumentException("A parcela não pode ser maior que a metade da renda");
		}
	}
}
