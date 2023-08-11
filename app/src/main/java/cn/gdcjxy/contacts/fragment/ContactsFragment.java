package cn.gdcjxy.contacts.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.gdcjxy.contacts.R;
import cn.gdcjxy.contacts.bean.Contact;
import cn.gdcjxy.contacts.dao.ContactDao;
import cn.gdcjxy.contacts.ui.AlterActivity;
import cn.gdcjxy.contacts.ui.ReFlashListView;

/**
 * ContactsFragment class
 */
public class ContactsFragment extends Fragment implements ReFlashListView.IReflashListener {

    private View view;
    private ReFlashListView contacts_list;
    private MyAdapter adapter;

    // list data
    private List<Contact> list;
    // database class
    private ContactDao dao;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contacts, container, false);
        if (view != null) {
            initView();
            dao = new ContactDao(getContext());
            // query all data
            list = dao.queryAll();
            adapter = new MyAdapter();
            contacts_list.setAdapter(adapter);// addListView
        }

        return view;
    }

    private void initView() {
        contacts_list = (ReFlashListView) view.findViewById(R.id.contacts_list);
        contacts_list.setOnItemClickListener(new MyOnItemClickListener());
        contacts_list.setInterface(this);
    }

    //reflush
    @Override
    public void onReflash() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                list = dao.queryAll();
                adapter = new MyAdapter();
                contacts_list.setAdapter(adapter);// addListView
                contacts_list.reflashComplete();
            }
        }, 2000);
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // convertViewInfo
            convertView = convertView != null ? convertView : View.inflate(getActivity(), R.layout.contacts_item, null);
            // getTextView
            TextView contacts_id = (TextView) convertView.findViewById(R.id.contacts_id);
            TextView contacts_name = (TextView) convertView.findViewById(R.id.contacts_name);
            TextView contacts_tel = (TextView) convertView.findViewById(R.id.contacts_tel);
            // getAccount
            final Contact a = list.get(position);
            // getTextView
            contacts_id.setText(a.getId() + "");
            contacts_name.setText(a.getName() + "");
            contacts_tel.setText(a.getTel() + "");
            return convertView;
        }

    }

    //MyOnItemClickListener
    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // getPosition
            Contact c = (Contact) parent.getItemAtPosition(position);
            Intent intent = new Intent(getContext(), AlterActivity.class);
            intent.putExtra("id", c.getId());
            intent.putExtra("name", c.getName());
            intent.putExtra("tel", c.getTel());
            startActivity(intent);
        }
    }
}

