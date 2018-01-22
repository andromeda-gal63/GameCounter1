package space.lucydevine.gamecounter1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static space.lucydevine.gamecounter1.R.string.menu1;
import static space.lucydevine.gamecounter1.R.string.menu4;

public class CountTeleOp extends AppCompatActivity {

    int sf1, sf2, sf3, sf4 = 0;
    int fieldLen = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_tele_op);

        // Initialize local counters.
        resetCounters();

        // Set up View Listeners:

        // Menu: NEXT -> EndMatchAndAdvance.
        TextView nextMenu = (TextView)findViewById(R.id.next);
        nextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextMenuIntent = new Intent(CountTeleOp.this, EndMatchAndAdvance.class);
                startActivity(nextMenuIntent);
            }
        });

        // Menu: PREV -> MainActivit(aka Autonomous)
        TextView prevMenu = (TextView)findViewById(R.id.prev);
        prevMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prevMenuIntent = new Intent(CountTeleOp.this, MainActivity.class);
                startActivity(prevMenuIntent);
            }
        });
    }

    /**
     * Setters to increment the counts for these special functions.
     */
    public void incrementSF1(View view){
        sf1 = sf1 + 1;
        TextView sf = (TextView)findViewById(R.id.r21);
        sf.setText(String.format("% 4d", sf1));
    }
    public void incrementSF2(View view){
        sf2 = sf2 + 1;
        TextView sf = (TextView)findViewById(R.id.r22);
        sf.setText(String.format("% 4d", sf2));
    }
    public void incrementSF3(View view){
        sf3 = sf3 + 1;
        TextView sf = (TextView)findViewById(R.id.r23);
        sf.setText(String.format("% 4d", sf3));
    }
    public void incrementSF4(View view){
        sf4 = sf4 + 1;
        TextView sf = (TextView)findViewById(R.id.r24);
        sf.setText(String.format("% 4d", sf4));
    }

    private void resetCounters(){
        sf1 = 0;
        sf2 = 0;
        sf3 = 0;
        sf4 = 0;
    }
}
