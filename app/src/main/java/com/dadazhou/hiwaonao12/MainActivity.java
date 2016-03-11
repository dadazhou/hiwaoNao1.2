package com.dadazhou.hiwaonao12;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class MainActivity extends Activity implements OnClickListener{

    private EditText mIP,mPort,mIP2,mPort2;
    private DatagramSocket socket;
    InetAddress serverAddress;
    private String Cmdstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

//        Rocker rocker = (Rocker) findViewById(R.id.rudder);
//
//        Bitmap rocker_bg = BitmapFactory.decodeResource(getResources(), R.drawable.rocker_bg);
//        Bitmap rocker_ctrl = BitmapFactory.decodeResource(getResources(), R.drawable.rocker_ctrl);
//        rocker.setRockerBg(rocker_bg);
//        rocker.setRockerCtrl(rocker_ctrl);
//
//        rocker.setRudderListener(new Rocker.RudderListener() {
//
//            @Override
//            public void onSteeringWheelChanged(int action, int angle) {
//                if (action == Rocker.ACTION_RUDDER) {
//                    //TODO:事件实现
//                    //	Log.e("夹角", "angle"+angle);
//                    try {
//                        if (angle < 0) {
//                            Log.e("NaoAPP", "angle<0");
//                        }
//                        else if(angle>=315||angle<45){
//                            Cmdstr = "前进";
//                            initSocket();
//                        }
//                        else if(angle>=45&&angle<135){
//                            Cmdstr = "右";
//                            initSocket();
//                        }
//                        else if(angle>=135&&angle<225){
//
//                        }
//                        else if(angle>=225&&angle<315){
//
//                        }
//                    }catch (Exception e){
//
//                    }
//                }
//            }
//        });
        initView();
    }

    private void initView(){
        findViewById(R.id.connect_button).setOnClickListener(this);
        findViewById(R.id.disconnect_button).setOnClickListener(this);
        findViewById(R.id.cmdbutton_xpg).setOnClickListener(this);
        findViewById(R.id.stop).setOnClickListener(this);
        findViewById(R.id.cmdbutton_qj).setOnClickListener(this);
        findViewById(R.id.cmdbutton_ht).setOnClickListener(this);
        findViewById(R.id.cmdbutton_zy).setOnClickListener(this);
        findViewById(R.id.cmdbutton_yy).setOnClickListener(this);
        findViewById(R.id.cmdbutton_zz).setOnClickListener(this);
        findViewById(R.id.cmdbutton_yz).setOnClickListener(this);
        findViewById(R.id.cmdbutton_zwjs).setOnClickListener(this);
        findViewById(R.id.cmdbutton_zql).setOnClickListener(this);
        findViewById(R.id.cmdbutton_dx).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.cmdbutton_flash).setOnClickListener(this);
        findViewById(R.id.text_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        mIP = (EditText) findViewById(R.id.ip);
        mPort = (EditText) findViewById(R.id.port);
        mIP2 = (EditText) findViewById(R.id.ip2);
        mPort2 = (EditText) findViewById(R.id.port2);

        switch (v.getId()) {
            case R.id.connect_button:{
                Log.i("NaoAppdebug","connect_button");
                initSocket(mIP,mPort);
                break;
            }
            case R.id.disconnect_button:{
                Log.i("NaoAppdebug","disconnect_button");
                break;
            }
            case R.id.cmdbutton_xpg: {
                Cmdstr = "小苹果";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                break;
            }

            case R.id.cmdbutton_zwjs: {
                Cmdstr = "自我介绍";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                break;
            }
            case R.id.stop: {
                Cmdstr = "stop";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                if (mIP2 != null||mPort2 !=null) {
                    initSocket(mIP2, mPort2);
                }
                break;
            }
            case R.id.cmdbutton_qj: {
                Cmdstr = "前进";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                break;
            }
            case R.id.cmdbutton_ht: {
                Cmdstr = "后退";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                break;
            }
            case R.id.cmdbutton_zy: {
                Cmdstr = "左移";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                break;
            }
            case R.id.cmdbutton_yy: {
                Cmdstr = "右移";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                break;
            }
            case R.id.cmdbutton_zz: {
                Cmdstr = "左转";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                break;
            }
            case R.id.cmdbutton_yz: {
                Cmdstr = "右转";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                break;
            }
            case R.id.cmdbutton_zql: {
                Cmdstr = "站起来";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                break;
            }
            case R.id.cmdbutton_dx: {
                Cmdstr = "蹲下";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                break;
            }

            case R.id.button2: {
                Cmdstr = "灌篮";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                if (mIP2 != null||mPort2 !=null) {
                    initSocket(mIP2, mPort2);
                }
                break;
            }

            case R.id.cmdbutton_flash: {
                Cmdstr = "眨眼睛";
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                if (mIP2 != null||mPort2 !=null) {
                    initSocket(mIP2, mPort2);
                }
                break;
            }

            case R.id.text_button: {
                EditText textmessage = (EditText) findViewById(R.id.text_in);
                Cmdstr = textmessage.getText().toString();
                Log.i("NaoAppdebug","Cmd = "+ Cmdstr);
                initSocket(mIP,mPort);
                if (mIP2 != null||mPort2 !=null) {
                    initSocket(mIP2, mPort2);
                }
                break;
            }
        }
    }

    private void initSocket(final EditText udpip, final EditText udpport){
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //首先创建一个DatagramSocket对象
                    //端口设置为可重用
                    if(socket == null){
                        socket = new DatagramSocket(null);
                        socket.setReuseAddress(true);
                        socket.bind(new InetSocketAddress(Integer.parseInt(udpport.getText().toString())));
                    }
                    Log.i("NaoAppdebug","创建DatagramSocket对象"+ Cmdstr);
                    //创建一个InetAddree
                    serverAddress = InetAddress.getByName(udpip.getText().toString());
                    Log.i("NaoAppdebug","InetAddree："+ serverAddress);
                    byte data[] = Cmdstr.getBytes();  //把传输内容分解成字节
                    //创建一个DatagramPacket对象，并指定要讲这个数据包发送到网络当中的哪个、
                    DatagramPacket packet = new
                            DatagramPacket(data, data.length, serverAddress, Integer.parseInt(udpport.getText().toString()));
                    Log.i("NaoAppdebug","数据包");
                    //调用socket对象的send方法，发送数据
                    socket.send(packet);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    Log.i("NaoAppdebug","send异常"+ e);
                }
            }
        });
        thread.start();

    }
}
