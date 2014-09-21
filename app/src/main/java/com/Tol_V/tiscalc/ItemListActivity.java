package com.Tol_V.tiscalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class ItemListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        drawList();
    }

    private void drawList() {
        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout2);
        linLayout.removeAllViews();

        LayoutInflater ltInflater = getLayoutInflater();

        ArrayList<FinalItem> items = SelectedItems.getInstance().getItems();

        for(FinalItem cur: items){
            View item = ltInflater.inflate(R.layout.list_item_extended, linLayout, false);

            TextView tvName = (TextView) item.findViewById(R.id.tvNameExt);
            TextView tvCount = (TextView) item.findViewById(R.id.tvCountExt);
            TextView tvPrice = (TextView) item.findViewById(R.id.tvPriceExt);
            TextView tvFullPrice = (TextView) item.findViewById(R.id.tvFullPriceExt);

            tvName.setText("Name: " + cur.getName());
            tvCount.setText("Count: " + Integer.toString(cur.getCount()));
            tvPrice.setText("Cost: " + Integer.toString(cur.getPrice()));
            tvFullPrice.setText("Price: " + Integer.toString(cur.getFullPrice()));

            linLayout.addView(item);
        }
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.item_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
