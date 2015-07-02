package unicauca.movil.holamundo.coleccionesii;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import unicauca.movil.holamundo.coleccionesii.models.ColorItem;
import unicauca.movil.holamundo.coleccionesii.util.AppUtil;


public class AddColorActivity extends ActionBarActivity {

    public static final String KEY_POS="pos";

    EditText nombre, hex, url;
    int pos=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_color);

        nombre = (EditText) findViewById(R.id.edit_nombre);
        hex = (EditText) findViewById(R.id.edit_nombre_hex);
        url = (EditText) findViewById(R.id.edit_url);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            pos = extras.getInt(KEY_POS);
            ColorItem item = AppUtil.data.get(pos);
            nombre.setText(item.getNombre());
            hex.setText(item.getNombreHex());
            url.setText(item.getUrl());
            getSupportActionBar().setTitle("Editar Color");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_color, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_ok) {
            if(pos<0) {
                ColorItem cItem = new ColorItem();
                cItem.setNombre(nombre.getText().toString());
                cItem.setNombreHex(hex.getText().toString());
                cItem.setUrl(url.getText().toString());

                AppUtil.data.add(0, cItem);
            }else{
                ColorItem cItem = AppUtil.data.get(pos);
                cItem.setNombre(nombre.getText().toString());
                cItem.setNombreHex(hex.getText().toString());
                cItem.setUrl(url.getText().toString());
            }
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
