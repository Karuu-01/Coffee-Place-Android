package com.moringaschool.newsapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.newsapp.R;
import com.moringaschool.newsapp.adapters.PagerAdapter;
import com.moringaschool.newsapp.ui.CreateAccountActivity;
import com.moringaschool.newsapp.ui.LoginActivity;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mHome,mSports,mScience,mTechnology,mEntertainment,mHealth;
    PagerAdapter pagerAdapter;
    Toolbar mToolbar;

//    private EditText  mEmail, mPass;
//    private TextView mTextView;
//    private Button SignUp;
//    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //User authentication
//        mEmail = findViewById(R.id.email);
//        mPass = findViewById(R.id.password);
//        mTextView = findViewById(R.id.text);
//        SignUp = findViewById(R.id.button);

//                mAuth = FirebaseAuth.getInstance();
//
//        SignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                createUser();
//            }
//        });


        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mHome = findViewById(R.id.home);
        mSports = findViewById(R.id.sports);
        mHealth = findViewById(R.id.health);
        mScience = findViewById(R.id.science);
        mTechnology = findViewById(R.id.technology);
        mEntertainment = findViewById(R.id.entertainment);

        ViewPager viewPager = findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.include);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0
                || tab.getPosition() == 1
                || tab.getPosition() == 2
                || tab.getPosition() == 3
                || tab.getPosition() == 4
                || tab.getPosition() == 5);
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
//
//    private void createUser() {
//        String email = mEmail.getText().toString();
//        String pass = mPass.getText().toString();
//
//        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            if (!pass.isEmpty()) {
//mAuth.createUserWithEmailAndPassword(email, pass)
//        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                Toast.makeText(MainActivity.this, "Succesfully Registered!!", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                finish();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//    @Override
//    public void onFailure(@NonNull Exception e) {
//        Toast.makeText(MainActivity.this, "Registration Error!", Toast.LENGTH_LONG).show();
//    }
//});
//            }else{
//                mPass.setError("Empty fields are  not allowed");
//            }
//        }else if (email.isEmpty()){
//            mEmail.setError("Empty Fields are not allowed");
//        }else {
//            mEmail.setError("Please enter correct email");
//        }
//    }
}