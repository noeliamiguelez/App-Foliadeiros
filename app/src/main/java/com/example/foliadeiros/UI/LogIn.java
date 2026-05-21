package com.example.foliadeiros.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foliadeiros.Api.RetrofitClient;
import com.example.foliadeiros.Api.UsuarioApiService;
import com.example.foliadeiros.Model.Login;
import com.example.foliadeiros.Model.Usuario;
import com.example.foliadeiros.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogIn extends AppCompatActivity {
    private UsuarioApiService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button bt_nonCOnta= (Button) findViewById(R.id.bt_nonConta);
        Button bt_acceder= (Button) findViewById(R.id.bt_acceder);

        bt_nonCOnta.setOnClickListener(view -> {
            Intent i_noConta= new Intent(LogIn.this, Rexistro.class);
            startActivity(i_noConta);
            finish();
        });

        bt_acceder.setOnClickListener(view -> {
            EditText et_mail= (EditText) findViewById(R.id.mail);
            EditText et_contr=(EditText) findViewById(R.id.password);
            String mail= et_mail.getText().toString().trim();
            String contraseña= et_contr.getText().toString().trim();

            if(mail.isEmpty()|| contraseña.isEmpty()){
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }
            api= RetrofitClient.getClient().create(UsuarioApiService.class);

            Login login= new Login(mail, contraseña);
            api.login(login).enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    if (response.isSuccessful()){
                        Usuario u= response.body();

                        SharedPreferences prefs= getSharedPreferences("MISPREFS", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("usuario_id", u.getId());
                        editor.apply();

                        Toast.makeText(LogIn.this, "Login correcto", Toast.LENGTH_SHORT).show();

                        Intent i_acceder= new Intent(LogIn.this, Provincias.class);
                        startActivity(i_acceder);
                        finish();
                    }else{
                        Toast.makeText(LogIn.this, "Email ou contrasinal incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    Toast.makeText(LogIn.this, "Erro de conexión", Toast.LENGTH_SHORT).show();

                }
            });



        });


    }
}