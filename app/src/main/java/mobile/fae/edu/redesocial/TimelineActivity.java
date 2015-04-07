package mobile.fae.edu.redesocial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import edu.fae.util.http.GetAsyncTask;
import edu.fae.util.http.JsonResult;
import edu.fae.util.http.JsonResultHandler;
import mobile.fae.edu.redesocial.JsonResultHandler.TimeLineJsonResultHandler;
import mobile.fae.edu.redesocial.Listener.PostItemOnClickListener;
import mobile.fae.edu.redesocial.adapter.PostArrayAdapter;
import mobile.fae.edu.redesocial.parser.PostArrayParser;
import mobile.fae.edu.redesocial.parser.PostParser;
import mobile.fae.edu.redesocial.util.Constants;


public class TimelineActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        updateListView();
    }

    public void updateListView(){
        final ListView listView = (ListView) findViewById(R.id.list_view_timeline);
        final PostArrayAdapter adapter = new PostArrayAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new PostItemOnClickListener(this));
        new GetAsyncTask(new TimeLineJsonResultHandler(this, adapter), this)
                .execute(Constants.TIMELINE_SERVICE_URL);
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
            startActivity(new Intent(this, PostFormActivity.class));
            return true;
        }

        if(id == R.id.action_refresh_timeline){
            updateListView();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateListView();
    }

}
