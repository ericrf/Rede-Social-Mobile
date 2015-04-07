package mobile.fae.edu.redesocial.model;

import java.io.Serializable;

/**
 * Created by Eric on 07/04/2015.
 */
public class Comentario extends AbstractModel implements Serializable{

    private String texto;
    private String autor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
