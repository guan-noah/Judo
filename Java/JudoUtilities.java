package Java;
/*
 * Judo.java
 * Noah Guan
 * 9/29/25
 * 
 * This class provides utility functions for managing a judo game.
 * It acts as a data holding class to receive, store, and transfer data (like GameData in Polybound).
 */

//imports
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import java.awt.CardLayout;

//general utility class for judo game management; holds static classes and methods for data retrieval and storage
public class JudoUtilities {
    private static ArrayList<JudoParticipant> participants;//for each judo player (for playing style selection, etc)
    private static HashMap<String, JPanel> pages; //holds different pages of the interface
    private static CardLayout cardLayout; //manages page switching
    private static JudoPanel mainPanel; //main application JPanel
    private static JudoGame game; //the current judo game instance

    /*
    //private constructor to prevent instantiation
    private JudoUtilities() {
    }
    */
    //overloaded constructor to initialize the static variables once (then never use constructor again)
    public JudoUtilities(ArrayList<JudoParticipant> participantsIn, HashMap<String, JPanel> pagesIn, 
    CardLayout cardLayoutIn, JudoPanel mainPanelIn, JudoGame gameIn) {
        JudoUtilities.participants = participantsIn;
        JudoUtilities.pages = pagesIn;//needed for CardLayout page switching
        JudoUtilities.cardLayout = cardLayoutIn;//needed for CardLayout page switching
        JudoUtilities.mainPanel = mainPanelIn;//needed for CardLayout page switching
        JudoUtilities.game = gameIn;
    }

    //page management methods
    public static void addPage(String name, JPanel page) {
        if (pages == null) {
            pages = new HashMap<>();//first initialization
        }
        pages.put(name, page);
        if (mainPanel != null) {
            mainPanel.add(page, name);
        }
        else {
            System.out.println("MainPanel not set. Page added to HashMap only.");
        }
    }
    public static void showPage(String name) {
        if (cardLayout != null && mainPanel != null) {
            cardLayout.show(mainPanel, name);
        }
        else {
            System.out.println("CardLayout or MainPanel not set.");
        }
    }
    public static JPanel getPage(String name) {
        if (pages != null) {
            return pages.get(name);
        }
        return null;
    }
    //CardLayout getter and setter
    public static void setCardLayout(CardLayout layout) {
        cardLayout = layout;
    }
    public static CardLayout getCardLayout() {
        return cardLayout;
    }
    //MainPanel getter and setter
    public static void setMainPanel(JudoPanel panel) {
        mainPanel = panel;
    }
    public static JudoPanel getMainPanel() {
        return mainPanel;
    }

    //game management methods
    public static void setGame(JudoGame judoGame) {
        game = judoGame;
    }
    public static JudoGame getGame() {
        return game;
    }

    //participant management methods
    public static void addParticipant(JudoParticipant participant) {
        participants.add(participant);
    }

    public static void removeParticipant(JudoParticipant participant) {
        participants.remove(participant);
    }

    //getter for participants
    public static ArrayList<JudoParticipant> getParticipants() {
        return participants;
    }

    //debugger to print all participants
    public static void printParticipants() {
        for (JudoParticipant participant : participants) {
            participant.displayInfo();
        }
    }
}

class JudoGame {
    public void startMatch() {
        System.out.println("Judo match started!");
        // Use utilities as needed
    }
}