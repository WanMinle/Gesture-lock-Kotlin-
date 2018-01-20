package com.example.minlewan.testmimasuo

import android.os.Bundle
import com.example.minlewan.testmimasuo.GestureLockViewGroup.OnGestureLockViewListener
import android.app.Activity
import android.util.Log
import android.view.View


class MainActivity : Activity() {

    private var mGestureLockViewGroup: GestureLockViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mGestureLockViewGroup = findViewById<View>(R.id.id_gestureLockViewGroup) as GestureLockViewGroup?
        mGestureLockViewGroup!!.setAnswer(intArrayOf(1, 2, 3, 4, 5)) //设置解锁密码
        mGestureLockViewGroup!!
                .setOnGestureLockViewListener(object : OnGestureLockViewListener {

                    override fun onUnmatchedExceedBoundary() {
                        Log.i("test","错误5次...")
                        mGestureLockViewGroup!!.setUnMatchExceedBoundary(5)
                    }

                    override fun onGestureEvent(mChoose:List<Int>) {
                        Log.i("test","密码"+ mChoose.toString())
//                        mGestureLockViewGroup!!.checkAnswer()//检查解锁密码
                        mGestureLockViewGroup!!.reset()// 重置
                    }

                    override fun onBlockSelected(cId: Int) {
//                        Log.i("test","点击了"+cId)
                    }
                })
    }

}