package net.typeblog.shelter.util;

import java.util.HashSet;
import java.util.Set;

/** Only the fixed bridge package is changed; preserve every other admin entry. */
public final class ProfileBridgeAllowlist {
    public static final String PACKAGE = "dev.profilebridge.app";

    private ProfileBridgeAllowlist() {}

    public static Set<String> updated(Set<String> current, boolean enabled) {
        Set<String> result = new HashSet<>(current);
        if (enabled) result.add(PACKAGE);
        else result.remove(PACKAGE);
        return result;
    }
}
