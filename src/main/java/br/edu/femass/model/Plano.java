
package br.edu.femass.model;

public class Plano {
    private String nomeplano;
    private Boolean ativo;

 public Plano(){
    
 }
 

  public Plano (String nomeplano)  {

    this.nomeplano = nomeplano;
    this.ativo = true;
  }

public String getNomeplano() {
    return nomeplano;
}

public void setNomeplano(String nomeplano) {
    this.nomeplano = nomeplano;
}

@Override
public String toString() {
    return this.nomeplano;
}

public Boolean getAtivo() {
    return ativo;
}
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nomeplano == null) ? 0 : nomeplano.hashCode());
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
    Plano other = (Plano) obj;
    if (nomeplano == null) {
        if (other.nomeplano != null)
            return false;
    } else if (!nomeplano.equals(other.nomeplano))
        return false;
    return true;
}


public void setAtivo(Boolean ativo) {
    this.ativo = ativo;
}
}