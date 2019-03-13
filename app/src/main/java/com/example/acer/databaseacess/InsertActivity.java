package com.example.acer.databaseacess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button btn;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        ed1=findViewById(R.id.rollnumber);
        ed2=findViewById(R.id.studentname);
        ed3=findViewById(R.id.studentmobilenumber);
        btn=findViewById(R.id.save);
        databaseReference=firebaseDatabase.getReference("StudentInfo");

    }


    public void save(View view) {

        String sno=ed1.getText().toString();
        String sname=ed2.getText().toString();
        String sphn=ed3.getText().toString();

        StudentModal studentModal=new StudentModal(sno,sname,sphn);
        String insert=databaseReference.push().getKey();
        databaseReference.child(insert).setValue(studentModal);
        Toast.makeText(this, "succesful", Toast.LENGTH_SHORT).show();
        finish();

    }
}
