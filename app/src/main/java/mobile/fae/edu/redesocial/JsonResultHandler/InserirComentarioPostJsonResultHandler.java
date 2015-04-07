package mobile.fae.edu.redesocial.JsonResultHandler;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import org.json.JSONException;

import edu.fae.util.http.JsonResult;
import mobile.fae.edu.redesocial.TimelineActivity;
import mobile.fae.edu.redesocial.model.Perfil;
import mobile.fae.edu.redesocial.parser.PerfilParser;
import mobile.fae.edu.redesocial.util.Singleton;

/**
 * Created by Eric on 07/04/2015.
 */
public class InserirComentarioPostJsonResultHandler extends  JsonResultTemplate {
    public InserirComentarioPostJsonResultHandler(Context context) {
        super(context);
    }

    @Override
    public void onJsonResult(JsonResult result) {
        if(result.hasError()){
            Toast.makeText(context, "Erro: " + result.getErrorMessage(), Toast.LENGTH_LONG).show();
            return;
        }

        if(result.hasSuccess() && result.hasJsonObject()) {
            try {
                if(result.getJsonObject().has("message")){
                    Toast.makeText(context, result.getJsonObject().getString("message"), Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        context.startActivity(new Intent(context, TimelineActivity.class));
    }
}
