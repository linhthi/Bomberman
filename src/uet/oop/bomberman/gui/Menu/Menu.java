package uet.oop.bomberman.gui.Menu;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.gui.Frame;

import javax.swing.*;

public class Menu extends JMenuBar {

    public Menu(Frame frame) {
        add( new GameMenu(frame) );
        add( new Options(frame) );
        add( new Help(frame) );
    }

}
