# SHAMUS // REIMAGINED

**Visual Alpha v0.4 — CGA Reborn × Tech-Noir**

A standalone Android fan remake prototype of the PC/DOS arcade maze game *Shamus*, built with a 2D Canvas engine and a native Android shell. Runs offline.

## What's new in v0.4

- **32 independently rendered vector animation poses:** eight frames each for the hero and the three robot classes. Agent legs alternate, ruby crawler legs stride individually, violet drone rotor spins, and amber jumper legs compress for its leaps.
- Higher-detail robot leg mechanisms, armor joints, cyan sensors, highlights and surface decals, preserving the previously approved CGA Reborn × Tech-Noir palette.
- Visual-only shooting recoil and muzzle bloom, hit flash, outward energy-wave impacts, and debris/shards from destroyed robots.
- Effects are capped for performance and do **not** change hitboxes, movement speed, aim direction, enemy behavior, room generation or scoring.

### Carried forward from v0.3

- No enemy friendly fire / false room clears.
- Swept bullet collision and correct +200 clear bonus.
- Fixed room-specific enemy/item spawn verification.
- GameSir **D-pad / left stick** chooses difficulty in menu; **A / Start** starts the game; **Start** toggles pause.
- Touchscreen, keyboard and gamepad control. Android screen rotates to either landscape orientation.

## Install / run

Go to the [latest successful Android APK workflow](https://github.com/UncleDozer/Shamus/actions/workflows/android-debug.yml), open its **Artifacts** section and download **Shamus-Reimagined-v0.4-debug-apk**. Extract `app-debug.apk`, then install on an Android phone.

Because GitHub's debug APK signing identity can vary between runs, you may need to remove v0.3 before installing v0.4. This is a development build, not a Play Store release.

You can also open `index.html` in a browser for testing, but **Android is the primary target**.

## Controls

| Mode | Controls |
| --- | --- |
| Main menu | GameSir D-pad / left stick selects difficulty; A / Start begins |
| Gameplay | GameSir stick / D-pad or touchscreen joystick moves in eight directions |
| Shoot | Hold A / RB / RT + direction |
| Pause | Start or on-screen Pause |
| Desktop | WASD / arrow keys to move, Alt / Space + direction to fire, P / Esc to pause |

## Compatibility

Android 8.0+ with target SDK 36 (Android 16). Uses an offline WebView shell: **this is an installable native Android application**, though the game engine itself is JavaScript/Canvas. No network permission is requested.

## Known limitations / roadmap

The current 127-room map is **our own connected procedural prototype**, **not** a verified copy of the original DOS room layouts. Enemy AI, timings and item placements still need to be studied against the original binary in the v0.5 authenticity phase.

The v0.4 art uses **programmatically articulated SVG sprites**, not hand-painted raster animation sheets. This is a meaningful motion upgrade, but further bespoke animation, directional frames and high-resolution character artwork may still be needed to match the concept sheet completely.

Noncommercial fan experiment. Original game rights belong to their respective owners.
