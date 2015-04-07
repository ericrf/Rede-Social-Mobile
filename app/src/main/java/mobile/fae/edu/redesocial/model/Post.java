package mobile.fae.edu.redesocial.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Eric on 02/04/2015.
 */
public class Post extends AbstractModel implements Serializable {
    private Perfil perfil;
    private String texto;
    private List<Comentario> comentarios;

    public String getNomeAutor(){
        return perfil.getNome();
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
