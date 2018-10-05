package feuerwehrfitness.de.feuerwehrfitnessproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.*;
public class OverviewActivity extends YouTubeBaseActivity {

    private Button buttonNewVideo;
    YouTubePlayerView youTubePlayerView;
    String videoCode = "ZAxHSfZwtT8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        buttonNewVideo= (Button)findViewById(R.id.PlayOtherVideo);

        buttonNewVideo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OverviewActivity.this, "Bleib Fit, Danke fürs Anschauen", Toast.LENGTH_SHORT).show();

                Intent intent = YouTubeStandalonePlayer.createVideoIntent(OverviewActivity.this,YoutubeService.getApi(), "cz_OvkDGNYA", 0,false,true );
                startActivity(intent);
            }
        });

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.YoutubePlayer);
        youTubePlayerView.initialize(YoutubeService.getApi(), new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videoCode);
                youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(OverviewActivity.this, youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
