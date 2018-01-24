package space.lucydevine.gamecounter1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.max;
import static space.lucydevine.gamecounter1.R.string.menu1;
import static space.lucydevine.gamecounter1.R.string.menu2;
import static space.lucydevine.gamecounter1.R.string.menu4;

public class MainActivity extends AppCompatActivity {

    int sf1, sf2, sf3, sf4 = 0;
    int fieldLen = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init SF counters.
        resetCounters();
        Log.i("MainActivity", "Starting a new match in Autonomous-mode.");

        // Set up View Listeners:

        // Menu: NEXT -> CountTeleOp.
        TextView nextMenu = (TextView)findViewById(R.id.next);
        nextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextMenuIntent = new Intent(MainActivity.this, CountTeleOp.class);
                startActivity(nextMenuIntent);
            }
        });

        // Menu: PREV + POWER(aka ON/OFF) -> ProgramDevice.
        TextView powerMenu = (TextView)findViewById(R.id.power);
        powerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check m1 clicked.
                TextView prevMenu = (TextView)findViewById(R.id.prev);
                prevMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent powerMenuIntent = new Intent(MainActivity.this, ProgramDevice.class);
                        startActivity(powerMenuIntent);
                    }
                });
            }
        });

        // Menu: RECALL -> Remind.
        TextView remindMenu = (TextView)findViewById(R.id.power);
        remindMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent remindMenu = new Intent(MainActivity.this, RemindActivity.class);
                startActivity(remindMenu);
            }
        });
    }

    /**
     * Setters to increment the counts for these special functions.
     */
    public void incrementSF1(View view){
        //sf1 = sf1 + 1;
        if (sf1 == 0){
            sf1 =+ 1;
        }
        TextView sf = (TextView)findViewById(R.id.c11);
        sf.setText(String.format("% 4d", sf1));
    }
    public void incrementSF2(View view){
        //sf2 = sf2 + 1;
        if (sf2 == 0){
            sf2 =+ 1;
        }
        TextView sf = (TextView)findViewById(R.id.c21);
        sf.setText(String.format("% 4d", sf2));
    }
    public void incrementSF3(View view){
        // For PowerUps/Line, you can only get this once.
        if (sf3 == 0){
            sf3 =+ 1;
        }
        TextView sf = (TextView)findViewById(R.id.c31);
        sf.setText(String.format("% 4d", sf3));
    }
    public void incrementSF4(View view){
        //sf4 = sf4 + 1;
        sf4 = 0;  // Unused for PowerUps/Auto.
        TextView sf = (TextView)findViewById(R.id.c41);
        sf.setText(String.format("% 4d", sf4));
    }

    private void resetCounters(){
        sf1 = 0;
        sf2 = 0;
        sf3 = 0;
        sf4 = 0;
    }

}
