package mobile.fae.edu.redesocial.Listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Eric on 02/04/2015.
 */
public class PostItemOnClickListener extends AbstractOnItemClickListenerTemplate {
    public PostItemOnClickListener(Context context) {
        super(context);
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        Toast.makeText(context, "Clicado: " + position, Toast.LENGTH_LONG).show();
    }
}
