package Java;
/*
GeneraJudoUtilities.java
Utility classes for general Judo application use
Extensions of standard Swing components
Noah Guan
12/27/25
*/

//imports 
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

//class to give file the proper name
public class GeneralJudoUtilities {
    private GeneralJudoUtilities() {
    }
}
class BarLabel extends JLabel {
    public BarLabel(String text) {
        super(text);
    }
}
//this class uses Polybound's Button class as reference
class Button extends JButton {
    protected boolean isHoveredOver = false;
    //constructor with text, buttonListener and size. 
    // large size: 200x60, medium size: 150x45, small size: 100x30 
    // font size in float: large: 24.0f, medium: 18.0f, small: 14.0f
    public Button(String text, Dimension buttonSize, float fontSize, ActionListener buttonListener) {
        super(text);
        addActionListener(buttonListener);
        setFont(getFont().deriveFont(fontSize));
        setPreferredSize(buttonSize);

        setFocusPainted(false);//removes the focus border when clicked
        //mouse listener for hover effect
        ButtonHandler handler = new ButtonHandler();
        addMouseListener(handler);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //draw border
        if (isHoveredOver) {
            g2d.setColor(Color.BLUE);//border color when hovered
        } else {
            g2d.setColor(Color.BLACK);//default border color
        }
        g2d.setStroke(new BasicStroke(3));//set shape border to 3px thickness
        g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);//draw rectangle border over the panel behind component
        g2d.dispose();//dispose graphics context
    }
    //Button handler class. Implements MouseListener for hover effect; only purpose is to set isHoveredOver boolean
    class ButtonHandler implements MouseListener {
        public void mouseEntered(MouseEvent e) {
            isHoveredOver = true;
            repaint();
        }
        public void mouseExited(MouseEvent e) {
            isHoveredOver = false;
            repaint();
        }
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }
}
//used Polybound's Popup class as reference
class Popup extends JPanel {
    protected JFrame popupFrame;
    protected JPanel popupPanel;
    protected String popupTitle;
    public Popup(String titleIn) {
        super();
        popupTitle = titleIn;

        popupFrame = getFrame();
        popupPanel = getPopupPanel();

        popupFrame.setContentPane(popupPanel);//set background of frame to popup panel
        setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 2)); // Black border with thickness 2
        setBackground(java.awt.Color.LIGHT_GRAY); // Light gray background
    }
    //this method sets up the JFrame; can be overridden for customization
    protected JFrame getFrame() {
        JFrame output = new JFrame(popupTitle);

        //frame setup
        output.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        output.setSize(600, 500);
        output.setLocationRelativeTo(null); // Center the popup on the screen

        return output;
    }
    protected JPanel getPopupPanel() {
        JPanel output = new JPanel();
        output.setLayout(new BorderLayout());

        return output;
    }
}