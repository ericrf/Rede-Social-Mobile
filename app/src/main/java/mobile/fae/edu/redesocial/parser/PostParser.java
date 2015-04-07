package mobile.fae.edu.redesocial.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.fae.util.JsonParse;
import mobile.fae.edu.redesocial.model.Comentario;
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

        ComentarioArrayParser parser = new ComentarioArrayParser();

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date updatedAt = json.has("updated_at") ? format.parse(json.getString("updated_at")) : null;
            format.applyPattern("dd/MM/yyyy HH:mm");
            post.setUpdatedAt(format.format(updatedAt));

            post.setComentarios(parser.parse(json.getJSONArray("comentarios")));

        } catch (ParseException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return post;
    }
}
