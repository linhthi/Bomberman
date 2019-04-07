/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.audio.MyAudioPlayer;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.tile.Tile;
import uet.oop.bomberman.graphics.Sprite;

/**
 *
 * @author pc
 */
public class WallItem extends Item{
    public WallItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

    @Override
	public boolean collide(Entity e) {
		// TODO: xử lý Bomber ăn Item
                if(e instanceof Bomber) {
                    Tile.hasWallItem = true;
                    MyAudioPlayer powerUpAudio = new MyAudioPlayer(MyAudioPlayer.POWER_UP);
                    powerUpAudio.play();
                    remove();
                    return false;
                    
                }
		return true;
	}

}
