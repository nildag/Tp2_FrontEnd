package com.example.tp2frontend.ficha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2frontend.ListaClienteActivity;
import com.example.tp2frontend.ListaEmpleadoActivity;
import com.example.tp2frontend.R;
import com.example.tp2frontend.api.PersonaId;

import java.util.ArrayList;


public class FiltroFichaActivity extends AppCompatActivity {
    TextView fisioterapeutaFiltrar;
    TextView pacienteFiltrar;
    TextView categoriaFiltrar;
    TextView subCategoriaFiltrar;
    EditText fechaDesde;
    EditText fechaHasta;
    String consulta = "";

    ArrayList<String> listaFiltros = new ArrayList<String>();

    PersonaId idEmpleado = new PersonaId();
    PersonaId idCliente= new PersonaId();
    Categoria categoria = new Categoria();
    SubCategoria subCategoria = new SubCategoria();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_ficha);
        fechaDesde=findViewById(R.id.txtFechaDesdeFicha);
        fechaHasta=findViewById(R.id.txtFechaHastaFicha);
        fisioterapeutaFiltrar=findViewById(R.id.txtFisioterapeutaFiltrar);
        pacienteFiltrar=findViewById(R.id.txtPacienteFiltrar);
        categoriaFiltrar=findViewById(R.id.txtCategoriaFiltrar);
        subCategoriaFiltrar=findViewById(R.id.txtSubCategoriaFiltrar);
    }

    public void agregarFiltroEmpleadoFicha(View view) {
        Intent intentEmpleado=new Intent(this, ListaEmpleadoActivity.class);
        startActivityForResult(intentEmpleado, 2);
    }

    public void agregarFiltroClienteFicha(View view) {
        Intent intentEmpleado=new Intent(this, ListaClienteActivity.class);
        startActivityForResult(intentEmpleado, 3);
    }

    public void agregarFiltroCategoriaFicha(View view) {
        Intent intentEmpleado=new Intent(this, ListaCategoriaActivity.class);
        startActivityForResult(intentEmpleado, 4);
    }

    public void agregarFiltroSubCategoriaFicha(View view) {
        Intent intentEmpleado=new Intent(this, ListaSubCategoriaActivity.class);
        if(categoria.getIdCategoria() != null){
            Bundle bundle=new Bundle();
            bundle.putInt("categoria",categoria.getIdCategoria());
            intentEmpleado.putExtras(bundle);
            System.out.println("if: 1");
        }else{
            Bundle bundle=new Bundle();
            bundle.putInt("categoria",-1);
            intentEmpleado.putExtras(bundle);
            System.out.println("if: 2");
        }
        startActivityForResult(intentEmpleado, 5);
    }

    public void btnEventoFiltrarFicha(View v) {
        Intent principalIntent=new Intent(this, FichasActivity.class);
        Bundle bundle=new Bundle();

        consulta = "";
        if(idCliente.getIdPersona()!=null){
            consulta=consulta+"\"idCliente\":{\"idPersona\":" + idCliente.getIdPersona() + "}";
        }
        if(idEmpleado.getIdPersona()!=null){
            //si el filtro no esta vacio agrega la coma
            if(!consulta.equals("")){
                consulta=consulta+',';
            }
            consulta=consulta+"\"idEmpleado\":{\"idPersona\":" + idEmpleado.getIdPersona() + "}";
        }
        if(subCategoria.getIdCategoria()!=null){
            //si el filtro no esta vacio agrega la coma
            if(!consulta.equals("")){
                consulta=consulta+',';
            }
            consulta=consulta+"\"idTipoProducto\":{\"idTipoProducto\":" + subCategoria.getIdTipoProducto() + "}";
        }
        if(!fechaDesde.getText().toString().equals("")){
            //si el filtro no esta vacio agrega la coma
            if(!consulta.equals("")){
                consulta=consulta+',';
            }
            consulta=consulta+"\"fechaDesdeCadena\":\""+ fechaDesde.getText().toString() +"\"";
        }
        if(!fechaHasta.getText().toString().equals("")){
            //si el filtro no esta vacio agrega la coma
            if(!consulta.equals("")){
                consulta=consulta+',';
            }
            consulta=consulta+"\"fechaHastaCadena\":\""+fechaHasta.getText().toString() +"\"";
        }

        if(!consulta.equals("")){
            consulta = "{" + consulta + "}";
        }

        bundle.putString("consulta", consulta);
        bundle.putString("user", getIntent().getExtras().getString("user"));
        principalIntent.putExtras(bundle);
        startActivity(principalIntent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        listaFiltros = new ArrayList<String>();
        switch(requestCode) {
            case (2) : {
                if (resultCode == ListaEmpleadoActivity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    idEmpleado.setIdPersona(data.getIntExtra("idPersona", -1));
                    fisioterapeutaFiltrar.setText(data.getStringExtra("nombre"));
                    //Toast.makeText(this, returnValue.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case (3) : {
                if (resultCode == ListaClienteActivity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    idCliente.setIdPersona(data.getIntExtra("idPersona", -1));
                    pacienteFiltrar.setText(data.getStringExtra("nombre"));
                    //Toast.makeText(this, returnValue.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case (4) : {
                if (resultCode == ListaCategoriaActivity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    categoria.setIdCategoria(data.getIntExtra("idCategoria", -1));
                    categoriaFiltrar.setText(data.getStringExtra("descripcion"));
                    //Toast.makeText(this, returnValue.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case (5) : {
                if (resultCode == ListaSubCategoriaActivity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    subCategoria.setIdTipoProducto(data.getIntExtra("idSubCategoria", -1));
                    subCategoriaFiltrar.setText(data.getStringExtra("descripcion"));
                    //Toast.makeText(this, returnValue.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}