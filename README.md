# SHAMUS // REIMAGINED

**Maze Beta v0.5** · Android (offline) · CGA Reborn × Tech-Noir

A visually modernized fan remake prototype of the IBM PC/DOS *Shamus*. The priority is its challenging maze gameplay, preserving v0.4's smooth animation and GameSir/touch control.

## What's new in 0.5

- A **fixed map of 127 numbered rooms across 4 irregularly shaped sectors**, replacing the old equal-width randomized room graph.
- New branches, dead ends and loops. Every room can be reached; transitions are reversible and cross-sector exits are explicit.
- An exploration map on Pause: visited rooms, the corridors between them, and sector progress.
- Key placement varies between a small set of candidate rooms (provisional behavior).
- Reusable world topology data in [data/maze-topology-draft.json](data/maze-topology-draft.json), with connectivity validation in `tests/validate_maze.py`.
- All movement, input, animations, shooting, hitboxes and room graphics are preserved from v0.4.

### IMPORTANT: original DOS maps not fully reconstructed yet

We found a **complete map of the IBM PC version**, published in 2013: [The Mazes of Shamus — IBM PC Version](https://int10h.org/blog/2013/10/mazes-of-shamus-ibm-pc/). The 0.5 route graph is **still a drafted, source-inspired approximation, not an exact transcription of that map**. We have *not* decoded every room's original links or all seven key/lock conditions. See [PC map research & verification plan](docs/PC_MAP_STATUS.md).

The original `SHAMUS.EXE` and `SHAMUS.OVL` files are not distributed in this repository.

## Download APK

Open [GitHub Actions / Android APK](https://github.com/UncleDozer/Shamus/actions/workflows/android-debug.yml), choose the latest **successful** run, download the artifact `Shamus-Reimagined-v0.5-debug-apk`, extract `app-debug.apk`, and install it on Android.

Android 8+; targets Android 16. The APK is standalone and works offline; the 2D game engine runs embedded in an Android WebView. It does not open Chrome. Test debug builds may use different signatures; uninstall the old version if Android refuses to upgrade.

## Controls

- **GameSir:** left stick or D-pad moves; A/RB/RT + direction fires; Start pauses/resumes. In menu, stick/D-pad selects Novice/Advanced, A/Start starts.
- **Touch:** left virtual joystick, right fire button, on-screen Pause.
- **Keyboard:** arrow keys/WASD move; Alt or Space + direction fires; P/Esc pauses.

## Roadmap

Next: verified transcription of the authentic PC route map, exact keyhole/key rules, room-specific interiors and original enemy timing — without sacrificing existing frame rate or modern art.

Noncommercial fan prototype; original rights belong to their respective owners.
