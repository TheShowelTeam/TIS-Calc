package com.Tol_V.tiscalc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private LinearLayout linLayout;
    private RelativeLayout relLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInterfaceResources();

        NodesTree.getInstance();

        drawList();
    }

    @Override
    public void onBackPressed() {
        NodesTree tree = NodesTree.getInstance();
        tree.setCurrentUp();
        drawList();
    }

    private void getInterfaceResources(){
        linLayout = (LinearLayout) findViewById(R.id.linLayout);
    }


    private void ShowAddDialog(final Item tmp)
    {
        Context mContext = getApplicationContext();
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.add_item, relLayout, false);

        final EditText input = (EditText)layout.findViewById(R.id.editText);

        final TextView tv_count = (TextView)layout.findViewById(R.id.textView2);
        final TextView tv_comment = (TextView)layout.findViewById(R.id.textView);
        final NumberPicker count_picker = (NumberPicker)layout.findViewById(R.id.numberPicker);


        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        tv_count.setText("Кол-во");
        tv_comment.setText("Комментарий");
        input.setText("");

        count_picker.setMinValue(1);
        count_picker.setMaxValue(100);
        count_picker.setValue(1);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Добавление!")
                .setMessage(tmp.getName())
                .setCancelable(false)
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String comment = input.getText().toString();
                                FinalItem newItem = new FinalItem((Item)tmp, comment, count_picker.getValue());
                                SelectedItems.getInstance().addFinalItem(newItem);
                                String msg = newItem.toString();
                                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        }
                );
        AlertDialog alert = builder.create();
        alert.setView(layout);
        alert.show();
    }
    private void drawList(){

        linLayout.removeAllViews();
        NodesTree tree = NodesTree.getInstance();
        ArrayList<Node> items = tree.getChildren();

        LayoutInflater ltInflater = getLayoutInflater();

        for (Node cur: items){
            View item = ltInflater.inflate(R.layout.list_item, linLayout, false);

            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            //ImageView ivPicture = (ImageView) findViewById(R.id.ivPicture);

            tvName.setText(cur.getName());
            if (cur instanceof Item){
                item.setBackgroundColor(getResources().getColor(R.color.item_background));
            }
            if (cur instanceof Category){
                item.setBackgroundColor(getResources().getColor(R.color.category_background));
            }

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
                        ShowAddDialog((Item)tmp);
                    }
                }
            });

            linLayout.addView(item);

        }
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
}
