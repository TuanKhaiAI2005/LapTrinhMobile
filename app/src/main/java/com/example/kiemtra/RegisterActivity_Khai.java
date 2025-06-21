package com.example.kiemtra;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity_Khai extends AppCompatActivity {

    EditText etUsername_Khai, etPassword_Khai, etRepassword_Khai;
    Button btnRegister_Khai;
    DatabaseHelper_Khai dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_khai);

        etUsername_Khai = findViewById(R.id.etUsername_Khai);
        etPassword_Khai = findViewById(R.id.etPassword_Khai);
        etRepassword_Khai = findViewById(R.id.etRepassword_Khai);
        btnRegister_Khai = findViewById(R.id.btnRegister_Khai);

        dbHelper = new DatabaseHelper_Khai(this);

        btnRegister_Khai.setOnClickListener(view -> {
            String user = etUsername_Khai.getText().toString().trim();
            String pass = etPassword_Khai.getText().toString().trim();
            String repass = etRepassword_Khai.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!pass.equals(repass)) {
                Toast.makeText(this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            // Thêm user vào database
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("username", user);
            values.put("password", pass);
            long result = db.insert("User_Khai", null, values);

            if (result != -1) {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity_Khai.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
