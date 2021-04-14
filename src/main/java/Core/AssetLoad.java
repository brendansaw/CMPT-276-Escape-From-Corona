package Core;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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

    public AssetLoad() {
        reloadAssets();
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
        loadMainMenuImage("src/main/resources/assets/newmainmenu.jpg");
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

    public Image getMainMenuImage(){return mainMenuImage;}
}
