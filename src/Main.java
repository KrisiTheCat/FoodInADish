import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Main {
    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setTitle("In der Weihnachtsbäckerei");
        frame.setSize(1790,200);
        frame.setLayout(null);

        JPanel allPnl = new JPanel();

        List<FoodInADish<Food>> fruits = new ArrayList<FoodInADish<Food>>();
        fruits.add(new FoodInADish<Food>(new Fruit("blueberry", 0.103, true),DishColor.GREEN));
        fruits.add(new FoodInADish<Food>(new Fruit("banana", 0.118, true),DishColor.BLUE));
        fruits.add(new FoodInADish<Food>(new Vegetable("pepper", 0.123, true),DishColor.DARKBLUE));
        fruits.add(new FoodInADish<Food>(new Fruit("strawberry", 0.009, true),DishColor.BLUE));
        fruits.add(new FoodInADish<Food>(new Vegetable("lettuce", 0.324, true),DishColor.YELLOW));

        Collections.sort(fruits);
        int x = 0;
        for(FoodInADish f : fruits){
            JPanel newpanel = f.draw();
            newpanel.setBounds(x,0,200,160);
            x+=200;
            frame.add(newpanel);
        }

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}