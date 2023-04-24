package classes;


public class Nodo {
	private Aviao dado;
	private int tempo;
	private Nodo prox;
	
	public Nodo(Aviao dado) {
		this.dado = dado;
		this.prox = null;
	}

	public Aviao getDado() {
		return dado;
	}

	public void setDado(Aviao dado) {
		this.dado = dado;
	}

	public Nodo getProx() {
		return prox;
	}

	public void setProx(Nodo prox) {
		this.prox = prox;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
}
