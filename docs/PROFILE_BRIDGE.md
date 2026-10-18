# Profile Bridge integration (fork)

Upstream: PeterCxy/Shelter commit 0afac87. License remains GPLv3; see LICENSE.
Fork: https://github.com/d3TaL/shelter-profile-bridge .

## Important discovery: upstream already supports allowlisting

Shelter already has **Allow Cross-Profile Interaction** in the context menu
of an application in the **Shelter/work tab**. Russian label:
**«Разрешить работу между профилями»**. Try that for the work copy of
Profile Bridge in the existing installation before considering a fork migration.
Then open the Android cross-profile consent screen from Profile Bridge 0.1.6.
This may solve the current task without replacing the installed DPC.

## Fork addition

Settings → Interactions → **Allow Profile Bridge cross-profile access**.
On Android 11+, reads the actual work-profile DPC package list. Enabling adds
only `dev.profilebridge.app`; disabling removes only it. All other entries
are preserved; no preference value substitutes for actual policy readback.
Both copies of the bridge need to be installed. User consent remains a separate
step in Android Settings. No app-op shell grant or root required.

The new fixed-package service methods accept only the Shelter package with
matching signing identity (Binder caller UID). They require profile owner and
API 30+. The existing upstream generic package-list API is retained; it shares
the policy mutation lock. No additional exported component is added.

Revocation removes the admin allowlist entry. Android determines the effective
permission and app-op reset; OEM allowlisting can be independent. Do not claim
the switch revokes every possible OEM-granted permission.

## Installation / existing work profile

The installed Shelter is 1.9.1, versionCode 445, signing certificate SHA-256:
`2d4837134f3519a11d104630ed42a4a795f4ab2327e1c9899cbebfbf89aba483`.
The original signing private key is not available. Fork test builds use a
dedicated persistent TEST key in GitHub Secrets, not the upstream signing key.
They cannot update the current installation. Do not uninstall the active DPC
or remove the work profile just to test this APK. Such changes need a separate
owner decision and migration plan. No migration has been performed.

For a spare device or emulator with no existing work profile: install the fork,
use standard Android provisioning, clone Profile Bridge, enable the switch,
grant user consent from Profile Bridge, and send only a public test HTTPS URL.
Verify the received text, then revoke the switch and verify denial of a fresh
send. Opening another copy alone is not evidence of payload permission.

This fork controls its managed work profile only, not Samsung Secure Folder.

## CI and artifacts

Gradle 8.7 (wrapper SHA-256 pinned), AGP 8.6.0, JDK 17; compile/target 35.
SetupWizardLibrary submodule pinned at ae5ee4b4a0fb380c99e05f53b753cc86b212f1dd.
Tests, debug/release lint, debug build and R8 unsigned release in Actions.
Master push uses dedicated test signing secrets; PR does not receive the key.
Artifacts contain APK, SHA256SUMS, source commit/run ID and GPL license.
Existing upstream lint exclusions and dependencies are retained; no new global
lint baseline added. Dependency verification/locks are not present upstream;
this iteration does not claim strict dependency verification.

Security instructions reviewed: Google android/skills android-permissions-security
and android-intent-security at commit 5bda39f154fb859a08d45e2392f3568e049f83fb.
Applied to Binder caller checks and least-privilege fixed-package DPC operation.
New signature check does not authenticate payloads sent to Profile Bridge itself.
