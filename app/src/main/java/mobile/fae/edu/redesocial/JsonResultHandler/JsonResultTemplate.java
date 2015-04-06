package mobile.fae.edu.redesocial.JsonResultHandler;

import android.content.Context;

import edu.fae.util.http.JsonResultHandler;

/**
 * Created by Eric on 02/04/2015.
 */
public abstract class JsonResultTemplate implements JsonResultHandler{
    protected Context context;

    public JsonResultTemplate(Context context){
        this.context = context;
    }
}
