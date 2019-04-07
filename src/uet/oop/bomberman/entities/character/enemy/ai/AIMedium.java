package uet.oop.bomberman.entities.character.enemy.ai;


import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIMedium extends AI {
	Bomber _bomber;
	Enemy _e;
	
	public AIMedium(Bomber bomber, Enemy e) {
		_bomber = bomber;
		_e = e;
	}

	@Override
	public int calculateDirection() {
		// TODO: cài đặt thuật toán tìm đường đi
                // Nếu enemy cùng hàng hoặc cùng cột với bomber thì nó sẽ đuổi theo
                // Nếu không thì nó sẽ di chuyển random giống với AILow
                if (_bomber == null) return random.nextInt(4);
                if (checkSameCulWithBomer()) {
                    if (_bomber.getY() < _e.getY()) 
                        return 0;
                    else return 2;
                }
                if (checkSameRowWithBomber()) {
                    if (_bomber.getX() < _e.getX())
                        return 3;
                    else return 1;
                }
                return random.nextInt(4);
        }
        // Kiểm tra xem enemy có nằm cùng hàng với bomber hay không
        public boolean checkSameRowWithBomber() {
               if (_bomber.getY() == _e.getY())
                   return true;
               return false;
        }
        // Kiểm tra xem enemy có nằm cùng cột với bomber hay không
        public boolean checkSameCulWithBomer() {
                if (_bomber.getX() == _e.getX())
                   return true;
               return false;
        }
        
}
