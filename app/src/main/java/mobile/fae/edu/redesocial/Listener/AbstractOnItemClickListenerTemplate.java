package mobile.fae.edu.redesocial.Listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Eric on 02/04/2015.
 */
public abstract class AbstractOnItemClickListenerTemplate implements AdapterView.OnItemClickListener {
    protected Context context;

    public AbstractOnItemClickListenerTemplate(Context context){
        this.context = context;
    }
}
