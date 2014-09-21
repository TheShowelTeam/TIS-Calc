package com.Tol_V.tiscalc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private TextView txtViewTest;
    private Button btnTest;
    private LinearLayout linLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInterfaceResources();

        NodesTree tree = NodesTree.getInstance();
        //Log.d("root:", tree.toString() );
        txtViewTest.setText(tree.toString());

        drawList();
    }

    private void drawList(){

        linLayout.removeAllViews();
        NodesTree tree = NodesTree.getInstance();
        ArrayList<Node> items = tree.getChildren();

        LayoutInflater ltInflater = getLayoutInflater();

        for (Node cur: items){
            View item = ltInflater.inflate(R.layout.list_item, linLayout, false);

            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View item) {
                    NodesTree tree = NodesTree.getInstance();
                    ArrayList<Node> items = tree.getChildren();

                    TextView tvType = (TextView) item.findViewById(R.id.tvType);
                    TextView tvName = (TextView) item.findViewById(R.id.tvName);
                    ImageView ivPicture = (ImageView) findViewById(R.id.ivPicture);

                    String name = tvName.getText().toString();
                    int i = 0;
                    while (i < items.size() && !items.get(i).getName().equals(name)){
                        i++;
                    }
                    if (i == items.size()){
                        return;
                    }

                    Node tmp = items.get(i);
                    if (tmp.getType() == NodeType.CATEGORY){
                        tree.setCurrent((Category)tmp);
                        drawList();
                    }

                }
            });

            TextView tvType = (TextView) item.findViewById(R.id.tvType);
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            ImageView ivPicture = (ImageView) findViewById(R.id.ivPicture);

            String type;// = cur.getType() == NodeType.CATEGORY ? "Category" : "Item";
            if (cur.getType() == NodeType.CATEGORY){
                type = "Category";
            } else {
                type = "Item";
            }

            if (item == null){
                Log.d("WE ARE", " STILL FUCKED");
            }

            tvType.setText(type);
            tvName.setText(cur.getName());
            //ivPicture.setImageDrawable(R.drawable.ic_launcher);

            linLayout.addView(item);

        }
    }

    private void getInterfaceResources(){
        txtViewTest = (TextView) findViewById(R.id.txtViewTest);
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

    public void btnTestClick(View view) {
        Node node = new Node(null, "Fuck You", null, NodeType.ITEM);
        Node item = new Item(null, "Item1", null, NodeType.ITEM, 100);
        Node category = new Category(null, "Category1", null, NodeType.CATEGORY);

        String msg = node.toString() + "\n" + item.toString() + '\n' + category.toString();
        Log.d("BLA", msg);
        txtViewTest.setText(msg);
    }

    public void btnBackClick(View view) {
        NodesTree tree = NodesTree.getInstance();
        tree.setCurrentUp();
        drawList();
    }
}
