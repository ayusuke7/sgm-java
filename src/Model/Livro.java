/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author YU7
 */
public class Livro {

    private int Id;
    private String testamento;
    private String nomeLivro;
    private String abreviacao;

    /**
     * @return the abreviacao
     */
    public String getAbreviacao() {
        return abreviacao;
    }

    /**
     * @param abreviacao the abreviacao to set
     */
    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }
    
    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the testamento
     */
    public String getTestamento() {
        return testamento;
    }

    /**
     * @param testamento the testamento to set
     */
    public void setTestamento(String testamento) {
        this.testamento = testamento;
    }

    /**
     * @return the nomeLivro
     */
    public String getNomeLivro() {
        return nomeLivro;
    }

    /**
     * @param nomeLivro the nomeLivro to set
     */
    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }
    
    
    
}
