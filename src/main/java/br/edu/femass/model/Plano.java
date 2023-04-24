
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
public void setAtivo(Boolean ativo) {
    this.ativo = ativo;
}
}