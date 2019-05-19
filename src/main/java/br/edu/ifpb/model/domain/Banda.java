package br.edu.ifpb.model.domain;

import java.util.Objects;

public class Banda {

    private int id;
    private String localDeOrigem;
    private String nomeFantasia;

    public Banda() {
    }

    public Banda(int id, String localDeOrigem, String nomeFantasia) {
        this.id = id;
        this.localDeOrigem = localDeOrigem;
        this.nomeFantasia = nomeFantasia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banda banda = (Banda) o;
        return id == banda.id &&
                Objects.equals(localDeOrigem, banda.localDeOrigem) &&
                Objects.equals(nomeFantasia, banda.nomeFantasia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, localDeOrigem, nomeFantasia);
    }

    @Override
    public String toString() {
        return "Banda{" +
                "id=" + id +
                ", localDeOrigem='" + localDeOrigem + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                '}';
    }
}
