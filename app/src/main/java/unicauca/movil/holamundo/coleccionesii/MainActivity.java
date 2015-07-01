package unicauca.movil.holamundo.coleccionesii;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    ListView list;
    String colores[];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        colores = getResources().getStringArray(R.array.colores);

        adapter = new ArrayAdapter<String>(this
                , android.R.layout.simple_list_item_1, colores);

        list.setAdapter(adapter);
    }


}
