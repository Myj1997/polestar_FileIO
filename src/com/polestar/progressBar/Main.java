package com.polestar.progressBar;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String [] args) {

        ProgressTest progressTest = new ProgressTest();

        Dimension dimension = new Dimension(500,200);
        JFrame frame = new JFrame();
        frame.setSize(dimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(progressTest.getPanel(), BorderLayout.CENTER);
        frame.setVisible(true);

    }
}
