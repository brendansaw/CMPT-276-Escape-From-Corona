package Core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class AssetLoadTest {
    AssetLoad assetLoad = new AssetLoad();

    @BeforeEach
    public void reset() {
        assetLoad.reloadAssets();
    }

    @Test
    public void notNullValidMCTest() {
        assertNotNull(assetLoad.getSpriteImage());
    }

    @Test
    public void notNullValidEnemyTest() {
        assertNotNull(assetLoad.getEnemyImage());
    }

    @Test
    public void notNullValidGroundTest() {
        assertNotNull(assetLoad.getGroundImage());
    }

    @Test
    public void notNullValidWallTest() {
        assertNotNull(assetLoad.getWallImage());
    }

    @Test
    public void notNullValidCheckpointTest() {
        assertNotNull(assetLoad.getCheckpointImage());
    }

    @Test
    public void notNullValidPunishmentTest() {
        assertNotNull(assetLoad.getPunishImage());
    }

    @Test
    public void notNullValidExitTest() {
        assertNotNull(assetLoad.getExitImage());
    }

    @Test
    public void notNullValidEntryTest() {
        assertNotNull(assetLoad.getEntryImage());
    }

    @Test
    public void nullValidMCTest() {
        assetLoad.loadSpriteImage("");
        assertNull(assetLoad.getSpriteImage());
    }

    @Test
    public void nullValidEnemyTest() {
        assetLoad.loadEnemyImage("");
        assertNull(assetLoad.getEnemyImage());
    }

    @Test
    public void nullValidGroundTest() {
        assetLoad.loadGroundImage("");
        assertNull(assetLoad.getGroundImage());
    }

    @Test
    public void nullValidWallTest() {
        assetLoad.loadWallImage("");
        assertNull(assetLoad.getWallImage());
    }

    @Test
    public void nullValidCheckpointTest() {
        assetLoad.loadCheckpointImage("");
        assertNull(assetLoad.getCheckpointImage());
    }

    @Test
    public void nullValidPunishmentTest() {
        assetLoad.loadPunishmentImage("");
        assertNull(assetLoad.getPunishImage());
    }

    @Test
    public void nullValidExitTest() {
        assetLoad.loadExitImage("");
        assertNull(assetLoad.getExitImage());
    }

    @Test
    public void nullValidEntryTest() {
        assetLoad.loadEntranceImage("");
        assertNull(assetLoad.getEntryImage());
    }
}
