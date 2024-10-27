
public class SalaryIncome implements Income{

	// TODO
	double income;
	
	public SalaryIncome(double income) {
		this.income = income;
	}
	
	

	public double getTax() {
		if(income<=5000) {
			return 0;
		}else if ((income>5000)&&(income<=10000)) {
			return (income-5000)*0.1;
		}else {
			return	(income-10000)*0.2+5000*0.1;
		}
	}
}
