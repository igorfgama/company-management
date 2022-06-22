package Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarDataProvider;

public class Developer extends Employee {

    private LocalDate lastBonusIncrease;
    //private Calendar calendar = Calendar().getInstance();

    public Developer(String name, String id, int choice, BigDecimal income) {
        super(name, id, choice, income);
        lastBonusIncrease = LocalDate.now();
    }

    @Override
    protected void setIncome(BigDecimal income) {
        this.income = income.multiply(new BigDecimal("1.2"));
    }

    public LocalDate getLastBonusIncrease(){
        return lastBonusIncrease;
    }
}