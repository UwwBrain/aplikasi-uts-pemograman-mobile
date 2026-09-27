package com.aliyah_hijriani_F52124079.aplikasi_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends BaseAdapter {

    private Context context;
    private List<MenuMakanan> listMenu;
    private LayoutInflater inflater;

    public MenuAdapter(Context context, List<MenuMakanan> listMenu) {
        this.context = context;
        this.listMenu = listMenu;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listMenu.size();
    }

    @Override
    public Object getItem(int position) {
        return listMenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView imgFoto;
        TextView tvNama;
        TextView tvHarga;
        TextView tvKategori;
        TextView tvDeskripsi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_menu, parent, false);
            holder = new ViewHolder();
            holder.imgFoto = convertView.findViewById(R.id.imgFoto);
            holder.tvNama = convertView.findViewById(R.id.tvNama);
            holder.tvHarga = convertView.findViewById(R.id.tvHarga);
            holder.tvKategori = convertView.findViewById(R.id.tvKategori);
            holder.tvDeskripsi = convertView.findViewById(R.id.tvDeskripsi);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MenuMakanan item = listMenu.get(position);
        holder.tvNama.setText(item.getNamaMenu());
        holder.tvHarga.setText(item.getHarga());
        holder.tvKategori.setText("Kategori: " + item.getKategori());
        holder.tvDeskripsi.setText(item.getDeskripsi());
        holder.imgFoto.setImageResource(item.getFotoResId());

        return convertView;
    }

    public void updateData(List<MenuMakanan> newList) {
        this.listMenu = newList;
        notifyDataSetChanged();
    }
}