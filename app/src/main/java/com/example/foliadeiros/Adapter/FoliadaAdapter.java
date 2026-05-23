package com.example.foliadeiros.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foliadeiros.Model.Foliada;
import com.example.foliadeiros.Model.Provincia;
import com.example.foliadeiros.R;

import java.util.List;

public class FoliadaAdapter extends ArrayAdapter<Foliada> {
    public FoliadaAdapter(Context context, List<Foliada> foliadas){
        super(context, 0, foliadas);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(getContext())
                    .inflate(R.layout.foliada_item, parent, false);
        }

        Foliada foliada= getItem(position);

        TextView nombre= convertView.findViewById(R.id.txtNombre);
        TextView fecha= convertView.findViewById(R.id.txtFecha);
        TextView lugar= convertView.findViewById(R.id.txtLugar);

        nombre.setText(foliada.getNombre());
        fecha.setText(foliada.getFecha());
        lugar.setText(foliada.getLugar());

        if (foliada.getProvincia().getId() == 1) {
            convertView.setBackgroundResource(R.drawable.fi_coruna_bg);
        } else if (foliada.getProvincia().getId() == 2) {
            convertView.setBackgroundResource(R.drawable.fi_lugo_bg);
        } else if (foliada.getProvincia().getId() == 3) {
            convertView.setBackgroundResource(R.drawable.fi_ourense_bg);
        } else if (foliada.getProvincia().getId() == 4) {
            convertView.setBackgroundResource(R.drawable.fi_pontevedra_bg);
        }

        return convertView;
    }

    public void actualizarLista(List<Foliada> nuevaLista){
        clear();
        addAll(nuevaLista);
        notifyDataSetChanged();
    }

}
