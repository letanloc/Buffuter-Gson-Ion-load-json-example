package loc.com.gsonloadjson.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

import loc.com.gsonloadjson.Model.Read;
import loc.com.gsonloadjson.R;

/**
 * Created by loc on 07/08/2015.
 */
public class ImagesAdapter extends BaseAdapter {
    ArrayList<Read.Data> list;
    Context context;
    Viewhole h;

    public ImagesAdapter(Context context, ArrayList<Read.Data> list) {
        this.list = list;
        this.context = context;
        h = new Viewhole();

    }

    @Override
    public int getCount() {
        return list.size();
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
        View view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_list, parent
                , false);
        // Html.fromHtml() giúp thông dich cac  lện của html ra text\
        h.txtTitle = (TextView) view.findViewById(R.id.textView);
        h.Img = (ImageView) view.findViewById(R.id.imageView);

        h.txtTitle.setText(Html.fromHtml(list.get(position).getId()));
        if ((list.get(position).getImagel()).getUrl() != null) {
            Ion.with(context)
                    .load((list.get(position).getImagel()).getUrl())
                    .withBitmap()
                    .intoImageView(h.Img);
        }
        return view;
    }

    // lóp này được sử dụng để  làm cho list của bạn muot hơn khi có môt  lượng data lớn
    private class Viewhole {
        TextView txtTitle;
        ImageView Img;

    }
}
