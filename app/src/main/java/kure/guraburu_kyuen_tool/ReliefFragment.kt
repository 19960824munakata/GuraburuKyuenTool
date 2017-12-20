package kure.guraburu_kyuen_tool

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_relief.*
import android.widget.ImageButton



/**
 * 救援ページ
 *
 * Created by yuuma on 2017/11/11.
 */

class ReliefFragment : Fragment() {

    private var flg = true

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_relief, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        val button1 = view!!.findViewById<ImageButton>(R.id.imageButton1)
        button1.setOnClickListener(View.OnClickListener {
            if (flg) {
                flg = false
            } else {
                flg = true
            }
        })

    }
}
