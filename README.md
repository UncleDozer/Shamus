# SHAMUS // REIMAGINED — Visual Alpha 0.2

**Playable fan remake prototype** with the approved **CGA Reborn × Tech-Noir** visual style.

## What changed in 0.2

- Luminous cyan electric barriers with animated zigzag arcs and metallic housing.
- Industrial raised floors, grilles, engraved panels, amber lighting and magenta accents.
- White/silver player armor with cyan visor.
- Three high-contrast enemy appearances: red assault bot, purple drone, amber/orange jumper.
- Neon HUD. All changes preserve gameplay coordinates, maze generation, collision sizes and timing from v0.1.
- Native Android WebView application source with sensor-landscape orientation and GameSir gamepad relay.

**Important:** the map is still an original 127-room prototype layout, not a faithful reconstruction of the original DOS maps. A cosmetic remaster is underway, not a finished remaster of the original gameplay.

## Play on desktop or phone

Open `index.html` in a modern browser (offline). Choose NOVICE or ADVANCED, then press **НАЧАТЬ ОПЕРАЦИЮ**.

PC: WASD/arrows to move; Alt/Space + direction to shoot; P/Esc pause.
Gamepad in browsers supporting Gamepad API: left stick/D-pad, A/RB/RT + direction to fire; Start pause.
Touch: left virtual joystick and right fire button. Landscape recommended.

## Android APK

The installable Android project is under [`android/`](android/). A GitHub Actions workflow (`Android APK (debug)`) builds an offline APK and uploads it as a run artifact. See [`android/README.md`](android/README.md) for details. A successful CI build and a real GameSir/device test have not yet been verified.

Android application architecture: native fullscreen wrapper around the same HTML5 Canvas engine. No network permissions; root `index.html` automatically packaged into the APK at build time.

## Credits & status

Noncommercial fan prototype. The original game and its intellectual property are owned by their respective rightsholders; original DOS executable files are **not** included in this repository.