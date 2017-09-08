package example.fastec.com.wang.latte.ec.main.person.order;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import example.fastec.com.wang.latte.ec.R;
import example.fastec.com.wang.latte.ui.recycler.MultipleFields;
import example.fastec.com.wang.latte.ui.recycler.MultipleItemEntity;
import example.fastec.com.wang.latte.ui.recycler.MultipleRecyclerAdapter;
import example.fastec.com.wang.latte.ui.recycler.MultipleViewHolder;

/**
 * Created by HP on 2017/8/31.
 */

public class OrderListAdapter extends MultipleRecyclerAdapter {


    protected OrderListAdapter(@Nullable List<MultipleItemEntity> data) {
        super(data);
        addItemType(OrderListItemType.ITEM_ORDER_LIST, R.layout.item_order_list);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case OrderListItemType.ITEM_ORDER_LIST:
                final AppCompatImageView imageView = holder.getView(R.id.image_order_list);
                final AppCompatTextView title = holder.getView(R.id.tv_order_list_title);
                final AppCompatTextView price = holder.getView(R.id.tv_order_list_price);
                final AppCompatTextView time = holder.getView(R.id.tv_order_list_time);

                final String titleVal = entity.getField(MultipleFields.TITLE);
                final String timeVal = entity.getField(OrderItemFields.TIME);
                final double priceVal = entity.getField(OrderItemFields.PRICE);
                final String imageUrl = entity.getField(MultipleFields.IMAGE_URL);

                Glide.with(mContext)
                        .load(imageUrl)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                        .dontAnimate()
                        .into(imageView);

                title.setText(titleVal);
                price.setText("价格：" + String.valueOf(priceVal));
                time.setText("时间：" + timeVal);
                break;
            default:

                break;
        }
    }
}