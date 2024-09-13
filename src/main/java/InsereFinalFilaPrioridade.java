import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair p = new Pair(elemento, prioridade);
		this.fila.add(p);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		int prioridade = 0;
		Pair p = this.fila.get(0);
		int index = 0;

		for(int i = 0; i < this.fila.size(); i++){
			if (this.fila.get(i).getPrioridade() > prioridade){
				prioridade = this.fila.get(i).getPrioridade();
				p = this.fila.get(i);
				index = i;
			}
		}

		this.fila.remove(index);

		return p.getElemento();
	}

}
