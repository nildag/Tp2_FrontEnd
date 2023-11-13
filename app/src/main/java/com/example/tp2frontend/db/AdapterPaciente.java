package com.example.tp2frontend.db;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp2frontend.R;


import java.util.List;

public class AdapterPaciente extends RecyclerView.Adapter<AdapterPaciente.ViewHolder>{
    private List<Paciente> listaPacientes;
    private ItemClickListener mItemListener;

    public AdapterPaciente(List<Paciente> listaDePacientes, ItemClickListener itemClickListener) {
        this.listaPacientes = listaDePacientes;
        this.mItemListener = itemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_paciente, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Paciente paciente = listaPacientes.get(i);

        viewHolder.tvPaciente.setText(paciente.getNombre());
        viewHolder.tvEmail.setText(paciente.getEmail());

        viewHolder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(paciente);
        });
    }

    @Override
    public int getItemCount() {
        return listaPacientes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPaciente;
        public TextView tvEmail;

        public ViewHolder(View v) {
            super(v);
            tvPaciente = v.findViewById(R.id.txtPaciente);
            tvEmail = v.findViewById(R.id.txtEmail);
        }
    }

    public interface ItemClickListener {
        void onItemClick(Paciente paciente);
    }

}
