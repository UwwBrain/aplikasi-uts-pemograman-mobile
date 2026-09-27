package com.aliyah_hijriani_F52124079.aplikasi_uts;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText etSearch;
    private MenuAdapter adapter;
    private List<MenuMakanan> dataOriginal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewMenu);
        etSearch = findViewById(R.id.etSearch);

        // Memuat Data Menu Cafenya
        initDataMenu();

        // Inisialisasi Adapter
        adapter = new MenuAdapter(this, dataOriginal);
        listView.setAdapter(adapter);

        // Fitur Pencarian Real-time
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Event kalau item nanti diklikk
        listView.setOnItemClickListener((parent, view, position, id) -> {
            MenuMakanan menu = (MenuMakanan) adapter.getItem(position);
            Toast.makeText(MainActivity.this, "Memilih: " + menu.getNamaMenu(), Toast.LENGTH_SHORT).show();
        });
    }

    private void initDataMenu() {
        // Kopi & Dessert
        dataOriginal.add(new MenuMakanan(
                "Burnt Cheesecake",
                "Rp 25.000",
                "Dessert",
                "Cheesecake lembut dan nagih",
                R.drawable.burnt
        ));

        dataOriginal.add(new MenuMakanan(
                "Donat Matcha",
                "Rp 10.000",
                "Dessert",
                "Donat matcha khas Jepang",
                R.drawable.matcha
        ));

        dataOriginal.add(new MenuMakanan(
                "Donat Strawberry",
                "Rp 10.000",
                "Dessert",
                "Donat strawberry manis dan mesess rainbow",
                R.drawable.strawberry
        ));

        dataOriginal.add(new MenuMakanan(
                "Donat Lemon",
                "Rp 10.000",
                "Dessert",
                "Donat lemon manis asemm segarr",
                R.drawable.lemon
        ));

        dataOriginal.add(new MenuMakanan(
                "Mie Gacoan Level 3",
                "Rp 12.000",
                "Makanan",
                "Mie pedas manis gurih dengan ayam dan pangsit",
                R.drawable.gacoan
        ));

        dataOriginal.add(new MenuMakanan(
                "Panglima Kebab Sapi",
                "Rp 15.000",
                "Makanan",
                "Kebab daging sapi panggang dengan saus spesial dan selada hijau fresh",
                R.drawable.kebab
        ));

        dataOriginal.add(new MenuMakanan(
                "Butterscotch Coffee",
                "Rp 22.000",
                "Minuman",
                "Espresso dingin dengan saus butterscotch gurih manis dan foam creamy",
                R.drawable.coffee
        ));

        dataOriginal.add(new MenuMakanan(
                "Tea Break Milk Tea",
                "Rp 10.000",
                "Minuman",
                "Minuman teh susu dingin dengan topping boba",
                R.drawable.milk
        ));

        dataOriginal.add(new MenuMakanan(
                "Thai Tea Original",
                "Rp 8.000",
                "Minuman",
                "Teh khas Thailand yang segar, manis, dan creamy",
                R.drawable.thai
        ));
    }

    private void filterData(String query) {
        List<MenuMakanan> filteredList = new ArrayList<>();
        for (MenuMakanan item : dataOriginal) {
            if (item.getNamaMenu().toLowerCase().contains(query.toLowerCase()) ||
                    item.getKategori().toLowerCase().contains(query.toLowerCase()) ||
                    item.getHarga().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.updateData(filteredList);
    }
}