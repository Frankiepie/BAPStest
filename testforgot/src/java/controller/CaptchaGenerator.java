/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaGenerator {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 50;
    private static final int FONT_SIZE = 30;
    private static final int NUM_CHARS = 5;

    public static String generateCaptchaText() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < NUM_CHARS; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public static BufferedImage generateCaptchaImage(String captchaText) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        Random random = new Random();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        for (int i = 0; i < captchaText.length(); i++) {
            int x = i * (WIDTH / NUM_CHARS);
            int y = HEIGHT / 2 + random.nextInt(HEIGHT / 2);
            g2d.drawChars(new char[] { captchaText.charAt(i) }, 0, 1, x, y);
        }
        g2d.dispose();
        return image;
    }
}