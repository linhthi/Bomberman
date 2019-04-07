package uet.oop.bomberman.level;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.LayeredEntity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Balloon;
import uet.oop.bomberman.entities.character.enemy.Doll;
import uet.oop.bomberman.entities.character.enemy.Kondoria;
import uet.oop.bomberman.entities.character.enemy.Minvo;
import uet.oop.bomberman.entities.character.enemy.Oneal;
import uet.oop.bomberman.entities.tile.Grass;
import uet.oop.bomberman.entities.tile.Portal;
import uet.oop.bomberman.entities.tile.Wall;
import uet.oop.bomberman.entities.tile.destroyable.Brick;
import uet.oop.bomberman.entities.tile.item.BombItem;
import uet.oop.bomberman.entities.tile.item.DetonatorItem;
import uet.oop.bomberman.entities.tile.item.FlameItem;
import uet.oop.bomberman.entities.tile.item.SpeedItem;
import uet.oop.bomberman.entities.tile.item.WallItem;
import uet.oop.bomberman.exceptions.LoadLevelException;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

public class FileLevelLoader extends LevelLoader {

	/**
	 * Ma trận chứa thông tin bản đồ, mỗi phần tử lưu giá trị kí tự đọc được
	 * từ ma trận bản đồ trong tệp cấu hình
	 */
	private static char[][] _map;
	
	public FileLevelLoader(Board board, int level) throws LoadLevelException {
		super(board, level);
	}
	
	@Override
	public void loadLevel(int level) throws LoadLevelException{
		// TODO: đọc dữ liệu từ tệp cấu hình /levels/Level{level}.txt
		// TODO: cập nhật các giá trị đọc được vào _width, _height, _level, _map
                // Note: đã xong
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                URL url = loader.getResource("./levels/Level"+level+".txt");
                String path = url.getPath();

                System.out.println(path);


                String line = "";
                try {
                    FileReader fileReader =
                            new FileReader(path);

                    BufferedReader bufferedReader =
                            new BufferedReader(fileReader);

                    line = bufferedReader.readLine();

                    String data[]=line.split(" ");

                    _level = Integer.parseInt(data[0]);
                    _height = Integer.parseInt(data[1]);
                    _width = Integer.parseInt(data[2]);
                    
                    _map = new char[_height][_width]; 
                    for (int i = 0; i < _height; i++) {
                        line = bufferedReader.readLine();
                        for (int j = 0; j < _width; j++) {
                            _map[i][j] = line.charAt(j);
                            System.out.print(_map[i][j]);
                        }
                        System.out.println("");
                    }
                    
                    

                    bufferedReader.close();
                } catch (IOException e) {

			throw new LoadLevelException("Error loading level " + path, e);

		}
                
	}

	@Override
	public void createEntities() {
		// TODO: tạo các Entity của màn chơi
		// TODO: sau khi tạo xong, gọi _board.addEntity() để thêm Entity vào game

		// TODO: phần code mẫu ở dưới để hướng dẫn cách thêm các loại Entity vào game
		// TODO: hãy xóa nó khi hoàn thành chức năng load màn chơi từ tệp cấu hình
		// thêm Wall
                
                for (int x = 0; x < getWidth(); x++) {
                    for (int y = 0; y < getHeight(); y++) {
                        int pos = x + y * getWidth();
                        Sprite sprite = Sprite.grass;
                        switch (_map[y][x]) {
                            case '#':
                                _board.addEntity(x + y * _width, new LayeredEntity(x, y, new Wall(x, y, Sprite.wall)));
                                break;
                            case '*':
                                int xB = x, yB = y;
                                _board.addEntity(xB + yB * _width,
                                        new LayeredEntity(xB, yB,
                                                new Grass(xB, yB, Sprite.grass),
                                                new Brick(xB, yB, Sprite.brick)
                                        )
                                );
                                break;
                            case 'x':
                                int xP = x , yP = y;
				_board.addEntity(xP + yP * _width,
                                                new LayeredEntity(xP, yP,
                                                    new Grass(xP, yP, Sprite.grass),
                                                    new Portal(xP, yP,_board, Sprite.portal),
                                                    new Brick(xP, yP, Sprite.brick)
								)
						);
	
                                break;
                            case 'p':
                                int xBomber = x, yBomber = y;
                                _board.addCharacter(new Bomber(Coordinates.tileToPixel(xBomber), Coordinates.tileToPixel(yBomber) + Game.TILES_SIZE, _board));
                                Screen.setOffset(0, 0);
                                _board.addEntity(xBomber + yBomber * _width, new Grass(xBomber, yBomber, Sprite.grass));
                                break;
                            case '1':
                                int xE = x, yE = y;
                                _board.addCharacter(new Balloon(Coordinates.tileToPixel(xE), Coordinates.tileToPixel(yE) + Game.TILES_SIZE, _board));
                                _board.addEntity(xE + yE * _width, new Grass(xE, yE, Sprite.grass));
                                break;
                            
                            case '2':
                                
                                _board.addCharacter(new Oneal(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                                _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));
                                break;
                            
                            case '3':
                                _board.addCharacter(new Doll(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                                _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));
                               break;
                            
                            case '4':
                                _board.addCharacter(new Kondoria(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                                _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));
                                break;
                                
                            case '5':
                                _board.addCharacter(new Minvo(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                                _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));
                                break;
                                case 'f':
                                _board.addEntity(pos,
                                        new LayeredEntity(x, y,
                                                new Grass(x, y, Sprite.grass),
                                                new FlameItem(x, y, Sprite.powerup_flames),
                                                new Brick(x, y, Sprite.brick)
                                        )
                                );
                                break;
                                
                            case 'b':
                                _board.addEntity(pos,
                                        new LayeredEntity(x, y,
                                                new Grass(x, y, Sprite.grass),
                                                new BombItem(x, y, Sprite.powerup_bombs),
                                                new Brick(x, y, Sprite.brick)
                                        )
                                );
                                break;
                                
                            case 's':
                                _board.addEntity(pos,
                                        new LayeredEntity(x, y,
                                                new Grass(x, y, Sprite.grass),
                                                new SpeedItem(x, y, Sprite.powerup_speed),
                                                new Brick(x, y, Sprite.brick)
                                        )
                                );
                                break;
                                
                            case 'w':
                                _board.addEntity(pos, 
                                        new LayeredEntity(x, y, 
                                                new Grass(x, y, Sprite.grass),
                                                new WallItem(x,y, Sprite.powerup_wallpass),
                                                new Brick(x, y, Sprite.brick)
                                        )
                                );
                                break;
                            
                            case 'd':
                                _board.addEntity(pos, 
                                        new LayeredEntity(x, y, 
                                                new Grass(x, y, Sprite.grass),
                                                new DetonatorItem(x,y, Sprite.powerup_detonator, _board),
                                                new Brick(x, y, Sprite.brick)
                                        )
                                );
                                break;
                                
                            default:
                                _board.addEntity(pos, new Grass(x, y, sprite));
                                break;
                }
            }
        }
		
        }
}
