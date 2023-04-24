package classes;
import java.util.Random;

public class Aeroporto {
	private Fila filaAterrissagem1;
	private Fila filaAterrissagem2;
	private Fila filaDecolagem1;
	private Fila filaDecolagem2;
	
	public void simular() {
		int tempo = 0;
		int tempoEsperaDecolagem = 0;
        int tempoEsperaAterrissagem = 0;
        int numAeronavesDeReserva = 0;
        
        this.filaAterrissagem1 = new Fila();
        this.filaAterrissagem2 = new Fila();
        
        this.filaDecolagem1 = new Fila();
        this.filaDecolagem2 = new Fila();
        
        Random gerador = new Random();
        
        tempo = gerador.nextInt(50);
        
        while (tempo != 0) {
        	tempo--;
            
            for (int i = 0; i < 4; i++) {
            	int id = (i+1) * 2;
            	int tempoMaximo = (int) (Math.random() * 10 + 5);
            	Aviao aviao = new Aviao(id);
            	aviao.setReserva(tempoMaximo);
            	
            	
            	if (this.filaAterrissagem1.getTamanho() <= this.filaAterrissagem2.getTamanho()) {
            		this.filaAterrissagem1.inserir(aviao);
            		System.out.println("Aeronave " + id + " entrou na fila de aterrissagem 1");
            	} else {
            		this.filaAterrissagem2.inserir(aviao);
            		System.out.println("Aeronave " + id + " entrou na fila de aterrissagem 2");
            	}
            }
            
            for (int i = 0; i < 4; i++) {
            	int id = (i+1) * 2;
            	Aviao aviao = new Aviao(id);
            	
            	if (this.filaDecolagem1.getTamanho() <= this.filaDecolagem2.getTamanho()) {
            		this.filaDecolagem1.inserir(aviao);
            		System.out.println("Aeronave " + id + " entrou na fila de decolagem 1");
            	} else {
            		this.filaDecolagem2.inserir(aviao);
            		System.out.println("Aeronave " + id + " entrou na fila de decolagem 2");
            	}
            }
            
        }   
	}
}
