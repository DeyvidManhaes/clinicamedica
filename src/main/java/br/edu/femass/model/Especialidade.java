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



@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
    Especialidade other = (Especialidade) obj;
    if (nome == null) {
        if (other.nome != null)
            return false;
    } else if (!nome.equals(other.nome))
        return false;
    return true;
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
