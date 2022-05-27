package com.artempdn.mysqlconn;

import Mysql.ConnMysql;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;

import java.sql.*;

public class MainActivity extends AppCompatActivity {

    TextView text,errorText;

    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);

        errorText = (TextView) findViewById(R.id.textView2);

        show = (Button) findViewById(R.id.button);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*ConnMysql connMysql = new ConnMysql();
                text.setText(connMysql.log);
                */
                new Async().execute();
            }
        });
    }
//////

    class Async extends AsyncTask<Void, Void, Void> {



        String records = "",error="";
        int records2;

        @Override

        protected Void doInBackground(Void... voids) {

            try

            {

                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.10.27:3306/baseenotv5", "root", "3asftorg");

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT Notaries.ID, Notaries.NAME FROM Notaries WHERE Notaries.ID LIKE '0600026%' AND Notaries.REAL=-1");


                while(resultSet.next()) {

                    records += resultSet.getString(1) + " " + resultSet.getString(2) + "\n";
                    //records += resultSet.getString(1) +"\n";

                }

                //records2 = resultSet.getInt(1);


            }

            catch(Exception e)

            {

                error = e.toString();

            }

            return null;

        }



        @Override

        protected void onPostExecute(Void aVoid) {

            text.setText(records);

            if(error != "")

                errorText.setText(error);

            super.onPostExecute(aVoid);

        }





    }


    ////////
}