package JavaAdvanced.ExamPrep.retake14april.classProblems.EasterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;

    private List<Egg> data;

    public Basket(String material, int capacity){
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addEgg(Egg egg) {
        this.data.add(egg);
    }
}
