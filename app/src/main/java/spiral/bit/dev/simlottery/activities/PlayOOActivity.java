package spiral.bit.dev.simlottery.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.anupkumarpanwar.scratchview.ScratchView;

import java.util.Random;

import spiral.bit.dev.simlottery.R;

public class PlayOOActivity extends AppCompatActivity {

    private ImageView image1, image2;
    private TextView moneyTv1, moneyTv2, summOfWin;
    private int isScratched = 0;
    private SharedPreferences balancePref;
    private SharedPreferences.Editor editorBalance;
    private int getVault = 0;
    private final Random random = new Random();
    int[] wins = {random.nextInt(5 + 1),
            random.nextInt(5 + 1)};
    int rVault;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_o_o);

        balancePref = getSharedPreferences("balance", 0);
        editorBalance = balancePref.edit();
        int currBalance = balancePref.getInt("money", 0);
        getSupportActionBar().setTitle("Ваш баланс: " + currBalance);
        Button takeReward = findViewById(R.id.take_reward_btn);
        image1 = findViewById(R.id.image_one);
        image2 = findViewById(R.id.image_two);
        moneyTv1 = findViewById(R.id.money_tv_1);
        moneyTv2 = findViewById(R.id.money_tv_2);
        summOfWin = findViewById(R.id.label_summ);
        ScratchView scratchView = findViewById(R.id.scratch_view);
        ScratchView scratchView2 = findViewById(R.id.scratch_view_2);

        prepareGame();

        takeReward.setOnClickListener(v -> {
            editorBalance.putInt("money", getVault + currBalance);
            editorBalance.apply();
            startActivity(new Intent(PlayOOActivity.this, PlayModeActivity.class));
        });

        scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                isScratched++;
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });

        scratchView2.setRevealListener(new ScratchView.IRevealListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onRevealed(ScratchView scratchView) {
                isScratched++;
                if (isScratched == 2) {
                    String sum = getVault + "";
                    sum = sum.replaceFirst("^0*", "");
                    if (sum.equals("")) summOfWin.setText("Сумма выигрыша: 0");
                    else summOfWin.setText("Сумма выигрыша: " + sum);
                    summOfWin.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void prepareGame() {
        rVault = new Random().nextInt(2000 + 10);
        if (wins[0] == 2) {
            image1.setImageResource(R.drawable.vault);
            moneyTv1.setText(rVault + " монет");
            getVault = rVault;
        }if (wins[1] == 3) {
            image2.setImageResource(R.drawable.vault);
            moneyTv2.setText(rVault + " монет");
            getVault = rVault;
        }
    }
}