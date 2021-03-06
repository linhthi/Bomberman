package uet.oop.bomberman.gui.Menu;

import uet.oop.bomberman.gui.Frame;
import uet.oop.bomberman.gui.InforDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameMenu extends JMenu {

    public Frame frame;

    public GameMenu(Frame frame) {
        super("Game");
        this.frame = frame;

        //New GameMenu

        JMenuItem newgame = new JMenuItem("New Game");
        newgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newgame.addActionListener(new MenuActionListener(frame));

        add(newgame);

        //High Scores

        JMenuItem scores = new JMenuItem("Top Scores");
        scores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        scores.addActionListener(new MenuActionListener(frame));

        add(scores);
    }

    class MenuActionListener implements ActionListener {
        public Frame _frame;
        public MenuActionListener(Frame frame) {
            _frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("New Game")) {
                _frame.newGame();
            }

            if(e.getActionCommand().equals("Top Scores")) {
                new InforDialog(_frame, "Top Scores", "If i had more time..", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

}
