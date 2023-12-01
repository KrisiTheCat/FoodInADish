import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Main {
    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setTitle("Banking app");
        frame.setSize(490,260);
        frame.setLayout(null);

        JPanel allPnl = new JPanel();

        List<FoodInADish<Food>> fruits = new ArrayList<FoodInADish<Food>>();
        fruits.add(new FoodInADish<Food>(new Fruit("blueberry", 0.182, true),DishColor.GREEN));
        fruits.add(new FoodInADish<Food>(new Fruit("banana", 0.118, true),DishColor.BLUE));
        fruits.add(new FoodInADish<Food>(new Vegetable("pepper", 0.123, true),DishColor.BLACK));

        Collections.sort(fruits);
        int x = 0;
        for(FoodInADish f : fruits){
            JPanel newpanel = f.draw();
            newpanel.setBounds(x,0,200,200);
            x+=200;
            frame.add(newpanel);
        }

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}