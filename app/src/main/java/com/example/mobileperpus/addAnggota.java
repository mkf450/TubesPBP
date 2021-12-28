package com.example.mobileperpus;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class addAnggota extends AppCompatActivity {
    private EditText nim, nama, password, email, kota, alamat, telp;
    private Button postDataBtn;
    private TextView responseTV;
    private ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_anggota);

        this.nim = findViewById(R.id.nim);
        this.nama = findViewById(R.id.nama);
        this.password = findViewById(R.id.password);
        this.email = findViewById(R.id.email);
        this.kota = findViewById(R.id.kota);
        this.alamat = findViewById(R.id.alamat);
        this.telp = findViewById(R.id.telp);
        this.postDataBtn = findViewById(R.id.idBtnPost);
        this.loadingPB = findViewById(R.id.idLoadingPB);
        this.responseTV = findViewById(R.id.idTVResponse);

        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nama.getText().toString().isEmpty() || password.getText().toString().isEmpty() || email.getText().toString().isEmpty() || kota.getText().toString().isEmpty() || telp.getText().toString().isEmpty()) {
                    Toast.makeText(addAnggota.this, "Tolong isi data dengan lengkap!", Toast.LENGTH_SHORT).show();
                    return;
                } createAnggota(nim.getText().toString(), nama.getText().toString(), email.getText().toString(), password.getText().toString(), alamat.getText().toString(), kota.getText().toString(), telp.getText().toString());
            }
        });
    }

    private void createAnggota(String nim, String nama, String email, String password, String alamat, String kota, String telp) {
        loadingPB.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://miniprojectperpus.masuk.id")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);

        Anggota anggota = new Anggota(nim, nama, password, alamat, kota, email, telp);

        Call<Anggota> createAnggota = api.createAnggota(anggota);

        createAnggota.enqueue(new Callback<Anggota>() {
            @Override
            public void onResponse(@NonNull Call<Anggota> call, @NonNull Response<Anggota> response) {
                Log.d("test", response.body().toString());
                loadingPB.setVisibility(View.GONE);
                if (response.code() == 200) {
                    String responseData = "\nResponse Code: " + response.code() + "\nThe request has succeeded! ";
                    responseTV.setText(responseData);
                    Toast.makeText(addAnggota.this, "Anggota berhasil dibuat", Toast.LENGTH_SHORT).show();
                } else {
                    String responseData = "\nResponse Code: " + response.code() + "\nThe request didn't succeeded :((";
                    responseTV.setText(responseData);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Anggota> call, @NonNull Throwable t) {
                Log.d("test", t.toString());
                responseTV.setText(String.format("Error : %s", t.getMessage()));
            }
        });
    }
}