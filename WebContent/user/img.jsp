<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Random"%>
<%@ page import="java.awt.*" %>
<%@ page language="java" contentType="image/jpeg; charset=utf-8"%>


<%!
	//随机产生颜色
	public Color getColor(){
		Random random = new Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
	
		return new Color(r,g,b);
	}

	//随机产生数值
	public String getNum(){
		int ran = (int)(Math.random()*9000+1000);
		return String.valueOf(ran);
	}
%>


<%
	//禁止缓存，防止验证码过期
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	
	//绘制验证码
	BufferedImage image = new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);
	Graphics graphics = image.getGraphics();
	graphics.fillRect(0, 0, 80, 30);
	//绘制干扰线条
	for(int i=0;i<60;i++){
		Random random = new Random();
		int xBegin = random.nextInt(80);
		int yBegin = random.nextInt(80);
		int xEnd = random.nextInt(xBegin+10);
		int yEnd = random.nextInt(yBegin+10);
		
		graphics.setColor(getColor());
		graphics.drawLine(xBegin, yBegin, xEnd, yEnd);
	}
	//绘制 验证码
	graphics.setColor(Color.black);
	String checkString=getNum();
	StringBuffer sb = new StringBuffer();
	for(int i=0;i<checkString.length();i++){
		sb.append(checkString.charAt(i)+" ");
	}
	
	graphics.drawString(sb.toString(), 20, 15);
	
	//将验证码真实值保存起来 
	session.setAttribute("cc", checkString);
	
	ImageIO.write(image, "jpeg", response.getOutputStream());
	
	
	//关闭
	out.clear();
	out=pageContext.pushBody(); //<input type="image" src="">
%>

