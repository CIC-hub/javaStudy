public class Main {
    public static void main(String[] args) {
        double totalTax = 0;
        Income[] incomes = {new SalaryIncome(12000), new RoyaltyIncome(5000)};
        for (Income income : incomes) {
            totalTax += income.getTax();
        }
        System.out.println(totalTax);
    }
}
