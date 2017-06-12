package wasu.com.texttest;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//苹果苹方字体是苹果为中国用户打造的一款富有中国元素的中文字体，
// 这套字体不仅字型优美，而且也能提升在手机、电脑屏幕上的清晰度以及易读性。
// 这套字体包含简体以及繁体中文，共有6种字重，可以很好地满足日常设计和阅读的需求。
// 这里给大家提供了完整版的苹果苹方字体全套打包下载，推荐有需要的用户下载使用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"fonts/ExtraLight.ttf");
        Typeface typeface2 = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");
        Typeface typeface3 = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Regular.ttf");
        Typeface typeface4 = Typeface.createFromAsset(getAssets(),"fonts/Light.ttf");
        Typeface typeface5 = Typeface.createFromAsset(getAssets(),"fonts/Medium.ttf");

//        BabushkaText babushka = (BabushkaText)findViewById(R.id.babushka_text);
//        // Add the first piece "Central Park"
//        babushka.addPiece(new BabushkaText.Piece.Builder("Central Park, NAAAAAAAAAAY")
//                .textColor(Color.parseColor("#414141"))
//                .build());
//
//        // Add the second piece "1.2 mi"
//        babushka.addPiece(new BabushkaText.Piece.Builder("1.2 mi BBBBBBBBBBBBBBBBBBBBBBB ")
//                .textColor(Color.parseColor("#0081E2"))
//                .textSizeRelative(2.9f)
//                .build());
//
//        // Add the third piece "from here"
//        babushka.addPiece(new BabushkaText.Piece.Builder("from here CCCCCCCCCCCCCCCCCCCC")
//                .textColor(Color.parseColor("#969696"))
//                .textSizeRelative(0.9f)
//                .build());
//
//        // Display the final, styled text
//        babushka.display();


        TextView textView1= (TextView)findViewById(R.id.textView1);
        TextView textView2= (TextView)findViewById(R.id.textView2);
        TextView textView3= (TextView)findViewById(R.id.textView3);
        TextView textView4= (TextView)findViewById(R.id.textView4);
        TextView textView5= (TextView)findViewById(R.id.textView5);
        textView1.setTypeface(typeface1);
        textView2.setTypeface(typeface2);
        textView3.setTypeface(typeface3);
        textView4.setTypeface(typeface4);
        textView5.setTypeface(typeface5);






    }


}
