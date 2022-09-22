package gliese832c.circulatorySystem.gui;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.proxy.ClientProxy;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTracker;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTrackers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

import static gliese832c.circulatorySystem.util.StringProcessing.getValueColorizedPercentage;

public class CirculatorySystemGui extends GuiScreenDynamic {
    private GuiButton buttonClose;
    private GuiLabel label;

    ///////////////////
    // Magic Numbers //
    ///////////////////

    // Gui Container
    private final int GUI_BASE_WIDTH = 184;
    private final int GUI_BASE_HEIGHT = 72;
    private final int NUTRITION_DISTANCE = 20; // Vertical distance between each nutrient

    // Nutrition Title
    private final int TITLE_VERTICAL_OFFSET = 18;

    // Nutrition icon positions
    private final int NUTRITION_ICON_HORIZONTAL_OFFSET = 10;
    private final int NUTRITION_ICON_VERTICAL_OFFSET = 32;

    // Nutrition bar positions
    private final int NUTRITION_BAR_WIDTH = 130;
    private final int NUTRITION_BAR_HEIGHT = 13;
    private final int NUTRITION_BAR_HORIZONTAL_OFFSET = 40;
    private final int NUTRITION_BAR_VERTICAL_OFFSET = 33;

    // Nutrition label positions
    private final int LABEL_NAME_HORIZONTAL_OFFSET = 30;
    private final int LABEL_VALUE_HORIZONTAL_OFFSET = 43;
    private final int LABEL_VERTICAL_OFFSET = 41;
    private int labelCharacterPadding = 0; // Add padding for long nutrient names

    // Close button position
    private final int CLOSE_BUTTON_WIDTH = 70;
    private final int CLOSE_BUTTON_HEIGHT = 20;
    private final int CLOSE_BUTTON_OFFSET = 12;

    private EntityPlayer player;

    public CirculatorySystemGui(EntityPlayer player) {
        this.player = player;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks); // Background
        drawNutritionBars(); // Nutrition bars
        super.drawLabels(mouseX, mouseY); // Labels/buttons
    }

    private void drawNutritionBars() {
        int i = 0;

        for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {

            NBTTagCompound data = tryGettingStatusTrackerData();

            double currentValue = data != null ? data.getDouble(statusTracker.key) : 0.0d;

            // Calculate percentage width for nutrition bars
            int systemBarDisplayWidth = (int) Math.round(currentValue * (double) NUTRITION_BAR_WIDTH);

            // Draw texture
            ResourceLocation currentResourceLocation = statusTracker.resourceLocation;
            GlStateManager.color(1F, 1F, 1F);
            TextureAtlasSprite sprite = mc.getTextureMapBlocks().getAtlasSprite(currentResourceLocation.toString());
            mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            drawTexturedModalRect(left + NUTRITION_ICON_HORIZONTAL_OFFSET, top + NUTRITION_ICON_VERTICAL_OFFSET + (i * NUTRITION_DISTANCE), sprite, 16, 16);

            // Draw black background
            drawRect(
                    left + NUTRITION_BAR_HORIZONTAL_OFFSET + labelCharacterPadding - 1,
                    top + NUTRITION_BAR_VERTICAL_OFFSET + (i * NUTRITION_DISTANCE) - 1,
                    left + NUTRITION_BAR_HORIZONTAL_OFFSET + NUTRITION_BAR_WIDTH + labelCharacterPadding + 1,
                    top + NUTRITION_BAR_VERTICAL_OFFSET + (i * NUTRITION_DISTANCE) + NUTRITION_BAR_HEIGHT + 1,
                    0xff000000
            );

            int redChannel = (int) (255 * currentValue);
            redChannel = 256 * 256 * Math.max(Math.min(redChannel, 255), 0);
            int greenChannel = (int) (255 - (255 * currentValue));
            greenChannel = 256 * Math.max(Math.min(greenChannel, 255), 0);
            int color = redChannel + greenChannel + 0xff000000;

            // Draw colored bar
            drawRect(
                    left + NUTRITION_BAR_HORIZONTAL_OFFSET + labelCharacterPadding,
                    top + NUTRITION_BAR_VERTICAL_OFFSET + (i * NUTRITION_DISTANCE),
                    left + NUTRITION_BAR_HORIZONTAL_OFFSET + systemBarDisplayWidth + labelCharacterPadding,
                    top + NUTRITION_BAR_VERTICAL_OFFSET + (i * NUTRITION_DISTANCE) + NUTRITION_BAR_HEIGHT,
                    //0xff0088CC
                    color
            );

            i++;
        }
    }

    // Called when GUI is opened or resized
    @Override
    public void initGui() {
        // Calculate label offset for long nutrition names
        for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {
            int systemTypeWidth = fontRenderer.getStringWidth(I18n.format(statusTracker.chatInfoMessage)); // Get width of localized string
            systemTypeWidth = (systemTypeWidth / 4) * 4; // Round to nearest multiple of 4
            if (systemTypeWidth > labelCharacterPadding)
                labelCharacterPadding = systemTypeWidth;
        }

        // Update dynamic GUI size
        super.updateContainerSize(GUI_BASE_WIDTH + labelCharacterPadding, GUI_BASE_HEIGHT + (StatusTrackers.statusTrackers.size() * NUTRITION_DISTANCE));

        // Add Close button
        buttonList.add(buttonClose = new GuiButton(
                0,
                (width / 2) - (CLOSE_BUTTON_WIDTH / 2),
                bottom - CLOSE_BUTTON_HEIGHT - CLOSE_BUTTON_OFFSET,
                CLOSE_BUTTON_WIDTH,
                CLOSE_BUTTON_HEIGHT,
                I18n.format("gui." + CirculatorySystem.MOD_ID + ".close")
        ));

        // Draw labels
        redrawLabels();
    }

    // Called when needing to propagate the window with new information
    public void redrawLabels() {

        NBTTagCompound data = tryGettingStatusTrackerData();

        // Clear existing labels for nutrition value or screen changes
        labelList.clear();

        // Draw title
        String nutritionTitle = I18n.format("gui." + CirculatorySystem.MOD_ID + ".title");
        labelList.add(label = new GuiLabel(fontRenderer, 0, (width / 2) - (fontRenderer.getStringWidth(nutritionTitle) / 2), top + TITLE_VERTICAL_OFFSET, 0, 0, 0xffffffff));
        label.addLine(nutritionTitle);

        // Nutrients names and values
        int i = 0;
        for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {
            // Create labels for each nutrient type name
            labelList.add(label = new GuiLabel(fontRenderer, 0, left + LABEL_NAME_HORIZONTAL_OFFSET, top + LABEL_VERTICAL_OFFSET + (i * NUTRITION_DISTANCE), 0, 0, 0xffffffff));
            label.addLine(I18n.format(statusTracker.chatInfoMessage)); // Add name from localization file

            // Create percent value labels for each nutrient value
            labelList.add(label = new GuiLabel(fontRenderer, 0, left + LABEL_VALUE_HORIZONTAL_OFFSET + labelCharacterPadding, top + LABEL_VERTICAL_OFFSET + (i * NUTRITION_DISTANCE), 0, 0, 0xffffffff));

            String value = data != null ? getValueColorizedPercentage(data.getDouble(statusTracker.key)) : "Couldn't Fetch Value";
            label.labels.add(value);
            //label.addLine(getValueColorizedPercentage(data.getDouble(statusTracker.key)));
            //fontRenderer.drawString();
            i++;
        }
    }

    // Called when button/element is clicked
    @Override
    protected void actionPerformed(GuiButton button) {
        if (button == buttonClose) {
            // Close GUI
            mc.player.closeScreen();
            if (mc.currentScreen == null)
                mc.setIngameFocus();
        }
    }

    // Close GUI if inventory key is hit again
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);

        // If escape key (1), or player inventory key (E), or Nutrition GUI key (N) is pressed
        if (keyCode == 1 || keyCode == Minecraft.getMinecraft().gameSettings.keyBindInventory.getKeyCode() || keyCode == ClientProxy.keyCirculatorySystemGui.getKeyCode()) {
            // Close GUI
            mc.player.closeScreen();
            if (mc.currentScreen == null)
                mc.setIngameFocus();
        }
    }

    // Opening Nutrition menu doesn't pause game
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }


    @Override
    public void updateScreen() {
        redrawLabels();
    }



    private NBTTagCompound tryGettingStatusTrackerData() {
        if (ClientProxy.clientProxyData.playerStatusTrackers == null) {
            // Request player data
            return null;
        } else {
            return ClientProxy.clientProxyData.playerStatusTrackers;
        }
    }
}