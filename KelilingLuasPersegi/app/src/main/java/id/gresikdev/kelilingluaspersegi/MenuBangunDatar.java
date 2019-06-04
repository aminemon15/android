package id.gresikdev.kelilingluaspersegi;
import org.w3c.dom.Document;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MenuBangunDatar extends ListActivity {


    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        String[] bangundatar = new String[] { "Persegi Panjang", "Segitiga",
                "Exit" };

        this.setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, bangundatar));
    }


    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();

        tampilkanPilihan(pilihan);
    }


    protected void tampilkanPilihan(String pilihan) {
        try {

            Intent i = null;
            if (pilihan.equals("Persegi Panjang")) {
                i = new Intent(this, HitungPersegiPanjang.class);
            } else if (pilihan.equals("Segitiga")) {
                i = new Intent(this, HitungSegitiga.class);
            } else if (pilihan.equals("Exit")) {
                finish();
            } else {
                Toast.makeText(this,"Anda Memilih: " + pilihan + " , Actionnya belum dibuat", Toast.LENGTH_LONG).show();
            }
            startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}