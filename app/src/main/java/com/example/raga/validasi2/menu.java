package com.example.raga.validasi2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity {
//step1: membuat deklarasi variable tiap widget
   RadioButton rbt1, rbt2;
   Button view1,kirimINT,kirimBUND;
   TextView namaLengkap,tanggalLahir,alamat,email,telpon;

   String temppilhanjrusan;
//step2: membuat variable string
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //step 3: memngambil aksi user dari widget ke variable
        namaLengkap=(TextView) findViewById(R.id.txtnama);
        tanggalLahir=(TextView) findViewById(R.id.txttgl);
        alamat=(TextView)findViewById(R.id.txtalamat);
        email=(TextView) findViewById(R.id.txtemail);
        telpon=(TextView) findViewById(R.id.txttelp);
        rbt1= (RadioButton)findViewById(R.id.idrpl);
        rbt2= (RadioButton)findViewById(R.id.idtkj);
        kirimINT=(Button) findViewById(R.id.btnkirim);
        kirimBUND=(Button) findViewById(R.id.btnkirim2);
        view1=(Button)findViewById(R.id.btntampilkan);


         //step4:membuat button aksi klik
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validasinama();

            }


        });

    }
// step 5:membuat method aksi pilih jurusan Radiobutton
       public void pilihjurusan(){
            if (rbt1.isChecked()) {
              temppilhanjrusan = "Rekayasa perangkat lunak";
           }else  if (rbt2.isChecked()) {
                temppilhanjrusan = "Tekhnik dan jaringan";
           }else{
                //step 6: membuat alert dialog untuk apabila user tidak memeilih sama sekali radiobutton
              AlertDialog.Builder alertmessage = new AlertDialog.Builder(this);
              alertmessage
                      .setTitle("peringatan!!!")
                      .setMessage("harap pilih terlebih dahulu, jurusannya")
                      .setPositiveButton("ya", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {

                          }
                      });
                AlertDialog alertDialog=alertmessage.create();
                alertDialog.show();

            }
    }
//step 7: membuat validasi inputan user
    public void validasinama() {
        String emailvalidator = email.getText().toString();
        //keterangan:if 1 maksudnya adalah untuk memberi notification dan memfocuskan jika user tidak mengisi nama
        //keterangan:if 2 maksudnya adalah untuk memberi notification dan memfocuskan jika user tidak mengisi nama, dan pindah ke pengisian biodata selanjutnya jika biodata yg sebelumnya sudah diisi
        //keterangan:if 3 maksudnya adalah untuk memberi notification dan memfocuskan jika user tidak mengisi nama, dan pindah ke pengisian biodata selanjutnya jika biodata yg sebelumnya sudah diisi

        if (namaLengkap.getText().toString().isEmpty()) {
            namaLengkap.setError("maaf,nama Lengkap harus diisi");
            namaLengkap.requestFocus();
        } else if (!namaLengkap.getText().toString().isEmpty() && tanggalLahir.getText().toString().isEmpty()) {
            tanggalLahir.setError("silahkan isi terlebih dahulu");
            tanggalLahir.requestFocus();
        } else if (!tanggalLahir.getText().toString().isEmpty() && alamat.getText().toString().isEmpty()) {
            alamat.setError("maaf,silahkan masukan alamat anda");
            alamat.requestFocus();
        } else if (!alamat.getText().toString().isEmpty() && email.getText().toString().isEmpty()){
            email.setError("maaf email tidak valid");
            email.requestFocus();
        } else if (!email.getText().toString().isEmpty() && telpon.getText().toString().isEmpty()) {
            telpon.setError("maaf silahkan isi no anda terlebih dahulu");
            telpon.requestFocus();
        }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailvalidator).matches()){
            email.setError("maaf email tidak valid!!!");
            email.requestFocus();
            email.setText("");
            email.setHint("sample: ragamuthahari@gmail.com");
        } else {
            //step 8: ketika semua edit text sudah terisi maka akan menjalankan statement
            //selanjutnya yaitu dengan pertama: eksekusi method terlebih dahulu
            pilihjurusan();
            //jika jurusan sudah terpilih dan memiliki nilai selanjutnya akan ditampilkan data alert daialog
            if (temppilhanjrusan != null) {
                AlertDialog.Builder alertTampilkandata = new AlertDialog.Builder(this);
                alertTampilkandata
                        //buatlah pesan sebagai berikut:
                        .setTitle("apakah akan dikirim???")
                        .setMessage("nama Lengkap!!!" + namaLengkap.getText().toString() + "\nalamat:" + alamat.getText().toString() + "\nEmail :" + email.getText().toString())
                        //membuat button mengirim jika kita sudah fix dalam mengisi biodata
                        .setPositiveButton("kirim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                kirimdata();


                            }
                        })
                        // membuat button edit ulang jika kita masih keliru dengan biodata kita
                        .setNegativeButton("edit ulang", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                namaLengkap.requestFocus();

                            }
                        });
               AlertDialog alertDialog= alertTampilkandata.create();
                alertDialog.show();


            }

        }

    }
    public void kirimdata(){
      final String nama=namaLengkap.getText().toString();
      final String tanggallahir=tanggalLahir.getText().toString();
      final String Alamat=alamat.getText().toString();
      final String Email=email.getText().toString();
      final String telpon1=telpon.getText().toString();
        //membuat adpbundle
      Bundle angkut = new Bundle();
        //masukan metod pilih jurusan guna mengambil dari pilihan user untuk jurusan
      pilihjurusan();

      angkut.putString("nama lengkap",nama);
      angkut.putString("Tanggal lahir",tanggallahir);
      angkut.putString("Alamat",Alamat);
      angkut.putString("EMAIL",Email);
      angkut.putString("Call",telpon1);
      angkut.putString("jurusan",temppilhanjrusan);

        Intent adppindah = new Intent(menu.this,MainActivity.class);
        adppindah.putExtras(angkut);
        startActivity(adppindah);
    }

}


