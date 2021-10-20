package hu.bartabalazs.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn_ko, btn_papir, btn_ollo;
    private ImageView sajatKep, gepKep;
    private TextView eredmeny, textViewCustom;
    private int gepTipp;
    private int sajatPont, gepPont;
    private Random random;
    private Toast customToast;
    private AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ujJatek();
        btn_ko.setOnClickListener(view -> {
            gepTipp = random.nextInt(3);
            // ha 0 akkor kő
            // ha 1 akkor papir
            // ha 2 akkor ollo;
            if(gepTipp == 1){
                gepPont++;
                gepKep.setImageResource(R.drawable.paper);
                textViewCustom.setText("A gép nyert!");
                customToast.show();
            } else if(gepTipp == 2){
                sajatPont++;
                gepKep.setImageResource(R.drawable.scissors);
                textViewCustom.setText("Te nyertél!");
                customToast.show();
            } else {
                gepKep.setImageResource(R.drawable.rock);
                textViewCustom.setText("Döntetlen!");
                customToast.show();
            }
            eredmeny.setText("Eredmeny: Ember: "+sajatPont+" Computer: "+gepPont);
            sajatKep.setImageResource(R.drawable.rock);
            nyertEValaki();

        });
        btn_papir.setOnClickListener(view -> {
            gepTipp = random.nextInt(3);
            // ha 0 akkor kő
            // ha 1 akkor papir
            // ha 2 akkor ollo;
            if(gepTipp == 2){
                gepPont++;
                gepKep.setImageResource(R.drawable.scissors);
                textViewCustom.setText("A gép nyert!");
                customToast.show();
            } else if(gepTipp == 0){
                sajatPont++;
                gepKep.setImageResource(R.drawable.rock);
                textViewCustom.setText("Te nyertél!!");
                customToast.show();
            } else {
                gepKep.setImageResource(R.drawable.paper);
                textViewCustom.setText("Döntetlen!");
                customToast.show();
            }
            eredmeny.setText("Eredmeny: Ember: "+sajatPont+" Computer: "+gepPont);
            sajatKep.setImageResource(R.drawable.paper);
            nyertEValaki();
        });
        btn_ollo.setOnClickListener(view -> {
            gepTipp = random.nextInt(3);
            // ha 0 akkor kő
            // ha 1 akkor papir
            // ha 2 akkor ollo;
            if(gepTipp == 0){
                gepPont++;
                gepKep.setImageResource(R.drawable.rock);
                textViewCustom.setText("A gép nyert!");
                customToast.show();
            } else if(gepTipp == 1){
                sajatPont++;
                gepKep.setImageResource(R.drawable.paper);
                textViewCustom.setText("Te nyertél!");
                customToast.show();
            } else {
                gepKep.setImageResource(R.drawable.scissors);
                textViewCustom.setText("Döntetlen!");
                customToast.show();
            }
            eredmeny.setText("Eredmeny: Ember: "+sajatPont+" Computer: "+gepPont);
            sajatKep.setImageResource(R.drawable.scissors);
            nyertEValaki();
        });
    }

    private void ujJatek() {
        sajatPont = 0;
        gepPont = 0;
        eredmeny.setText("Eredmeny: Ember: "+sajatPont+" Computer: "+gepPont);
    }
    private void nyertEValaki(){
        if(sajatPont == 3){
            alertBuilder.setTitle("Győzelem!");
            alertBuilder.create();
            alertBuilder.show();
        } else if (gepPont == 3){
            alertBuilder.setTitle("Vereség!");
            alertBuilder.create();
            alertBuilder.show();
        }
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
        random = new Random();
        customToast = new Toast(getApplicationContext());
        CreateCustomToast();
        alertBuilder = new AlertDialog.Builder(this);
        CreateAlertDialog();
    }
    private void CreateCustomToast(){
        customToast.setDuration(Toast.LENGTH_SHORT);
        View view =getLayoutInflater().inflate(R.layout.custom_toast, findViewById(R.id.custom_toast));
        textViewCustom = view.findViewById(R.id.textViewCustom);
        customToast.setView(view);
        customToast.setGravity(Gravity.CENTER, 0, 0);
    }
    private void CreateAlertDialog(){
        alertBuilder.setMessage("Szeretne új játékot?");
        alertBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {finish();}
        });
        alertBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ujJatek();
                closeContextMenu();
            }
        });
        alertBuilder.setCancelable(false);
    }
}