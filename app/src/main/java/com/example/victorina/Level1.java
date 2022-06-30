package com.example.victorina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level1 extends AppCompatActivity {

    Dialog dialog;
    public  int numLeft;//несет в себе число в переменной
     public  int numRight;//переменная для правой картинки+тектс
Array array = new Array();//создали массив
    Random random = new Random();//генератор случайных чисел


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //создаем переменную text_Levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);//установка текста

        final ImageView img_left= (ImageView)findViewById(R.id.image_left);
//скруляет углы левой
        img_left.setClipToOutline(true);
        final ImageView img_right= (ImageView)findViewById(R.id.image_right);
//скруляет углы правой
        img_right.setClipToOutline(true);
        //путь к левой TextView
        final  TextView text_left =findViewById(R.id.text_left);
        //путь к правой TextView
        final  TextView text_right=findViewById(R.id.text_right);
        //развернуть игру на весть экран-начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.
                        FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //развернуть игру на весть экран-конец
        Button button_back = (Button) findViewById(R.id.button_back);//создание и подключение кнопки назад
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//возврат к выборю уровня
                try {
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }

        });//конструкция кнопки
        //вызов диалогового окна в начале игры
        dialog= new Dialog(this);//создание нового диалоговонго окна
   dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заоловок
   dialog.setContentView(R.layout.preview_dialog);//путь к макету диалоового окна
   dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
   //прозрачный фон диалоового окна
    dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад
       //кнопка закрытия диалогового окна
        TextView btnclose =(TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             // обрбатываем нажатие кнопки начало
                try {
                //вернуться назад к выбору уровня
                    Intent intent =new Intent(Level1.this,GameLevels.class);//создали намерение для перехода
               startActivity(intent);//старт намерения
               finish();//закрытие класса
                }catch (Exception e) {
                }
                dialog.dismiss();//зарытие диалоговоо оена
                 // обрбатываем нажатие кнопки конец
                }


        });
        //кнопка закрытия диалогового окна конец
        //кнопка продолжить начало
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();//закрываем диалоговое окно
            }
        });
        //кнопка продолжить конец
        dialog.show();//показать окно
    numLeft=random.nextInt(10);//генерируем число от 0до10
    img_left.setImageResource(array.images1[numLeft]);//достаем из массива картинку
    text_left.setText(array.texts1[numLeft]);//достаем из массива текст
 
    numRight = random.nextInt(10);//генерируем случайное число от 0до9
       //Цикл с предусловием, проверяющий равенство чисел - начало
        while (numLeft==numRight){
            numRight= random.nextInt(10);
        }
        //Цикл с предусловием, проверяющий равенство чисел - конец
        img_right.setImageResource(array.images1[numRight]);//достаем из массива картинку
        text_right.setText(array.texts1[numRight]);//достаем из массива текст
    }
    //системная кнопка начало
    @Override
    public void onBackPressed(){
        // обрбатываем нажатие кнопки начало
        try {
            //вернуться назад к выбору уровня
            Intent intent =new Intent(Level1.this,GameLevels.class);//создали намерение для перехода
            startActivity(intent);//старт намерения
            finish();//закрытие класса
        }catch (Exception e) {
        }
        // обрбатываем нажатие кнопки конец
    }
    //системная кнопка назад конец
}
