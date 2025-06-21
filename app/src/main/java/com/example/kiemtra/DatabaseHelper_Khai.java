package com.example.kiemtra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper_Khai extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Food_Khai.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper_Khai(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng User
        db.execSQL("CREATE TABLE User_Khai (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL, " +
                "password TEXT NOT NULL)");

        // Tạo bảng Restaurant
        db.execSQL("CREATE TABLE Restaurant_Khai (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "address TEXT, " +
                "image TEXT)");

        // Tạo bảng Food
        db.execSQL("CREATE TABLE Food_Khai (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "description TEXT, " +
                "price REAL, " +
                "size TEXT, " +
                "restaurant_id INTEGER, " +
                "image TEXT, " +
                "FOREIGN KEY(restaurant_id) REFERENCES Restaurant_Khai(id))");

        // Dữ liệu mẫu
        insertSampleData(db);
    }

    private void insertSampleData(SQLiteDatabase db) {
        // 5 user
        db.execSQL("INSERT INTO User_Khai (username, password) VALUES " +
                "('khai1', '123'), ('khai2', 'abc'), ('khai3', '321'), ('khai4', '456'), ('khai5', '789')");

        // 5 nhà hàng
        db.execSQL("INSERT INTO Restaurant_Khai (name, address, image) VALUES " +
                "('Nhà hàng A', '123 Lê Lợi', 'img_a'), " +
                "('Nhà hàng B', '456 Nguyễn Huệ', 'img_b'), " +
                "('Nhà hàng C', '789 Trần Hưng Đạo', 'img_c'), " +
                "('Nhà hàng D', '12 Hai Bà Trưng', 'img_d'), " +
                "('Nhà hàng E', '98 Pasteur', 'img_e')");

        // 10 món ăn
        db.execSQL("INSERT INTO Food_Khai (name, description, price, size, restaurant_id, image) VALUES " +
                "('Phở Bò', 'Phở bò truyền thống', 35000, 'Small', 1, 'pho')," +
                "('Bún Chả', 'Bún chả Hà Nội', 40000, 'Small', 1, 'buncha')," +
                "('Cơm Tấm', 'Cơm tấm sườn', 45000, 'Small', 2, 'comtam')," +
                "('Hủ Tiếu', 'Hủ tiếu Nam Vang', 40000, 'Small', 2, 'hutieu')," +
                "('Mì Quảng', 'Mì Quảng đặc sản', 35000, 'Small', 3, 'miquang')," +
                "('Bánh Mì', 'Bánh mì pate', 20000, 'Small', 3, 'banhmi')," +
                "('Bánh Xèo', 'Bánh xèo miền Trung', 40000, 'Small', 4, 'banhxeo')," +
                "('Bún Bò', 'Bún bò Huế', 45000, 'Small', 4, 'bunbo')," +
                "('Gỏi Cuốn', 'Gỏi cuốn tôm thịt', 30000, 'Small', 5, 'goicuon')," +
                "('Chè Thái', 'Chè Thái ngọt mát', 25000, 'Small', 5, 'chethai')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User_Khai");
        db.execSQL("DROP TABLE IF EXISTS Restaurant_Khai");
        db.execSQL("DROP TABLE IF EXISTS Food_Khai");
        onCreate(db);
    }
}
