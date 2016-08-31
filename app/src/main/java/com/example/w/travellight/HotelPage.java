package com.example.w.travellight;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class HotelPage extends Activity {

    private ImageButton back;
    private Spinner hotel_type,hotel_sort,hotel_choose;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_page);
        hotel_type= (Spinner) findViewById(R.id.hotel_type);
        hotel_sort= (Spinner) findViewById(R.id.hotel_sort);
        hotel_choose= (Spinner) findViewById(R.id.hotel_choose);
        listView= (ListView) findViewById(R.id.hotel);
        back= (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HotelPage.this,HomePage.class));
            }
        });

        HotelRope op=new HotelRope(this);
        if(op.either()){op.insertedall();}
        ArrayList<HotelItem> hotel_data=op.getHotelList();
        HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,this);
        listView.setAdapter(hotelAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LinearLayout linearLayout= (LinearLayout) listView.getChildAt(position);
                TextView tv_url= (TextView) linearLayout.findViewById(R.id.url);
                String url=tv_url.getText().toString();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });

        hotel_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] type=getResources().getStringArray(R.array.hotel_type);
                if (position==1){
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getHotelListtype1();
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
                else if(position==2){
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getHotelListtype2();
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
                else if (position==3){
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getHotelListtype3();
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
                else if (position==4){
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getHotelListtype4();
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
                else if (position==5){
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getHotelListtype5();
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
                else {
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getHotelList();
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        hotel_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] sort=getResources().getStringArray(R.array.hotel_sort);
                if(position==1){
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getPriceLtoH() ;
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
                else if(position==2){
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getPriceHtoL();
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
                else if(position==3){
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getPjHtoL();
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
                else if(position==4){
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getMydHtoL();
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
                else{
                    HotelRope op=new HotelRope(HotelPage.this);
                    ArrayList<HotelItem> hotel_data=op.getHotelList();
                    HotelAdapter hotelAdapter=new HotelAdapter(hotel_data,HotelPage.this);
                    listView.setAdapter(hotelAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        hotel_choose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] choose=getResources().getStringArray(R.array.hotel_choose);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
