package Alest;

import java.util.Comparator;

public class ObjetoLogAcidente {
    private String nomeLog;
    private int totalAcidentes;

    
    public ObjetoLogAcidente(String nomeLog, int totalAcidentes) {
        this.nomeLog = nomeLog;
        this.totalAcidentes = totalAcidentes;
    }

    public int getTotalAcidentes() {
        return totalAcidentes;
    }

    public void setTotalAcidentes(int totalAcidentes) {
        this.totalAcidentes = totalAcidentes;
    }

    public String getNomeLog() {
        return nomeLog;
    }

    public void setNomeLog(String nomeLog) {
        this.nomeLog = nomeLog;
    }

    @Override
    public String toString() {
        return "ObjetoLogAcidente [nomeLog=" + nomeLog + ", totalAcidentes=" + totalAcidentes + "] \n";
    }
}
