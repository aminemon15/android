package id.amin_syifa.dgreen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by muhammadyusuf on 01/19/2017.
 * kodingindonesia
 */

public class tambahActivity extends AppCompatActivity implements View.OnClickListener{
    //Dibawah ini merupakan perintah untuk mendefinikan View
        private EditText editTextKode;
        private EditText editTextNama;
        private EditText editTextSatuan;

        private Button buttonAdd;
        private Button buttonView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tambah);

            //Inisialisasi dari View
            editTextKode = (EditText) findViewById(R.id.editTextKode);
            editTextNama = (EditText) findViewById(R.id.editTextNama);
            editTextSatuan = (EditText) findViewById(R.id.editTextSatuan);

            buttonAdd = (Button) findViewById(R.id.buttonAdd);
            buttonView = (Button) findViewById(R.id.buttonView);

            //Setting listeners to button
            buttonAdd.setOnClickListener(this);
            buttonView.setOnClickListener(this);
        }


        //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
        private void addEmployee(){

            final String Kode = editTextKode.getText().toString().trim();
            final String Nama = editTextNama.getText().toString().trim();
            final String Satuan = editTextSatuan.getText().toString().trim();

            class AddEmployee extends AsyncTask<Void,Void,String>{

                ProgressDialog loading;

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(tambahActivity.this,"Menambahkan...","Tunggu...",false,false);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    Toast.makeText(tambahActivity.this,s,Toast.LENGTH_LONG).show();
                }

                @Override
                protected String doInBackground(Void... v) {
                    HashMap<String,String> params = new HashMap<>();
                    params.put(konfigurasi.KEY_EMP_KODE,Kode);
                    params.put(konfigurasi.KEY_EMP_NAMA,Nama);
                    params.put(konfigurasi.KEY_EMP_SATUAN,Satuan);

                    RequestHandler rh = new RequestHandler();
                    String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
                    return res;
                }
            }

            AddEmployee ae = new AddEmployee();
            ae.execute();
        }

        @Override
        public void onClick(View v) {
            if(v == buttonAdd){
                addEmployee();
            }

            if(v == buttonView){
                startActivity(new Intent(this,TampilSemuaBarang.class));
            }
        }
    }