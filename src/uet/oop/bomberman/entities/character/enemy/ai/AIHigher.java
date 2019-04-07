/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

/**
 *
 * @author pc
 */
public class AIHigher extends AI{
    AIMedium aiMedium;
    AIHigh aihigh;
    Board _board;
    Enemy _e;
    public AIHigher(Bomber bomber, Enemy e, Board b) {
        aiMedium = new AIMedium(bomber, e);
        aihigh = new AIHigh(e, b);
        _board = b;
        _e = e;
    }

    @Override
    public int calculateDirection() {
        if(!_board.getBombs().isEmpty()) {
            return aihigh.calculateDirection();
        }
        return aiMedium.calculateDirection();
    }

    
    
}
