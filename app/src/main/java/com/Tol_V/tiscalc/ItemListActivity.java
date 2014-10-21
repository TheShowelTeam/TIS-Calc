package com.Tol_V.tiscalc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class ItemListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        drawList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_delete_list:
                deleteList();
                return true;
            case R.id.action_write_list:
                writeList();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void deleteList(){
        SelectedItems.getInstance().deleteAllItems();
        drawList();
    }

    private void writeList(){
        //do stuff
        ChooseFileNameDialog();
    }


    private void writeToFileHTML(String filePath)
    {
        if (filePath.equals("")) {
            Log.d("writeListPDF()", "empty input");
            return;
        }
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d("writeListPDF()", "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        // получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + "TISCalc(results)");
        // создаем каталог
        sdPath.mkdirs();
        // формируем объект File, который содержит путь к файлу
        File sdFile = new File(sdPath, filePath+".html");
        try {
            // открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
            // пишем данные
            SelectedItems selectedItems = SelectedItems.getInstance();
            String tab = "\t";
            String op = "<td>";
            String cl = "</td>";


            bw.write("<html>" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" +
                    "<h1 align = \"center\"> Коммерческое предложение </h1>\n" +
                    "<table border align = \"center\">" +
                    "        <tr>\n" +
                    "                <th>Название</th> <th>Кол-во</th> <th>Стоимость</th>\n" +
                    "        </tr>");
           // bw.write("--------------------------------------\n");
            for (int i = 0; i < selectedItems.getItems().size(); i++)
            {
                String name = selectedItems.getFinalItem(i).getName();
                String count = Integer.toString(selectedItems.getFinalItem(i).getCount());
                String comment = selectedItems.getFinalItem(i).getComment();
                String cost = Float.toString((float)selectedItems.getFinalItem(i).getPrice()/100);
                String price = Float.toString((float)selectedItems.getFinalItem(i).getFullPrice()/100);

                bw.write("<tr>");
                bw.write(op+name+cl + op+count+cl + op+price+cl);
                bw.write("</tr>");
            }
            bw.write("</table>");
            bw.write("<p align =\"center\">");
            bw.write("Итого:" + Float.toString((float)selectedItems.getResultPrice()/100));
            bw.write("</p>");
            bw.write("</html>");
            // закрываем поток
            bw.close();

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
            // Find the SD Card path
            File filepath = Environment.getExternalStorageDirectory();

            // Create a new folder in SD Card
            File dir = new File(filepath.getAbsolutePath()
                    + "/TISCalc(results)/");
            dir.mkdirs();

            // Create a name for the saved image
            File file = new File(dir, "logo_small.png");

            OutputStream output;

            // Show a toast message on successful save
            try {

                output = new FileOutputStream(file);

                // Compress into png format image from 0% - 100%
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
                output.flush();
                output.close();
            }

            catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        Log.d("writeList()", "Файл записан на SD: " + sdFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeToFileTXT(String filePath)
    {
        if (filePath.equals("")) {
            Log.d("writeList()", "empty input");
            return;
        }
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d("writeList()", "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        // получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + "TISCalc(results)");
        // создаем каталог
        sdPath.mkdirs();
        // формируем объект File, который содержит путь к файлу
        File sdFile = new File(sdPath, filePath+".txt");
        try {
            // открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
            // пишем данные
            SelectedItems selectedItems = SelectedItems.getInstance();
            String tab = "\t";
            bw.write("Название" + tab + "Коммент." + tab + "Цена" + tab + "Кол-во" + tab + "Стоимость\n");
            bw.write("--------------------------------------\n");
            for (int i = 0; i < selectedItems.getItems().size(); i++)
            {
                String name = selectedItems.getFinalItem(i).getName();
                String count = Integer.toString(selectedItems.getFinalItem(i).getCount());
                String comment = selectedItems.getFinalItem(i).getComment();
                String cost = Float.toString((float)selectedItems.getFinalItem(i).getPrice()/100);
                String price = Float.toString((float)selectedItems.getFinalItem(i).getFullPrice()/100);
                bw.write(name + tab + comment + tab + cost + tab + count + tab + price + "\n");
            }
            bw.write("Итого:" + Float.toString((float)selectedItems.getResultPrice()/100));

            // закрываем поток
            bw.close();
            Log.d("writeList()", "Файл записан на SD: " + sdFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private void ChooseFileNameDialog()
    {
        String res = "";
        final EditText input = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(ItemListActivity.this);
        builder.setTitle("Удаление")
                .setMessage("Введите имя файла (фирмы)")
                .setCancelable(false)
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Сохранить",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                writeToFileTXT(input.getText().toString());
                                writeToFileHTML(input.getText().toString());

                                dialog.cancel();
                            }
                        }
                );
        AlertDialog alert = builder.create();
        alert.setView(input);
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

            tvName.setText("Название: " + cur.getName());
            tvCount.setText("Кол-во: " + Integer.toString(cur.getCount()));
            tvPrice.setText("Цена: " + Float.toString((float)cur.getPrice()/100));
            tvFullPrice.setText("Стоимость: " + Float.toString((float)cur.getFullPrice()/100));
            tvComment.setText("Коммент.: " + cur.getComment());

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
        String msg = "Итоговая цена: " + df.format((float)SelectedItems.getInstance().getResultPrice()/100);
        tvResultPrice.setText(msg);
        linLayout.addView(item);
    }

}
