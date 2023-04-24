package classes;
import java.util.Random;

public class Aeroporto {
	private Fila filaAterrissagem1;
	private Fila filaAterrissagem2;
	private Fila filaDecolagem1;
	private Fila filaDecolagem2;
	private int contadorAvioes = 0;
	
	// métodos para gerar de 0 a 2 aviões que chegam para aterrissar e que serão inseridos as filas de aterrissagem 1 e 2
	public void geraAviaoAterrissagem() {
		Random gerador = new Random();
		int numAvioes = gerador.nextInt(3);
		for (int i = 0; i < numAvioes; i++) {
			int id = this.contadorAvioes + 1;
			int combustivel = (int)(Math.random() * 20 ) + 1;
			Aviao aviao = new Aviao(id);
        	aviao.setReserva(combustivel);
        	if (this.filaAterrissagem2.getTamanho() < this.filaAterrissagem1.getTamanho()) {
        		this.filaAterrissagem2.inserir(aviao);
        		System.out.println("Aeronave " + id + " entrou na fila de aterrissagem 2");
        		System.out.println("A fila de aterrissagem 2 possui atualmente os seguintes aviões: ");
        		this.filaAterrissagem2.mostraFila();
        	} else {
        		this.filaAterrissagem1.inserir(aviao);
        		System.out.println("Aeronave " + id + " entrou na fila de aterrissagem 1");
        		System.out.println("A fila de aterrissagem 1 possui atualmente os seguintes aviões: ");
        		this.filaAterrissagem1.mostraFila();
        	}
        	this.contadorAvioes++;
		}
	}
	
	// métodos para gerar de 0 a 2 aviões que chegam para decolar e que serão inseridos as filas de decolagem 1 e 2
	public void geraAviaoDecolagem() {
		Random gerador = new Random();
		int numAvioes = gerador.nextInt(3);
		for (int i = 0; i < numAvioes; i++) {
			int id = this.contadorAvioes + 1;
			Aviao aviao = new Aviao(id);
        	if (this.filaDecolagem2.getTamanho() < this.filaDecolagem1.getTamanho()) {
        		this.filaDecolagem2.inserir(aviao);
        		System.out.println("Aeronave " + id + " entrou na fila de decolagem 2");
        		System.out.println("A fila de decolagem 2 possui atualmente os seguintes aviões: ");
        		this.filaDecolagem2.mostraFila();
        	} else {
        		this.filaDecolagem1.inserir(aviao);
        		System.out.println("Aeronave " + id + " entrou na fila de decolagem 1");
        		System.out.println("A fila de decolagem 1 possui atualmente os seguintes aviões: ");
        		this.filaDecolagem1.mostraFila();
        	}
        	this.contadorAvioes++;
		}
	}
	
	// método para quando algum avião for aterrissar ele será removido da fila de aterrissagem que estiver
	public void aterrissar() {
		if (this.filaAterrissagem2.getTamanho() > this.filaAterrissagem1.getTamanho()) {
    		System.out.println("Aeronave " + this.filaAterrissagem2.getInicioDado().getId() + " aterrissou na pista 2");
    		this.filaAterrissagem2.remover();
    		System.out.println("A fila de aterrissagem 2 possui atualmente os seguintes aviões: ");
    		this.filaAterrissagem2.mostraFila();
    	} else {
    		System.out.println("Aeronave " + this.filaAterrissagem1.getInicioDado().getId() + " aterrissou na pista 1");
    		this.filaAterrissagem1.remover();
    		System.out.println("A fila de aterrissagem 1 possui atualmente os seguintes aviões: ");
    		this.filaAterrissagem1.mostraFila();
    	}
	}
	
	// método para quando algum avião for decolar ele será removido da fila de decolagem que estiver
	public void decolar() {
		if (this.filaDecolagem2.getTamanho() > this.filaDecolagem1.getTamanho()) {
    		System.out.println("Aeronave " + this.filaDecolagem2.getInicioDado().getId() + " decolou na pista 2");
    		this.filaDecolagem2.remover();
    		System.out.println("A fila de decolagem 2 possui atualmente os seguintes aviões: ");
    		this.filaDecolagem2.mostraFila();
    	} else {
    		System.out.println("Aeronave " + this.filaDecolagem1.getInicioDado().getId() + " decolou na pista 1");
    		this.filaDecolagem1.remover();
    		System.out.println("A fila de decolagem 1 possui atualmente os seguintes aviões: ");
    		this.filaDecolagem1.mostraFila();
    	}
	}
	
	// a cada tempo o combustível de cada avião nas filas de aterrissagem será diminuido 1
	public void diminuiCombustivel() {
		if (!this.filaAterrissagem1.estaVazio()) {
			Nodo aux = this.filaAterrissagem1.getInicio();
			while (aux != null) {
				aux.getDado().setReserva(aux.getDado().getReserva() - 1);
				aux = aux.getProx();
			}
		}
		
		if (!this.filaAterrissagem2.estaVazio()) {
			Nodo aux = this.filaAterrissagem2.getInicio();
			while (aux != null) {
				aux.getDado().setReserva(aux.getDado().getReserva() - 1);
				aux = aux.getProx();
			}
		}
	}
	
	public void simular() {
		/*int tempo = 0;
		int tempoEsperaDecolagem = 0;
        int tempoEsperaAterrissagem = 0;
        int numAeronavesDeReserva = 0;*/
        
        this.filaAterrissagem1 = new Fila();
        this.filaAterrissagem2 = new Fila();
        
        this.filaDecolagem1 = new Fila();
        this.filaDecolagem2 = new Fila();
        
        this.geraAviaoAterrissagem();
        this.geraAviaoDecolagem();
        this.aterrissar();
        this.decolar();
        this.diminuiCombustivel();
        
         
	}
}
