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
    public void notNullValidBonusTest() {
        assertNotNull(assetLoad.getBonusImage());
    }

    @Test
    public void notNullValidMainMenuTest(){
        assertNotNull(assetLoad.getMainMenuImage());
    }

    @Test
    public void notNullValidGameOverLoseTest(){
        assertNotNull(assetLoad.getGameOverLoseImage());
    }

    @Test
    public void notNullValidGameOverWinTest(){
        assertNotNull(assetLoad.getGameOverWinImage());
    }

    @Test
    public void notNullValidPauseScreenTest(){
        assertNotNull(assetLoad.getPauseScreenImage());
    }

    @Test
    public void notNullValidCoronaTimeTest(){
        assertNotNull(assetLoad.getCoronaClip());
    }

    @Test
    public void notNullClickTest(){
        assertNotNull(assetLoad.getClickClip());
    }

    @Test
    public void notNullSwooshTest(){
        assertNotNull(assetLoad.getSwooshClip());
    }

    @Test
    public void notNullGameOverAudioTest(){
        assertNotNull(assetLoad.getGameOverClip());
    }

    @Test
    public void notNullVictoryTest(){
        assertNotNull(assetLoad.getVictoryClip());
    }

    @Test
    public void notNullThemeSongTest(){
        assertNotNull(assetLoad.getThemeSongClip());
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

    @Test
    public void nullValidBonusTest() {
        assetLoad.loadBonusImage("");
        assertNull(assetLoad.getBonusImage());
    }

    @Test
    public void nullValidMainMenuTest() {
        assetLoad.loadMainMenuImage("");
        assertNull(assetLoad.getMainMenuImage());
    }

    @Test
    public void nullValidGameOverLoseTest() {
        assetLoad.loadGameOverLoseImage("");
        assertNull(assetLoad.getGameOverLoseImage());
    }

    @Test
    public void nullValidGameOverWinTest() {
        assetLoad.loadGameOverWinImage("");
        assertNull(assetLoad.getGameOverWinImage());
    }

    @Test
    public void nullValidPauseScreenTest() {
        assetLoad.loadPauseScreenImage("");
        assertNull(assetLoad.getPauseScreenImage());
    }

    @Test
    public void nullValidCoronaTest() {
        assetLoad.loadCoronaTimeAudio("");
        assertNull(assetLoad.getCoronaClip());
    }

    @Test
    public void nullValidClickTest() {
        assetLoad.loadClickAudio("");
        assertNull(assetLoad.getClickClip());
    }

    @Test
    public void nullValidSwooshTest() {
        assetLoad.loadSwooshAudio("");
        assertNull(assetLoad.getSwooshClip());
    }

    @Test
    public void nullValidGameOverAudioTest() {
        assetLoad.loadGameOverAudio("");
        assertNull(assetLoad.getGameOverClip());
    }

    @Test
    public void nullValidVictoryTest() {
        assetLoad.loadVictoryAudio("");
        assertNull(assetLoad.getVictoryClip());
    }

    @Test
    public void nullValidThemeSongTest() {
        assetLoad.loadThemeSongAudio("");
        assertNull(assetLoad.getThemeSongClip());
    }
}
