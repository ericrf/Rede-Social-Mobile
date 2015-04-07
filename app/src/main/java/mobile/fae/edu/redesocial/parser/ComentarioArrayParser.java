package mobile.fae.edu.redesocial.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.fae.util.JsonParse;
import mobile.fae.edu.redesocial.model.Comentario;

/**
 * Created by Eric on 07/04/2015.
 */
public class ComentarioArrayParser {

    private ComentarioParser parser = new ComentarioParser();

    public List<Comentario> parse(JSONArray json) throws JSONException {
        ArrayList<Comentario> comentarios = new ArrayList<>();
        try{
            for(int i = 0; i < json.length() ; i++)
                comentarios.add(parser.parse(json.getJSONObject(i)));
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            return comentarios;
        }
    }
}
