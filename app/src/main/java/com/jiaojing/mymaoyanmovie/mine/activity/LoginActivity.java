package com.jiaojing.mymaoyanmovie.mine.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.mine.bean.Container;
import com.jiaojing.mymaoyanmovie.utils.ToastUtil;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;

public class LoginActivity extends Activity implements View.OnClickListener ,Handler.Callback, PlatformActionListener {

    private ImageView ib_return;
    private EditText username;
    private EditText password;
    private Button btn_login;
    private TextView register;
    private TextView quick_login;
    private ImageButton qq_login;
    private ImageButton space_login;
    private ImageButton xinlang_login;
    private ImageButton weixin_login;
    public static String mAppid;
    public static QQAuth mQQAuth;
    private UserInfo mInfo;
    private Tencent mTencent;

    //模拟paaid
    private final String APP_ID = "222222";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ib_return = (ImageView) findViewById(R.id.ib_return);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.btn_login);
        register = (TextView) findViewById(R.id.register);
        quick_login = (TextView) findViewById(R.id.quick_login);
//        ShareSDK.initSDK(this);
        qq_login = (ImageButton) findViewById(R.id.qq_login);
        space_login = (ImageButton) findViewById(R.id.space_login);
        xinlang_login = (ImageButton) findViewById(R.id.xinlang_login);
        weixin_login = (ImageButton) findViewById(R.id.weixin_login);
        ib_return.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        register.setOnClickListener(this);
        quick_login.setOnClickListener(this);
        qq_login.setOnClickListener(this);
        space_login.setOnClickListener(this);
        xinlang_login.setOnClickListener(this);
        weixin_login.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        final Context context = LoginActivity.this;
        final Context ctxContext = context.getApplicationContext();
        mAppid = APP_ID;
        //生成授权QQ登录的对象
        mQQAuth = QQAuth.createInstance(mAppid, ctxContext);
        mTencent = Tencent.createInstance(mAppid, LoginActivity.this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_return:
                finish();
                break;
            case R.id.btn_login:
                String userName = username.getText().toString();
                String passWord = password.getText().toString().trim();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
                    ToastUtil.showToast(this, "用户名或密码不能为空");
                }

                break;
            case R.id.register:
//                Intent intent = new Intent(this,RegisterActivity.class);
//                intent.putExtra("url", Url.REGISTER_H5);
//                startActivity(intent);
                break;
            case R.id.quick_login:

                break;
            case R.id.qq_login:
                //登录
                IUiListener listener = new BaseUiListener() {
                    @Override
                    protected void doComplete(JSONObject values) {

                        updateUserInfo();
                    }
                };
                mQQAuth.login(this, "all", listener);

                mTencent.login(this, "all", listener);
                break;
            case R.id.space_login:
                String platformName1 = "QZone";
                break;
            case R.id.xinlang_login:
                String platformName2 = "SinaWeibo";
                break;
            case R.id.weixin_login:
                String platformName3 = "Wechat";
                break;
        }

    }

    private void updateUserInfo() {
        //判断不为空，且在有效期
        if (mQQAuth != null && mQQAuth.isSessionValid()) {

            //登录状态监听
            IUiListener listener = new IUiListener() {

                @Override
                public void onError(UiError e) {
                    // TODO Auto-generated method stub
                    ToastUtil.showToast(LoginActivity.this,"登录失败");
                }

                //登录完成时回调，即成功
                @Override
                public void onComplete(final Object response) {
                    JSONObject jsonObject = (JSONObject) response;
                    final String nickname = jsonObject.optString("nickname");
                    final String figureurl_qq_2 = jsonObject.optString("figureurl_qq_2");

                    //干掉当前界面
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("TAG", "1111111111111");
                            Intent intent = new Intent("abcdefg");
                            Container.name = nickname;
                            Container.icon = figureurl_qq_2;
                            Container.mQQAuth = mQQAuth;
                            sendBroadcast(intent);
                            Log.e("TAG", "222222222222222");
                            finish();
                        }
                    });
                    ToastUtil.showToast(LoginActivity.this, "登录成功");
                }


                //取消
                @Override
                public void onCancel() {
                    ToastUtil.showToast(LoginActivity.this,"取消登录");
                }
            };

            mInfo = new UserInfo(this, mQQAuth.getQQToken());
            //发送验证请求
            mInfo.getUserInfo(listener);

        } else {
        }
    }

    /**
     * 处理消息
     *
     * @param msg
     * @return
     */
    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }

    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            doComplete((JSONObject) response);
        }

        protected void doComplete(JSONObject values) {
        }

        @Override
        public void onError(UiError e) {

        }

        @Override
        public void onCancel() {

        }
    }

    /**
     * 成功时回调
     *
     * @param platform
     * @param action
     * @param res
     */
    @Override
    public void onComplete(Platform platform, int action,
                           HashMap<String, Object> res) {

        if (action == Platform.ACTION_USER_INFOR) {

        }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

    }

}
