package com.example.finalepratiquehttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalepratiquehttp.http.Service;
import com.example.finalepratiquehttp.http.retrofitUtil;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ErreurErreurErreurActivity extends AppCompatActivity {
    public EditText et ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur_erreur_erreur);

       this.setupView();
    }

    private void setupView() {
        TextView titleTV = findViewById(R.id.dwTitle);
        titleTV.setText("Erreur Erreur Erreur");
        et = findViewById(R.id.etMDP);
        this.setupButton();

    }

    private void setupButton() {
        Button btnPost = findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Service service = retrofitUtil.get();
                if(et.getText().toString() !=null || et.getText().toString() != et.getHint()){
                    service.getPw(et.getText().toString()).enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if(response.isSuccessful()){
                                Snackbar.make(findViewById(android.R.id.content), response.body(), Snackbar.LENGTH_LONG).show();
                            }
                            else{
                                try {
                                    Snackbar.make(findViewById(android.R.id.content), "Failed : "+ response.errorBody().string(), Snackbar.LENGTH_LONG).show();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Aucune réponse du serveur",Toast.LENGTH_LONG).show();
                        }
                    });

                }
                else {
                    Toast.makeText(getApplicationContext(),"Veuillez entrer un valeur valide",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}