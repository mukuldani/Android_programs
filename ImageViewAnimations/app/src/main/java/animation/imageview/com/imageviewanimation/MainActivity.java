package animation.imageview.com.imageviewanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Button alphaButton;
    private Button rotateButton;
    private Button translateButton;
    private Button scaleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        alphaButton = findViewById(R.id.alphaButton);
        rotateButton = findViewById(R.id.rotateButton);
        translateButton = findViewById(R.id.translateButton);
        scaleButton = findViewById(R.id.scaleButton);

        alphaButton.setOnClickListener(this);
        rotateButton.setOnClickListener(this);
        translateButton.setOnClickListener(this);
        scaleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alphaButton : alphaAnimation();
                                    break;
            case R.id.rotateButton : rotateAnimation();
                                    break;
            case R.id.translateButton : translateAnimation();
                                    break;
            case R.id.scaleButton : scaleAnimation();
                                    break;
        }
    }

    private void alphaAnimation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, View.ALPHA,1,0);
        objectAnimator.setDuration(4000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();
    }

    private void rotateAnimation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, View.ROTATION,0,360);
        objectAnimator.setDuration(4000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();
    }

    private void translateAnimation() {
        ObjectAnimator objectAnimator_transX = ObjectAnimator.ofFloat(imageView, View.TRANSLATION_X,1,200);
        objectAnimator_transX.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator_transX.setRepeatMode(ValueAnimator.REVERSE);

        ObjectAnimator objectAnimator_transY = ObjectAnimator.ofFloat(imageView, View.TRANSLATION_Y,1,200);
        objectAnimator_transY.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator_transY.setRepeatMode(ValueAnimator.REVERSE);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(4000);
        set.playTogether(objectAnimator_transX,objectAnimator_transY);
        set.start();
    }

    private void scaleAnimation() {
        ObjectAnimator objectAnimator_scaleX = ObjectAnimator.ofFloat(imageView,View.SCALE_X,1,2);
        objectAnimator_scaleX.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator_scaleX.setRepeatMode(ValueAnimator.REVERSE);

        ObjectAnimator objectAnimator_scaleY = ObjectAnimator.ofFloat(imageView,View.SCALE_Y,1,2);
        objectAnimator_scaleY.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator_scaleY.setRepeatMode(ValueAnimator.REVERSE);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(4000);
        set.playTogether(objectAnimator_scaleX,objectAnimator_scaleY);
        set.start();
    }


}
