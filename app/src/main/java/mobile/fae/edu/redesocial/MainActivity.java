package mobile.fae.edu.redesocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.fae.util.http.JsonResultHandler;
import edu.fae.util.http.PostAsyncTask;
import edu.fae.util.http.PostRequest;
import mobile.fae.edu.redesocial.JsonResultHandler.LoginJsonResultHandler;
import mobile.fae.edu.redesocial.util.Constants;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrarUsuario(View v){
        String nome = ((EditText) findViewById(R.id.edit_text_cadastro_nome)).getText().toString();
        String email = ((EditText) findViewById(R.id.edit_text_cadastro_email)).getText().toString();
        String senha = ((EditText) findViewById(R.id.edit_text_cadastro_senha)).getText().toString();

        JsonResultHandler handler = new LoginJsonResultHandler(this);
        PostAsyncTask task = new PostAsyncTask(handler, this);

        PostRequest request = new PostRequest(Constants.CADASTRO_SERVICE_URL);
        request.addParam("nome", nome);
        request.addParam("email", email);
        request.addParam("senha", senha);

        task.execute(request);
    }

    public void doLogin(View v){
        String email = ((EditText) findViewById(R.id.edit_text_login_username)).getText().toString();
        String senha = ((EditText) findViewById(R.id.edit_text_login_password)).getText().toString();

        JsonResultHandler handler = new LoginJsonResultHandler(this);
        PostAsyncTask task = new PostAsyncTask(handler, this);

        PostRequest request = new PostRequest(Constants.LOGIN_SERVICE_URL);
        request.addParam("email", email);
        request.addParam("senha", senha);

        task.execute(request);
    }
}
