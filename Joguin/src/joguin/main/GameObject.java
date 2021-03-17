package joguin.main;

import java.awt.Graphics;

// Tudo que for um objeto do jogo � referido nessa classe
public abstract class GameObject {
	/*O comando protected define que essas variaveis
	 apenas poder�o ser acessadas atrav�s de objetos herdados de Game Object */
	protected int x, y; 
	protected ID id;
	protected int veloX, veloY;

	/* Construtor para Game Object necess�rio para criar objetos como o jogador
	 * quando criamos uma instancia para nosso Game Object ser� necessario
	 * esses 3 componentes 'int x, int y, ID id'.
	 * Todo valor que for atribuido a esses par�metros ser� associado automaticamente
	 * nas variaveis protected definidas acima desse coment�rio */
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	//M�todos que n�o precisamos na classe Jogador mas est�o na classe jogador
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
	
	public ID getId() {
		return id;
	}

	public void setVeloX(int veloX) {
		this.veloX= veloX;
	}
	
	public void setVeloY(int veloY) {
		this.veloY= veloY;
	}
	
	public int getVeloX() {
		return veloX;
	}
	
	public int getVeloY() {
		return veloY;
	}
	
	
}
