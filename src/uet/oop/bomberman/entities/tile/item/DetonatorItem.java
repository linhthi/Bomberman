/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.audio.MyAudioPlayer;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;

/**
 *
 * @author pc
 */
public class DetonatorItem extends Item{
    Board _board;
    public DetonatorItem(int x, int y, Sprite sprite, Board board) {
		super(x, y, sprite);
                _board = board;
	}

    @Override
	public boolean collide(Entity e) {
		// TODO: xử lý Bomber ăn Item
                if(e instanceof Bomber) {
                    _board.addLives(1);
                    MyAudioPlayer powerUpAudio = new MyAudioPlayer(MyAudioPlayer.POWER_UP);
                    powerUpAudio.play();
                    remove();
                    return false;
                    
                }
		return true;
	}
    
}
