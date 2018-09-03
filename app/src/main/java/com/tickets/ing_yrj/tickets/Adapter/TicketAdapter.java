package com.tickets.ing_yrj.tickets.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tickets.ing_yrj.tickets.Model.Ticket;
import com.tickets.ing_yrj.tickets.R;

import java.util.List;

public class TicketAdapter extends BaseAdapter {
    private List<Ticket> item;
    private Context context;

    public TicketAdapter(Context context, List<Ticket> item){
        this.context = context;
        this.item=item;
    }
    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_ticket, parent, false);
            viewHolder.ticket_text_1 = (TextView) convertView.findViewById(R.id.ticket_text_1);
            viewHolder.ticket_text_2 = (TextView) convertView.findViewById(R.id.ticket_text_2);
            viewHolder.text_date_item_ticket_1 = (TextView) convertView.findViewById(R.id.text_date_item_ticket_1);
            viewHolder.text_date_item_ticket_2=(TextView) convertView.findViewById(R.id.text_date_item_ticket_2);
            viewHolder.date_item_ticket_1=(TextView) convertView.findViewById(R.id.date_item_ticket_1);
            viewHolder.date_item_ticket_2=(TextView) convertView.findViewById(R.id.date_item_ticket_2);
            viewHolder.img_ticket_url = (ImageView) convertView.findViewById(R.id.img_ticket_url);
            viewHolder.btn_item_ticket_compartir = (ImageView) convertView.findViewById(R.id.btn_item_ticket_compartir);
            viewHolder.btn_item_ticket_mas = (ImageView) convertView.findViewById(R.id.btn_item_ticket_mas);
            viewHolder.ratingBar_item_ticket = (RatingBar) convertView.findViewById(R.id.ratingBar_item_ticket);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(item.get(position).getText_1().equals("")){
            viewHolder.ticket_text_1.setText("Not ticket");
            viewHolder.ticket_text_2.setVisibility(View.INVISIBLE);
            viewHolder.text_date_item_ticket_1.setVisibility(View.INVISIBLE);
            viewHolder.text_date_item_ticket_2.setVisibility(View.INVISIBLE);
            viewHolder.img_ticket_url.setVisibility(View.INVISIBLE);
            viewHolder.btn_item_ticket_compartir.setVisibility(View.INVISIBLE);
            viewHolder.btn_item_ticket_mas.setVisibility(View.INVISIBLE);
            viewHolder.ratingBar_item_ticket.setVisibility(View.INVISIBLE);
            viewHolder.date_item_ticket_1.setVisibility(View.INVISIBLE);
            viewHolder.date_item_ticket_2.setVisibility(View.INVISIBLE);
        }else {
            viewHolder.ticket_text_1.setText(item.get(position).getText_1());
            viewHolder.ticket_text_2.setText(item.get(position).getText_2());
            viewHolder.text_date_item_ticket_1.setText(item.get(position).getDate_1());
            viewHolder.text_date_item_ticket_2.setText(item.get(position).getDate_2());
            Glide.with(convertView.getContext())
                        .load(item.get(position).getUrlImg())
                        .into(viewHolder.img_ticket_url);
            viewHolder.btn_item_ticket_compartir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            viewHolder.btn_item_ticket_mas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            viewHolder.ratingBar_item_ticket.setRating(item.get(position).getPoint());
            viewHolder.ticket_text_2.setVisibility(View.VISIBLE);
            viewHolder.text_date_item_ticket_1.setVisibility(View.VISIBLE);
            viewHolder.text_date_item_ticket_2.setVisibility(View.VISIBLE);
            viewHolder.img_ticket_url.setVisibility(View.VISIBLE);
            viewHolder.btn_item_ticket_compartir.setVisibility(View.VISIBLE);
            viewHolder.btn_item_ticket_mas.setVisibility(View.VISIBLE);
            viewHolder.ratingBar_item_ticket.setVisibility(View.VISIBLE);
            viewHolder.date_item_ticket_1.setVisibility(View.VISIBLE);
            viewHolder.date_item_ticket_2.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
    public void clear(){item.clear();}

    public static class ViewHolder{
        TextView ticket_text_1;
        TextView ticket_text_2;
        TextView text_date_item_ticket_1;
        TextView text_date_item_ticket_2;
        ImageView img_ticket_url;
        ImageView btn_item_ticket_compartir;
        ImageView btn_item_ticket_mas;
        RatingBar ratingBar_item_ticket;
        TextView date_item_ticket_1;
        TextView date_item_ticket_2;
    }
}
