package mobile.fae.edu.redesocial;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import mobile.fae.edu.redesocial.adapter.ComentarioArrayAdapter;
import mobile.fae.edu.redesocial.model.Post;


public class PostDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        Post post = (Post) getIntent().getExtras().get("post");

        ((TextView) findViewById(R.id.text_view_post_detail_autor)).setText(post.getNomeAutor());
        ((TextView) findViewById(R.id.text_view_post_detail_updatedAt)).setText(post.getUpdatedAt());
        ((TextView) findViewById(R.id.text_view_post_detail_texto)).setText(post.getTexto());

        ListView listView = (ListView) findViewById(R.id.list_view_detalhes_post_comentarios);
        ComentarioArrayAdapter adapter = new ComentarioArrayAdapter(this);
        adapter.addAll(post.getComentarios());
        listView.setAdapter(adapter);
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
            Intent intent = new Intent(this, ComentarioFormActivity.class);
            intent.putExtra("postId", ((Post) getIntent().getExtras().get("post")).getId());
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
