package Alest;
import java.util.ArrayList;
import java.util.List;
// Temos que ter dois nodos um de logradouros e outro de acidentes, ao adicionar um novo acidente identificamos um nodo com o nomeLogradouro ja existe dentro dos nossos nodos de logradouro, caso ja exista simplesmente adicionamos o acidente dentro dessa lista, caso ele nao exista criamos um nodoLogradouro e colocamos como headAcidente pois ele sera o primeiro acidente da lista
public class ListaDeAcidentes {
    private class NodoLogradouro {
        private String tipoLogradouro;
        private String nomeLogradouro;
        private NodoAcidente refHeadAcidente;
        private NodoLogradouro refNextLogradouro;

        public void addLogradouro(Acidente acidente) {
            this.tipoLogradouro = acidente.getLogradouro();
            this.nomeLogradouro = acidente.getNomeLog();
            NodoAcidente node = new NodoAcidente(acidente);
            this.refHeadAcidente = node;
            this.refNextLogradouro = null;
        };

        public NodoLogradouro(Acidente acidente){
            addLogradouro(acidente);
        }

        // public List<Acidente> getListaAcidentes() {

        // }

        public String getTipoLogradouro() {
            return tipoLogradouro;
        }

        public void setTipoLogradouro(String tipoLogradouro) {
            this.tipoLogradouro = tipoLogradouro;
        }

        public String getNomeLogradouro() {
            return nomeLogradouro;
        }

        public void setNomeLogradouro(String nomeLogradouro) {
            this.nomeLogradouro = nomeLogradouro;
        }

        public NodoAcidente getRefHeadAcidente() {
            return refHeadAcidente;
        }

        public void setRefHeadAcidente(NodoAcidente refHeadAcidente) {
            this.refHeadAcidente = refHeadAcidente;
        }

        public NodoLogradouro getRefNextLogradouro() {
            return refNextLogradouro;
        }

        public void setRefNextLogradouro(NodoLogradouro refNextLogradouro) {
            this.refNextLogradouro = refNextLogradouro;
        }

        @Override
        public String toString() {
            return "NodoLogradouro [nomeLogradouro=" + nomeLogradouro + ", refHeadAcidente=" + refHeadAcidente
                    + ", refNextLogradouro=" + refNextLogradouro + ", tipoLogradouro=" + tipoLogradouro + "] \n";
        };
    }

    private class NodoAcidente {
        private Acidente elem;
        private NodoAcidente refNextAcidente;

        public NodoAcidente(Acidente elem) {
            this.elem = elem;
            this.refNextAcidente = null;
        }

        public Acidente getElem() {
            return elem;
        }

        public void setElem(Acidente elem) {
            this.elem = elem;
        }

        public NodoAcidente getRefNextAcidente() {
            return refNextAcidente;
        }

        public void setRefNextAcidente(NodoAcidente refNextAcidente) {
            this.refNextAcidente = refNextAcidente;
        }

        @Override
        public String toString() {
            return "NodoAcidente [elem=" + elem + ", refNextAcidente=" + refNextAcidente + "] \n";
        }

    }

    private NodoLogradouro refHeadLogradouro = null;
    private NodoLogradouro refTailLogradouro = null;
    private int qtdElem = 0;

    public ListaDeAcidentes() {}

    public boolean addLogradouroAcidente(Acidente acidente) {
        NodoLogradouro ant, novo, prox = null;
        NodoAcidente prev, novo1, next = null;

        if(qtdElem == 0) {
            addFirst(acidente);
            return true;
        } else if(alredyExists(acidente.getNomeLog()) == null) {
            novo = new NodoLogradouro(acidente);
            ant = refHeadLogradouro;
            for (int i = 1; i < qtdElem ; i++) {
                ant = ant.getRefNextLogradouro();
            }
            prox = ant.getRefNextLogradouro();
			ant.setRefNextLogradouro(novo);
            novo.setRefNextLogradouro(prox);
            qtdElem++;
            return true;
        } else  {
            novo1 = new NodoAcidente(acidente);
            ant = alredyExists(acidente.getNomeLog());
            prev = ant.getRefHeadAcidente();
            while(prev.getRefNextAcidente() != null) {
                prev = prev.getRefNextAcidente();
            }
            next = prev.getRefNextAcidente();
            prev.setRefNextAcidente(novo1);
            novo1.setRefNextAcidente(next);
            return true;
        }
    };

    public void addFirst(Acidente acidente) {
		NodoLogradouro novo = new NodoLogradouro(acidente);
        novo.setRefNextLogradouro(refHeadLogradouro);
		this.refHeadLogradouro = novo;
		qtdElem++;
	}


    public NodoLogradouro alredyExists(String nomeLogradouro) {
		NodoLogradouro aux;
        int i;
        
        if (refHeadLogradouro != null) {
            aux = refHeadLogradouro;
            for (i = 1; i <= qtdElem; i++){
                if(aux.getNomeLogradouro().equals(nomeLogradouro)) return aux;
                aux = aux.getRefNextLogradouro();
            }
        }

		return null;
	}

    public ArrayList<Acidente> getAcidentes(String nomeLogradouro) {
        NodoLogradouro aux;
        NodoAcidente acidente;

        ArrayList lista = new ArrayList<Acidente>();

        if (refHeadLogradouro != null) {
            aux = refHeadLogradouro;
            for (int i = 1; i <= qtdElem; i++){
                if(aux.getNomeLogradouro() == nomeLogradouro) {
                    acidente = aux.getRefHeadAcidente();
                    while (acidente.getRefNextAcidente() != null) {
                        lista.add(acidente);
                        acidente = acidente.getRefNextAcidente();
                    }
                }
                aux = aux.getRefNextLogradouro();
            }
        }
        return lista;
    }

    public NodoLogradouro getRefHeadLogradouro() {
        return refHeadLogradouro;
    }

    public void setRefHeadLogradouro(NodoLogradouro refHeadLogradouro) {
        this.refHeadLogradouro = refHeadLogradouro;
    }

    public NodoLogradouro getRefTailLogradouro() {
        return refTailLogradouro;
    }

    public void setRefTailLogradouro(NodoLogradouro refTailLogradouro) {
        this.refTailLogradouro = refTailLogradouro;
    }

    @Override
    public String toString() {
        return "ListaDeAcidentes [qtdElem=" + qtdElem + ", refHeadLogradouro=" + refHeadLogradouro
                + ", refTailLogradouro=" + refTailLogradouro + "] \n";
    };

}