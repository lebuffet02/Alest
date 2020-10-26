// import java.util.ArrayList;

public class ListaDeAcidentes {

    // private ArrayList<NodeLogradouro> currentNode;
    // private ArrayList<NodeLogradouro> tailNode;
    // private ArrayList<NodeLogradouro> headNode;
    private int qtdElements = 0;

    private Node refHead = null;
    private Node refTail = null;
    private Node currentNode = null;
    
    public int size() {
		return qtdElements;
    }

    public ListaDeAcidentes(Acidentes acidente) {
        addFirst(acidente);
    }
    
    public void addFirst(Acidentes acidente) {
		Node novo = new Node(acidente);
		if (refHead == null) refTail = novo;
		novo.setNext(refHead);
		refHead = novo;
		qtdElements++;
    }
    
    public String get(int pos) {
		String res = null;
		Node aux;
		int i;

		if ((pos >= 0) && (pos < qtdElements)) {
			if (refHead != null) {
				aux = refHead;
				for (i = 1; i <= pos; i++)
					aux = aux.getNext();

				res = aux.getElem();
			}
		} else
			throw (new IndexOutOfBoundsException());

		return res;
	}


    private class Node {

        private Node refNext = null;
        private Node refPrev = null;
        private Acidente acidente;

        public Node(Acidentes acidente, Node refNext, Node refPrev) {
            this.acidente = acidente;
            this.refNext = refNext;
            this.refPrev = refPrev;
        }

        public Node getNext() {
            return refNext;
        }

        public Node getPrev() {
            return refPrev;
        }

        public Node getElem() {
            return acidente;
        }

        public setNext(Node refNext) {
            this.refNext = refNext;
        }

    }
    
}

    