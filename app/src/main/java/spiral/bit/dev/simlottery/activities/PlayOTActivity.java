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

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.anupkumarpanwar.scratchview.ScratchView;

import java.util.Random;

import spiral.bit.dev.simlottery.R;

public class PlayOTActivity extends AppCompatActivity {

    private ImageView image1, image2, image3;
    private TextView text1, text2, text3, summOfWin;
    private int getMoney = 0, getBag = 0, getVault = 0;
    private final Random random = new Random();
    private SharedPreferences balancePref;
    private SharedPreferences.Editor editorBalance;
    int[] wins = {random.nextInt(5 + 1),
            random.nextInt(5 + 1),
            random.nextInt(5 + 1)};
    private int isScratched = 0;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_o_t);

        balancePref = getSharedPreferences("balance", 0);
        editorBalance = balancePref.edit();
        int currBalance = balancePref.getInt("money", 0);
        getSupportActionBar().setTitle("Ваш баланс: " + currBalance);

        Button takeReward = findViewById(R.id.take_reward_btn);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        summOfWin = findViewById(R.id.label_summ);
        image1 = findViewById(R.id.image_one);
        image2 = findViewById(R.id.image_two);
        image3 = findViewById(R.id.image_three);
        ScratchView scratchView1 = findViewById(R.id.scratch_view);
        ScratchView scratchView2 = findViewById(R.id.scratch_view_2);
        ScratchView scratchView3 = findViewById(R.id.scratch_view_3);

        prepareGame();

        takeReward.setOnClickListener(v -> {
            editorBalance.putInt("money", (getMoney + getBag + getVault) + currBalance);
            editorBalance.apply();
            startActivity(new Intent(PlayOTActivity.this, PlayModeActivity.class));
        });

        scratchView1.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                isScratched++;
                checkCells();
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
                checkCells();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });

        scratchView3.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                isScratched++;
                checkCells();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void checkCells() {
        if (isScratched == 3) {
            String sum = (getMoney + getBag + getVault) + "";
            sum = sum.replaceFirst("^0*", "");
            if (sum.equals("")) summOfWin.setText("Сумма выигрыша: 0");
            else summOfWin.setText("Сумма выигрыша: " + sum);
            summOfWin.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("SetTextI18n")
    private void prepareGame() {
        int rMoney = new Random().nextInt(20 + 1);
        int rBag = new Random().nextInt(120 + 50);
        int rVault = new Random().nextInt(300 + 100);
        if (wins[0] == 0) {
            image1.setImageResource(R.drawable.money);
            text1.setText(rMoney + " монет");
            getMoney = rMoney;
        }
        if (wins[1] == 2) {
            image2.setImageResource(R.drawable.money_bag);
            text2.setText(rBag + " монет");
            getBag = rBag;
        }
        if (wins[2] == 1) {
            image3.setImageResource(R.drawable.vault);
            text3.setText(rVault + " монет");
            getVault = rVault;
        }
    }
}