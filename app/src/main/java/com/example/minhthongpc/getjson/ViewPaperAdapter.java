package com.example.minhthongpc.getjson;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.minhthongpc.getjson.model.ThongTin;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPaperAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<ThongTin> thongTins;

    private TextView textView,textView2;
    private ImageView imageView;


    public ViewPaperAdapter(Context context, List<ThongTin> thongTins) {
        this.context = context;
        this.thongTins = thongTins;
    }

    @Override
    public int getCount() {
        return thongTins.size();
    }



    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        //layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        //View view = layoutInflater.inflate(R.layout.item,container,false );
        View itemview = LayoutInflater.from(context).inflate(R.layout.item, container, false);
        textView = itemview.findViewById(R.id.textview);
        textView2 = itemview.findViewById(R.id.textview2);
        imageView = itemview.findViewById(R.id.imageview);
        ThongTin thongTin = thongTins.get(position);

        textView.setText(thongTin.getDesc());
        Picasso.with(context).load(thongTin.getImage()).into(imageView);
        textView2.setText("asdsadsadas");

        container.addView(itemview);

        return itemview;
    }

    @Override
    public void destroyItem( ViewGroup container, int position,Object object) {
        container.removeView((View)object);
    }
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==o;
    }
}
