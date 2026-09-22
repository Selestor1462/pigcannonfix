# Pig Cannon Fix

A lightweight Fabric mod for Minecraft 26.3 that restores the pre-snapshot-10 entity behavior, allowing minecarts and vehicles to pick up mobs located across borders in lazy chunks.

## Overview

In snapshot 26.3-snapshot-10, modifications to entity chunk interaction checks unintentionally prevented minecarts from mounting entities across chunk borders if the target mob was resting in a non-entity-ticking (lazy) chunk. 

## Requirements

- Minecraft **26.3**
- Fabric Loader **>=0.19.5**
- Java **25**

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 26.3.
2. Download the latest `pigcannonfix-x.x.x.jar` from the releases page.
3. Place the `.jar` into your Minecraft instance's `mods` folder.

## Building from Source

To compile the mod yourself:

```bash
# Clone the repository
git clone [https://github.com/your-username/pigcannonfix.git](https://github.com/your-username/pigcannonfix.git)
cd pigcannonfix

# Build the mod
./gradlew clean build    # On macOS/Linux
.\gradlew clean build    # On Windows
