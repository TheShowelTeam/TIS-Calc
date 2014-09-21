package com.Tol_V.tiscalc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class ItemListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        drawList();
    }

    private  void DeleteDialog(final FinalItem tmp)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(ItemListActivity.this);
        builder.setTitle("Удаление")
                .setMessage(tmp.getName())
                .setCancelable(false)
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Удалить",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //deleting
                                SelectedItems selectedItems = SelectedItems.getInstance();
                                selectedItems.deleteFinalItem(tmp);
                                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linLayout2);
                                linearLayout.removeAllViews();
                                drawList();
                                dialog.cancel();
                            }
                        }
                );
        AlertDialog alert = builder.create();
        alert.show();
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
            TextView tvComment = (TextView) item.findViewById(R.id.tvCommentExt);

            tvName.setText("Name: " + cur.getName());
            tvCount.setText("Count: " + Integer.toString(cur.getCount()));
            tvPrice.setText("Cost: " + Integer.toString(cur.getPrice()));
            tvFullPrice.setText("Price: " + Integer.toString(cur.getFullPrice()));
            tvComment.setText("Comment: " + cur.getComment());

            final FinalItem tmpCur = new FinalItem(cur);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DeleteDialog(tmpCur);
                }
            });

            linLayout.addView(item);
        }

        View item = ltInflater.inflate(R.layout.full_price_layout, linLayout, false);
        TextView tvResultPrice = (TextView) item.findViewById(R.id.tvResultPrice);

        DecimalFormat df = new DecimalFormat("#.##");
        String msg = "Result price: " + df.format(SelectedItems.getInstance().getResultPrice());
        tvResultPrice.setText(msg);
        linLayout.addView(item);
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
