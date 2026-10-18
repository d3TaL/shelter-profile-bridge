# Shelter Profile Bridge fork

Scope: narrow user-controlled cross-profile allowlisting for
`dev.profilebridge.app`. Preserve other DPC policy entries. Default off;
disabling removes only this package. Read back actual policy after changes.
No automatic user consent, app-op grants, Knox bypass, profile removal or
profile-owner migration. New IPC methods require same app identity and signer.

Owner workflow: verify, commit and push to `d3TaL/shelter-profile-bridge`, wait
for Actions, download APK and SHA-256 into `/storage/emulated/0/Download/artifacts`.
Author and committer: d3TaL <85562612+d3TaL@users.noreply.github.com> via git
environment variables. No assistant attribution or Co-authored-by trailers.
Use apply_patch for edits. No subagents unless owner explicitly asks.
Builds, tests and lint must run through GitHub Actions, not locally on the phone.

Preserve GPLv3 license and upstream attribution. Record actual checks and
installation/signing limits in docs/VALIDATION.md. Never uninstall the active
Shelter DPC or remove its work profile without a separate explicit instruction.

Android security instructions already reviewed for this work:
android-intent-security and android-permissions-security, Google android/skills
commit 5bda39f154fb859a08d45e2392f3568e049f83fb. Check actual public Android APIs.
