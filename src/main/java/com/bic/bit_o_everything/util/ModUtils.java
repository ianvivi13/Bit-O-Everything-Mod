package com.bic.bit_o_everything.util;

import com.ibm.icu.impl.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public final class ModUtils {

    /**
     * Class pertaining to some advanced functions on the player's view
     */
    public static class advancedPlayerView {

        /**
         * Raycasts the player's view to determine if they are looking at a block
         * @param range the range (in blocks) of how far the player should be able to see a block
         * @return BlockHitResult based on if the player is looking at a block at a far distance
         */
        public static BlockHitResult getBlockLookingAt(Level level, Player player, double range) {
            Vec3 view = player.getViewVector(1F);
            Vec3 eyePos = player.getEyePosition(1F);
            ClipContext cc = new ClipContext(eyePos, view.scale(range).add(eyePos),ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, null);
            return level.clip(cc);
        }
    }

    public static class advancedMath {
        /**
         * scales a value according to the algorithm: [<b>val</b> % in range (<b>min</b> -> <b>max</b>)]<sup><b>power</b></sup><br>
         * Refer to this <a href="https://www.desmos.com/calculator/cgixul5oxs">graph</a>
         * @param min smallest value in range
         * @param max largest value in range
         * @param val value to scale
         * @param power value to scale by: x/1 will be exponential, x/1 will be logarithmic, 1 will be linear. A negative power, will result in the return going down as <b>val</b> approaches <b>max</b>
         * @return 0 -> 1
         */
        public static double scale(float min, float max, float val, double power) {
            if (power == 0) return 0;
            if (min >= max) return 0;
            double signPower = Math.signum(power);
            return signPower * Math.pow((clamp(val, min, max)-max) / (min-max), Math.abs(power)) + Math.abs((signPower - 1)/2);
        }

        public static float clamp(float val, float min, float max) {
            return val > max ? max : min > val ? min : val;
        }


    }

    /**
     * Class pertaining to some advanced random functions
     */
    public static class advancedRandom {

        public static boolean randomTrue(double d) {
            return Math.random() < d;
        }

        /**
         * @return a random int between min and max
         */
        public static int randomRange(int min, int max) {
            return (int) ((Math.random() * (max - min)) + min);
        }
    }

    public static class advancedRotation {
        /**
         * simplifies a radian (r) to a value between 0 (inclusive) and 2&pi; (exclusive) according to this <a href="https://www.desmos.com/calculator/invrphnxlq">graph</a>
         */
        public static float simplify0To2Pi(float r) {
            return (float) (r - (2 * Math.PI * Math.floor(r/(2 * Math.PI))));
        }

        /**
         * simplifies a radian (r) to a value between -&pi; (inclusive) and &pi; (exclusive) according to this <a href="https://www.desmos.com/calculator/kancjmicjx">graph</a>
         */
        public static float simplifyNegPiToPi(float r) {
            return (float) (r - (2 * Math.PI * Math.floor(r/(2 * Math.PI) + 1/2d)));
        }

        /**
         * locks a radian (val) to increments (step) in a circle. Defined by this <a href="https://www.desmos.com/calculator/3ia9iujqcn">graph</a>
         */
        public static float step(float val, double step) {
            return (float) (Math.floor(val/step + 1/2d)*step);
        }

    }

    public static class advancedChat {
        private enum sectionType {
            REGULAR_TEXT,
            URL,
            STYLE_MODIFIER
        }

        private static final Map<String, String> chatMap = Map.ofEntries(
                entry(" ", "$"),
                entry("pi", "π"),
                entry("copy", "©"),
                entry("1/4","¼"),
                entry("1/2","½"),
                entry("3/4","¾"),
                entry("degree","°")
        );

        public static Component format(String message) {
            message = replaceSymbols(message);
            return buildFancyComponent(separateSections(message));
        }

        private static Style editStyle(Style currentStyle, String s) {
            StringBuilder col = new StringBuilder("=======");
            char[] arr = s.toCharArray();
            boolean currentBool = true;
            for (char item: arr) {
                if (col.toString().length() <= 6) {
                    col.append(item);
                    if (col.toString().length() == 7) {
                        currentStyle = currentStyle.withColor(TextColor.parseColor(col.toString()));
                    }
                } else {
                    switch (item) {
                        case 'b' -> currentStyle = currentStyle.withBold(currentBool);
                        case 'i' -> currentStyle = currentStyle.withItalic(currentBool);
                        case 'g' -> currentStyle = currentStyle.withObfuscated(currentBool);
                        case 'u' -> currentStyle = currentStyle.withUnderlined(currentBool);
                        case 's' -> currentStyle = currentStyle.withStrikethrough(currentBool);
                        case 'r' -> currentStyle = Style.EMPTY;
                        case '#' -> col = new StringBuilder("#");
                    }
                    currentBool = item != '/';
                }
            }
            return currentStyle;
        }

        private static List<Pair<String, sectionType>> separateUrls(String message) {
            List<Pair<String, sectionType>> ret = new ArrayList<>();
            if (message.contains("url(")) {
                String[] parts = message.split("url\\(",2);
                String beforeUrl = parts[0];
                String url = StringUtils.substringBefore(parts[1],")");
                String afterUrl = StringUtils.substringAfter(parts[1],")");
                ret.add(Pair.of(beforeUrl, sectionType.REGULAR_TEXT));
                ret.add(Pair.of(url, sectionType.URL));
                if (!afterUrl.equals("")) {
                    ret.addAll(separateUrls(afterUrl));
                }
            } else {
                ret.add(Pair.of(message, sectionType.REGULAR_TEXT));
            }
            return ret;
        }

        private static List<Pair<String, sectionType>> separateModifiers(String message) {
            List<Pair<String, sectionType>> ret = new ArrayList<>();

            boolean insideExpression = false;
            message = message.replace("%%","% %");
            String[] arr = message.split("%");
            for (String item: arr) {
                if (insideExpression) {
                    if (item.equals(" ")) {
                        ret.add(Pair.of("|",sectionType.REGULAR_TEXT));
                    } else {
                        ret.add(Pair.of(item.replace(" ",""),sectionType.STYLE_MODIFIER));
                    }
                } else {
                    if (!item.equals("")) {
                        ret.add(Pair.of(item, sectionType.REGULAR_TEXT));
                    }
                }
                insideExpression = !insideExpression;
            }

            return ret;
        }

        private static List<Pair<String, sectionType>> separateSections(String message) {
            List<Pair<String, sectionType>> ret = new ArrayList<>();
            List<Pair<String, sectionType>> urlSeparated = separateUrls(message);
            for (Pair<String, sectionType> item: urlSeparated) {
                if (item.second.equals(sectionType.URL)) {
                    ret.add(item);
                } else {
                    ret.addAll(separateModifiers(item.first));
                }
            }

            return ret;
        }

        private static Component buildFancyComponent(List<Pair<String, sectionType>> messageParts) {
            MutableComponent newMessage = MutableComponent.create(ComponentContents.EMPTY);
            Style currentStyle = Style.EMPTY;

            for (Pair<String, sectionType> item: messageParts) {
                switch (item.second) {
                    case URL -> {
                        String url = item.first;
                        String text = item.first;
                        if (item.first.contains(",")) {
                            String[] brokenUrl = item.first.split(",");
                            url = brokenUrl[0];
                            text = brokenUrl[1];
                        }
                        ClickEvent urlEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, url);
                        HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.literal(url));
                        newMessage.append(Component.literal(text).withStyle(Style.EMPTY.withClickEvent(urlEvent).withItalic(true).withColor(ChatFormatting.BLUE).withUnderlined(true).withHoverEvent(hoverEvent)));
                    }
                    case STYLE_MODIFIER -> currentStyle = editStyle(currentStyle, item.first);
                    case REGULAR_TEXT -> newMessage.append(Component.literal(item.first).withStyle(currentStyle));
                }
            }
            return newMessage;
        }

        private static String replaceSymbols(String string) {
            StringBuilder ret = new StringBuilder();
            string = string.replace("$$","$ $");
            String[] arr = string.split("\\$");
            boolean inExpression = false;
            for (String item: arr) {
                if (inExpression) {
                    if (item.startsWith("#")) {
                        try {
                            int i = HexFormat.fromHexDigits(item.substring(1));
                            ret.appendCodePoint(i);
                        } catch (Exception ignored) {}
                    } else {
                        if (advancedChat.chatMap.get(item.toLowerCase()) != null) {
                            ret.append(advancedChat.chatMap.get(item.toLowerCase()));
                        }
                    }
                } else {
                    ret.append(item);
                }
                inExpression = !inExpression;
            }
            return ret.toString();
        }

    }
}
