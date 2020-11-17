package spiral.bit.dev.simlottery.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import spiral.bit.dev.simlottery.R;

public class PlayModeActivity extends AppCompatActivity {

    private SharedPreferences.Editor editorBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_mode);
        SharedPreferences balance = getSharedPreferences("balance", 0);
        int currBalance = balance.getInt("money", 0);
        editorBalance = balance.edit();
        getSupportActionBar().setTitle("Ваш баланс: " + currBalance);

        CardView playMode1 = findViewById(R.id.play_mode_1);
        CardView playMode2 = findViewById(R.id.play_mode_2);
        CardView playMode3 = findViewById(R.id.play_mode_3);

        playMode1.setOnClickListener(v -> startActivity(new Intent(PlayModeActivity.this, PlayOTActivity.class)));

        playMode2.setOnClickListener(v -> {
            if (currBalance >= 250) {
                editorBalance.putInt("money", currBalance - 250);
                editorBalance.apply();
                startActivity(new Intent(PlayModeActivity.this, PlayTTActivity.class));
            } else
                Toast.makeText(PlayModeActivity.this, "У вас недостаточно денег!", Toast.LENGTH_SHORT).show();
        });

        playMode3.setOnClickListener(v -> {
            if (currBalance >= 500) {
                editorBalance.putInt("money", currBalance - 500);
                editorBalance.apply();
                startActivity(new Intent(PlayModeActivity.this, PlayOOActivity.class));
            } else
                Toast.makeText(PlayModeActivity.this, "У вас недостаточно денег!", Toast.LENGTH_SHORT).show();
        });
    }
}
