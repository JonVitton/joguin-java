/*
 * 
 *  ~~~~~~~COMENTADO E ADAPTADO POR @Jon Vitton~~~~~~~
 *  
 *  Como é meu primeiro estudo de POO em Java decidi comentar de forma detalhada
 *  o que algumas variaveis, funções e comandos fazem
 *  
 *  */
package joguin.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Jogo extends Canvas implements Runnable{

	private static final long serialVersionUID = 3154823909995290841L;/*Serial gerado para que a biblioteca Canvas
	seja identificada e a classe funcione*/
	
	public static final int WIDTH = 640, HEIGHT = WIDTH/12 * 9; /* Aqui é possivel definir o tamanho da janela
	o calculo em Height deixa um tamanho padronizado e bom */
	
	private Thread fio;/* Esse jogo vai rodar em torno de apenas uma 'thread' por ser algo simples, 
	não é o recomendado mas não teremos problemas*/
	
	private boolean running = false;
	
	//Puxa a classe 'janela' e apresenta a versão grafica e interativa do jogo
	public Jogo(){
		new janela(WIDTH, HEIGHT, "O JOGO! (Sim, você perdeu)", this);
		
	}
	
	//> > > > > Inicia a Thread do programa < < < < 
	public synchronized void start(){
		fio = new Thread (this); 
		fio.start(); 
		running = true;
	}
	
	//> > > Encerra a Thread < < < 
	public synchronized void stop(){
		try {
			fio.join();
			running = false;
		}catch(Exception x) {
			x.printStackTrace();//apresenta algum bug no console caso aconteça.
		}
		
	}
	
	/* Loop necessário para o funcionamento do jogo.
	 * Existem muitos modelos semelhantes a esse, adicionei comentários para que fique 
	 * bem entendivel já que vi pouquissimos lugares 
	 * explicando como ele funciona
	 * */
	public void run() {
		long tempo = System.nanoTime(); //Retorna o valor do timer do sistema em nanosegundos
		double qtdeTicks= 60.0; //Define quantos "Ticks" você quer por segundo, aqui definimos 60
		double y = 1000000000 / qtdeTicks; 
		double delta = 0; // Descreve a diferença de nanosegundos entre 'System.nanoTime' e o ultimo 'tick ()'
		long timer = System.currentTimeMillis(); //Retorna o tempo atual do sistema em milissegundos
		int frames = 0;
		while (running) {
			long agora = System.nanoTime();
			delta += (agora - tempo) / y; //Calculo que determina o valor de delta para 1
			tempo = agora;
			while(delta >=1) {
				/*Enquanto delta for igual a 1 ele gera 1 tick e depois zera seu valor 
				 * para gerar outro tick
				 * */
				tick();
				delta--;
			}
			if(running)
				render();
			frames ++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				/* A cada segundo esse if printa como a tela foi renderizada 
				 * naquele segundo e quantas atualizações tiveram, atualizações são
				 * incrementadas com cada tick().
				 * Por segundo temos 60 atualizações*/
				timer += 1000;
				System.out.println("FPS: "+ frames);
				frames = 0;
			}
		}
		stop();
	}
	
	// Renderizador de Ticks
	private void tick(){
		
		
	}
	
	// Limitador do valor do FPS
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);//Aqui é definido o numero de Buffers criados
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH, HEIGHT);
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]){
		
		new Jogo();
		
	}
}
