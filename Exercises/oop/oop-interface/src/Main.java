
/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		// TODO: 用接口给一个有工资收入和稿费收入的小伙伴算税:
        double totalTax = 0;
        Income[] incomes = {new SalaryIncome(12000), new RoyaltyIncome(5000)};
        for (Income income : incomes) {
            totalTax += income.getTax();
        }
        System.out.println(totalTax);
	}

}
