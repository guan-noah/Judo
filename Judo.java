/*
 * Judo.java
 * Noah Guan
 * 9/29/25
 * 
 * This class manages a judo game interface, allowing users to add participants.
 * It holds the different pages (home, settings, intermission, match).
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Judo{
    public static void main(String[] args) {
        JFrame interfaceHolder = new JFrame();
        JudoPanel judoPanel = new JudoPanel();
        interfaceHolder.add(judoPanel);
        interfaceHolder.setSize(800, 600);
        interfaceHolder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interfaceHolder.setVisible(true);
        //JudoParticipant participant = new JudoParticipant("Player1", "Blue", 5, 50.0);
        //participant.displayInfo();
    }
}

//simply sets up the first panel and holds the different pages. initializes JudoUtilities
class JudoPanel extends JPanel {
    public JudoPanel() {
        setLayout(new BorderLayout());
        
        add(new InteractivePanel());
    }
    class InteractivePanel extends JPanel {
        public InteractivePanel() {
            setLayout(new CardLayout());
            add(new HomePage(), "HomePage");
            add(new SettingsPage(), "SettingsPage");
            add(new IntermissionPage(), "IntermissionPage");
            add(new MatchPage(), "MatchPage");

            // Additional UI setup code here
            CardLayout cl = (CardLayout)(getLayout());
            cl.show(this, "HomePage");

            JudoUtilities.addPage("HomePage", new HomePage());
            JudoUtilities.addPage("SettingsPage", new SettingsPage());
            JudoUtilities.addPage("IntermissionPage", new IntermissionPage());
            JudoUtilities.addPage("MatchPage", new MatchPage());
            JudoUtilities.showPage("HomePage");
        }
    }
}

//pages and their UI layouts
class HomePage extends JPanel {
    public HomePage() {
        setLayout(new BorderLayout());
        // UI components for the home page
        add(new JLabel("Welcome to Judo!"), BorderLayout.NORTH);
    }
}
class SettingsPage extends JPanel {
    public SettingsPage() {
        // UI components for the settings page
        add(new JLabel("Settings Page"));
    }
}
class IntermissionPage extends JPanel {
    public IntermissionPage() {
        // UI components for the intermission page
        add(new JLabel("Intermission Page"));
    }
}
class MatchPage extends JPanel {
    public MatchPage() {
        // UI components for the match page
        add(new JLabel("Match Page"));
    }
}

// Class to represent a Judo participant
class JudoParticipant {
    private String name, beltColor;
    private boolean whiteSide;
    private int age;
    private double weight;

    //constructor with preliminary info
    public JudoParticipant(String name, String beltColor, int age, double weight) {
        this.name = name;
        this.beltColor = beltColor;
        this.whiteSide = true; // Default to white side
        this.age = age;
        this.weight = weight;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getBeltColor() {
        return beltColor;
    }

    public boolean isWhiteSide() {
        return whiteSide;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    //debugging method to display info
    public void displayInfo()
    {
        System.out.println("/tJudo Participant Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Belt Color: " + beltColor);
        System.out.println("White Side: " + (whiteSide ? "Yes" : "No"));
    }
}
