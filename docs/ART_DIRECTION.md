# SHAMUS — Art Direction v1.0

## Approved direction
**CGA Reborn × Tech-Noir**, with **higher-contrast robots**.

The original CGA spirit (electric cyan, magenta, deep black, sharp arcade silhouettes) meets tangible industrial volume, directional amber practical lights, metallic relief, local bloom and shadows. The result is modern, legible 2D pixel/illustrative art, **not** a 3D conversion and **not** isometric.

This document is an art target. The existing v0.1 `index.html` is an older gameplay prototype and **does not yet implement this look**.

## Non-negotiable gameplay / camera
- Fixed overhead camera; full room visible at all times.
- Original maze topology, hitboxes, collision, pace, challenge and mechanics are the preservation target; current v0.1 still uses its own map.
- No decorative objects can conceal a hazard, doorway, projectile, player or enemy.
- Light effects must never alter gameplay collision boundaries or hide bullet trajectories.
- Design for readability on both a phone screen and desktop.

## Palette and hierarchy
| Role | Color / rule |
| --- | --- |
| Background | `#04050C` near-black; most floor value below gameplay silhouettes |
| Electric hazard | `#18D9FF` bright cyan, `#D6FCFF` white hot core |
| Magenta machinery | `#F21DD7` vivid, selective, not a blanket on enemies |
| Player | `#E9F4F7` light silver-white with cyan visor and dark contour |
| Enemy class A | `#FF3D31` red-orange body, `#FFB21E` warning joints, cyan optical sensor |
| Enemy class B | `#902BEA` saturated violet, `#FFCD45` amber pincers, cyan optical sensor |
| Enemy class C | `#FA258C` hot pink body with coral/amber accents |
| Keys / rewards | `#FFC928` warm gold; luminous, unmistakable |
| Environmental lamps | `#FFA12A` amber. Warm highlights are secondary to cyan hazards |

**Enemy color principle:** distinguish classes first by *silhouette*, second by *color*, third by animation/behavior. Give the robots a strong colored body-to-floor contrast and bright differentiated secondary colors; do not let them dissolve into blue electric barriers.

## Shape language
- Electric walls: unchanged precise path and thickness in collision space; visually two-layered — precise bright core and soft blue glow outside. Zigzags animate, but the core remains fixed.
- Surfaces: beveled metal panels, vents, warning stripes, compact pipes, scratches, subtle reflections and occlusion.
- Player: compact athletic white/silver armored figure, readable in 8 directions. Distinct cyan visor; dark outer outline and focused gun muzzle.
- Robots: saturated red, purple, and pink variants with differentiated construction (hovering head, claw crawler, turret spider). Strong silhouettes, readable attack tell frames.
- Doors: dark solid frame and vivid yellow-black hazard stripes, distinct from lethal blue walls.
- Shadow / boss: clearly distinguishable from regular robots, with recognizable silhouette and telegraphing.

## Lighting / effects
- Real-looking volume via painted material shading, contact shadows, edge lighting and foreground pipe depth, but keep top-down arcade space.
- Warm overhead amber lights and cyan reflections on nearby metal; small magenta accent lights.
- Restrict full-screen bloom and chromatic aberration. Bright cores always remain sharp.
- Directional sparks, brief muzzle flashes, impacts and electric arcing. Avoid prolonged screen occlusion.
- Animations should be lively, not at the expense of tight responsiveness.

## Production approach
1. Extract / document DOS game room layouts and critical mechanics.
2. Establish a canonical fixed reference room for art review.
3. Produce separate layered/sprite assets for hero (8-way), robot classes, hazards, doors, keys, floor and HUD.
4. Implement art in engine with independent glow/light layers and crisp collision geometry.
5. Test screenshots at native phone size and contrast/grayscale; validate hitbox-to-art alignment.
6. Package as standalone Android APK with GameSir support. Browser prototype remains optional test harness.

## Sign-off notes
- Initial CGA Reborn reference approved after comparison with Tech-Noir, Industrial Nightmare and Graphic Assault.
- User requested **adding Tech-Noir volume and lighting** to CGA Reborn.
- User then approved the hybrid direction and requested **more contrast in robot coloration**.
