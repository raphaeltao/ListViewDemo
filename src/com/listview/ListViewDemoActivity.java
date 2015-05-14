package com.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * ListView保留选中样式
 * @author raphael
 * 
 */
public class ListViewDemoActivity extends Activity
{
    private int previous_selected = -1;

    private TextView previous_view;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i <= 50; i++)
        {
            list.add("item " + i);
        }
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyAdapter(list));
        // 设置item监听
        listView.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                TextView item = (TextView) view;
                item.setBackgroundResource(R.drawable.item_pressed);// 将当前选中条目添加选中效果
             // 如果已经单击过条目并且上次保存的item位置和当前位置不同
                if (previous_selected != -1 && previous_selected != position)
                {
                    previous_view.setBackgroundResource(R.drawable.item_bg);// 把上次选中的样式去掉
                }
                previous_view = item; // 记录当前选中条目
                previous_selected = position;// 记录当前位置
            }
        });
    }

    /**
     * 自定义Adapter
     * @author Administrator
     *
     */
    private final class MyAdapter extends BaseAdapter
    {
        TextView textView = null;

        private ArrayList<String> list = null;

        public MyAdapter(ArrayList<String> list)
        {
            this.list = list;
        }

        @Override
        public int getCount()
        {
            return list.size();
        }

        @Override
        public Object getItem(int position)
        {
            return list.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
            {
                textView = new TextView(ListViewDemoActivity.this);
            }
            else
            {
                textView = (TextView) convertView;
            }
            if (previous_selected == position)
            {
                // 当listview滑动的时候仍然保持当前的选中效果
                textView.setBackgroundResource(R.drawable.item_pressed);
            }
            else
            {
                textView.setBackgroundResource(R.drawable.item_bg);
            }
            textView.setText(list.get(position));
            textView.setTextSize(40);
            return textView;
        }
    }
}