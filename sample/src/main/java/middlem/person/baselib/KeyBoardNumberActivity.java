package middlem.person.baselib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import person.middlem.viewmodule.listview.StringData;

public class KeyBoardNumberActivity extends AppCompatActivity {

    private ListView listView;
    private KeyBoardAdapter keyBoardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_board_number);
        listView = findViewById(R.id.listView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        keyBoardAdapter=new KeyBoardAdapter(this,getStringData());
        listView.setAdapter(keyBoardAdapter);
    }

    private List<KeyBoardData> getStringData() {
        List<KeyBoardData> stringList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            KeyBoardData keyBoardData = new KeyBoardData();
            keyBoardData.setContent("数据item【  "+i+"  】");
            keyBoardData.setType(i);
            stringList.add(keyBoardData);
        }
        return  stringList;
    }
}
