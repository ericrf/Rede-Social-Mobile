package mobile.fae.edu.redesocial.parser;

import org.json.JSONException;
import org.json.JSONObject;

import edu.fae.util.JsonParse;
import mobile.fae.edu.redesocial.model.Perfil;
import mobile.fae.edu.redesocial.model.Post;

/**
 * Created by Eric on 02/04/2015.
 */
public class PostParser implements JsonParse<Post> {
    @Override
    public Post parse(JSONObject json) throws JSONException {
        Post post = new Post();
        post.setId(json.has("id") ? json.getLong("id"): null);
        post.setPerfil(json.has("perfil") ? (new PerfilParser()).parse(json.getJSONObject("perfil")) : new Perfil());
        post.setTexto(json.has("texto") ? json.getString("texto") : "");
        return post;
    }
}
