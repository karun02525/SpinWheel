package com.ryan.luckywheel;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;
import rubikstudio.library.PielView;

public class MainActivity extends Activity {
    List<LuckyItem> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final LuckyWheelView luckyWheelView = findViewById(R.id.luckyWheel);

        LuckyItem luckyItem1 = new LuckyItem();
        luckyItem1.secondaryText = "You Won";
        luckyItem1.secondaryText2 = "300 WRP";
        //luckyItem1.icon = R.drawable.test1;
        luckyItem1.color = Color.parseColor("#E4D700");
        data.add(luckyItem1);

        LuckyItem luckyItem2 = new LuckyItem();
        luckyItem2.secondaryText = "Try";
        luckyItem2.secondaryText2 = "Again";
        luckyItem2.color = Color.parseColor("#C70606");
        data.add(luckyItem2);

        LuckyItem luckyItem3 = new LuckyItem();
        luckyItem3.secondaryText = "You Won";
        luckyItem3.secondaryText2 = "Rs.58";
        luckyItem3.color = Color.parseColor("#7709B4");
        data.add(luckyItem3);

        LuckyItem luckyItem4 = new LuckyItem();
        luckyItem4.secondaryText = "You Won";
        luckyItem4.secondaryText2 = "T-Shirt";
        luckyItem4.color = Color.parseColor("#DE6800");
        data.add(luckyItem4);

        LuckyItem luckyItem5 = new LuckyItem();
        luckyItem5.secondaryText = "Better Luck";
        luckyItem5.secondaryText2 = "Next Time";
        luckyItem5.color = Color.parseColor("#337D37");
        data.add(luckyItem5);

        LuckyItem luckyItem6 = new LuckyItem();
        luckyItem6.secondaryText = "You Won";
        luckyItem6.secondaryText2 = "1000 WRP";
        luckyItem6.color =Color.parseColor("#37ABA9");
        data.add(luckyItem6);
//-------------------------------------

        LuckyItem luckyItem11 = new LuckyItem();
        luckyItem11.secondaryText = "You Won";
        luckyItem11.secondaryText2 = "Cap";
        luckyItem11.color = Color.parseColor("#E4D700");
        data.add(luckyItem11);

        LuckyItem luckyItem22 = new LuckyItem();
        luckyItem22.secondaryText = "You Won";
        luckyItem22.secondaryText2 = "Mobile";
        luckyItem22.color = Color.parseColor("#C70606");
        data.add(luckyItem22);

        LuckyItem luckyItem33 = new LuckyItem();
        luckyItem33.secondaryText = "You Won";
        luckyItem33.secondaryText2 = "Bag";
        luckyItem33.color = Color.parseColor("#7709B4");
        data.add(luckyItem33);

        LuckyItem luckyItem44 = new LuckyItem();
        luckyItem44.secondaryText = "You Won";
        luckyItem44.secondaryText2 = "500 WRP";
        luckyItem44.color =Color.parseColor("#DE6800");
        data.add(luckyItem44);

        LuckyItem luckyItem55 = new LuckyItem();
        luckyItem55.secondaryText = "You Won";
        luckyItem55.secondaryText2 = "Pen";
        luckyItem55.color =Color.parseColor("#337D37");
        data.add(luckyItem55);

        LuckyItem luckyItem66 = new LuckyItem();
        luckyItem66.secondaryText = "You Won";
        luckyItem66.secondaryText2 = "Rs.496";
        luckyItem66.color =Color.parseColor("#37ABA9");
        data.add(luckyItem66);




        luckyWheelView.setData(data);
       // luckyWheelView.setRound(5);
        luckyWheelView.setTouchEnabled(false);
        luckyWheelView.setLuckyWheelTextColor(Color.parseColor("#FFFFFF"));
       // luckyWheelView.setLuckyWheelCursorImage(R.drawable.ic_cursor);


        //  luckyWheelView.setLuckyWheelBackgrouldColor(Color.parseColor("#000000"));
       // luckyWheelView.setLuckyWheelCursorImage(R.drawable.ic_cursor);

     //   luckyWheelView.setLuckyWheelBackgrouldColor(Color.parseColor("#000000"));
       // luckyWheelView.setBorderColor(Color.parseColor("#203BCF"));


        /*luckyWheelView.setLuckyWheelBackgrouldColor(0xff0000ff);
        luckyWheelView.setLuckyWheelTextColor(0xffcc0000);
        luckyWheelView.setLuckyWheelCenterImage(getResources().getDrawable(R.drawable.icon));
        luckyWheelView.setLuckyWheelCursorImage(R.drawable.ic_cursor);*/


        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = getRandomIndex();
                luckyWheelView.startLuckyWheelWithTargetIndex(index);
            }
        });

        findViewById(R.id.cursorView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = getRandomIndex();
                luckyWheelView.startLuckyWheelWithTargetIndex(index);
            }
        });

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                diaglog(data.get(index).secondaryText +" "+data.get(index).secondaryText2);
                //Toast.makeText(getApplicationContext(), data.get(index).secondaryText +" "+data.get(index).secondaryText2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size() - 1) + 0;
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }




    public void diaglog(String s) {


        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        Button dialogButton = (Button) dialog.findViewById(R.id.cool_id);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_score_id);
     //   String a = currentNumber(360 - (degree % 360));

        textView.setText(s);


        // if button is clicked, close the custom dialog

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();

    }
}
