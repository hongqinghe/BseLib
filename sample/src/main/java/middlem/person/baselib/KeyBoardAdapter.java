package middlem.person.baselib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import person.middlem.viewmodule.listview.StringData;
import person.middlem.viewmodule.listview.ViewHolderUtils;

/***********************************************
 * <P> desc:
 * <P> Author: gongTong
 * <P> Date: 2018/5/15 11:02
 ***********************************************/

public class KeyBoardAdapter extends BaseAdapter {

    private Context mContext;
    private List<KeyBoardData> stringList;

    public KeyBoardAdapter(){

    }
    public KeyBoardAdapter(Context context, List<KeyBoardData> stringList) {
        this.mContext = context;
        this.stringList = stringList;
    }
    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_key_board, null);
        }
        TextView content = ViewHolderUtils.get(convertView, R.id.tv_content);
        EditText editText = ViewHolderUtils.get(convertView, R.id.edit);
        content.setText(stringList.get(position).getContent());
        editText.setText("99999"+stringList.get(position).getType());

        return convertView;
    }
}
