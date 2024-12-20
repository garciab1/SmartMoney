package sv.edu.catolica.dam_smartmoney.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

import sv.edu.catolica.dam_smartmoney.Classes.Categoria;
import sv.edu.catolica.dam_smartmoney.R;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {
    private List<Categoria> categorias;
    private Context context;
    private int[] categoriaColores; // Para almacenar los colores de las categorías

    public CategoriaAdapter(Context context, List<Categoria> categorias, int[] categoriaColores) {
        this.context = context;
        this.categorias = categorias;
        this.categoriaColores = categoriaColores; // Guardar los colores
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_expences, parent, false);
        return new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        holder.nombreTextView.setText(categoria.getNombre());

        // Establecer el color del View
        holder.colorView.setBackgroundColor(categoriaColores[position % categoriaColores.length]);
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public static class CategoriaViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        View colorView; // Usar View para el color

        public CategoriaViewHolder(View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            colorView = itemView.findViewById(R.id.colorView);
        }
    }
}