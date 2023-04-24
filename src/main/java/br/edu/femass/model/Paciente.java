package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import br.edu.femass.utils.Cpf;

public class Paciente {
    private String nome;
    private String endereco;
    private String cpf;
    private Long prontuario;
    private List<String> telefones = new ArrayList<String>();
    private Boolean ativo;
    private String email;

    private static Long ultimoprontuario = 0L;

    public Paciente(){

    }

    public Paciente(String nome, String cpf,String telefone){

        
        if (Cpf.isCpf(cpf)==false)throw new IllegalArgumentException("CPF Inválido");
        this.nome = nome;        
        this.cpf= cpf;
        this.telefones.add(telefone);
        this.ativo = true;

        this.prontuario = ultimoprontuario+1;
        ultimoprontuario ++;
    
    }


    public String getNome() {
        return nome;
    }



    public String getCpf() {
        return cpf;
    }



    public Long getProntuario() {
        return prontuario;
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

    public void adicionarTelefone (String telefone) {
        
        this.telefones.add(telefone);
    }

    public void removerTelefone (String telefone) throws Exception {
        if (telefones.size()==1){
            throw new Exception("O Paciente tem que ter pelo menos um telefone");
        }
        this.telefones.remove(telefone);
    }

    @Override
    public String toString() {
        return this.nome;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Paciente other = (Paciente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    
    public static void atualizarUltimoProntuario(Set<Paciente> pacientes) {
        for (Paciente paciente: pacientes) {
            if (paciente.getProntuario().longValue()>ultimoprontuario) {
                ultimoprontuario = paciente.getProntuario();
            }
        }
    }
    

}
