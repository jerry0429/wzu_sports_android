package com.tim.app.ui.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.library.widget.recycle.BaseRecyclerAdapter;
import com.application.library.widget.roundimg.RoundedImageView;
import com.bumptech.glide.Glide;
import com.tim.app.R;
import com.tim.app.constant.AppConstant;
import com.tim.app.server.entry.RankingData;
import com.tim.app.ui.cell.GlideApp;
import com.tim.app.ui.fragment.RankingDataFragment;

import java.util.List;

/**
 * 排行榜
 */
public class RankingDataAdapter extends BaseRecyclerAdapter<BaseRecyclerAdapter.BaseRecyclerViewHolder, RankingData> {
    private RankingDataFragment context;
    private int type;

    public RankingDataAdapter(RankingDataFragment mContext, List<RankingData> mDataList, int type) {
        super(mDataList);
        this.context = mContext;
        this.type = type;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseRecyclerViewHolder
                holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_rank_data, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder mHolder, int position, RankingData data) {
        if (data == null) {
            return;
        }

        final ViewHolder holder = (ViewHolder) mHolder;

        if (AppConstant.TYPE_COST_ENERGY == type) {
            holder.tvCostNumber.setText(String.valueOf(data.getCostValue()));
        } else if (AppConstant.TYPE_COST_TIME == type) {
            holder.tvCostNumber.setText(String.valueOf(data.getCostValue() / 60));
        }
        if (AppConstant.TYPE_COST_TIME == type) {
            holder.tvCostUnit.setText(" " + context.getString(R.string.minute));
        } else if (AppConstant.TYPE_COST_ENERGY == type) {
            holder.tvCostUnit.setText(" " + context.getString(R.string.kcal));
        }
        if (!TextUtils.isEmpty(data.getUserName())) {
            holder.tvName.setText(data.getUserName());
        }
        if (!TextUtils.isEmpty(data.getAvatar())) {
            if (data.getAvatar() == "") {

            } else {
                // Glide.with(context).clear(holder.rivAvatar);
                GlideApp.with(context)
                        .load(data.getAvatar())
                        .skipMemoryCache(true)
                        .placeholder(R.drawable.ic_default_avatar)
                        .circleCrop()
                        .into(holder.rivAvatar);
            }
        }
        holder.tvNo.setText(String.valueOf(position + 4));
        if (position != getDataList().size() - 1) {
            holder.vLine.setVisibility(View.VISIBLE);
        } else {
            holder.vLine.setVisibility(View.GONE);
        }
    }

    @Override
    public void onViewRecycled(BaseRecyclerViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        Glide.with(viewHolder.itemView.getContext()).clear(viewHolder.itemView);
    }

    /**
     * todo 这个ViewHolder有待改进
     */
    public class ViewHolder extends BaseRecyclerViewHolder {
        TextView tvCostNumber;
        TextView tvCostUnit;
        TextView tvNo;
        RoundedImageView rivAvatar;
        TextView tvName;
        View vLine;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCostNumber = (TextView) itemView.findViewById(R.id.tvCostNumber);
            tvCostUnit = (TextView) itemView.findViewById(R.id.tvCostUnit);
            tvNo = (TextView) itemView.findViewById(R.id.tvNo);
            rivAvatar = (RoundedImageView) itemView.findViewById(R.id.rivAvatar);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            vLine = (View) itemView.findViewById(R.id.vLine);
        }
    }
}
