package Alest;

import java.time.LocalDateTime;

/**
 * Acidentes
 */
public class Acidente {

    public String logradouro;
    public String nomeLog;
    public String tipoAcidente;
    public LocalDateTime data;
    public String diaSemana;
    public int feridos;
    public int fatais;
    public int auto;
    public int taxi;
    public int lotacao;
    public int onibusUrb;
    public int onibusInt;
    public int caminhao;
    public int moto;
    public int carroca;
    public int bicicleta;
    public String tempo;
    public String turno;
    public String regiao;

    public Acidente(String logradouro, String nomeLog, String tipoAcidente, LocalDateTime data, String diaSemana,
            int feridos, int fatais, int auto, int taxi, int lotacao, int onibusUrb, int onibusInt, int caminhao,
            int moto, int carroca, int bicicleta, String tempo, String turno, String regiao) {
        this.logradouro = logradouro;
        this.nomeLog = nomeLog;
        this.tipoAcidente = tipoAcidente;
        this.data = data;
        this.diaSemana = diaSemana;
        this.feridos = feridos;
        this.fatais = fatais;
        this.auto = auto;
        this.taxi = taxi;
        this.lotacao = lotacao;
        this.onibusUrb = onibusUrb;
        this.onibusInt = onibusInt;
        this.caminhao = caminhao;
        this.moto = moto;
        this.carroca = carroca;
        this.bicicleta = bicicleta;
        this.tempo = tempo;
        this.turno = turno;
        this.regiao = regiao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNomeLog() {
        return nomeLog;
    }

    public void setNomeLog(String nomeLog) {
        this.nomeLog = nomeLog;
    }

    public String getTipoAcidente() {
        return tipoAcidente;
    }

    public void setTipoAcidente(String tipoAcidente) {
        this.tipoAcidente = tipoAcidente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getFeridos() {
        return feridos;
    }

    public void setFeridos(int feridos) {
        this.feridos = feridos;
    }

    public int getFatais() {
        return fatais;
    }

    public void setFatais(int fatais) {
        this.fatais = fatais;
    }

    public int getAuto() {
        return auto;
    }

    public void setAuto(int auto) {
        this.auto = auto;
    }

    public int getTaxi() {
        return taxi;
    }

    public void setTaxi(int taxi) {
        this.taxi = taxi;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public int getOnibusUrb() {
        return onibusUrb;
    }

    public void setOnibusUrb(int onibusUrb) {
        this.onibusUrb = onibusUrb;
    }

    public int getOnibusInt() {
        return onibusInt;
    }

    public void setOnibusInt(int onibusInt) {
        this.onibusInt = onibusInt;
    }

    public int getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(int caminhao) {
        this.caminhao = caminhao;
    }

    public int getMoto() {
        return moto;
    }

    public void setMoto(int moto) {
        this.moto = moto;
    }

    public int getCarroca() {
        return carroca;
    }

    public void setCarroca(int carroca) {
        this.carroca = carroca;
    }

    public int getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(int bicicleta) {
        this.bicicleta = bicicleta;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "nomeLogradouro= " + nomeLog + " data= " + data + " diaSemana= " + diaSemana + " \n";
    }

    

}