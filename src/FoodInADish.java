import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FoodInADish<T> extends DrawableObj implements Comparable<FoodInADish<T>>{
    T food;
    DishColor dishColor;

    public FoodInADish() {
        this.food = (T) new Object();
        this.dishColor = DishColor.BLACK;
    }

    public FoodInADish(T food, DishColor dishColor) {
        this.food = food;
        this.dishColor = dishColor;
    }

    public T getFood() {
        return food;
    }

    public void setFood(T food) {
        this.food = food;
    }

    public DishColor getDishColor() {
        return dishColor;
    }

    public void setDishColor(DishColor dishColor) {
        this.dishColor = dishColor;
    }

    @Override
    public String toString(){
        return "A " + food.toString() + "(" + food.getClass() + ") in a " + dishColor + " dish";
    }

    @Override
    public int compareTo(FoodInADish<T> o) {
        if(food instanceof Fruit)
            if(o.getFood() instanceof Fruit) return compareDouble(((Food)food).getKg(),(((Food)o.getFood()).getKg()));
            else return -1;
        if(o.getFood() instanceof Fruit)
            return 1;
        return compareDouble(((Food)food).getKg(),(((Food)o.getFood()).getKg()));
    }

    int compareDouble(double a, double b){
        if(Double.compare(a,b)<0) return -1;
        else if(Double.compare(a,b)==0) return 0;
        return 1;
    }

    @Override
    public JPanel draw() throws IOException {
        //Image foodImg = new ImageIcon().getImage();
        //graphics.drawImage(img, xCoord, yCoord, this);
        JPanel panel = new JPanel();
        System.out.println("resources/"+food.toString()+".png");
        BufferedImage foodImg = ImageIO.read(new File("resources/"+food.toString()+".png"));
        JLabel foodLbl = new JLabel(new ImageIcon(foodImg));
        foodLbl.setBounds(0,0,FruitImages.valueOf(food.toString().toUpperCase()).width,FruitImages.valueOf(food.toString().toUpperCase()).height);
        panel.add(foodLbl);
        return panel;
    }
}
