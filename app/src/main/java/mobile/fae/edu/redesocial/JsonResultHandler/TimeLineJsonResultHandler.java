package mobile.fae.edu.redesocial.JsonResultHandler;

import android.content.Context;
import android.widget.ArrayAdapter;

import edu.fae.util.http.JsonResult;
import mobile.fae.edu.redesocial.model.Post;
import mobile.fae.edu.redesocial.parser.PostArrayParser;

/**
 * Created by Eric on 06/04/2015.
 */
public class TimeLineJsonResultHandler extends JsonResultTemplate {

    private ArrayAdapter adapter;

    public TimeLineJsonResultHandler(Context context, ArrayAdapter<Post> adapter){
        super(context);
        this.context = context;
        this.adapter = adapter;
    }

    @Override
    public void onJsonResult(JsonResult result) {
        new PostArrayParser(context, adapter).parse(result.getJsonArray());
    }
}
