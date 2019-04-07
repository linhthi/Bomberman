package uet.oop.bomberman.gui;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.gui.Menu.Menu;

import javax.swing.*;
import java.awt.*;

/**
 * Swing Frame chứa toàn bộ các component
 */
public class Frame extends JFrame {
	
	public GamePanel _gamepane;
	private JPanel _containerpane;
	private InfoPanel _infopanel;
	
	private Game _game;

	public Frame() {
		setJMenuBar(new Menu(this));

		_containerpane = new JPanel(new BorderLayout());
		_gamepane = new GamePanel(this);
		_infopanel = new InfoPanel(_gamepane.getGame());
		
		_containerpane.add(_infopanel, BorderLayout.PAGE_START);
		_containerpane.add(_gamepane, BorderLayout.PAGE_END);
		
		_game = _gamepane.getGame();
		
		add(_containerpane);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);	
		
		_game.start();
	}
	
	public void setTime(int time) {
		_infopanel.setTime(time);
	}
	
	public void setPoints(int points) {
		_infopanel.setPoints(points);
	}

	public void setLives(int lives) {
		_infopanel.setLives(lives);
	}
        
        public void setLevel(int level) {
                _infopanel.setLevel(level);
        }

	public void newGame(){
		_game.getBoard().newGame();
	}

	public void pauseGame(){
		_game.getBoard().gamePause();
	}

	public void resumeGame(){
		_game.getBoard().gameResume();
	}
}