
package br.com.prog3.rh;

public class Cargo {
    
    private Integer codigo;
    private String descricao;
    private Double salario;
    
    public Cargo(){}//Contrutor Padrao

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
    
    
}
