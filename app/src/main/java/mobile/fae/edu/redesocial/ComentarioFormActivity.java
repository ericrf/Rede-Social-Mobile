package mobile.fae.edu.redesocial;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import edu.fae.util.http.PostAsyncTask;
import edu.fae.util.http.PostRequest;
import mobile.fae.edu.redesocial.JsonResultHandler.InserirComentarioPostJsonResultHandler;
import mobile.fae.edu.redesocial.util.Constants;


public class ComentarioFormActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario_form);
    }

    public void inserirComentario(View view){
        Long postId = (Long) getIntent().getExtras().get("postId");
        String texto = ((EditText) findViewById(R.id.edit_text_comentario_form_texto)).getText().toString();

        InserirComentarioPostJsonResultHandler handler = new InserirComentarioPostJsonResultHandler(this);
        PostAsyncTask task = new PostAsyncTask(handler, this);

        PostRequest request = new PostRequest(Constants.COMENTARIO_ADD_SERVICE_URL);
        request.addParam("postId", postId);
        request.addParam("texto", texto);

        task.execute(request);
    }
}
