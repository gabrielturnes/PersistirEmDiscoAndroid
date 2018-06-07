package ifsc.poo.victor.persistenciaemdisco;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private SharedPreferences mPreferences;
    private static final String mSharedPrefFile= "poo.engtelecom.contador";

    private final String CONTADOR_KEY = "contador";
    private final String COR_KEY = "cor";



    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mPreferences.edit();

        TextView textView = (TextView) findViewById(R.id.textView);
        String valor = textView.getText().toString();
        String[] textoSeparado = valor.split(" ");
        int soma = Integer.parseInt(textoSeparado[0]);


        editor.putInt(CONTADOR_KEY,soma);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPreferences = getSharedPreferences(mSharedPrefFile,MODE_PRIVATE);

        int contador = mPreferences.getInt(CONTADOR_KEY,0);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(""+contador+" jujubas");

        Button BotaoAzul = (Button) findViewById(R.id.BotaoAzul);
        BotaoAzul.setOnClickListener(this);
        Button BotaoVerm = (Button) findViewById(R.id.BotaoVerm);
        BotaoVerm.setOnClickListener(this);
        Button BotaoVerde = (Button) findViewById(R.id.BotaoVerde);
        BotaoVerde.setOnClickListener(this);







    }

    public void incrementaContador(View view){
        TextView textView = (TextView) findViewById(R.id.textView);
        String valor = textView.getText().toString();
        String[] textoSeparado = valor.split(" ");
        int soma = Integer.parseInt(textoSeparado[0])+1;
        textView.setText(""+soma+" jujubas");





    }


    public void mudaCor(View view){
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setBackgroundColor(Color.BLUE);

    }


    @Override
    public void onClick(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        switch(view.getId()){
            case R.id.BotaoAzul:
                Button BotaoAzul = (Button) findViewById(R.id.BotaoAzul);
                //BotaoAzul.setOnClickListener(this);
                int cor = ((ColorDrawable) BotaoAzul.getBackground()).getColor();
                textView.setBackgroundColor(cor);
                break;

            case R.id.BotaoVerde:
                Button BotaoVerde = (Button) findViewById(R.id.BotaoVerde);
                cor = ((ColorDrawable) BotaoVerde.getBackground()).getColor();
                textView.setBackgroundColor(cor);
                break;
            case R.id.BotaoVerm:
                Button BotaoVerm = (Button) findViewById(R.id.BotaoVerm);
                cor = ((ColorDrawable) BotaoVerm.getBackground()).getColor();
                textView.setBackgroundColor(cor);
                break;


        }

    }


}
