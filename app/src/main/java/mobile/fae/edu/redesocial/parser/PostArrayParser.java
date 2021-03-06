package mobile.fae.edu.redesocial.parser;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import mobile.fae.edu.redesocial.adapter.PostArrayAdapter;
import mobile.fae.edu.redesocial.model.Post;

/**
 * Created by Eric on 06/04/2015.
 */
public class PostArrayParser {
    private Context context;
    private ArrayAdapter adapter;

    public PostArrayParser(Context context, ArrayAdapter adapter) {
        this.context = context;
        this.adapter = adapter;
    }

    public void parse(JSONArray array) {
        PostParser parser = new PostParser();
        for(int i = 0; i < array.length(); i++)
            try {
                adapter.add(parser.parse(array.getJSONObject(i)));
            } catch (JSONException e) {
                Toast.makeText(context, "Não foi possível processar a resposta do servidor", Toast.LENGTH_LONG).show();
            }
    }
}
