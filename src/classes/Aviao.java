package classes;

public class Aviao {
	private int id;
	private int reserva;
	
	public Aviao(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReserva() {
		return reserva;
	}
	public void setReserva(int reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aviao [id=");
		builder.append(id);
		builder.append(", reserva=");
		builder.append(reserva);
		builder.append("]");
		return builder.toString();
	}
}
