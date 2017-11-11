package kure.guraburu_kyuen_tool

import kure.guraburu_kyuen_tool.util.UserInfoViewPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //todo メンバ変数はこういう宣言でいいのかな？
    private var mPager : ViewPager? = null;
    private var mAdapter: FragmentPagerAdapter? = null;
    private var mCurrentPage = 0;
    private val TAG = "HogeHoge"

    private val mPageButtonId = arrayOf(R.id.reliefButton,R.id.officialTwitterButton,
            R.id.officialPageButton,R.id.wikiButton,R.id.settingButton);

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            mPager = findViewById(R.id.pager)

            mAdapter = UserInfoViewPagerAdapter(supportFragmentManager)
            mPager!!.setAdapter(mAdapter)
            mCurrentPage = 0

            // ボタンにリスナーを設定
            for (item in mPageButtonId) {
                Log.v(TAG, "ButtonId:$item")
                var button: Button = findViewById(item)
                button.setOnClickListener(this)
            }
        }
        catch (e: Throwable) {
            Log.e(TAG, "$e")
        }
    }

    override fun onClick(v: View) {
        // 押下されたボタンによってFragmentを切り替える
        Log.v(TAG, "onClick:$v.id")
        when (v.id) {
            mPageButtonId[0] -> {
                mCurrentPage = 0
                mPager!!.setCurrentItem(mCurrentPage)
            }
            mPageButtonId[1] -> {
                mCurrentPage = 1
                mPager!!.setCurrentItem(mCurrentPage)
            }
            mPageButtonId[2] -> {
                mCurrentPage = 2
                mPager!!.setCurrentItem(mCurrentPage)
            }
            mPageButtonId[3] -> {
                mCurrentPage = 3
                mPager!!.setCurrentItem(mCurrentPage)
            }
            mPageButtonId[4] -> {
                mCurrentPage = 4
                mPager!!.setCurrentItem(mCurrentPage)
            }
            else -> {
                mCurrentPage = 0
                mPager!!.setCurrentItem(mCurrentPage)
            }
        }
    }



}
