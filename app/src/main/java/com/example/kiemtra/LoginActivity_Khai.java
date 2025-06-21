package com.example.kiemtra;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity_Khai extends AppCompatActivity {

    EditText username_Khai, password_Khai;
    Button btnLogin_Khai;
    TextView tvRegister_Khai;
    DatabaseHelper_Khai dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_khai);

        username_Khai = findViewById(R.id.username_Khai);
        password_Khai = findViewById(R.id.password_Khai);
        btnLogin_Khai = findViewById(R.id.btnLogin_Khai);
        tvRegister_Khai = findViewById(R.id.tvRegister_Khai);

        dbHelper = new DatabaseHelper_Khai(this);

        btnLogin_Khai.setOnClickListener(view -> {
            String user = username_Khai.getText().toString().trim();
            String pass = password_Khai.getText().toString().trim();

            if (CheckUser_Khai(user, pass)) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HomeActivity_Khai.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        tvRegister_Khai.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity_Khai.class);
            startActivity(intent);
        });
    }

    private boolean CheckUser_Khai(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User_Khai WHERE username=? AND password=?", new String[]{username, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
}
