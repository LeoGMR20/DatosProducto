package com.example.datosproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleFacturaActivity extends AppCompatActivity {

    //Componentes visuales

    private TextView tvFactura, tvAgradecimiento, tvPrecioNeto, tvDescuento, tvTotal;
    private ImageView ivAnima;
    private Button btnPagar;

    //Atributos

    private final double DESCUENTO_PORCENTAJE = 0.1;
    private double descuento, total;

    //Paso de parámetros

    private Producto producto;

    //Animaciones

    private Animation rotacion, left_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_factura);
        inicializarVistas();
        recibirDatosPantallaHome();
        inicializarAnimaciones();
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compra();
                /*ejecutarAnimacionRotacion();*/
                ejecutarAnimacionMovimiento();
            }
        });
    }

    private void inicializarVistas() {
        tvFactura = findViewById(R.id.tvFactura);
        tvAgradecimiento = findViewById(R.id.tvAgradecimiento);
        tvPrecioNeto = findViewById(R.id.tvPrecioNeto);
        tvDescuento = findViewById(R.id.tvDescuento);
        tvTotal = findViewById(R.id.tvTotal);
        ivAnima = findViewById(R.id.ivAnima);
        btnPagar = findViewById(R.id.btnPagar);
    }

    private void recibirDatosPantallaHome() {
        producto = (Producto) this.getIntent().getExtras().getSerializable("objeto_producto2");
        tvPrecioNeto.setText("Precio Neto: "+producto.getPrecio().toString());
        descuento = DESCUENTO_PORCENTAJE * producto.getPrecio();
        tvDescuento.setText("Descuento ("+(DESCUENTO_PORCENTAJE * 100)+"%): "+descuento);
    }

    private void compra() {
        total = producto.getPrecio() - descuento;
        tvTotal.setText("Total: "+total);
        tvAgradecimiento.setVisibility(View.VISIBLE);
    }

    private void inicializarAnimaciones() {
        rotacion = AnimationUtils.loadAnimation(this,R.anim.rotacion);
        left_right = AnimationUtils.loadAnimation(this,R.anim.left_right);
    }

    private void ejecutarAnimacionRotacion() {
        rotacion.setDuration(7000);
        ivAnima.startAnimation(rotacion);
    }

    private void ejecutarAnimacionMovimiento(){
        left_right.setDuration(7000);
        ivAnima.startAnimation(left_right);
    }
}