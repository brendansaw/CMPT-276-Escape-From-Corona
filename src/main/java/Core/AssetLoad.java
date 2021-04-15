package Core;

import javafx.scene.image.Image;

import javax.sound.sampled.*;
import java.io.*;
import java.util.function.IntUnaryOperator;

public class AssetLoad {
    private InputStream spriteStream;
    private InputStream enemyStream;
    private InputStream groundStream;
    private InputStream wallStream;
    private InputStream checkpointStream;
    private InputStream punishStream;
    private InputStream exitStream;
    private InputStream entryStream;
    private InputStream bonusStream;
    private InputStream mainMenuStream;
    private InputStream gameOverLoseStream;
    private InputStream gameOverWinStream;
    private InputStream pauseScreenStream;

    private File coronaFile;
    private File clickFile;
    private File swooshFile;
    private File gameOverFile;
    private File victoryFile;
    private File themeSongFile;

    private Clip coronaClip = null;
    private Clip clickClip = null;
    private Clip swooshClip = null;
    private Clip gameOverClip = null;
    private Clip victoryClip = null;
    private Clip themeSongClip = null;


    private Image spriteImage = null;
    private Image enemyImage = null;
    private Image groundImage = null;
    private Image wallImage = null;
    private Image checkpointImage = null;
    private Image punishImage = null;
    private Image exitImage = null;
    private Image entryImage = null;
    private Image bonusImage = null;
    private Image mainMenuImage = null;
    private Image gameOverLoseImage = null;
    private Image gameOverWinImage = null;
    private Image pauseScreenImage = null;

    public AssetLoad() {
        reloadAssets();
        reloadAudioAssets();
    }

    public void reloadAssets() {
        loadSpriteImage("src/main/resources/assets/bonnie.png");
        loadEnemyImage("src/main/resources/assets/enemy.png");
        loadGroundImage("src/main/resources/assets/grass.png");
        loadWallImage("src/main/resources/assets/wall.png");
        loadCheckpointImage("src/main/resources/assets/chkpt.png");
        loadPunishmentImage("src/main/resources/assets/punish.png");
        loadExitImage("src/main/resources/assets/exit.png");
        loadEntranceImage("src/main/resources/assets/entry.png");
        loadBonusImage("src/main/resources/assets/bonusimage.png");
        loadMainMenuImage("src/main/resources/assets/mainmenufinal.jpg");
        loadGameOverLoseImage("src/main/resources/assets/YouLostFinal.jpg");
        loadGameOverWinImage("src/main/resources/assets/YouWonFinal.jpg");
        loadPauseScreenImage("src/main/resources/assets/pauseFinal.jpg");
    }

    public void reloadAudioAssets() {
        loadCoronaTimeAudio("src/main/resources/assets/coronatimelower.wav");
        loadClickAudio("src/main/resources/assets/click.wav");
        loadSwooshAudio("src/main/resources/assets/swoosh.wav");
        loadGameOverAudio("src/main/resources/assets/gameover.wav");
        loadVictoryAudio("src/main/resources/assets/victory.wav");
        loadThemeSongAudio("src/main/resources/assets/themesonglow.wav");

    }

    public Clip loadCoronaTimeAudio(String path){
        try {
            coronaFile = new File(path);
            AudioInputStream coronaInput = AudioSystem.getAudioInputStream(coronaFile);
            coronaClip = AudioSystem.getClip();
            coronaClip.open(coronaInput);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            coronaFile = null;
            coronaClip = null;
            return coronaClip;
        }
            return coronaClip;
    }
    public Clip loadClickAudio(String path){
        try {
            clickFile = new File(path);
            AudioInputStream clickInput = AudioSystem.getAudioInputStream(clickFile);
            clickClip = AudioSystem.getClip();
            clickClip.open(clickInput);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            clickFile = null;
            clickClip = null;
        }
            return clickClip;
    }

    public Clip loadSwooshAudio(String path){
        try {
            swooshFile = new File(path);
            AudioInputStream swooshInput = AudioSystem.getAudioInputStream(swooshFile);
            swooshClip = AudioSystem.getClip();
            swooshClip.open(swooshInput);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            swooshFile = null;
            swooshClip = null;
        }
        return swooshClip;
    }
    public Clip loadGameOverAudio(String path){
        try {
            gameOverFile = new File(path);
            AudioInputStream gameOverInput = AudioSystem.getAudioInputStream(gameOverFile);
            gameOverClip = AudioSystem.getClip();
            gameOverClip.open(gameOverInput);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            gameOverFile = null;
            gameOverClip = null;
        }
        return gameOverClip;
    }

    public Clip loadVictoryAudio(String path){
        try {
            victoryFile = new File(path);
            AudioInputStream victoryInput = AudioSystem.getAudioInputStream(victoryFile);
            victoryClip = AudioSystem.getClip();
            victoryClip.open(victoryInput);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            victoryFile = null;
            victoryClip = null;
        }
        return victoryClip;
    }
    public Clip loadThemeSongAudio(String path){
        try {
            themeSongFile = new File(path);
            AudioInputStream themeSongInput = AudioSystem.getAudioInputStream(themeSongFile);
            themeSongClip = AudioSystem.getClip();
            themeSongClip.open(themeSongInput);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            themeSongFile = null;
            themeSongClip = null;
        }
        return themeSongClip;
    }



    public Image loadSpriteImage(String path) {
        try {
            spriteStream = new FileInputStream(path);
            spriteImage = new Image(spriteStream);
        }
        catch (FileNotFoundException e) {
            spriteStream = null;
            spriteImage = null;
            return spriteImage;
        }
        return spriteImage;
    }

    public Image loadEnemyImage(String path) {
        try {
            enemyStream = new FileInputStream(path);
            enemyImage = new Image(enemyStream);
        }
        catch (FileNotFoundException e) {
            enemyStream = null;
            enemyImage = null;
            return enemyImage;
        }
        return enemyImage;
    }

    public Image loadGroundImage(String path) {
        try {
            groundStream = new FileInputStream(path);
            groundImage = new Image(groundStream);
        }
        catch (FileNotFoundException e) {
            groundStream = null;
            groundImage = null;
            return groundImage;
        }
        return groundImage;
    }

    public Image loadWallImage(String path) {
        try {
            wallStream = new FileInputStream(path);
            wallImage = new Image(wallStream);
        }
        catch (FileNotFoundException e) {
            wallStream = null;
            wallImage = null;
            return wallImage;
        }
        return wallImage;
    }

    public Image loadCheckpointImage(String path) {
        try {
            checkpointStream = new FileInputStream(path);
            checkpointImage = new Image(checkpointStream);
        }
        catch (FileNotFoundException e) {
            checkpointStream = null;
            checkpointImage = null;
            return checkpointImage;
        }
        return checkpointImage;
    }

    public Image loadPunishmentImage(String path) {
        try {
            punishStream = new FileInputStream(path);
            punishImage = new Image(punishStream);
        }
        catch (FileNotFoundException e) {
            punishStream = null;
            punishImage = null;
            return punishImage;
        }
        return punishImage;
    }

    public Image loadExitImage(String path) {
        try {
            exitStream = new FileInputStream(path);
            exitImage = new Image(exitStream);
        }
        catch (FileNotFoundException e) {
            exitStream = null;
            exitImage = null;
            return exitImage;
        }
        return exitImage;
    }

    public Image loadEntranceImage(String path) {
        try {
            entryStream = new FileInputStream(path);
            entryImage = new Image(entryStream);
        }
        catch (FileNotFoundException e) {
            entryStream = null;
            entryImage = null;
            return entryImage;
        }
        return entryImage;
    }

    public Image loadBonusImage(String path) {
        try {
            bonusStream = new FileInputStream(path);
            bonusImage = new Image(bonusStream);
        }
        catch (FileNotFoundException e) {
            bonusStream = null;
            bonusImage = null;
            return bonusImage;
        }
        return bonusImage;

    }
    public Image loadMainMenuImage(String path) {
        try {
            mainMenuStream = new FileInputStream(path);
            mainMenuImage = new Image(mainMenuStream);
        }
        catch (FileNotFoundException e) {
            mainMenuStream = null;
            mainMenuImage = null;
            return mainMenuImage;
        }
        return mainMenuImage;
    }

    public Image loadGameOverLoseImage(String path) {
        try {
            gameOverLoseStream = new FileInputStream(path);
            gameOverLoseImage = new Image(gameOverLoseStream);
        }
        catch (FileNotFoundException e) {
            gameOverLoseStream = null;
            gameOverLoseImage = null;
            return gameOverLoseImage;
        }
        return gameOverLoseImage;
    }

    public Image loadGameOverWinImage(String path) {
        try {
            gameOverWinStream = new FileInputStream(path);
            gameOverWinImage = new Image(gameOverWinStream);
        }
        catch (FileNotFoundException e) {
            gameOverWinStream = null;
            gameOverWinImage = null;
            return gameOverWinImage;
        }
        return gameOverWinImage;
    }

    public Image loadPauseScreenImage(String path) {
        try {
            pauseScreenStream = new FileInputStream(path);
            pauseScreenImage = new Image(pauseScreenStream);
        }
        catch (FileNotFoundException e) {
            pauseScreenStream = null;
            pauseScreenImage = null;
            return pauseScreenImage;
        }
        return pauseScreenImage;
    }


    public Image getSpriteImage() {
        return spriteImage;
    }

    public Image getEnemyImage() {
        return enemyImage;
    }

    public Image getGroundImage() {
        return groundImage;
    }

    public Image getWallImage() {
        return wallImage;
    }

    public Image getCheckpointImage() {
        return checkpointImage;
    }

    public Image getPunishImage() {
        return punishImage;
    }

    public Image getEntryImage() {
        return entryImage;
    }

    public Image getExitImage() {
        return exitImage;
    }

    public Image getBonusImage() {
        return bonusImage;
    }

    public Image getMainMenuImage()
    {
        return mainMenuImage;
    }

    public Image getGameOverLoseImage()
    {
        return gameOverLoseImage;
    }

    public Image getGameOverWinImage()
    {
        return gameOverWinImage;
    }

    public Image getPauseScreenImage()
    {
        return pauseScreenImage;
    }


    public Clip getCoronaClip() {
        return  coronaClip;
    }
    public Clip getClickClip() {
        return  clickClip;
    }
    public Clip getSwooshClip() {
        return  swooshClip;
    }
    public Clip getGameOverClip() {
        return  gameOverClip;
    }
    public Clip getVictoryClip() {
        return  victoryClip;
    }
    public Clip getThemeSongClip() {
        return  themeSongClip;
    }


}


