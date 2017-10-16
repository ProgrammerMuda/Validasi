package com.example.raga.validasi2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvnama=(TextView)findViewById(R.id.btnama);
        TextView tvtanggallahir=(TextView)findViewById(R.id.tanggallahir);
        TextView tvalamat=(TextView)findViewById(R.id.alamat);
        TextView tvemail=(TextView)findViewById(R.id.email);
        TextView tvtelpon=(TextView)findViewById(R.id.telpon);
        TextView tvjurusan=(TextView)findViewById(R.id.jurusan);

      if (getIntent().getExtras()!=null){
          Bundle tampungbundle = getIntent().getExtras();
          tvnama.setText(tampungbundle.getString("nama lengkap"));
          tvtanggallahir.setText(tampungbundle.getString("Tanggal lahir"));
          tvalamat.setText(tampungbundle.getString("Alamat"));
          tvemail.setText(tampungbundle.getString("EMAIL"));
          tvtelpon.setText(tampungbundle.getString("Call"));
          tvjurusan.setText(tampungbundle.getString("jurusan"));

      }else{
          Toast.makeText(MainActivity.this,"data yang dikirim tidak ada!!",Toast.LENGTH_SHORT).show();
      }


    }
}
