<div align="center">
  <h1>NexAlloy</h1>
  <a href="https://discord.gg/QWUrAA2mKq"><img alt="Discord Server" src="https://img.shields.io/badge/Discord%20Server-5865F2.svg?logo=discord&logoColor=white"></a>
  <a href="https://t.me/revancedxposed"><img alt="Telegram Channel" src="https://img.shields.io/badge/Telegram_Channel-blue.svg?logo=telegram&logoColor=white"></a>
  <a href="https://github.com/NexAlloy/NexAlloy/releases/latest"><img alt="GitHub Downloads" src="https://img.shields.io/endpoint?url=https%3A%2F%2Fshields.chsbuffer.workers.dev%2F%3Frepos%3DNexAlloy%2FNexAlloy%26cacheSeconds%3D3600"></a>
  <a href="https://github.com/NexAlloy/NexAlloy"><img alt="GitHub Stars" src="https://img.shields.io/github/stars/NexAlloy/NexAlloy"></a>  
  <br>
</div>

**ChsBuffer's LSPosed module, powered by Morphe, ReVanced, and beyond.**  
> [!CAUTION]
> **Migration Notice:** This project has evolved from **ReVancedXposed** to **NexAlloy**. 
> 
> **Upgrading:** We’ve kept the original Package ID for your convenience. You can install this as an update, but **you must manually export your settings from the old version and import them into the new one** to keep your configuration.

>[!IMPORTANT]  
> - This is **NOT an official Morphe or ReVanced project**, do not ask their developers for help.  
> - **Root access** is strictly **required** to use this module!
> - **Having issues?** Check the **[FAQ](https://github.com/NexAlloy/NexAlloy/wiki/Frequently-Asked-Questions)** before reporting.

## Downloads
- **Release build**: [Download](https://github.com/NexAlloy/NexAlloy/releases/latest)
- **Nightly build**: [Download](https://nightly.link/NexAlloy/NexAlloy/workflows/android/main)

<sub>If you've joined the YouTube beta program, please try the nightly build before reporting an issue.</sub>

## Patches

### YouTube ([22/93] Implemented)
> Reference: [MorpheApp/morphe-patches](https://github.com/MorpheApp/morphe-patches)
> CPU Impact: 🟢 Passive | 🟡 Low–Medium | 🔴 Heavy

- [ ] 🟢 **Add to queue** — Overrides the feed flyout 'Play next in queue' with the Morphe video queue.
- [ ] 🟢 **Ambient mode** — Adds options to bypass power saving restrictions for Ambient mode and disable it entirely or in fullscreen.
- [ ] 🟢 **App refresh rate** — Adds an option to change the app refresh rate.
- [x] 🟢 **Bypass image region restrictions** — Adds an option to use a different host for user avatar and channel images and can fix missing images that are blocked in some countries.
- [ ] 🟢 **Bypass link redirects** — Adds an option to bypass redirects and open the original link directly.
- [x] 🟢 **Captions** — Adds an option to disable captions from being automatically enabled or to set caption cookies.
- [ ] 🟢 **Change form factor** — Adds an option to change the UI appearance to a phone, tablet, or automotive device.
- [ ] 🟢 **Change header** — Adds an option to change the header logo in the top left corner of the app.
- [x] 🟢 **Change start page** — Adds an option to set which page the app opens in instead of the homepage.
- [ ] 🟢 **Channel search** — Adds an option to search inside the channel that is currently open instead of searching all of YouTube.
- [ ] 🟡 **Channel whitelist** — Adds options to allow whitelisting specific channels to show ads or override playback speeds.
- [ ] 🟢 **Check watch history domain name resolution** — Checks if the device DNS server is preventing user watch history from being saved.
- [x] 🟢 **Copy video link** — Adds options to display buttons in the video player to copy video links.
- [ ] 🟢 **Custom branding** — Adds options to change the app icon and app name. For mounted (root) installations the branding is applied while patching, because it cannot be changed from the app settings.
- [ ] 🟢 **Custom player overlay opacity** — Adds an option to change the opacity of the video player background when player controls are visible.
- [x] 🔴 **DeArrow** — Adds options to replace video thumbnails and titles using the DeArrow API, or replace video thumbnails with image captures from the video.
- [ ] 🟢 **Disable auto feed refresh** — Adds an option to stop feeds from refreshing automatically after they become outdated.
- [ ] 🟢 **Disable double tap actions** — Adds an option to disable player double tap gestures.
- [ ] 🟢 **Disable DRC audio** — Adds an option to disable DRC (Dynamic Range Compression) audio.
- [ ] 🟢 **Disable fullscreen gestures** — Adds options to selectively disable gestures for entering and exiting fullscreen mode, and to disable pinch-to-zoom.
- [ ] 🟢 **Disable haptic feedback** — Adds an option to disable haptic feedback in the player for various actions.
- [ ] 🟢 **Disable layout updates** — Adds an option to disable server side layout updates and use an older UI.
- [ ] 🟢 **Disable player popup panels** — Adds an option to disable panels (such as live chat) from opening automatically.
- [ ] 🟢 **Disable playlist autoplay** — Adds an option to stop a playlist from automatically advancing to the next video.
- [ ] 🟢 **Disable QUIC protocol** — Adds an option to disable QUIC (Quick UDP Internet Connections) network protocol.
- [ ] 🟢 **Disable rolling number animations** — Adds an option to disable rolling number animations of video view count, user likes, and upload time.
- [ ] 🟢 **Disable scrolling speed limit** — Adds an option to remove limits of how fast the home and subscription feed can be scrolled.
- [x] 🟢 **Disable Shorts resuming on startup** — Adds an option to disable Shorts from resuming on app startup when Shorts were last being watched.
- [ ] 🟢 **Disable sign in to TV popup** — Adds options to disable the popups asking to sign into or connect to a TV on the same local network.
- [x] 🟢 **Disable video codecs** — Adds options to disable or force HDR, and to disable VP9 codecs.
- [ ] 🟢 **Double tap to seek** — Adds additional double-tap to seek values to the YouTube settings menu.
- [x] 🟢 **Downloads** — Adds support to download videos with an external downloader app using the in-app download button or a video player action button.
- [x] 🟡 **Enable debugging** — Adds options for debugging and exporting Morphe logs to the clipboard.
- [ ] 🟢 **Exit fullscreen mode** — Adds options to automatically exit fullscreen mode when a video reaches the end.
- [ ] 🟢 **Force fullscreen landscape** — Adds an option to rotate the player to landscape when entering fullscreen mode on tablets and other large screen devices.
- [x] 🟢 **Force original audio** — Adds an option to always use the original audio track.
- [ ] 🟢 **Fullscreen video scale** — Adds options to stretch or zoom videos to fill the screen in fullscreen mode.
- [ ] 🟢 **GmsCore support** — Allows the app to work without root by using a different package name when patched using a GmsCore instead of Google Play Services.
- [x] 🔴 **Hide ads** — Adds options to hide general ads, Premium promotions and video ads.
- [ ] 🟢 **Hide autoplay preview** — Adds an option to hide the autoplay preview at the end of videos.
- [ ] 🟢 **Hide end screen cards** — Adds an option to hide suggested video cards at the end of videos.
- [ ] 🟢 **Hide end screen suggested video** — Adds an option to hide the suggested video at the end of videos.
- [ ] 🟢 **Hide info cards** — Adds an option to hide info cards that creators add in the video player.
- [x] 🔴 **Hide layout components** — Adds options to hide general layout components.
- [ ] 🟡 **Hide player flyout menu components** — Adds options to hide menu components that appear when pressing the gear icon in the video player.
- [ ] 🟢 **Hide player overlay buttons** — Adds options to hide the player Cast, Autoplay, Captions, Previous & Next buttons, and to hide or change the opacity of the player control buttons background.
- [ ] 🟢 **Hide related video overlay** — Adds an option to hide the related video overlay shown when swiping up in fullscreen.
- [ ] 🟡 **Hide related videos** — Adds options to hide related videos.
- [x] 🟡 **Hide Shorts components** — Adds options to hide components related to Shorts.
- [ ] 🟢 **Hide status bar** — Adds an option to hide the system status bar. Swipe down from the top edge to show it for a moment.
- [ ] 🟢 **Hide timestamp** — Adds an option to hide the timestamp in the bottom left of the video player.
- [x] 🟡 **Hide video action buttons** — Adds options to hide video action buttons in fullscreen and portrait modes.
- [ ] 🟢 **Loop video** — Adds an option to loop videos and display loop video button in the video player.
- [ ] 🟢 **Media notification controls** — Adds options to disable the seekbar and previous/next buttons in the media notification and headphone controls.
- [ ] 🟢 **Miniplayer** — Adds options to change the in-app minimized player. Patching 21.28.206 and lower has more miniplayer types to choose from.
- [ ] 🟢 **Mute button** — Adds an option to show a player button that mutes the video audio.
- [x] 🟡 **Navigation bar** — Adds options to hide and change the bottom navigation bar (such as the Shorts button) and the upper navigation toolbar.
- [ ] 🟡 **Network proxy** — Adds settings to route supported network requests through an HTTP or HTTPS proxy. Including this patch may cause connectivity problems on certain devices
- [ ] 🟢 **Open channel of live avatar** — Adds an option to prevent a channel's current live video from opening when tapping its avatar.
- [ ] 🟢 **Open links externally** — Adds an option to always open links in your browser instead of with the in-app browser.
- [ ] 🟢 **Open Shorts in regular player** — Adds options to open Shorts in the regular video player.
- [ ] 🟢 **Open system share sheet** — Adds an option to always open the system share sheet instead of the in-app share sheet.
- [ ] 🟢 **Open videos fullscreen** — Adds options to automatically open videos in fullscreen portrait or landscape mode.
- [ ] 🟢 **Override YouTube Music buttons** — Overrides YouTube Music buttons to open Morphe Music or any compatible third-party client.
- [ ] 🟢 **Picture-in-picture button** — Adds an option to display a picture-in-picture button in the video player.
- [ ] 🟢 **Play all** — Adds an option to play all the videos from a channel and to display play all button in the video player.
- [ ] 🟢 **Playback buffer** — Adds an option to change the video playback buffer size.
- [ ] 🟢 **Playback in feeds** — Adds the 'Playback in feeds' setting of YouTube to the Morphe settings, where it is always available even if YouTube hides it.
- [x] 🟡 **Playback speed** — Adds options to customize available playback speeds, set a default playback speed, and show a speed dialog button in the video player.
- [ ] 🟢 **Player icon style** — Adds an option to change the style of the player button icons.
- [ ] 🟡 **PoToken provider** — Adds option to get PoToken using an external PoToken minter app.
- [ ] 🟢 **Reload video** — Adds an option to display reload video button in the video player.
- [ ] 🟡 **Remember live stream playback position** — Adds an option to remember the playback position of an ongoing live stream and resume from there when reopening that live stream.
- [x] 🟢 **Remove background playback restrictions** — Removes restrictions on background playback, including playing kids videos in the background.
- [ ] 🟢 **Remove viewer discretion dialog** — Adds an option to remove the dialog that appears when opening a video that has been age-restricted by accepting it automatically. This does not bypass the age restriction.
- [ ] 🟡 **Restore original titles** — Adds an option to show the original video titles, video descriptions and channel descriptions instead of the auto-translated ones.
- [x] 🔴 **Return YouTube Dislike** — Adds an option to show the dislike count of videos with Return YouTube Dislike.
- [x] 🟢 **Sanitize sharing links** — Removes the tracking query parameters from shared links.
- [ ] 🟢 **Save to Watch later** — Adds an option to display save to Watch later button in the video player.
- [ ] 🟡 **Seekbar** — Adds options to show old seekbar thumbnails, disable precise seeking when swiping up on the seekbar, slide to seek instead of playing at 2x speed when pressing and holding, tapping the player seekbar to seek, hiding the video player seekbar, enabling seeking in live streams, and expanding the live stream DVR duration.
- [ ] 🟢 **Settings menu filter** — Adds an option to hide items on the standard YouTube settings screen by their visible name.
- [ ] 🟡 **Shorts autoplay** — Adds options to automatically play the next Short.
- [ ] 🟢 **Shorts icon style** — Adds an option to change the style of the Shorts action button icons.
- [ ] 🔴 **Skip silence** — Adds an option to automatically skip silent pauses in audio playback.
- [x] 🔴 **SponsorBlock** — Adds options to enable and configure SponsorBlock, which can skip undesired video segments such as sponsored content.
- [ ] 🟢 **Spoof app version** — Adds an option to trick the app into thinking you are running an older version.
- [ ] 🟢 **Spoof device dimensions** — Adds an option to spoof the device dimensions which can unlock higher video qualities.
- [ ] 🟡 **Spoof video streams** — Adds options to spoof the client video streams to fix playback.
- [x] 🟡 **Swipe controls** — Adds options to enable and configure volume and brightness swipe controls.
- [ ] 🟢 **Theme** — Adds options for theming, and settings to change the app foreground and background colors.
- [x] 🟢 **Video quality** — Adds options to set default video qualities and always use the advanced video quality menu.
- [ ] 🔴 **Voice over translation** — Adds additional voice over languages using text-to-speech synchronized to the video playback.
- [ ] 🟢 **Wide search bar** — Adds a wide search bar to the top of the home and subscription feed.

### YouTube Music
- Remove music video ads
- Remove background playback restrictions
- Hide upgrade button
- Hide 'Get Music Premium' label
- Enable exclusive audio playback

### Reddit
- Hide ads
- Sanitize sharing links
- Start as guest

### Google Photos
- Spoof Pixel XL

### Photomath
- Unlock plus

### Instagram
- Hide ads

### Threads
- Hide ads

### Strava
- Unlock subscription features
- Disable subscription suggestions

### AllTrails
- Enable Peak membership

## Supports
[![Discord Server](https://img.shields.io/badge/Join-Discord-5865F2.svg?logo=discord)](https://discord.gg/QWUrAA2mKq)  
[![FAQ](https://img.shields.io/badge/Read-FAQ-orange.svg?logo=github)](https://github.com/NexAlloy/NexAlloy/wiki/Frequently-Asked-Questions)  
or [Create an issue](https://github.com/NexAlloy/NexAlloy/issues/new/choose)

## ⭐ Credits

[DexKit](https://luckypray.org/DexKit/en/): a high-performance dex runtime parsing library.  
[Morphe](https://morphe.software): Transform Your Android Apps  
[ReVanced](https://revanced.app): Continuing the legacy of Vanced at [revanced.app](https://revanced.app)
