package com.example.wzh.bmobtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Button btn_add, btn_delete, btn_update, btn_query, btn_signup, btn_signin;

    private String objectId="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "54ad3553e524934a7c98958570138bc1");
        // 初始化View
        initView();
        initListener();
    }

    private void initView() {
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_query = (Button) findViewById(R.id.btn_query);

        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signin = (Button) findViewById(R.id.btn_signin);
    }

    private void initListener() {
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_query.setOnClickListener(this);

        btn_signup.setOnClickListener(this);
        btn_signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v == btn_add) {
            createPerson();
        } else if (v == btn_delete) {
            deletePersonByObjectId();
        } else if (v == btn_update) {
            updatePersonByObjectId();
        } else if (v == btn_query) {
            queryPersonByObjectId();
        } else if (v == btn_signup) {
            createBmobUser();
        } else if (v == btn_signin) {
            loginBmobUser();
        }
    }

    private void createBmobUser() {

        BmobUser bu = new BmobUser();
        bu.setUsername("sendi");
        bu.setPassword("123456");
        bu.setEmail("sendi@163.com");
        //注意：不能用save方法进行注册
        bu.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if(e==null){
                    ShowToast("注册成功:" + objectId.toString());
                }else{
                    ShowToast("创建数据失败：" + e.getMessage());
                }
            }
        });
    }


    private void loginBmobUser() {

//        BmobUser bu = new BmobUser();
////        bu.setUsername(username);
////        bu.setPassword(password);
//        bu.save(new SaveListener<String>() {
//
//            @Override
//            public void done(String objectId, BmobException e) {
//                if(e==null){
////                    toast("登录成功:");
//                    ShowToast("登录成功");
//                    //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
//                    //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
//                    BmobUser user = BmobUser.getCurrentUser();
//                    if(e != null){
//                        // 允许用户使用应用
//                    }else{
//                        //缓存用户对象为空时， 可打开用户注册界面…
//                    }
//                }else{
//                    ShowToast(e.toString());
//                }
//            }
//        });
    }

    /**
     * 创建一条person数据 createPersonData
     *
     * @Title: createPersonData
     * @throws
     */
    private void createPerson() {
        final Person p2 = new Person();
        p2.setName("lucky");
        p2.setAddress("北京海淀");
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    ShowToast("添加数据成功，返回objectId为："+objectId);
                }else{
                    ShowToast("创建数据失败：" + e.getMessage());
                }
            }
        });
    }

    /**
     * 更新指定objectId的person数据
     *
     * @return void
     * @throws
     */
    private void updatePersonByObjectId() {
        //将指定edd2cd30c7的Person这一行数据中的address内容更新为“北京朝阳”
        final Person p2 = new Person();
        p2.setAddress("北京朝阳");
        p2.update("edd2cd30c7", new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    ShowToast("更新成功:"+p2.getUpdatedAt());
                }else{
                    ShowToast("更新失败：" + e.getMessage());
                }
            }
        });
    }

    /**
     * 删除指定ObjectId的person数据 deletePersonByObjectId
     *
     * @Title: deletePersonByObjectId
     * @return void
     * @throws
     */
    private void deletePersonByObjectId() {
        final Person p2 = new Person();
        p2.setObjectId("edd2cd30c7");
        p2.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    ShowToast("删除成功:"+p2.getUpdatedAt());
                }else{
                    ShowToast("删除失败：" + e.getMessage());
                }
            }
        });
    }

    /** 查询指定6b6c11c537的person数据
     * queryPerson
     * @Title: queryPerson
     * @throws
     */
    private void queryPersonByObjectId() {
        //查找Person表里面id为edd2cd30c7的数据
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.getObject("edd2cd30c7", new QueryListener<Person>() {
            @Override
            public void done(Person person, BmobException e) {
                if(e==null){
                    ShowToast("查询成功");
                }else{
                    ShowToast("查询失败：" + e.getMessage());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
