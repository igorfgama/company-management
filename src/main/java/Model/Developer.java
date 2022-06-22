package Model;

import java.math.BigDecimal;
import java.util.Calendar;

public class Developer extends Employee {

    private Calendar lastBonusIncrease;

    public Developer(String name, String id, int choice, BigDecimal income) {
        super(name, id, choice, income);
    }

    @Override
    protected void setIncome(BigDecimal income) {
        this.income = income.multiply(new BigDecimal("1.2"));
    }

    private Calendar getLastBonusIncrease(){
        return lastBonusIncrease;
    }
}