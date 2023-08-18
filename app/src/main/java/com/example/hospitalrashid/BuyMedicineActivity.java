package com.example.hospitalrashid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages = {
            {"Uprise-D3 1000IU Capsule", "", "", "", "50"},
            {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
            {"AealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},

            {"BealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
            {"CealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},



    };
    private String[][] packages_details = {
            {"Building and Keeping the bones and teeth strong\n" +
                    "Reducing Fatique/stress and muscular pains\n" +
                    "Boosting immunity and increasing resistance against infection"},
            {"Building and Keeping the bones and teeth strong\n" +
                    "Reducing Fatique/stress and muscular pains\n" +
                    "Boosting immunity and increasing resistance against infection"},
            {"Building and Keeping the bones and teeth strong\n" +
                    "Reducing Fatique/stress and muscular pains\n" +
                    "Boosting immunity and increasing resistance against infection"},
            {"Building and Keeping the bones and teeth strong\n" +
                    "Reducing Fatique/stress and muscular pains\n" +
                    "Boosting immunity and increasing resistance against infection"},
            {"Building and Keeping the bones and teeth strong\n" +
                    "Reducing Fatique/stress and muscular pains\n" +
                    "Boosting immunity and increasing resistance against infection"}
    };
    ListView lst;
    HashMap<String, String> item;
    SimpleAdapter sa;
    ArrayList list;

    Button btnBack, btnGoToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        btnGoToCart = findViewById(R.id.buttonBMGoToCart);
        btnBack = findViewById(R.id.buttonBMBack);
        lst = findViewById(R.id.listViewBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packages_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);

            }
        });



    }
}