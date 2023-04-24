package br.edu.femass.model;

public class Especialidade {
    private String nome;
    private Boolean ativo;

    public Especialidade(){
        
    }



  public Especialidade(String nome)  {

    this.nome = nome;
    this.ativo = true;
  }

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

@Override
public String toString() {
    return this.nome;
}

public Boolean getAtivo() {
    return ativo;
}

public void setAtivo(Boolean ativo) {
    this.ativo = ativo;
}



/*public Especialidade get(int index) {
    for (Especialidade sym : scope.getEspecialidade(NON_RECURSIVE)) {
        if (!unwanted(sym) && (index-- == 0))
            return sym;
    }
    throw new IndexOutOfBoundsException();
}



private boolean unwanted(Especialidade sym) {
    return false;
}*/
  
}
