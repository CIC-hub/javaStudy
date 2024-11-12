
public class SalaryIncome extends Income{

	// TODO
	public SalaryIncome(double income) {
        super(income);
    }
	// TODO
@Override
	public double getTax() {
		
		// TODO Auto-generated method stub
		 if (income <= 5000) {
	         return 0;
	     } else if (income > 5000 && income <= 10000) {
	         return (income - 5000) * 0.1;
	     } else {
	         return (income - 10000) * 0.2 + 5000 * 0.1;
	     }	
	
	}
}
