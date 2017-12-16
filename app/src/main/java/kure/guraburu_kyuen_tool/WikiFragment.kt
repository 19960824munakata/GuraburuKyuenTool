package kure.guraburu_kyuen_tool

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.webkit.WebViewClient


//import android.webkit.WebView
//import android.webkit.WebViewClient

/**
 * Wikiページ
 *
 * Created by yuuma on 2017/11/11.
 */

class WikiFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_wiki, container, false)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        var wikiWebView = view!!.findViewById<WebView>(R.id.wikiView)

        wikiWebView.webViewClient = WebViewClient()
        //最初にgoogleのページを表示する。
        wikiWebView.loadUrl("https://グランブルーファンタジー.gamewith.jp")
        //jacascriptを許可する
        wikiWebView.settings.javaScriptEnabled = true

    }
}