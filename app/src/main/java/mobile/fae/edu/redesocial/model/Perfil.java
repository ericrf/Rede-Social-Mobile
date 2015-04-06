package mobile.fae.edu.redesocial.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Eric on 02/04/2015.
 */
public class Perfil extends AbstractModel implements Serializable {
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private String sobre;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }
}
