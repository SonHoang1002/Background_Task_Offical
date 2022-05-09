package com.example.background_task;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView, tVContent;
    private Handler mHandler;
    private ProgressBar progressBar1, progressBar2;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);
        mHandler = new Handler();
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        button = findViewById(R.id.button);
        tVContent = findViewById(R.id.tVContent);

        findViewById(R.id.button1).setOnClickListener(view->{
            startActivity(new Intent(MainActivity.this,MainActivity2.class));
        });
    }

    public void startTask(View view) {

        //getAllUsers s
        new Thread(() -> {
            try {
                ApiCLient.getApi().getAllUsers().enqueue(new Callback<ArrayList<User>>() {
                    @Override
                    public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                        ArrayList<User> list = response.body();
                        mTextView.setText(" Number of list: " + list.size());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                        mTextView.setText("Error: " + t.getMessage());
                    }
                });
                mHandler.post(() -> {

                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        //updateUserById
//        User user1 = new User( "Hoang Trung Son", "hts@gmail.com", "female", "10");
//        new Thread(() -> {
//            ApiCLient.getApi().updateUserById(4010, user1).enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//                    Toast.makeText(MainActivity.this, "Update User Successfully", Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//
//                }
//            });
//        }).start();

        // getUserById s
//        new Thread(() -> {
//            try {
//                ApiCLient.getApi().getUserById(4001).enqueue(new Callback<User>() {
//                    @Override
//                    public void onResponse(Call<User> call, Response<User> response) {
//                        User user = response.body();
//                        tVContent.setText("" + user.name);
//                    }
//
//                    @Override
//                    public void onFailure(Call<User> call, Throwable t) {
//                        tVContent.setText("Error: " + t.getMessage());
//                    }
//                });
//                mHandler.post(() -> {
//
//                });
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();

        //deleteUserById
//        new Thread(() -> {
//            ApiCLient.getApi().deleteUserById(4010).enqueue(new Callback() {
//                @Override
//                public void onResponse(Call call, Response response) {
//
//                }
//
//                @Override
//                public void onFailure(Call call, Throwable t) {
//
//                }
//            });
//        }).start();
//        Toast.makeText(MainActivity.this, "Update User Successfully", Toast.LENGTH_SHORT).show();


//        new Thread(() -> {
//            try {
//                URL url = new URL("https://gorest.co.in/public/v2/users");
//                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
//                StringBuffer stringBuffer = new StringBuffer();
//                String text;
//                while((text = bufferedReader.readLine() )!=null){
//                    stringBuffer.append(text);
//                }
//                bufferedReader.close();
//                mHandler.post(() -> {
//                    tVContent.setText(stringBuffer);
//                });
//            }  catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();


//        progressBar1.setVisibility(View.VISIBLE);
//        progressBar2.setVisibility(View.VISIBLE);
//        new Thread(() -> {
//            int s = 2000;
//            try {
//                for(int i=0;i<=200;i++){
//                    Thread.sleep(s/200);
//                    int finalI = i;
//                    mHandler.post(()->{
//                        button.setText(""+finalI);
//                        progressBar2.setProgress(finalI);
//                    });
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            mHandler.post(() -> {
//                mTextView.setText("Awake at last after sleeping for " + s + " milliseconds!");
//                button.setText("Click me");
//                progressBar1.setVisibility(View.INVISIBLE);
//                progressBar2.setVisibility(View.INVISIBLE);
//            });
//        }).start();
    }
}


//echo "# Background_Task_Offical" >> README.md
//        git init
//        git add README.md
//        git commit -m "first commit"
//        git branch -M main
//        git remote add origin https://github.com/SonHoang1002/Background_Task_Offical.git
//        git push -u origin main