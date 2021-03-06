package linxiaowu.com.swiperefreshlayoutdemo;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import linxiaowu.com.swiperefreshlayoutdemo.model.HealthListBean;
import linxiaowu.com.swiperefreshlayoutdemo.net.image.DefaultImageLoader;
import linxiaowu.com.swiperefreshlayoutdemo.util.NetworkUtils;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    // 数据集
    private List<HealthListBean.HealthBean> type;
    private DefaultImageLoader imageLoder;

    public RecyclerAdapter(List<HealthListBean.HealthBean> dataset) {
        super();
        type = dataset;
        imageLoder = DefaultImageLoader.getInstance();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.diabetes_knowledge_item, null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
//        viewHolder.mTextView.setText(type[i]);
        HealthListBean.HealthBean appKnowledge = type.get(i);
        viewHolder.title.setText(appKnowledge.TITLE);
        String time = appKnowledge.ADDTIME;
        viewHolder.time.setText(time);
        String path = NetworkAPIs.IMAGE_URL + NetworkUtils.imageUrl(appKnowledge.PHOTO);
        imageLoder.get(path, NetworkUtils.getImageListener(viewHolder.knowledge_icon));
    }

    @Override
    public int getItemCount() {
        return type.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView knowledge_icon;
        private TextView title;
        private TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            knowledge_icon = (ImageView) itemView
                    .findViewById(R.id.knowledge_icon);
            title = (TextView) itemView
                    .findViewById(R.id.knowledge_title);
            time = (TextView) itemView
                    .findViewById(R.id.knowledge_time);
        }

    }
}
