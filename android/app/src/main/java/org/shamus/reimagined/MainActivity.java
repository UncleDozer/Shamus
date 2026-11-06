package org.shamus.reimagined;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/** Offline game container with a native GameSir/XInput-to-JavaScript gamepad relay. */
public final class MainActivity extends Activity {
    private WebView gameView;
    private float stickX = 0f, stickY = 0f;
    private boolean dLeft, dRight, dUp, dDown, aPressed, rightBumper, rightTrigger;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        enterImmersiveMode();
        gameView = new WebView(this);
        gameView.setBackgroundColor(Color.BLACK);
        gameView.setKeepScreenOn(true);
        gameView.setFocusable(true);
        gameView.setFocusableInTouchMode(true);
        gameView.setWebChromeClient(new WebChromeClient());
        gameView.setWebViewClient(new WebViewClient());
        WebSettings settings = gameView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setMediaPlaybackRequiresUserGesture(true);
        gameView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        setContentView(gameView);
        gameView.requestFocus();
        gameView.loadUrl("file:///android_asset/index.html");
    }

    private void enterImmersiveMode() {
        getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
            View.SYSTEM_UI_FLAG_FULLSCREEN |
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

    @Override public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) enterImmersiveMode();
    }

    @Override public boolean dispatchKeyEvent(KeyEvent event) {
        final int source = event.getSource();
        if ((source & InputDevice.SOURCE_GAMEPAD) == InputDevice.SOURCE_GAMEPAD ||
            (source & InputDevice.SOURCE_DPAD) == InputDevice.SOURCE_DPAD) {
            boolean down = event.getAction() == KeyEvent.ACTION_DOWN;
            int k = event.getKeyCode();
            switch (k) {
                case KeyEvent.KEYCODE_DPAD_LEFT: dLeft = down; break;
                case KeyEvent.KEYCODE_DPAD_RIGHT: dRight = down; break;
                case KeyEvent.KEYCODE_DPAD_UP: dUp = down; break;
                case KeyEvent.KEYCODE_DPAD_DOWN: dDown = down; break;
                case KeyEvent.KEYCODE_BUTTON_A: aPressed = down; break;
                case KeyEvent.KEYCODE_BUTTON_R1: rightBumper = down; break;
                case KeyEvent.KEYCODE_BUTTON_R2: rightTrigger = down; break;
                case KeyEvent.KEYCODE_BUTTON_START:
                    if (down && event.getRepeatCount() == 0 && gameView != null) {
                        gameView.evaluateJavascript(
                            "window.dispatchEvent(new KeyboardEvent('keydown',{code:'KeyP'}));", null);
                    }
                    return true;
                default: return super.dispatchKeyEvent(event);
            }
            relayPad();
            return true;
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            if (gameView != null) gameView.evaluateJavascript(
                "window.dispatchEvent(new KeyboardEvent('keydown',{code:'KeyP'}));", null);
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override public boolean onGenericMotionEvent(MotionEvent e) {
        if ((e.getSource() & InputDevice.SOURCE_JOYSTICK) == InputDevice.SOURCE_JOYSTICK &&
             e.getAction() == MotionEvent.ACTION_MOVE) {
            stickX = deadZone(e.getAxisValue(MotionEvent.AXIS_X));
            stickY = deadZone(e.getAxisValue(MotionEvent.AXIS_Y));
            relayPad();
            return true;
        }
        return super.onGenericMotionEvent(e);
    }

    private static float deadZone(float v) { return Math.abs(v) < 0.15f ? 0f : v; }

    private void relayPad() {
        if (gameView == null) return;
        float x = dLeft ? -1f : dRight ? 1f : stickX;
        float y = dUp ? -1f : dDown ? 1f : stickY;
        gameView.evaluateJavascript("window.__nativePad={x:"+x+",y:"+y+",fire:"+
            (aPressed || rightBumper || rightTrigger)+"};", null);
    }

    @Override protected void onPause() {
        if (gameView != null) gameView.evaluateJavascript("window.dispatchEvent(new Event('blur'));", null);
        super.onPause();
    }

    @Override protected void onDestroy() {
        if (gameView != null) {
            gameView.destroy();
            gameView = null;
        }
        super.onDestroy();
    }
}
