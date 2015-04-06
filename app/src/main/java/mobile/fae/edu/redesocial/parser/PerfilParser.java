package mobile.fae.edu.redesocial.parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.fae.util.JsonParse;
import mobile.fae.edu.redesocial.model.Perfil;

/**
 * Created by Eric on 02/04/2015.
 */
public class PerfilParser implements JsonParse<Perfil> {
    @Override
    public Perfil parse(JSONObject json) throws JSONException{
        Perfil perfil = new Perfil();
        perfil.setId(json.getLong("id"));

        perfil.setCreatedAt(json.getString("created_at"));
        perfil.setUpdatedAt(json.getString("updated_at"));

        perfil.setNome(json.getString("nome"));
        perfil.setEmail(json.getString("email"));
        perfil.setSenha(json.getString("senha"));
        perfil.setFoto(json.getString("foto"));
        perfil.setSobre(json.getString("sobre"));

        return perfil;
    }
}
