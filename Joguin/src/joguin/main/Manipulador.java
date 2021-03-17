package joguin.main;

import java.awt.Graphics;
import java.util.LinkedList;

//Classe responsavel por manter e atualizar todos os objetos do jogo
public class Manipulador {
	
	//Permite que criemos uma lista de objetos de jogo em nosso jogo
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	
	
	/*Função criada dentro da LinkedList que permite que o ID
	 * seja capturado.*/
	public void tick() {
		for(int i = 0; i < object.size(); i++ ){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	/* As duas funções acima tem o papel de renderizar e atualizar
	 * todos os objetos do jogo*/
	
	public void addObject(GameObject object) {
		
		
	}
}
