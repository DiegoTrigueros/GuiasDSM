package sv.edu.udb.crud_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference databaseRef = database.getReference("users");

    List<User> users;
    ListView usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersList = findViewById(R.id.usersListView);
        addUser();
    }

    @Override
    protected void onStart() {
        users = new ArrayList<>();

        super.onStart();

        FloatingActionButton fab_agregar= findViewById(R.id.fab_agregar);

        fab_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ModifyUser.class);
                intent.putExtra("accion","a");
                intent.putExtra("userId", "");
                intent.putExtra("userName","");
                intent.putExtra("userLastName", "");
                intent.putExtra("userPhone", "");
                startActivity(intent);
            }
        });

        //attaching value event listener
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                users.clear();
                for (DataSnapshot dato : dataSnapshot.getChildren()) {
                    String uId = dato.child("userId").getValue(String.class);
                    String uName = dato.child("userName").getValue(String.class);
                    String uLName = dato.child("userLastName").getValue(String.class);
                    String uPhone = dato.child("userPhone").getValue(String.class);
                    User user = new User(uId, uName, uLName, uPhone);
                    Log.i("USER: ", "User " + user.getUserId());
                    users.add(user);
                }

                UserAdapter adapter = new UserAdapter(MainActivity.this, users );
                usersList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        usersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), ModifyUser.class);
                intent.putExtra("accion","e"); // Editar
                intent.putExtra("userId", users.get(i).getUserId());
                intent.putExtra("userName",users.get(i).getUserName());
                intent.putExtra("userLastName", users.get(i).getUserLastName());
                intent.putExtra("userPhone", users.get(i).getUserPhone());
                startActivity(intent);
            }
        });


        usersList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {

                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setMessage("¿Está seguro de eliminar registro?")
                        .setTitle("Confirmación");

                ad.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.databaseRef
                                .child(users.get(position).getUserId()).removeValue();

                        Toast.makeText(MainActivity.this,
                                "!Registro borrado!",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this,
                                "!Operación de borrado cancelada!",Toast.LENGTH_SHORT).show();
                    }
                });

                ad.show();
                return true;
            }
        });
    }


    public void addUser(){
        String uuid = UUID.randomUUID().toString();
        String userId = uuid.substring(uuid.length() - 16);
        User user = new User(userId, "Diego", "Trigueros", "76574636");
        databaseRef.child(userId).setValue(user);
    }
}