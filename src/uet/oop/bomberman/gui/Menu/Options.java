package uet.oop.bomberman.gui.Menu;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.gui.Frame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Options extends JMenu {

    Frame _frame;

    public Options(Frame frame) {
        super("Options");

        _frame = frame;

        JMenuItem pause = new JMenuItem("Pause");
        pause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        pause.addActionListener(new MenuActionListener(frame));
        add(pause);

        JMenuItem resume = new JMenuItem("Resume");
        resume.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        resume.addActionListener(new MenuActionListener(frame));
        add(resume);

    }

    class MenuActionListener implements ActionListener {
        public Frame _frame;
        public MenuActionListener(Frame frame) {
            _frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("Pause")) {
                _frame.pauseGame();
            }

            if(e.getActionCommand().equals("Resume")) {
                _frame.resumeGame();
            }
        }
    }
}
