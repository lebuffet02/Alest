package Alest;

/**
 * ObjetoDiaDaSemana
 */
public class ObjetoDiaDaSemana {
    private String diaDaSemana;
    private int qtdAcidentes;

    public ObjetoDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
        this.qtdAcidentes = 1;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public int getQtdAcidentes() {
        return qtdAcidentes;
    }

    public void setQtdAcidentes(int qtdAcidentes) {
        this.qtdAcidentes = qtdAcidentes;
    }

    public void aumentaAcidentes() {
        this.qtdAcidentes++;
    }

    @Override
    public String toString() {
        return "ObjetoDiaDaSemana [diaDaSemana=" + diaDaSemana + ", qtdAcidentes=" + qtdAcidentes + "] \n";
    }
}