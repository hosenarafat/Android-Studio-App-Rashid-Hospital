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

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Bladimir Putin", "Treatment Time: Morning ", "Exp : 20yrs", "Mobile N0：12345678","2190"},
                    {"Doctor Name : Joe Baiden", "Treatment Time: Afternoon ", "Exp : 4yrs", "Mobile N0：12345687","2120"},
                    {"Doctor Name : Emanuel Macron", "Treatment Time : Evening", "Exp : 7yrs", "Mobile N0：12345768","2130"},
                    {"Doctor Name : Recep Erdugan", "Treatment Time : Morning ", "Exp : 22yrs", "Mobile N0：12346578","2170"},
                    {"Doctor Name : Rishi Sunak", "Treatment Time: Afternoon ", "Exp : 2yrs", "Mobile N0：12435678","2110"}

            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Neonel Messi", "Treatment Time: Morning ", "Exp : 20yrs", "Mobile N0：21345678","1190"},
                    {"Doctor Name : Chistiano Ronaldo", "Treatment Time: Afternoon ", "Exp : 22yrs", "Mobile N0：22345687","1180"},
                    {"Doctor Name : Neymar Jr", "Treatment Time : Evening", "Exp : 7yrs", "Mobile N0：11345768","1130"},
                    {"Doctor Name : Karim Benjema", "Treatment Time : Morning ", "Exp : 12yrs", "Mobile N0：13346578","1170"},
                    {"Doctor Name : Xavi Alponso", "Treatment Time: Afternoon ", "Exp : 2yrs", "Mobile N0：41435678","1110"}

            };


    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Edgar Buchanan", "Treatment Time: Morning ", "Exp : 20yrs", "Mobile N0：12345678","190"},
                    {"Doctor Name : Thomas Bramwell", "Treatment Time: Afternoon ", "Exp : 4yrs", "Mobile N0：12345687","120"},
                    {"Doctor Name : Bill Dorfman", "Treatment Time : Evening", "Exp : 7yrs", "Mobile N0：12345768","130"},
                    {"Doctor Name : Paul Revere", "Treatment Time : Morning ", "Exp : 22yrs", "Mobile N0：12346578","170"},
                    {"Doctor Name : Mark Spitzer", "Treatment Time: Afternoon ", "Exp : 2yrs", "Mobile N0：12435678","110"}

            };


    private String[][] doctor_details4 =
            {
                    {"Doctor Name :Antonio Abbate", "Treatment Time: Morning ", "Exp : 20yrs", "Mobile N0：12345678","90"},
                    {"Doctor Name : Richard Becker", "Treatment Time: Afternoon ", "Exp : 4yrs", "Mobile N0：12345687","20"},
                    {"Doctor Name : Wendy Book", "Treatment Time : Evening", "Exp : 7yrs", "Mobile N0：12345768","30"},
                    {"Doctor Name : Roger Blumenthal", "Treatment Time : Morning ", "Exp : 22yrs", "Mobile N0：12346578","70"},
                    {"Doctor Name : Barry Borlaug", "Treatment Time: Afternoon ", "Exp : 2yrs", "Mobile N0：12435678","10"}

            };


    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Soon Shiong", "Treatment Time: Morning ", "Exp : 20yrs", "Mobile N0：12345678","90"},
                    {"Doctor Name : Khalid Abbed", "Treatment Time: Afternoon ", "Exp : 4yrs", "Mobile N0：12345687","20"},
                    {"Doctor Name : Naresh Trehan", "Treatment Time : Evening", "Exp : 7yrs", "Mobile N0：12345768","30"},
                    {"Doctor Name : Arthur Reese ", "Treatment Time : Morning ", "Exp : 22yrs", "Mobile N0：12346578","70"},
                    {"Doctor Name :  Arthur Reese ", "Treatment Time: Afternoon ", "Exp : 2yrs", "Mobile N0：12435678","10"}

            };




    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textviewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
           doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);


            }
        });
    }
}