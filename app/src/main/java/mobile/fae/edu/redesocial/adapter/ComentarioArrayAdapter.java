package mobile.fae.edu.redesocial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import mobile.fae.edu.redesocial.R;
import mobile.fae.edu.redesocial.model.Comentario;
import mobile.fae.edu.redesocial.model.Post;

/**
 * Created by Eric on 02/04/2015.
 */
public class ComentarioArrayAdapter extends ArrayAdapter<Comentario> {
    private Context context;

    public ComentarioArrayAdapter(Context context) {
        super(context, R.layout.row_view_timeline);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_view_post_comentarios, parent, false);
        Comentario comentario = (Comentario) getItem(position);

        ((TextView)view.findViewById(R.id.text_view_post_comentario_nome)).setText(comentario.getAutor());
        ((TextView)view.findViewById(R.id.text_view_post_comentario_updatedAt)).setText(comentario.getUpdatedAt());
        ((TextView)view.findViewById(R.id.text_view_post_comentario_texto)).setText(comentario.getTexto());

        return view;
    }
}
