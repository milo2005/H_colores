package unicauca.movil.holamundo.coleccionesii;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.holamundo.coleccionesii.adapters.ColorAdapter;
import unicauca.movil.holamundo.coleccionesii.models.ColorItem;


public class MainActivity extends ActionBarActivity {

    ListView list;
    String colores[];
    ColorAdapter adapter;

    List<ColorItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        colores = getResources().getStringArray(R.array.colores);

        data = new ArrayList<>();
        adapter = new ColorAdapter(this, data);

        list.setAdapter(adapter);

        llenarData();
    }

    private void llenarData() {
        for(int i=0;i<colores.length;i++){
            String color[] = colores[i].split(",");
            ColorItem item = new ColorItem();
            item.setNombre(color[0]);
            item.setNombreHex(color[1]);
            item.setUrl(color[2]);
            data.add(item);
        }
        adapter.notifyDataSetChanged();
    }


}
