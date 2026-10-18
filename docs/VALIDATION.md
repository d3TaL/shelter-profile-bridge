# Fork validation

## Initial iteration

- Fork checkout and SetupWizardLibrary submodule fetched; upstream license GPLv3 retained.
- Installed Shelter 1.9.1/versionCode 445 APK signature verified using apksig 9.4.1.
- Installed certificate SHA-256: 2d4837134f3519a11d104630ed42a4a795f4ab2327e1c9899cbebfbf89aba483.
- New settings switch and fixed-package allowlist/deny added, policy readback,
  same package/signer IPC checks. API <30 remains unsupported for this setting.
- Unit checks cover preservation of other packages, nonmutation of input and
  idempotent enable/revoke. DPC and unauthorized Binder device tests pending.
- No installation, profile removal, DPC transfer or mutation of live policy performed.
- The upstream app context menu already offers the underlying allowlist action.
  This corrects the earlier assumption that no upstream UI exists.
- CI/build result and fork signing certificate to be recorded after actual run.
- CI 39169194635: unit tests PASS; lint found 4 new API guard visibility
  errors and 3 upstream errors (missing column index check and DPC
  systemExempted exact-alarm inference). Added direct API guards, column index
  check, and two per-service lint annotations documenting existing profile-owner
  eligibility. No new alarm permission, no change to existing FGS types and no
  global lint baseline. Runtime FGS eligibility remains platform-enforced.
- Initial local Gradle attempt stopped before task execution: Android SDK not
  installed. No APK built locally. Per owner instruction all further tests,
  lint and builds use GitHub Actions only.
- Dedicated persistent fork TEST key stored in GitHub repository secrets;
  not the upstream key, not production signing. Master CI restores it only
  for trusted branch builds; PR jobs do not receive the key.
