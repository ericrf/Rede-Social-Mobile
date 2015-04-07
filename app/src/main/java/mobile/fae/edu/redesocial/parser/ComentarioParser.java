package mobile.fae.edu.redesocial.parser;

import org.json.JSONException;
import org.json.JSONObject;

import edu.fae.util.JsonParse;
import mobile.fae.edu.redesocial.model.Comentario;

/**
 * Created by Eric on 07/04/2015.
 */
public class ComentarioParser implements JsonParse<Comentario> {
    @Override
    public Comentario parse(JSONObject json) throws JSONException {
        Comentario comentario = new Comentario();
        comentario.setId(json.has("id") ? json.getLong("id") : null);
        comentario.setTexto(json.has("texto") ? json.getString("texto") : null);
        comentario.setUpdatedAt(json.has("updated_at") ? json.getString("updated_at") : null);
        comentario.setAutor(json.getJSONObject("perfil").getString("nome"));
        return comentario;
    }
}
