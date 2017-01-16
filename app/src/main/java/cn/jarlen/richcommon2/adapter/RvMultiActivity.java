package cn.jarlen.richcommon2.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.jarlen.richcommon.adapter.multiple.RvMultiAdapter;
import cn.jarlen.richcommon.adapter.multiple.RvMultiItemManager;
import cn.jarlen.richcommon.ui.BaseActivity;
import cn.jarlen.richcommon2.R;
import cn.jarlen.richcommon2.data.Bean;

/**
 * DESCRIBE:
 * Created by hjl on 2017/1/12.
 */

public class RvMultiActivity extends BaseActivity {

    private RecyclerView recyclerView;

    private MultiTestAdapter testAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_rv_adapter;
    }

    @Override
    protected void onBindView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        testAdapter = new MultiTestAdapter(this);
        recyclerView.setAdapter(testAdapter);

        List<Bean> datas = new ArrayList<Bean>();

        for (int index = 0; index < 1000; index++) {
            Bean bean = new Bean();
            bean.setType(index % 3);
            bean.setName("test " + index);

            datas.add(bean);
        }

        testAdapter.addDataList(datas);
    }

    @Override
    protected void preBindView() {

    }


    private class MultiTestAdapter extends RvMultiAdapter<Bean>{

        public MultiTestAdapter(Context context) {
            super(context);
        }

        @Override
        protected void preMultiItemView(RvMultiItemManager itemManager) {
            itemManager.addMultiItemView(new MultiItemView1(mContext));
            itemManager.addMultiItemView(new MultiItemView2(mContext));
            itemManager.addMultiItemView(new MultiItemView3(mContext));
            itemManager.addMultiItemView(new MultiItemView4(mContext));
            itemManager.addMultiItemView(new MultiItemView0(mContext));
        }
    }
}