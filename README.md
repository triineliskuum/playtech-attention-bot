# Playtech Internship – Attention Bid Bot

## Overview
This project implements a bidding bot for the Attention Economy simulation.

The bot competes in auctions for video advertisements and aims to maximize:
value / ebucks spent

## Strategy
The bot uses a lightweight heuristic-based strategy:

- Prefers viewers who are subscribed
- Increases bids when viewer interests match the selected category (ASMR)
- Uses engagement proxy: commentCount / viewCount
- Keeps latency extremely low to avoid timeouts

## Category
ASMR

## Run

```bash
javac Main.java
jar cfe bot.jar Main Main.class
java -jar bot.jar 10000000
```

Notes
- Designed to stay within strict time constraints (~40ms per decision)
- Avoids complex computation for performance reasons
