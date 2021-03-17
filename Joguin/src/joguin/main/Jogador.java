package joguin.main;

import java.awt.Graphics;

public class Jogador extends GameObject{

	//Constructor que puxamos da classe GameObject
	public Jogador(int x, int y, ID id) {
		super(x, y, id);
	
		/*Aqui puxamos a classe setX e definimos o valor 
		 * da variavel x dentro de GameObject para 100 */
		setX(100); 
	}

	public void tick() {

		
	}

	public void render(Graphics g) {
		
	}
	
}
