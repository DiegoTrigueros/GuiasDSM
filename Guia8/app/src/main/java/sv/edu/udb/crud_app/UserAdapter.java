package sv.edu.udb.crud_app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private Activity context;
    private List<User> users;

    public UserAdapter(Activity context, List<User> users){
        super(context, R.layout.activity_main, users);
        this.context = context;
        this.users = users;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowview=null;

        if (view == null)
            rowview = layoutInflater.inflate(R.layout.user_layout,null, false);
        else rowview = view;

        TextView id = rowview.findViewById(R.id.uId);
        TextView nombre = rowview.findViewById(R.id.uName);
        TextView telefono = rowview.findViewById(R.id.uPhone);

        id.setText("Código : "+users.get(position).getUserId());
        nombre.setText("Nombre : " + users.get(position).getUserName() + " " + users.get(position).getUserLastName());
        telefono.setText("Teléfono : " + users.get(position).getUserPhone());

        return rowview;
    }
}
