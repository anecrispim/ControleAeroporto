package classes;


public class Fila {
	private Nodo inicio = null;
	private Nodo fim;
	private int tamanho = 0;
	
	public int getTamanho() {
		return tamanho;
	}
	
	public boolean estaVazio() {
		return tamanho == 0;
	}
	
	public Aviao getInicio() {
		if(!estaVazio()) {
			return inicio.getDado();
		} else {
			System.out.println("Fila está vazia");
			return null;
		}
	}
	public void mostraFila() {
		if (estaVazio()) {
			System.out.println("Lista vazia");
			return;
		}
		Nodo aux = inicio;
		while (aux != null) {
			System.out.print(aux.getDado()+" ");
			aux = aux.getProx();
		}
		System.out.println();
	}
	
	public void inserir(Aviao dado) {
		Nodo novo = new Nodo(dado);
		if (estaVazio()) {
			inicio = novo;
			fim = novo;
		} else {
			fim.setProx(novo);
			fim = novo;
		}
		tamanho++;
	}
	public Aviao remover() {
		if (estaVazio()) {
			return null;
		}
		Aviao valor = inicio.getDado();
		inicio = inicio.getProx();
		tamanho--;
		if (estaVazio()) {
			fim = null;
		}
		return valor;
	}
}
