import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingBall extends JFrame implements ActionListener {
    private JButton leftBtn = new JButton("Left");
    private JButton rightBtn = new JButton("Right");
    private JButton upBtn = new JButton("Up");
    private JButton downBtn = new JButton("Down");

    public BallPanel getBallPanel() {
        return ballPanel;
    }

    private BallPanel ballPanel = new BallPanel();

    public MovingBall(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(leftBtn);
        buttonPanel.add(rightBtn);
        buttonPanel.add(upBtn);
        buttonPanel.add(downBtn);

        ballPanel.setBackground(Color.WHITE);
        this.add(ballPanel);
        this.add(buttonPanel, BorderLayout.SOUTH);
        leftBtn.addActionListener(this);
        rightBtn.addActionListener(this);
        upBtn.addActionListener(this);
        downBtn.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent buttonPressed) {
        if(buttonPressed.getSource() == leftBtn)
            ballPanel.left();
        else if(buttonPressed.getSource() == rightBtn)
            ballPanel.right();
        else if(buttonPressed.getSource() == upBtn)
            ballPanel.up();
        else if(buttonPressed.getSource() == downBtn)
            ballPanel.down();
    }
}
