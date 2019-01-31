package com.example.mediico;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class showSingleMedicine extends Activity {

    private DatabaseReference showSingleStudentDatabaseRef;

    TextView studentName;
    TextView studentBatch;
    TextView studentRoll;
    TextView studentPhone;
    TextView studentEmail;
    TextView studentRegistrationNo;

    Button editStudentButton;
    Button deleteStudentButton;

    // private FirebaseAuth loginAuthentication;
    private DatabaseReference userDatabase;
    String key;
    String batch;
    String nowUser;
    Medicine student;

    // User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_single_medicine);
        // editStudentButton = findViewById(R.id.Edit_student_button);
        // editStudentButton.setVisibility(GONE);
        // deleteStudentButton = findViewById(R.id.Delete_student_button);
        //deleteStudentButton.setVisibility(GONE);
        studentName =(TextView) findViewById(R.id.medicine_value);
        studentBatch = (TextView) findViewById(R.id.quantity_value);
        //studentRoll = findViewById(R.id.studentRoll_value);
        // studentPhone = findViewById(R.id.studentPhone_value);
        // studentEmail =findViewById(R.id.studentEmail_value);
        // studentRegistrationNo = findViewById(R.id.studentRegistration_value);

        // loginAuthentication = FirebaseAuth.getInstance();
        // final FirebaseUser currentUser = loginAuthentication.getCurrentUser();
        //nowUser=currentUser.getEmail();
        // userDatabase= FirebaseDatabase.getInstance().getReference("users/"+nowUser.replace('.','&'));

        key = getIntent().getStringExtra("showKey");
        //batch =getIntent().getStringExtra("batch");
        showSingleStudentDatabaseRef = FirebaseDatabase.getInstance().getReference("Medicine/"+ key);


        showSingleStudentDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                student = dataSnapshot.getValue(Medicine.class);

                studentName.setText(student.getBrandName());
                studentBatch.setText(String.valueOf(student.getStock()));
                // studentRoll.setText(student.getRoll());
                //studentPhone.setText(student.getPhone());
                // studentEmail.setText(student.getEmail());
                // studentRegistrationNo.setText(student.getRegistrationNo());

                showSingleStudentDatabaseRef.removeEventListener(this);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // userDatabase.addValueEventListener(new ValueEventListener() {
        //  @Override
        // public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        // user=dataSnapshot.getValue(User.class);
        // if(user.getIsModerator().equals("true")){
        //  System.out.println("habijabi");
        // editStudentButton.setVisibility(View.VISIBLE);
        //deleteStudentButton.setVisibility(View.VISIBLE);
    }
}

// @Override
// public void onCancelled(DatabaseError databaseError) {

//}
//  });

//editStudentButton.setOnClickListener(new View.OnClickListener() {
// @Override
// public void onClick(View v) {
// takeToEditStudent(v);
//  }

//  });

// deleteStudentButton.setOnClickListener(new View.OnClickListener() {
           /* @Override
            public void onClick(View v) {
                showSingleStudentDatabaseRef.removeValue();
                finish();
            }
        });

    }

    private void takeToEditStudent(View v) {
        Intent intent = new Intent(this,EditStudent.class);
        intent.putExtra("showKey",key);
        intent.putExtra("batch",batch);
        startActivity(intent);
    }*/


