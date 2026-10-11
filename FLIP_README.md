# Flip Messages (Fossify Messages fork for D-pad phones)

Changes from upstream Fossify Messages:
- minSdk lowered 26 -> 24 (Android 7) with core library desugaring.
- Left/right softkeys: Conversation list = New / Options. Thread = Send / Options (Options has Attach).
- Softkey label bar at the bottom of the conversation list and thread screens.
- High-contrast yellow focus highlight on compose buttons and attachment picker items.
- Picker items and buttons are focusable so the arrow keys and center key reach them.

Build: push to GitHub, open Actions > "Build flip-phone APK" > download the `flip-messages-apk` artifact.
Install: sideload the .apk, then set it as the default SMS app.
