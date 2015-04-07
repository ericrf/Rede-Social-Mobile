package mobile.fae.edu.redesocial;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import edu.fae.util.http.JsonResult;
import edu.fae.util.http.JsonResultHandler;
import edu.fae.util.http.PostAsyncTask;
import edu.fae.util.http.PostRequest;
import mobile.fae.edu.redesocial.util.Constants;


public class PostFormActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_form);
    }

    public void inserirPost(View v){
        String texto = ((EditText) findViewById(R.id.edit_text_post_form_texto)).getText().toString();

        PostAsyncTask task = new PostAsyncTask(new JsonResultHandler() {
            @Override
            public void onJsonResult(JsonResult result) {
                startActivity(new Intent(getApplicationContext(), TimelineActivity.class));
            }
        }, this);
        PostRequest request = new PostRequest(Constants.POST_ADD_SERVICE_URL);
        request.addParam("texto", texto);
        task.execute(request);

    }
}
