import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<FoodInADish<Food>> fruits = new ArrayList<FoodInADish<Food>>();
        fruits.add(new FoodInADish<Food>(new Fruit("apple", 0.182, true),DishColor.GREEN));
        fruits.add(new FoodInADish<Food>(new Fruit("banana", 0.118, true),DishColor.BLUE));
        fruits.add(new FoodInADish<Food>(new Vegetable("pepper", 0.123, true),DishColor.BLACK));

        Collections.sort(fruits);
        for(FoodInADish f : fruits){
            System.out.println(f.toString());
        }
    }
}