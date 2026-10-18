package net.typeblog.shelter.util;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class ProfileBridgeAllowlistTest {
    @Test public void enablingPreservesOtherEntriesAndDoesNotMutateInput() {
        Set<String> input = new HashSet<>(Arrays.asList("org.example.other"));
        Set<String> enabled = ProfileBridgeAllowlist.updated(input, true);
        assertTrue(enabled.contains("org.example.other"));
        assertTrue(enabled.contains(ProfileBridgeAllowlist.PACKAGE));
        assertFalse(input.contains(ProfileBridgeAllowlist.PACKAGE));
        assertEquals(enabled, ProfileBridgeAllowlist.updated(enabled, true));
    }
    @Test public void revokingRemovesOnlyBridgeAndIsIdempotent() {
        Set<String> input = new HashSet<>(Arrays.asList("org.example.other", ProfileBridgeAllowlist.PACKAGE));
        Set<String> disabled = ProfileBridgeAllowlist.updated(input, false);
        assertEquals(new HashSet<>(Arrays.asList("org.example.other")), disabled);
        assertTrue(input.contains(ProfileBridgeAllowlist.PACKAGE));
        assertEquals(disabled, ProfileBridgeAllowlist.updated(disabled, false));
    }
}
