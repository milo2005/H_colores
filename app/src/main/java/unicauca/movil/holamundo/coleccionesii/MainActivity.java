package unicauca.movil.holamundo.coleccionesii;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.holamundo.coleccionesii.adapters.ColorAdapter;
import unicauca.movil.holamundo.coleccionesii.models.ColorItem;
import unicauca.movil.holamundo.coleccionesii.util.AppUtil;


public class MainActivity extends ActionBarActivity implements DialogInterface.OnClickListener{

    ListView list;
    String colores[];
    ColorAdapter adapter;

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        colores = getResources().getStringArray(R.array.colores);

        AppUtil.data = new ArrayList<>();
        adapter = new ColorAdapter(this, AppUtil.data);

        list.setAdapter(adapter);

        registerForContextMenu(list);

        llenarData();
    }

    private void llenarData() {
        for(int i=0;i<colores.length;i++){
            String color[] = colores[i].split(",");
            ColorItem item = new ColorItem();
            item.setNombre(color[0]);
            item.setNombreHex(color[1]);
            item.setUrl(color[2]);
            AppUtil.data.add(item);
        }
        adapter.notifyDataSetChanged();


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }


    //region Menu de Opciones

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(this, AddColorActivity.class);
                startActivity(intent);

                break;
            case R.id.action_more:
                Toast.makeText(this,"Entraste en mas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_info:
                Toast.makeText(this,"Entraste en info", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(this,"Entraste en Acerca de", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion


    //region Menu Contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_ctx_color, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        pos = info.position;

        switch(item.getItemId()){
            case R.id.action_edit:
                Intent intent = new Intent(this, AddColorActivity.class);
                intent.putExtra(AddColorActivity.KEY_POS,pos);
                startActivity(intent);
                break;
            case R.id.action_delete:
                showDeleteAlert();
                break;
        }

        return super.onContextItemSelected(item);
    }

    //endregion

    private void showDeleteAlert() {
        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.delete_title))
                .setMessage(getString(R.string.delete_msg))
                //.setView()
                .setPositiveButton(getString(R.string.delete_positive),this)
                .setNegativeButton(getString(R.string.delete_negative),this)
                .create();

        alert.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which==DialogInterface.BUTTON_POSITIVE){
            AppUtil.data.remove(pos);
            adapter.notifyDataSetChanged();

        }
    }
}
