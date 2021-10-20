package hu.bartabalazs.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_ko, btn_papir, btn_ollo;
    private ImageView sajatKep, gepKep;
    private TextView eredmeny;
    private int sajatPont, gepPont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ujJatek();
        btn_ko.setOnClickListener(view -> {

        });
    }

    private void ujJatek() {
        sajatPont = 0;
        gepPont = 0;

    }

    private void init(){
        btn_ko = findViewById(R.id.btn_ko);
        btn_papir = findViewById(R.id.btn_papir);
        btn_ollo = findViewById(R.id.btn_ollo);
        sajatKep = findViewById(R.id.sajatKep);
        gepKep = findViewById(R.id.gepKep);
        sajatPont = 0;
        gepPont = 0;
        eredmeny = findViewById(R.id.eredmeny);
    }
}