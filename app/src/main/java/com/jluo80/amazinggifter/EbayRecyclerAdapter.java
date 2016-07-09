package com.jluo80.amazinggifter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by Jiahao on 7/8/2016.
 */
public class EbayRecyclerAdapter extends RecyclerView.Adapter<EbayRecyclerAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<Gift> mGifts;
    private ImageLoader mImageLoader;

    EbayRecyclerAdapter(Context context, ArrayList<Gift> gifts) {
        this.mContext = context;
        this.mGifts = gifts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_gift_card_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        final Gift gift = mGifts.get(i);
        viewHolder.giftTitle.setText(gift.getItemTitle());
        viewHolder.currentPrice.setText(gift.getCurrentPrice());

        // Get the ImageLoader through your singleton class.
        mImageLoader = MySingleton.getInstance(viewHolder.giftTitle.getContext()).getImageLoader();
        viewHolder.giftPicture.setImageUrl(gift.getGalleryUrl(), mImageLoader);

        // Set up onClick events
        viewHolder.giftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri itemUri = Uri.parse(gift.getItemUrl());
                Context context = view.getContext();
                context.startActivity(new Intent(Intent.ACTION_VIEW, itemUri));
            }
        });

        viewHolder.giftPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                context.startActivity(new Intent(mContext, AddGiftsActivity.class));
            }
        });

        viewHolder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return mGifts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //        private final TextView mTextView;
        CardView mCardView;
        TextView giftTitle;
        TextView currentPrice;
        NetworkImageView giftPicture;
        TextView buyButton;

        ViewHolder(View view) {
            super(view);
            mCardView = (CardView)itemView.findViewById(R.id.cv);
            giftTitle = (TextView)itemView.findViewById(R.id.gift_title);
            currentPrice = (TextView)itemView.findViewById(R.id.current_price);
            giftPicture = (NetworkImageView)itemView.findViewById(R.id.gift_picture);
            buyButton = (TextView)itemView.findViewById(R.id.buy);
        }
    }

}
