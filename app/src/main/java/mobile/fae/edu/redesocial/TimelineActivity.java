package mobile.fae.edu.redesocial;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import edu.fae.util.JsonListDownloadAsyncTask;
import edu.fae.util.JsonParse;
import mobile.fae.edu.redesocial.adapter.PostArrayAdapter;
import mobile.fae.edu.redesocial.model.Perfil;
import mobile.fae.edu.redesocial.model.Post;
import mobile.fae.edu.redesocial.parser.PostParser;


public class TimelineActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet("http://www.robsonluz.com.br/stream/index.json");
        HttpResponse response = null;
        HttpEntity entity = null;
        PostParser parser = new PostParser();
        ArrayList<Post> posts = new ArrayList<Post>();
        try {
            response = client.execute(get);
            entity = response.getEntity();
            String s = EntityUtils.toString(entity);

            JSONArray array = new JSONArray(s);

            if(array.length() == 0){
                Toast.makeText(this, "Não existem posts em sua timeline", Toast.LENGTH_LONG).show();
                return;
            }

            for (int i = 0; i < array.length(); i++)
                posts.add(parser.parse(array.getJSONObject(i)));

            


        } catch (IOException e) {
            Toast.makeText(this, "Não foi possível obter dados do serviço", Toast.LENGTH_LONG).show();
        } catch (NullPointerException e){
            Toast.makeText(this, "Ocorreu um erro durante a execução do programa", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            Toast.makeText(this, "Não foi possível processar a resposta do servidor", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_new_post) {
            Toast.makeText(this, "TODO: abrir formulário para inclusão de novo post", Toast.LENGTH_LONG).show();
            return true;
        }

        if(id == R.id.action_refresh_timeline){
            Toast.makeText(this, "TODO: refresh tela timeline", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
