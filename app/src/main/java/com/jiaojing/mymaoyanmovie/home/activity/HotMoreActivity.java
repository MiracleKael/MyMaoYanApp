package com.jiaojing.mymaoyanmovie.home.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.base.BaseActivity;

import butterknife.Bind;

public class HotMoreActivity extends BaseActivity {


    @Bind(R.id.hot_more_webview)
    WebView hotMoreWebview;

    @Override
    protected void listener() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");
        //WebView加载web资源
        hotMoreWebview.loadUrl(url);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        hotMoreWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
//                return super.shouldOverrideUrlLoading(view, url);
                view.loadUrl(url);
                return true;
            }
        });
        //优先使用缓存
        hotMoreWebview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //启用支持javascript
        WebSettings settings = hotMoreWebview.getSettings();
        settings.setJavaScriptEnabled(true);

        //判断页面加载过程
        hotMoreWebview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
//                if (newProgress == 100) {
//                    // 网页加载完成
//
//                } else {
//                    // 加载中
//
//                }
            }
        });
    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_hot_more;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(hotMoreWebview.canGoBack()){
                hotMoreWebview.goBack();
                return true;
            }else{
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
