package uet.oop.bomberman.gui.Menu;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.gui.Frame;
import uet.oop.bomberman.gui.InforDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Help extends JMenu {

    public Help(Frame frame)  {
        super("Help");

        //How to play

        JMenuItem instructions = new JMenuItem("How to play");
        instructions.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        instructions.addActionListener(new MenuActionListener(frame));

        add(instructions);

        //Information

        JMenuItem about = new JMenuItem("About");
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        about.addActionListener(new MenuActionListener(frame));

        add(about);

    }

    class MenuActionListener implements ActionListener {
        public Frame _frame;
        public MenuActionListener(Frame frame) {
            _frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("How to play")) {
                new InforDialog(_frame, "How to play",
                        "Movement: W,A,S,D or UP,DOWN, RIGHT, LEFT\nPut Bombs: SPACE, X",
                        JOptionPane.QUESTION_MESSAGE);
            }

            if(e.getActionCommand().equals("About")) {
                new InforDialog(_frame, "About",
                        "Author: Hoang Thi Linh\n " +
                                "Group 1 - INT2204 6\n",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
}
