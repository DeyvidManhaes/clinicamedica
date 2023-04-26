package br.edu.femass.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Agenda {

    private Long codagendamento;
    private Medico medico;
    private Especialidade especialidade;
    private Paciente paciente;
    private Plano plano;
    private String datahoje;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm ");
    private String dateagendamento;
    private Boolean ativo;

    private static Long ultimocod = 0L;

    public Agenda(){
        
    }

    public Agenda(
            Medico medico,
            Especialidade especialidade,
            Paciente paciente,
            Plano plano,
            String dateagendamento) {

        this.medico = medico;
        this.especialidade = especialidade;
        this.paciente = paciente;
        this.plano = plano;
        this.datahoje = sdf.format(new Date());
        this.dateagendamento = sdf.format(dateagendamento);
        this.ativo = true;

        this.codagendamento = ultimocod + 1;
        ultimocod++;

    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getDatahoje() {
        return datahoje;
    }

    public Long getCodagendamento() {
        return codagendamento;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codagendamento == null) ? 0 : codagendamento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Agenda other = (Agenda) obj;
        if (codagendamento == null) {
            if (other.codagendamento != null)
                return false;
        } else if (!codagendamento.equals(other.codagendamento))
            return false;
        return true;
    }

    public String getDataagendamento() {
        return dateagendamento;
    }

    public void setDataagendamento(String data1) {
        this.dateagendamento = sdf.format(data1);
    }

    @Override
    public String toString() {
        return "Agendamento: " + codagendamento + ", Paciente: " + paciente.getNome() +
                ", Médico: " + medico.getNome() + ", Consulta agendada: " + dateagendamento;
    }

}
