package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.femass.utils.Cpf;

public class Medico {
    private String nome;
    private String CRM;
    private String endereco;
    private String cpf;
    private List<String> telefones = new ArrayList<String>();
    private Boolean ativo;
    private String email;
    private Especialidade especialidades;

    public Medico(){

    }

    public Medico(String nome, String CRM, String cpf,String telefone, Especialidade especialidade){

        this.nome = nome;
        if (Cpf.isCpf(cpf)==false){
            throw new IllegalArgumentException("CPF Inválido");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.CRM = CRM;
        this.especialidades = especialidade;


        this.telefones.add(telefone);
        this.ativo = true;
 


    }



    public Especialidade getEspecialidades() {
        return especialidades;
    }

    /*public void adicionarEspecialidade (Especialidade especialidade) throws Exception {
        
        this.especialidades.add(especialidade);
    }

    public void removerEspecialidade (Especialidade especialidade) throws Exception {
        if (especialidades.size()==1){
            throw new Exception("O Médico tem que ter pelo menos uma especialidade");
        }
        this.especialidades.remove(especialidade);
    }*/

   

    public String getNome() {
        return nome;
    }



    public String getCpf() {
        return cpf;
    }



    public String getCRM() {
        return CRM;
    }

    public List<String> getTelefones() {
        return telefones;
    }



    public String getEndereco() {
        return endereco;
    }



    public Boolean getativo() {
        return ativo;
    }



    public void setativo(Boolean ativo) {
        this.ativo = ativo;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void adicionarTelefone (String telefone) throws Exception {
        
        this.telefones.add(telefone);
    }

    public void removerTelefone (String telefone) throws Exception {
        if (telefones.size()==1){
            throw new Exception("O Médico tem que ter pelo menos um telefone");
        }
        this.telefones.remove(telefone);
    }

    @Override
    public String toString() {
        return "Nome: "+ this.nome + "Especialidade: " + this.especialidades;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((CRM == null) ? 0 : CRM.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Medico other = (Medico) obj;
        if (CRM == null) {
            if (other.CRM != null)
                return false;
        } else if (!CRM.equals(other.CRM))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    

   
    

}
