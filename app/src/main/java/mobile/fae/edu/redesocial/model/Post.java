package mobile.fae.edu.redesocial.model;

/**
 * Created by Eric on 02/04/2015.
 */
public class Post extends AbstractModel {
    private Perfil perfil;
    private String texto;

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
}
