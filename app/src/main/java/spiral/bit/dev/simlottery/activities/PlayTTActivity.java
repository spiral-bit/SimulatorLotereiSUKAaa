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

public class PlayTTActivity extends AppCompatActivity {

    private ImageView image1, image2, image3, image4, image5,
            image6, image7, image8, image9;
    private TextView text1, text2, text3, text4, text5,
            text6, text7, text8, text9, summOfWin;
    private int getMoney = 0, getBag = 0, getVault = 0, isScratched = 0;
    private final Random random = new Random();
    private SharedPreferences balancePref;
    private SharedPreferences.Editor editorBalance;
    int[] wins = {random.nextInt(5 + 1),
            random.nextInt(5 + 1),
            random.nextInt(5 + 1),
            random.nextInt(5 + 1),
            random.nextInt(5 + 1),
            random.nextInt(5 + 1),
            random.nextInt(5 + 1),
            random.nextInt(5 + 1),
            random.nextInt(5 + 1)};

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_t_t);
        balancePref = getSharedPreferences("balance", 0);
        editorBalance = balancePref.edit();
        int currBalance = balancePref.getInt("money", 0);
        getSupportActionBar().setTitle("Ваш баланс: " + currBalance);
        Button takeReward = findViewById(R.id.take_reward_btn);
        text1 = findViewById(R.id.text_1);
        text2 = findViewById(R.id.text_2);
        text3 = findViewById(R.id.text_3);
        text4 = findViewById(R.id.text_4);
        text5 = findViewById(R.id.text_5);
        text6 = findViewById(R.id.text_6);
        text7 = findViewById(R.id.text_7);
        text8 = findViewById(R.id.text_8);
        text9 = findViewById(R.id.text_9);
        summOfWin = findViewById(R.id.label_summ);

        takeReward.setOnClickListener(v -> {
            editorBalance.putInt("money", (getMoney + getBag + getVault) + currBalance);
            editorBalance.apply();
            startActivity(new Intent(PlayTTActivity.this, PlayModeActivity.class));
        });

        ScratchView scratchView1 = findViewById(R.id.scratch_view);
        ScratchView scratchView2 = findViewById(R.id.scratch_view_2);
        ScratchView scratchView3 = findViewById(R.id.scratch_view_3);
        ScratchView scratchView4 = findViewById(R.id.scratch_view_4);
        ScratchView scratchView5 = findViewById(R.id.scratch_view_5);
        ScratchView scratchView6 = findViewById(R.id.scratch_view_6);
        ScratchView scratchView7 = findViewById(R.id.scratch_view_7);
        ScratchView scratchView8 = findViewById(R.id.scratch_view_8);
        ScratchView scratchView9 = findViewById(R.id.scratch_view_9);

        image1 = findViewById(R.id.image_1);
        image2 = findViewById(R.id.image_2);
        image3 = findViewById(R.id.image_3);
        image4 = findViewById(R.id.image_4);
        image5 = findViewById(R.id.image_5);
        image6 = findViewById(R.id.image_6);
        image7 = findViewById(R.id.image_7);
        image8 = findViewById(R.id.image_8);
        image9 = findViewById(R.id.image_9);

        prepareGame();

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

        scratchView4.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                isScratched++;
                checkCells();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });

        scratchView5.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                isScratched++;
                checkCells();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });

        scratchView6.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                isScratched++;
                checkCells();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });

        scratchView7.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                isScratched++;
                checkCells();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });

        scratchView8.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                isScratched++;
                checkCells();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });

        scratchView9.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                isScratched++;
                checkCells();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
            }
        });

        prepareGame();
    }

    @SuppressLint("SetTextI18n")
    private void checkCells() {
        if (isScratched == 9) {
            String sum = (getMoney + getBag + getVault) + "";
            sum = sum.replaceFirst("^0*", "");
            if (sum.equals("")) summOfWin.setText("Сумма выигрыша: 0");
            else summOfWin.setText("Сумма выигрыша: " + sum);
            summOfWin.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("SetTextI18n")
    private void prepareGame() {
        int rMoney = new Random().nextInt(50 + 1);
        int rBag = new Random().nextInt(200 + 50);
        int rVault = new Random().nextInt(400 + 100);
        if (wins[0] == 0) {
            image1.setImageResource(R.drawable.money);
            text1.setText(rMoney + " монет");
            getMoney = rMoney;
        } else if (wins[0] == 1) {
            image1.setImageResource(R.drawable.money_bag);
            text1.setText(rBag + " монет");
            getBag = rBag;
        } else if (wins[0] == 4) {
            image1.setImageResource(R.drawable.vault);
            text1.setText(rVault + " монет");
            getVault = rVault;
        }
        if (wins[1] == 0) {
            image2.setImageResource(R.drawable.money);
            text2.setText(rMoney + " монет");
            getMoney = rMoney;
        } else if (wins[1] == 1) {
            image2.setImageResource(R.drawable.money_bag);
            text2.setText(rBag + " монет");
            getBag = rBag;
        } else if (wins[1] == 4) {
            image2.setImageResource(R.drawable.vault);
            text2.setText(rVault + " монет");
            getVault = rVault;
        }
        if (wins[2] == 2) {
            image3.setImageResource(R.drawable.money);
            text3.setText(rMoney + " монет");
            getMoney = rMoney;
        } else if (wins[2] == 0) {
            image3.setImageResource(R.drawable.money_bag);
            text3.setText(rBag + " монет");
            getBag = rBag;
        } else if (wins[2] == 5) {
            image3.setImageResource(R.drawable.vault);
            text3.setText(rVault + " монет");
            getVault = rVault;
        }
        if (wins[3] == 1) {
            image4.setImageResource(R.drawable.money);
            text4.setText(rMoney + " монет");
            getMoney = rMoney;
        } else if (wins[3] == 2) {
            image4.setImageResource(R.drawable.money_bag);
            text4.setText(rBag + " монет");
            getBag = rBag;
        } else if (wins[3] == 3) {
            image4.setImageResource(R.drawable.vault);
            text4.setText(rVault + " монет");
            getVault = rVault;
        }
        if (wins[4] == 1) {
            image5.setImageResource(R.drawable.money);
            text5.setText(rMoney + " монет");
            getMoney = rMoney;
        } else if (wins[4] == 4) {
            image5.setImageResource(R.drawable.money_bag);
            text5.setText(rBag + " монет");
            getBag = rBag;
        } else if (wins[4] == 0) {
            image5.setImageResource(R.drawable.vault);
            text5.setText(rVault + " монет");
            getVault = rVault;
        }
        if (wins[5] == 1) {
            image6.setImageResource(R.drawable.money);
            text6.setText(rMoney + " монет");
            getMoney = rMoney;
        } else if (wins[5] == 2) {
            image6.setImageResource(R.drawable.money_bag);
            text6.setText(rBag + " монет");
            getBag = rBag;
        } else if (wins[5] == 4) {
            image6.setImageResource(R.drawable.vault);
            text6.setText(rVault + " монет");
            getVault = rVault;
        }
        if (wins[6] == 3) {
            image7.setImageResource(R.drawable.money);
            text7.setText(rMoney + " монет");
            getMoney = rMoney;
        } else if (wins[6] == 2) {
            image7.setImageResource(R.drawable.money_bag);
            text7.setText(rBag + " монет");
            getBag = rBag;
        } else if (wins[6] == 0) {
            image7.setImageResource(R.drawable.vault);
            text7.setText(rVault + " монет");
            getVault = rVault;
        }
        if (wins[7] == 4) {
            image8.setImageResource(R.drawable.money);
            text8.setText(rMoney + " монет");
            getMoney = rMoney;
        } else if (wins[7] == 5) {
            image8.setImageResource(R.drawable.money_bag);
            text8.setText(rBag + " монет");
            getBag = rBag;
        } else if (wins[7] == 1) {
            image8.setImageResource(R.drawable.vault);
            text8.setText(rVault + " монет");
            getVault = rVault;
        }
        if (wins[8] == 2) {
            image9.setImageResource(R.drawable.money);
            text9.setText(rMoney + " монет");
            getMoney = rMoney;
        } else if (wins[8] == 3) {
            image9.setImageResource(R.drawable.money_bag);
            text9.setText(rBag + " монет");
            getBag = rBag;
        } else if (wins[8] == 5) {
            image9.setImageResource(R.drawable.vault);
            text9.setText(rVault + " монет");
            getVault = rVault;
        }
    }
}