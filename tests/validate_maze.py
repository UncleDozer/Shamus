#!/usr/bin/env python3
"""Validate the documented PROVISIONAL 127-room world topology.

This checks internal consistency; it does NOT prove the draft links match the DOS map.
"""
import json
from collections import deque
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
data = json.loads((ROOT / 'data' / 'maze-topology-draft.json').read_text(encoding='utf-8'))
rows = data['rooms']
assert len(rows) == 127, 'expected 127 total rooms'
rooms = {r['id']: r for r in rows}
assert set(rooms) == set(range(127)), 'missing or duplicated room IDs'
bounds = [(0, 37), (38, 66), (67, 92), (93, 126)]
opposite = dict(N='S', S='N', E='W', W='E')
for z, (first, last) in enumerate(bounds):
    for i in range(first, last + 1):
        assert rooms[i]['sector'] == z, ('incorrect sector', i)
for i, room in rooms.items():
    for direction, j in room['links'].items():
        assert direction in opposite, ('unknown direction', i, direction)
        assert j in rooms, ('nonexistent destination', i, j)
        assert rooms[j]['links'].get(opposite[direction]) == i, ('missing reciprocal link', i, j)
        if room['sector'] != rooms[j]['sector']:
            assert (i, j) in {(37, 38), (38, 37), (66, 67), (67, 66), (92, 93), (93, 92)}, ('bad intersector edge', i, j)
def reachable(start, only_sector=None):
    q = deque([start])
    seen = {start}
    while q:
        for next_room in rooms[q.popleft()]['links'].values():
            if next_room not in seen and (only_sector is None or rooms[next_room]['sector'] == only_sector):
                seen.add(next_room)
                q.append(next_room)
    return seen
assert len(reachable(0)) == 127, 'not all rooms are reachable'
for z, (first, last) in enumerate(bounds):
    seen = reachable(first, z)
    assert len(seen) == (last - first + 1), ('isolated sector rooms', z, seen)
    edges = sum(1 for i in range(first, last + 1) for j in rooms[i]['links'].values()
                if rooms[j]['sector'] == z) // 2
    assert edges >= last - first, ('not connected as a maze', z)
    print(f'Sector {z + 1}: {len(seen)} rooms, {edges} connections, '
          f'{edges - (last - first)} independent loops')
print('OK: draft graph covers all 127 rooms. Authenticity is NOT verified.')
