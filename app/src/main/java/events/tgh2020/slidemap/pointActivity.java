package events.tgh2020.slidemap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pointActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        String[] subjects = {"9/14(月)", "9/15(火)", "9/16(水)", "9/17(木)"};
        String[] comments = {"三浦さんに写真を送信　　　+30pt", "鈴木さんから写真を受信　　-20pt",
                "三浦さんから写真を受信　　-30pt", "南さんに写真を送信　　　　+10pt"};

        // ListViewに表示するリスト項目をArrayListで準備する
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i=0; i<subjects.length; i++){
            Map<String, String> item = new HashMap<String, String>();
            item.put("Subject", subjects[i]);
            item.put("Comment", comments[i]);
            data.add(item);
        }

        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] { "Subject", "Comment" },
                new int[] { android.R.id.text1, android.R.id.text2});

        // ListViewにArrayAdapterを設定する
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}