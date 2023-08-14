package com.deepshooter.composecomponents.ui.modules.github

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModel
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.deepshooter.composecomponents.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.ref.WeakReference
import javax.inject.Inject


/**
 * Using this to hide the default error page.
 * The extra "?app" is an indicator that it is us loading the blank page.
 */
private const val CUSTOM_BLANK = "about:blank?app"
private const val TAG = "GithubViewModel"

@HiltViewModel
class GithubViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(WebViewState())
    val state: StateFlow<WebViewState>
        get() = _state

    private var _swipeRefreshLayout: WeakReference<SwipeRefreshLayout>? = null

    private var _webView: WeakReference<WebView>? = null

    fun initSwipeRefresh(swipeRefreshLayout: SwipeRefreshLayout) {
        Log.d(TAG, "initSwipeRefresh")

        this._swipeRefreshLayout = WeakReference(swipeRefreshLayout)

        swipeRefreshLayout.setOnRefreshListener {
            _webView?.get()?.reload()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView(webView: WebView) {
        Log.d(TAG, "initWebView")

        if (BuildConfig.DEBUG) {
            WebView.setWebContentsDebuggingEnabled(true)
        }

        this._webView = WeakReference(webView)

        this._webView = WeakReference(webView)

        webView.apply {
            val webSettings = this.settings

            webSettings.run {
                javaScriptEnabled = true
                domStorageEnabled = true
            }

            webViewClient = object : WebViewClient() {
                override fun onPageStarted(
                    view: WebView?,
                    url: String?,
                    favicon: Bitmap?
                ) {

                    Log.d(TAG, "onPageStarted")

                    if (url != CUSTOM_BLANK) {
                        _state.value = _state.value.copy(
                            loadingProgress = 0,
                            error = null
                        )
                    }

                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    Log.d(TAG, "onPageFinished")

                    _state.value = _state.value.copy(
                        loadingProgress = null
                    )

                    _swipeRefreshLayout?.get()?.isRefreshing = false

                    super.onPageFinished(view, url)
                }


                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {

                    Log.d(TAG, "onReceivedError(): error: ${error?.errorCode}")

                    request?.let {
                        // Help: https://stackoverflow.com/a/44273685/2263329
                        if (it.isForMainFrame) {
                            error?.let {
                                // Help: https://stackoverflow.com/a/33419123/2263329
                                onReceivedError(
                                    view,
                                    error.errorCode,
                                    error.description.toString(),
                                    request.url.toString()
                                )
                            }
                        }
                    }
                }

                override fun onReceivedError(
                    view: WebView?,
                    errorCode: Int,
                    description: String?,
                    failingUrl: String?
                ) {

                    Log.d(
                        TAG,
                        "onReceivedError(): errorCode: $errorCode | description: $description | failingUrl: $failingUrl"
                    )

                    try {
                        view?.stopLoading()
                        view?.loadUrl(CUSTOM_BLANK)
                    } catch (e: Exception) {
                        Log.d(TAG, "Exception:$e")
                    }

                    _state.value = _state.value.copy(
                        error = WebViewError(
                            errorCode = errorCode,
                            description = description,
                            failingUrl = failingUrl
                        )
                    )
                }
            }

            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(
                    view: WebView?,
                    newProgress: Int
                ) {
                    Log.d(TAG, "onProgressChanged: newProgress: $newProgress")
                    _state.value = _state.value.copy(
                        loadingProgress = newProgress
                    )
                }
            }

            // WebView Cookies
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)
        }
    }

    fun webViewCanGoBack(): Boolean {
        _webView?.get()?.let {
            Log.d(TAG, "webViewCanGoBack")
            return it.canGoBack()
        }
        return false
    }

    fun webViewGoBack() {
        Log.d(TAG, "webViewGoBack")
        _webView?.get()?.goBack()
    }

    fun webViewReload() {
        _webView?.get()?.reload()
    }

}


data class WebViewState(
    val loadingProgress: Int? = null,
    val error: WebViewError? = null
)

data class WebViewError(
    val errorCode: Int,
    val description: String?,
    val failingUrl: String?
)
