<%@ page import="controller.CaptchaGenerator" %>
<%@ page contentType="image/jpeg" %>
<% 
    String captchaText = CaptchaGenerator.generateCaptchaText();
    java.awt.Image captchaImage = CaptchaGenerator.generateCaptchaImage(captchaText);
    javax.imageio.ImageIO.write((java.awt.image.RenderedImage) captchaImage, "jpeg", response.getOutputStream());
%>