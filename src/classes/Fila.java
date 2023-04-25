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
	
	
	public Nodo getInicio() {
		return inicio;
	}

	public Aviao getInicioDado() {
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

	public Fila ordenarFilaPorReserva(Fila fila, Aeroporto aero) {
		if (estaVazio()) {
			System.out.println("Lista vazia");
			return null;
		}
		Fila novaFila = new Fila();
		while (!fila.estaVazio()) {
			if (fila.getInicioDado().getReserva() < 5) {
				aero.setNumAeronavesDeReserva(+1);
			}
			Aviao elemento = fila.remover();
			Nodo aux = novaFila.getInicio();
			Nodo anterior = null;
			boolean inserido = false;
			
			while (aux != null && !inserido) {
				if (elemento.getReserva() <= aux.getDado().getReserva()) {
					Nodo novo = new Nodo(elemento);
					novo.setProx(aux);
					if (anterior == null) {
						novaFila.inicio = novo;
					} else {
						anterior.setProx(novo);
					}
					inserido = true;
				}
				anterior = aux;
				aux = aux.getProx();
			}
			
			if (!inserido) {
				novaFila.inserir(elemento);
			}
		}
		return novaFila;
	}
}
