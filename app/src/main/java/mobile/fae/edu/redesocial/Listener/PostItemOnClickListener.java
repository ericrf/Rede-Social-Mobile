package mobile.fae.edu.redesocial.Listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import mobile.fae.edu.redesocial.PostDetailActivity;
import mobile.fae.edu.redesocial.model.Post;

/**
 * Created by Eric on 02/04/2015.
 */
public class PostItemOnClickListener extends AbstractOnItemClickListenerTemplate {
    public PostItemOnClickListener(Context context) {
        super(context);
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        Intent intent = new Intent(context, PostDetailActivity.class);
        intent.putExtra("post", (Post) adapter.getItemAtPosition(position));
        context.startActivity(intent);
    }
}
