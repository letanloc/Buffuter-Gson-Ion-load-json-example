package loc.com.gsonloadjson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.StringReader;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import loc.com.gsonloadjson.Adapter.ImagesAdapter;
import loc.com.gsonloadjson.Model.Read;

/**
 * Created by loc on 07/08/2015.
 */
public class fragment extends Fragment {

    @Bind(R.id.gridView)
    GridView gr;
    Read read;
    ImagesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, v);
        read = new Read();
        Ion.with(this)
                .load("https://api.desktoppr.co/1/users/letanloc/wallpapers")
                .asString()
                .setCallback(OnloadJson);


        return v;
    }

    private FutureCallback<String> OnloadJson = new FutureCallback<String>() {
        @Override
        public void onCompleted(Exception e, String result) {

            if (e == null) {
                try {
                    JsonReader reader = new JsonReader(new StringReader(result));
                    Gson gson = new Gson();
                    Read.ListImage m = gson.fromJson(reader, Read.ListImage.class);
                    ArrayList<Read.Data> lis = m.getlist();
                    adapter = new ImagesAdapter(getActivity(), lis);
                    gr.setAdapter(adapter);

                } catch (Exception dx) {
                    Log.e("Error", dx.toString());

                }
            }

        }
    };

}
