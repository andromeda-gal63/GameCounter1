package space.lucydevine.gamecounter1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndMatchAndAdvance extends AppCompatActivity {
    int sf1, sf2, sf3, sf4 = 0;
    int fieldLen = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_match_and_advance);

        // Initialize local counters.
        resetCounters();

        // Set up View Listeners:

        // Menu: NEXT -> EndMatchAndAdvance.
        TextView nextMenu = (TextView)findViewById(R.id.next);
        nextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Store final counts and advance to next match.
                // storeEndGamePoints();

                // Advance to Autonomous.
                Intent nextMenuIntent = new Intent(EndMatchAndAdvance.this, MainActivity.class);
                startActivity(nextMenuIntent);
            }
        });

        // Menu: PREV -> MainActivit(aka Autonomous)
        TextView prevMenu = (TextView)findViewById(R.id.prev);
        prevMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prevMenuIntent = new Intent(EndMatchAndAdvance.this, CountTeleOp.class);
                startActivity(prevMenuIntent);
            }
        });

        // Menu: RECALL -> Remind.
        TextView remindMenu = (TextView)findViewById(R.id.power);
        remindMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent remindMenu = new Intent(EndMatchAndAdvance.this, RemindActivity.class);
                startActivity(remindMenu);
            }
        });
    }


    /**
     * Setters to increment the counts for these special functions.
     */
    public void incrementSF1(View view){
        // Mutually exclusive with "Climb".
        // Counting a Park resets Climbs back to zero.
        if (sf2 > 0){
            sf2 = 0;  // Reset Climb in case they fell before buzzer.
        }
        sf1 = 1;

        // Update both counters.
        TextView sfView1 = (TextView)findViewById(R.id.c11);
        sfView1.setText(String.format("% 4d", sf1));

        TextView sfView2 = (TextView)findViewById(R.id.c21);
        sfView2.setText(String.format("% 4d", sf2));
    }
    public void incrementSF2(View view){
        // Mutually exclusive with "Park".
        // Counting a Climb resets Park back to zero.
        if (sf1 > 0){
            sf1 = 0;  // Reset Climb in case they fell before buzzer.
        }
        sf2 = 1;

        // Update both counters.
        TextView sfView2 = (TextView)findViewById(R.id.c21);
        sfView2.setText(String.format("% 4d", sf2));

        TextView sfView1 = (TextView)findViewById(R.id.c11);
        sfView1.setText(String.format("% 4d", sf1));
    }
    public void incrementSF3(View view){
        // Maximum "Assists" is 2.
        if (sf3 < 2){
            sf3 = sf3 + 1;
        }
        TextView sf = (TextView)findViewById(R.id.c31);
        sf.setText(String.format("% 4d", sf3));
    }
    public void incrementSF4(View view){
        sf4 = sf4 + 1;
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
