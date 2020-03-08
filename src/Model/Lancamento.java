/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author AYU7-WN
 */
public class Lancamento {
    
    private int id;
    private int idMembro;
    private int idIgreja;
    private String mesRef;
    private String dizimo;
    private String oferta;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idMembro
     */
    public int getIdMembro() {
        return idMembro;
    }

    /**
     * @param idMembro the idMembro to set
     */
    public void setIdMembro(int idMembro) {
        this.idMembro = idMembro;
    }

    /**
     * @return the mesRef
     */
    public String getMesRef() {
        return mesRef;
    }

    /**
     * @param mesRef the mesRef to set
     */
    public void setMesRef(String mesRef) {
        this.mesRef = mesRef;
    }

    /**
     * @return the dizimo
     */
    public String getDizimo() {
        return dizimo;
    }

    /**
     * @param dizimo the dizimo to set
     */
    public void setDizimo(String dizimo) {
        this.dizimo = dizimo;
    }

    /**
     * @return the oferta
     */
    public String getOferta() {
        return oferta;
    }

    /**
     * @param oferta the oferta to set
     */
    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    /**
     * @return the idIgreja
     */
    public int getIdIgreja() {
        return idIgreja;
    }

    /**
     * @param idIgreja the idIgreja to set
     */
    public void setIdIgreja(int idIgreja) {
        this.idIgreja = idIgreja;
    }
    
}
