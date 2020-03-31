package gui;

import entities.Entity;
import escape.*;
import escape_Level.Level;
import escape_Level_Block.*;

public class Bitmap3D extends Bitmap {
	private double[] zBuffer;
	private double[] zBufferWall;
	private double xCam, yCam, zCam, rCos, rSin, fov, xCenter, yCenter, rot;

	public Bitmap3D(int width, int height) {
		super(width, height);

		zBuffer = new double[width * height];
		zBufferWall = new double[width];
	}

	public void render(Game game) {
		
	}

	private void renderFloor(Level level) {
		for (int y = 0; y < height; y++) {
			double yd = ((y + 0.5) - yCenter) / fov;

			boolean floor = true;
			double zd = (4 - zCam * 8) / yd;
			if (yd < 0) {
				floor = false;
				zd = (4 + zCam * 8) / -yd;
			}

			for (int x = 0; x < width; x++) {
				if (zBuffer[x + y * width] <= zd) continue;

				double xd = (xCenter - x) / fov;
				xd *= zd;

				double xx = xd * rCos + zd * rSin + (xCam + 0.5) * 8;
				double yy = zd * rCos - xd * rSin + (yCam + 0.5) * 8;

				int xPix = (int) (xx * 2);
				int yPix = (int) (yy * 2);
				int xTile = xPix >> 4;
				int yTile = yPix >> 4;

				Block block = level.getBlock(xTile, yTile);
				int col = block.floorCol;
				int tex = block.floorTex;
				if (!floor) {
					col = block.ceilCol;
					tex = block.ceilTex;
				}

				if (tex < 0) {
					zBuffer[x + y * width] = -1;
				} else {
					zBuffer[x + y * width] = zd;
					pixels[x + y * width] = Art.floors.pixels[((xPix & 15) + (tex % 8) * 16) + ((yPix & 15) + (tex / 8) * 16) * 128];
				}
			}
		}

	}

	private void renderSprite(double x, double y, double z, int tex, int color) {
		double xc = (x - xCam) * 2 - rSin * 0.2;
		double yc = (y - zCam) * 2;
		double zc = (z - yCam) * 2 - rCos * 0.2;

		double xx = xc * rCos - zc * rSin;
		double yy = yc;
		double zz = zc * rCos + xc * rSin;

		if (zz < 0.1) return;

		double xPixel = xCenter - (xx / zz * fov);
		double yPixel = (yy / zz * fov + yCenter);

		double xPixel0 = xPixel - height / zz;
		double xPixel1 = xPixel + height / zz;

		double yPixel0 = yPixel - height / zz;
		double yPixel1 = yPixel + height / zz;

		int xp0 = (int) Math.ceil(xPixel0);
		int xp1 = (int) Math.ceil(xPixel1);
		int yp0 = (int) Math.ceil(yPixel0);
		int yp1 = (int) Math.ceil(yPixel1);

		if (xp0 < 0) xp0 = 0;
		if (xp1 > width) xp1 = width;
		if (yp0 < 0) yp0 = 0;
		if (yp1 > height) yp1 = height;
		zz *= 4;
		for (int yp = yp0; yp < yp1; yp++) {
			double ypr = (yp - yPixel0) / (yPixel1 - yPixel0);
			int yt = (int) (ypr * 16);
			for (int xp = xp0; xp < xp1; xp++) {
				double xpr = (xp - xPixel0) / (xPixel1 - xPixel0);
				int xt = (int) (xpr * 16);
				if (zBuffer[xp + yp * width] > zz) {
					int col = Art.sprites.pixels[(xt + tex % 8 * 16) + (yt + (tex / 8) * 16) * 128];
						if(col != 0xffFF00FF) {
						pixels[xp + yp * width] = col;
						zBuffer[xp + yp * width] = zz;
						}
					
				}
			}
		}

	}

	private void renderWall(double x0, double y0, double x1, double y1, int tex, int color) {
		renderWall(x0, y0, x1, y1, tex, color, 0, 1);
	}

	private void renderWall(double x0, double y0, double x1, double y1, int tex, int color, double xt0, double xt1) {
	
	}

	public void postProcess(Level level) {
		for (int i = 0; i < width * height; i++) {
			double zl = zBuffer[i];
			if (zl < 0) {
				int xx = ((int) Math.floor((i % width) - rot * 512 / (Math.PI * 2))) & 511;
				int yy = i / width;
				pixels[i] = Art.sky.pixels[xx + yy * 512] * 0x444455;
			} else {
				int xp = (i % width);
				int yp = (i / width) * 14;

				double xx = ((i % width - width / 2.0) / width);
				int col = pixels[i];
				int brightness = (int) (300 - zl * 6 * (xx * xx * 2 + 1));
				brightness = (brightness + ((xp + yp) & 3) * 4) >> 4 << 4;
				if (brightness < 0) brightness = 0;
				if (brightness > 255) brightness = 255;

				int r = (col >> 16) & 0xff;
				int g = (col >> 8) & 0xff;
				int b = (col) & 0xff;

				r = r * brightness / 255;
				g = g * brightness / 255;
				b = b * brightness / 255;

				pixels[i] = r << 16 | g << 8 | b;
			}
		}
	}
}
