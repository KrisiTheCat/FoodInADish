import javax.swing.*;
import java.io.IOException;

abstract class DrawableObj {
    int xCoord;
    int yCoord;
    int width;
    int height;
    public abstract JPanel draw() throws IOException;
}
