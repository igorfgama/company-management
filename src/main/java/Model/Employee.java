package Model;

import java.math.BigDecimal;

public abstract class Employee {
    public static enum postCategory{
        MANAGER("Gerente de Projetos"),
        COORDINATOR("Coordenador"),
        DEVELOPER("Programador");

        private final String value;

        postCategory(String valuePost){
            value = valuePost;
        }
    }
    private String name;
    protected BigDecimal income;
    private String id;
    private int post;

    public Employee(String name, String id, int post, BigDecimal income){
        this.name = name;
        this.id = id;
        this.post = post;
        this.income = income;
    }

    public String selectPost(int choice) {
        switch (choice){
            case 1 -> { return postCategory.MANAGER.value; }
            case 2 -> { return postCategory.COORDINATOR.value; }
            case 3 -> { return postCategory.DEVELOPER.value; }
        }
        return null;
    }

    public String getName(){
        return name;
    }

    public BigDecimal getIncome(){
        return income;
    }

    public String getId() {
        return id;
    }

    public int getPost(){
        return post;
    }

    abstract protected void setIncome(BigDecimal income);
}