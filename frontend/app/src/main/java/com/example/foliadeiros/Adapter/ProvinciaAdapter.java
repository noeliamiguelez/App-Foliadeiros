package com.example.foliadeiros.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foliadeiros.Model.Provincia;
import com.example.foliadeiros.R;

import java.util.List;

public class ProvinciaAdapter extends ArrayAdapter<Provincia> {

    public ProvinciaAdapter(Context context, List<Provincia> provincias){
        super(context, 0, provincias);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(getContext())
                    .inflate(R.layout.provincia, parent, false);
        }

        Provincia provincia= getItem(position);

        TextView txt= convertView.findViewById(R.id.txtProvincia);
        txt.setText(provincia.getNombre());

        String nombre= provincia.getNombre();

        if (nombre.equals("A Coruña")){
            convertView.setBackgroundResource(R.drawable.p_coruna_bg);
        }else if(nombre.equals("Lugo")){
            convertView.setBackgroundResource(R.drawable.p_lugo_bg);
        }else if(nombre.equals("Ourense")){
            convertView.setBackgroundResource(R.drawable.p_ourense_bg);
        }else{
            convertView.setBackgroundResource(R.drawable.p_pontevedra_bg);
        }

        return convertView;
    }
}
