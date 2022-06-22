package Model;

import java.math.BigDecimal;

public class Coordinator extends Employee {
    public Coordinator(String name, String id, int choice, BigDecimal income) {
        super(name, id, choice, income);
    }

    @Override
    protected void setIncome(BigDecimal income) {
        this.income = income.multiply(new BigDecimal("1.2"));
    }
}
