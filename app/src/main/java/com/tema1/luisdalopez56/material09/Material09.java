package com.tema1.luisdalopez56.material09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Material09 extends AppCompatActivity {

    Toolbar toolbar;
    ImageView icono;
    LinearLayout detalle;

    private static final int DURACION = 250;
    boolean giro = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material09);

        toolbar = findViewById(R.id.barra1);
        icono = findViewById(R.id.imagen2);
        detalle = findViewById(R.id.linear3);
        toolbar.inflateMenu(R.menu.menu);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.opcion1:
                        Toast.makeText(getBaseContext(),"OPCION1",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.opcion2:
                        Toast.makeText(getBaseContext(),"OPCION2",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.opcion3:
                        Toast.makeText(getBaseContext(),"OPCION3",Toast.LENGTH_SHORT).show();
                        return true;
                    default:return false;
                }


            }
        });

        toolbar.setTitle("EL RAPTO DE LAS SABINAS");
        toolbar.setSubtitle("Jacques Louis David");

    }

    private void rotate(float angulo){
        Animation animation = new RotateAnimation(0.0f,angulo, Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);

        animation.setFillAfter(true);
        animation.setDuration(DURACION);
        icono.startAnimation(animation);
    }
    public void tocado(View view) {

        if (giro){
            icono.setImageResource(R.mipmap.menos);
            rotate(-180.0f);
            giro = false;
            es.vcarmen.material09.Dinamizador.contrae(detalle, DURACION);

        }else {
            icono.setImageResource(R.mipmap.mas);
            rotate(180.0f);
            giro = true;

            es.vcarmen.material09.Dinamizador.expande(detalle,DURACION);



        }

    }
}
