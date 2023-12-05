import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class FoodInADish<T> extends DrawableObj implements Comparable<FoodInADish<T>>{
    T food;
    DishColor dishColor;

    public FoodInADish() {
        this.food = (T) new Object();
        this.dishColor = DishColor.DARKBLUE;
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
        JPanel panel = new JPanel();
        panel.setLayout(null);

        BufferedImage foodImg = ImageIO.read(new File("resources/"+food.toString()+".png"));
        Image foodImg1 = makeWhiteBGToTransparent(foodImg);
        JLabel foodLbl = new JLabel(new ImageIcon(foodImg1));
        foodLbl.setBounds(0,0,200,100);

        BufferedImage dishImg = ImageIO.read(new File("resources/"+dishColor.toString().toLowerCase()+".png"));
        Image dishImg1 = makeWhiteBGToTransparent(dishImg);
        JLabel dishLbl = new JLabel(new ImageIcon(dishImg1));
        dishLbl.setBounds(0,40,200,100);

        panel.add(foodLbl);
        panel.add(dishLbl);
        return panel;
    }

    public Image makeWhiteBGToTransparent(final BufferedImage im) {
        final ImageFilter filter = new RGBImageFilter() {
            public int markerRGB = 0xFFFFFFFF;

            public final int filterRGB(final int x, final int y, final int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    return 0x00FFFFFF & rgb;
                } else {
                    return rgb;
                }
            }
        };

        final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }
}
