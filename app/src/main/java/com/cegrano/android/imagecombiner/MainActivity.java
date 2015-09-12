package com.cegrano.android.imagecombiner;

import android.support.percent.PercentFrameLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import static com.cegrano.android.imagecombiner.R.id.grid_layout;

public class MainActivity extends AppCompatActivity {

    private PercentFrameLayout mGridLayout;
    private RecyclerView recyclerView;
    private List<CombinerFormat> combiners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGridLayout = (PercentFrameLayout) findViewById(grid_layout);
        recyclerView = (RecyclerView) findViewById(R.id.list_image_small);
        setDate();
    }

    private void setDate() {
        combiners = new Gson().fromJson(CombinerFormat.test, new TypeToken<List<CombinerFormat>>() {
        }.getType());
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = View.inflate(parent.getContext(), R.layout.layout_grid, null);
                return new RecyclerView.ViewHolder(view) {
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
                final PercentFrameLayout gridLayout = (PercentFrameLayout) holder.itemView.findViewById(R.id.grid_layout);
                CombinerShowHelper.draw(gridLayout, combiners.get(position));
                gridLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CombinerShowHelper.draw(mGridLayout, combiners.get(position));
                    }
                });
            }

            @Override
            public int getItemCount() {
                return combiners == null ? 0 : combiners.size();
            }
        });
        CombinerShowHelper.draw(mGridLayout,combiners.get(3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
