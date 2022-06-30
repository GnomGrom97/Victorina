package com.example.victorina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
private  Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent =new Intent(MainActivity.this,GameLevels.class);
                    startActivity(intent);finish();//запускает новую активити и завершает старую
                } catch (Exception e) {
                }
                }
        });
        Window w=getWindow();//убирает строку состояния сверху и разворачивает на весь экран
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    //системная кнопка назад-начало

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//если текущее время + 2сек  больше текущего времени то
        if (backPressedTime +2000> System.currentTimeMillis()){
       backToast.cancel();//команда для закрытия окна сообщения
            super.onBackPressed();
            return;
        }else {
          backToast =  Toast.makeText(getBaseContext(),"Нажмите еще раз,чтобы выйти",Toast.LENGTH_SHORT);
          backToast.show();
        //вторая чатсть условия


        }

        backPressedTime=System.currentTimeMillis();//засечение времени в сек
    }

    //системная кнопка назад-конец
}