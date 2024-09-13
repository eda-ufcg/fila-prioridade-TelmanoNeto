public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;
	private int capacity;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
		this.capacity = capacidade;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		Pair p = new Pair(elemento, prioridade);
		if (isFull()) throw new IllegalStateException();

		if(isEmpty()){
			this.fila[++this.last] = p;
			this.head++;
		}
		else{
			this.fila[++this.last % this.capacity] = p;
			
			int i = this.last;
			while(i > 0 && this.fila[i].getPrioridade() > this.fila[-1].getPrioridade()){
				Pair aux = this.fila[i];
				this.fila[i] = this.fila[i-1];
				this.fila[i-1] = aux;
				i--;
			}
			this.last++;
		}
		
	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		if(isEmpty()) throw new IllegalStateException();
		Pair p = this.fila[this.head];

		if(this.head + 1 == this.last){
			this.head = this.last = -1;
			
		}
		else{
			this.head++;
		}
		
		return p.getElemento();
	}

	private boolean isEmpty(){
		return this.last == -1 & this.head ==-1;
	}

	private boolean isFull(){
		return this.last + 1 == this.head;
	}

	

}
