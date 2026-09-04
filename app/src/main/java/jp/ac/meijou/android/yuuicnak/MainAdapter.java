package jp.ac.meijou.android.yuuicnak;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Optional;

import jp.ac.meijou.android.yuuicnak.databinding.ListItemBinding;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final List<ListItem> list;

    public MainAdapter(List<ListItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 指定された位置のデータをViewHolderにバインド
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding binding;
        private ListItem currentItem;

        /**
         * 新しい ViewHolder インスタンスを生成します。
         *
         * @param parent 親のViewGroup
         * @return 生成された ViewHolder
         */
        public static ViewHolder create(@NonNull ViewGroup parent) {
            var view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        /**
         * コンストラクタ。
         *
         * @param itemView リストの1行分のView
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.binding = ListItemBinding.bind(itemView);

            // 項目がクリックされたときの処理を一度だけ設定
            itemView.setOnClickListener(v -> Optional.ofNullable(currentItem)
                    .ifPresent(item -> item.startActivity(v.getContext())));
        }

        /**
         * データをViewにバインド（表示）します。
         *
         * @param value バインドするListItemのデータ
         */
        public void onBind(ListItem value) {
            this.currentItem = value;
            binding.listImage.setImageDrawable(value.image());
            binding.listText.setText(value.description());
        }
    }
}
