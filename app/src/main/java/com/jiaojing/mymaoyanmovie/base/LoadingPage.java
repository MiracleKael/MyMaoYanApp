package com.jiaojing.mymaoyanmovie.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.utils.ToastUtil;
import com.jiaojing.mymaoyanmovie.utils.UIUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by jiaojing on 2016/12/7.
 * 作用：xxx
 */
public abstract class LoadingPage extends FrameLayout{
    //1.声明四中状态
    private static final int STATE_LOADING = 1;//正在加载
    private static final int STATE_ERROR = 2;//加载失败
    private static final int STATE_EMPTY = 3;//联网成功，但空数据
    private static final int STATE_SUCCESS = 4;//成功

    //2 提供四种页面
    private View view_loading;
    private View view_error;
    private View view_empty;
    private View view_success;

    //默认
    private  int state_current = STATE_LOADING;


    private Context mContext;
    private LayoutInflater mInflater;

    public LoadingPage(Context context) {
        this(context, null);
    }

    public LoadingPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        init();
    }

    private void init() {
        //初始化必要的View
        //指明视图显示宽高的参数
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        TextView tv = new TextView(mContext);
        if(view_loading == null){
            view_loading = mInflater.inflate(R.layout.page_loading, null);
            addView(view_loading, params);
        }
        if(view_error == null){
            view_error =  mInflater.inflate(R.layout.page_error, null);
            tv = (TextView) view_error.findViewById(R.id.tv_refresh);
            tv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    refreshNet();

                }
            });
            addView(view_error, params);
        }
        if(view_empty == null){
            view_empty =  mInflater.inflate(R.layout.page_empty, null);
            addView(view_empty, params);
        }

        //根据state_current的值， 决定显示哪个具体的view
        showSafePage();
    }

    //点击刷新网络
    public void refreshNet() {
        state_current = STATE_LOADING;
        showPage();
        show();
    }

    private void showSafePage() {
        //更新界面的操作,在主线程
        UIUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //加载显示具体的view
                showPage();
            }
        });
    }

    //根据state_current的值， 决定显示哪个具体的view
    private void showPage() {
        view_loading.setVisibility(state_current == STATE_LOADING ? View.VISIBLE : View.GONE);
        view_error.setVisibility(state_current == STATE_ERROR ? View.VISIBLE : View.GONE);
        view_empty.setVisibility(state_current == STATE_EMPTY ? View.VISIBLE : View.GONE);

        if(view_success == null){
//            view_success =UIUtils.getView(layoutId());
            view_success =View.inflate(mContext, layoutId(),null);
            addView(view_success);
        }
        view_success.setVisibility(state_current == STATE_SUCCESS ? View.VISIBLE : View.GONE);
    }

    public abstract int layoutId();

    //执行联网操作
    private ResultState resultState;

    public void show() {
        String url = url();
        if (TextUtils.isEmpty(url)) {
            resultState = ResultState.SUCCESS;
            resultState.setContent("");
            loadPage();
            return;
        }

//        //模拟联网操作的延迟
//        UIUtils.getHandler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
                OkHttpUtils.get()
                        .url(url())
                        .id(100)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                ToastUtil.showToast(mContext, "请检查网络");
                                Log.e("TAG", "onError====="+e.getMessage());
                                resultState = ResultState.ERROR;
                                resultState.setContent("");
                                loadPage();
                            }

                            @Override
                            public void onResponse(String response, int id) {
                                Log.e("TAG", "sucesss=====");
                                switch (id){
                                    case 100:
                                        if (TextUtils.isEmpty(response)) {
                                            resultState = ResultState.EMPTY;
                                            resultState.setContent("");
                                        } else {
                                            resultState = ResultState.SUCCESS;
                                            resultState.setContent(response);
                                        }

                                        loadPage();
                                        break;
                                }
                            }
                        });
//            }
//        }, 2000);

    }
    private void loadPage() {
        switch (resultState){
            case ERROR:
                state_current = STATE_ERROR;
                break;
            case EMPTY:
                state_current = STATE_EMPTY;
                break;
            case SUCCESS:
                state_current = STATE_SUCCESS;
                break;
        }

        showSafePage();

        if(state_current == STATE_SUCCESS){//如果当前是联网成功
            onSuccess(resultState, view_success);
        }
    }
    protected abstract void onSuccess(ResultState resultState, View view_success);

    protected abstract String url();


    //提供枚举类:将当前联网以后状态以及可能返回的数据，封装在枚举类中
    public enum ResultState{

        ERROR(2),EMPTY(3),SUCCESS(4);

        int state ;
        private String content;
        ResultState(int state) {
            this.state = state;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
