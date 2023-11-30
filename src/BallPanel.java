import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class BallPanel extends JPanel {
    private final Image img;
    private int xCoord;
    private int yCoord;
    private Dimension preferredSize;

    private boolean dirXRight = true;
    private boolean dirYDown = true;
    BallPanel(){
        this.img = new ImageIcon("resources/chrome_ball.png").getImage();
        this.xCoord = -1;
        this.yCoord = -1;
        this.preferredSize = new Dimension(300,200);
    }

    public void left() {
        xCoord -= 5;
        repaint();
    }
    public void right() {
        xCoord += 5;
        repaint();
    }
    public void up() {
        yCoord -= 5;
        repaint();
    }
    public void down() {
        yCoord += 5;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return preferredSize;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(img, xCoord, yCoord, this);
    }

    public void move() throws InterruptedException {

        int width = 400;
        int height = 400;

        while(true) {

            if((dirXRight && xCoord+125>width) || (!dirXRight && xCoord-125<0))
                dirXRight=!dirXRight;

            if((dirYDown && yCoord+125>height) || (!dirYDown && yCoord-125<0))
                dirYDown=!dirYDown;


            if(dirXRight)
                right();
            else
                left();

            if(dirYDown)
                down();
            else
                up();

            Thread.sleep(50);
        }
    }
}
