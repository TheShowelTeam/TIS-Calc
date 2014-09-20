package com.Tol_V.tiscalc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private LinearLayout linLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInterfaceResources();

        NodesTree.getInstance();

        drawList();
    }

    private void drawList(){

        linLayout.removeAllViews();
        NodesTree tree = NodesTree.getInstance();
        ArrayList<Node> items = tree.getChildren();

        LayoutInflater ltInflater = getLayoutInflater();

        for (Node cur: items){
            View item = ltInflater.inflate(R.layout.list_item, linLayout, false);

            //TextView tvType = (TextView) item.findViewById(R.id.tvType);
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            //ImageView ivPicture = (ImageView) findViewById(R.id.ivPicture);

            //String type = cur.getType() == NodeType.CATEGORY ? "Category" : "Item";

            if (cur instanceof Item){
                item.setBackgroundColor(getResources().getColor(R.color.item_background));
            }

            if (cur instanceof Category){
                item.setBackgroundColor(getResources().getColor(R.color.category_background));
            }

            //tvType.setText(type);
            tvName.setText(cur.getName());
            //ivPicture.setImageDrawable(R.drawable.ic_launcher);

            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View item) {
                    NodesTree tree = NodesTree.getInstance();
                    ArrayList<Node> items = tree.getChildren();

                    TextView tvName = (TextView) item.findViewById(R.id.tvName);

                    String name = tvName.getText().toString();
                    int i = 0;
                    while (i < items.size() && !items.get(i).getName().equals(name)){
                        i++;
                    }
                    if (i == items.size()){
                        return;
                    }

                    Node tmp = items.get(i);
                    if (tmp instanceof Category){
                        tree.setCurrent((Category)tmp);
                        drawList();
                    }

                    if (tmp instanceof Item){
                        FinalItem newItem = new FinalItem((Item)tmp, "test", 1);
                        SelectedItems.getInstance().addFinalItem(newItem);
                        String msg = newItem.toString();
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                        Log.d("added FinalItem: ", msg);
                    }

                }
            });

            linLayout.addView(item);

        }
    }

    private void getInterfaceResources(){
        linLayout = (LinearLayout) findViewById(R.id.linLayout);
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @Override
    public void onBackPressed() {
        NodesTree tree = NodesTree.getInstance();
        tree.setCurrentUp();
        drawList();
    }

    public void btnBackClick(View view) {
//        NodesTree tree = NodesTree.getInstance();
//        tree.setCurrentUp();
//        drawList();
    }
}
