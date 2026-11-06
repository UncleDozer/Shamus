# Android app (source)

The Android app is a fullscreen, **offline WebView container** for the same 2D engine as the standalone `index.html`. After building, this is an installable Android application rather than a game opened in Chrome. Rendering and game logic remain JavaScript/Canvas.

- Android 8.0+ (`minSdk 26`); targets Android 16 (`targetSdk 36`).
- Landscape orientation with sensor rotation between landscape orientations.
- GameSir/XInput: left stick or D-pad to move, A/RB/R2 + direction to fire; START pauses. Android gamepad events are relayed to the embedded game because WebView's Gamepad API availability varies.
- Touch controls remain available.
- `android/app/build.gradle` copies the root `index.html` into Android assets automatically before every build.
- No Internet permission is declared; gameplay is offline.

## Build from GitHub

Open **Actions → Android APK (debug)**, run the workflow or open the automatically triggered run. Download the artifact `Shamus-Reimagined-v0.2-debug-apk` and unpack the ZIP to get `app-debug.apk`.

## Build locally

Requires JDK 17, Gradle 8.11.1 and Android SDK platform 36. From the repository root:

```sh
gradle -p android :app:assembleDebug
```

**Status:** Android source is prepared. Compatibility, APK production, gamepad mapping and frame rate on a specific phone require a completed CI build and physical-device test.
