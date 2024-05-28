package activities;

import static android.widget.Toast.makeText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.listadetarefasulb.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import fragments.BlankFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//Floating Action Button
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);


//Calling Floating Action Button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

    }
//Creating and calling "menu_ulb"
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuinflater = new MenuInflater(this);
        menuinflater.inflate(R.menu.menu_ulb, menu);
        return true;
    }
//Selecting items from menu created and calling fragments
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_open:
                Toast.makeText(MainActivity.this, "Open Pressed", Toast.LENGTH_SHORT).show();

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, BlankFragment.class, null)
                        .commit();


                break;
            case R.id.item_edit:
                Toast.makeText(MainActivity.this, "Edit Pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_settings:
                Toast.makeText(MainActivity.this, "Settings Pressed", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}