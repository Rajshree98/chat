package com.nema.rajshree.chitchatting;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class peoplename extends AppCompatActivity {

    private nameAdapter adapter;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseDatabase mfirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ArrayList<Message> nameList;
    private ListView mNameListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peoplename);
        Button b = (Button) findViewById(R.id.bnext);
        nameList = new ArrayList<>();


        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseReference = mfirebaseDatabase.getInstance().getReference("message");
        mNameListView = (ListView) findViewById(R.id.nameListView);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(peoplename.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nameList.clear();
                Message y;
                for (DataSnapshot chat : dataSnapshot.getChildren()) {
                    /*for (DataSnapshot childd : chat.getChildren()) {
                        Message message = childd.getValue(Message.class);


                        nameList.add(message);

                        //mMessageEditText.setText(message.text);
                    }*/
                    Message message=chat.getValue(Message.class);


                   // nameList.add(message);

                }
                adapter = new nameAdapter(peoplename.this, R.layout.item_message, nameList);
                mNameListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

