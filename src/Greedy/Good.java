package Greedy;

public class Good {
    public String name;
    public int weight;
    public int price;
    public Float average;

    public Good(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.average =(float) price/weight;
    }
}
