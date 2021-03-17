package joguin.main;

import java.awt.Canvas; 
import java.awt.Dimension;
import javax.swing.JFrame; /*Biblioteca do JRE que permite incluirmos o JFrame 
que é necessario para criarmos janelas*/

public class janela extends Canvas{

	private static final long serialVersionUID = -1407782618385377247L; /*Serial gerado para que a biblioteca Canvas
	seja identificada e a classe funcione*/
	
	public janela( int width, int height, String title, Jogo jogo) {
		
		JFrame janela = new JFrame(title); // Aqui definimos um nome para a variavel de nossa janela
		
		
		janela.setPreferredSize(new Dimension(width,height));// <<<<< cada um desses 3 comandos define um tamanho preferido,   
		janela.setMaximumSize(new Dimension(width,height));	// 	<<<<< máximo e 
		janela.setMinimumSize(new Dimension(width,height));// 	<<<<< minimo
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Permite que seja possivel encerrar a aplicação
		
		janela.setResizable(false); //Impede que a janela seja redimensionada para previnir probemas
		
		janela.setLocationRelativeTo(null); /*Não necessario para o funcionamento. 
		Posiciona a localidade relativa para 'NULL' permitindo que a janela inicie no centro da tela 
		e não no canto superior esquerdo*/
		
		janela.add(jogo);// Adiciona a classe 'Jogo' em nossa janela
		
		janela.setVisible(true);
		
		jogo.start();
	}

}
