package com.example.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Superhero App
        val superHeroWebView: WebView = findViewById(R.id.superHeroURL)
        superHeroWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        superHeroWebView.loadUrl("https://superheroes-7d106.web.app")
        superHeroWebView.settings.javaScriptEnabled = true
        superHeroWebView.settings.allowContentAccess = true
        superHeroWebView.settings.domStorageEnabled = true
        superHeroWebView.settings.useWideViewPort = true
        superHeroWebView.settings.setAppCacheEnabled(true)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val superHeroWebView: WebView = findViewById(R.id.superHeroURL)
        // Check if the key event was the Back button and if there's history
        if (keyCode == KeyEvent.KEYCODE_BACK && superHeroWebView.canGoBack()) {
            superHeroWebView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}

