# IBM PC Shamus: route-map reconstruction status

## Primary source identified

**VileR, “The Mazes of Shamus — IBM PC Version” (21 October 2013)**:
https://int10h.org/blog/2013/10/mazes-of-shamus-ibm-pc/

The article embeds the complete four-level IBM PC room map as `https://int10h.org/blog/img/MAP.gif`. It explicitly says the PC map differs from the Atari map, particularly on levels 2 and 3. It also explains that some keys appear randomly in one of several eligible rooms, with extra lives/mystery objects occupying the other possibilities. Use the PC map, **not** Atari/C64 route diagrams, as the reconstruction reference.

The user's DOS archive `Shamus.rar` contains `SHAMUS.EXE` (1,024 bytes) and `SHAMUS.OVL` (33,024 bytes). The OVL has been extracted and inspected locally, but the binary map table has **not** yet been reliably isolated or decoded.

## Work completed in v0.5 maze beta

- Introduced a single fixed `PC_TOPOLOGY` array embedded in `index.html`, and a human-readable copy in `data/maze-topology-draft.json`.
- 127 rooms, numbered 000–126, partitioned into **non-uniform** sectors: 000–037, 038–066, 067–092, 093–126 (guided by the published PC map).
- Fixed and validated 4-directional reciprocal links; full global reachability; an interconnected maze, cul-de-sacs and occasional loops for each sector.
- Replaced the former hardcoded 8×4 pause map with a topology-derived map that displays visited rooms and their known connections.
- Preserved prior movement speed, sprites, animations, shot physics, collision hitboxes, GameSir/touch handling, lighting and room interiors unchanged.
- Added run-to-run variation for provisional key placement in some groups of rooms, mirroring the original principle.

**Critical qualification:** We have **not** yet proved that the individual room links, exits, item locations or lock/key rules in v0.5 match the original game. The `maze-topology-draft.json` graph is an **authored provisional graph**, not an extraction or verified transcription of the published map. The original has more distinct keys/locks than the present three-sector-gate model. This game version is a layout-engine prototype, not “original maps restored”.

## Verification checklist for the authentic-map milestone

1. Capture/transcribe all edges of the published IBM PC route diagram into `data/maze-topology-verified.json`; record source and confidence for every edge.
2. Validate each direction with its opposite, detect disconnected components, and compare all room IDs (000–126).
3. Recheck keys, keyhole shapes, locks, one-of-N random key spawn groups, and gate progression from actual DOS gameplay or binary code.
4. Verify at least representative rooms from each of the four levels in DOS execution.
5. Swap the data payload into the game, leaving animation, controls, graphics and physics untouched.
6. Add automated regression tests for path reachability, key/door solvability, transitions between sectors, and room-entry spawn safety.

## External reference

Source map article: https://int10h.org/blog/2013/10/mazes-of-shamus-ibm-pc/

This document does not redistribute the original graphics or DOS game binaries.
