package xyz.isunxu.image_practice_0.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by sunxu on 16/1/28.
 */
public class ImageUtils {
    /**
     * 根据具体给定的bitmap,色调 饱和度及亮度生成新的bitmap
     *
     * @param tone 色调
     * @param saturation 饱和度
     * @param lum 亮度
     * @return new bitmap
     */
    public static Bitmap handleImageMatrix(Bitmap bm, float tone, float saturation, float lum) {
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        // 色调
        ColorMatrix toneMatrix = new ColorMatrix();
        toneMatrix.setRotate(0, tone);
        toneMatrix.setRotate(1, tone);
        toneMatrix.setRotate(2, tone);

        // 饱和度
        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        // 亮度
        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum, 1);

        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(toneMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        canvas.drawBitmap(bm, 0, 0, paint);
        return bitmap;
    }


    /**
     * 根据给定的bitmap,具体的矩阵生成新的bitmap
     *
     * @param bm 原图的bitmap
     * @param matrixs Assign the array of floats into this matrix, copying all of its values.
     * @return new bitmap
     */
    public static Bitmap handleColorMatrix(Bitmap bm, float[] matrixs) {
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(matrixs);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(bm, 0, 0, paint);

        return bitmap;
    }


    /**
     * 灰色效果
     * @param bm
     * @return
     */
    public static Bitmap generateGrayImage(Bitmap bm) {
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        float[] matrixs = new float[] {
                0.33f, 0.59f, 0.11f, 0, 0,
                0.33f, 0.59f, 0.11f, 0, 0,
                0.33f, 0.59f, 0.11f, 0, 0,
                0, 0, 0, 1, 0
        };

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(matrixs);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(bm, 0, 0, paint);

        return bitmap;
    }


    /**
     * 图像反转
     * @param bm
     * @return
     */
    public static Bitmap revertImage(Bitmap bm) {
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        float[] matrixs = new float[] {
                -1, 0,0,1,1,
                0,-1,0,1,1,
                0,0,-1,1,1,
                0,0,0,1,0
        };

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(matrixs);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(bm, 0, 0, paint);

        return bitmap;
    }


    /**
     * 怀旧效果
     * @param bm
     * @return
     */
    public static Bitmap memoriesImage(Bitmap bm) {
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        float[] matrixs = new float[] {
                0.393f,0.769f,0.189f,0,0,
                0.349f,0.686f,0.168f,0,0,
                0.272f,0.534f,0.134f,0,0,
                0,0,0,1,0
        };

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(matrixs);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(bm, 0, 0, paint);

        return bitmap;
    }


    /**
     * 去色效果
     * @param bm
     * @return
     */
    public static Bitmap desaturateImage(Bitmap bm) {
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        float[] matrixs = new float[] {
                1.5f,1.5f,1.5f,0,-1,
                1.5f,1.5f,1.5f,0,-1,
                1.5f,1.5f,1.5f,0,-1,
                0 ,0 ,0,1,0
        };

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(matrixs);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(bm, 0, 0, paint);

        return bitmap;
    }


    /**
     * 高饱和度效果
     * @param bm
     * @return
     */
    public static Bitmap highSaturationImage(Bitmap bm) {
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        float[] matrixs = new float[] {
               1.438f,-0.122f,-0.016f,0,-0.03f,
               -0.062f,1.378f,-0.016f,0,0.05f,
                -0.062f,-0.122f,1.438f,0,-0.02f,
                0,0,0,1,0
        };

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(matrixs);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(bm, 0, 0, paint);

        return bitmap;
    }


    public static Bitmap backsheetImage(Bitmap bm) {

        int width = bm.getWidth();
        int height = bm.getHeight();
        int color ;
        int r,g,b,a;

        Bitmap bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);

        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];

        bm.getPixels(oldPx, 0, width, 0, 0, width, height);

        for (int i=0;i<oldPx.length;i++) {
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r= 255- r;
            g= 255- g;
            b= 255- b;

            if (r > 255) {
                r = 255;
            }
            else if (r < 0) {
                r = 0;
            }

            if (g > 255) {
                g = 255;
            }
            else if (g< 0) {
                g = 0;
            }

            if (b > 255) {
                b = 255;
            }
            else if (b < 0) {
                b = 0;
            }

            newPx[i] = Color.argb(a, r, g, b);
        }

        bitmap.setPixels(newPx, 0, width, 0, 0, width, height);
        return bitmap;
    }

 public static Bitmap olderImage(Bitmap bm) {

        int width = bm.getWidth();
        int height = bm.getHeight();
        int color ;
        int r,g,b,a;

        Bitmap bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);

        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];

        bm.getPixels(oldPx, 0, width, 0, 0, width, height);

        for (int i=0;i<oldPx.length;i++) {
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r= (int)(0.393*r+0.769*g+0.189*b);
            g= (int)(0.349*r+0.686*g+0.168*b);
            b= (int)(0.272*r+0.534*g+0.131*b);

            if (r > 255) {
                r = 255;
            }
            else if (r < 0) {
                r = 0;
            }

            if (g > 255) {
                g = 255;
            }
            else if (g< 0) {
                g = 0;
            }

            if (b > 255) {
                b = 255;
            }
            else if (b < 0) {
                b = 0;
            }

            newPx[i] = Color.argb(a, r, g, b);
        }

        bitmap.setPixels(newPx, 0, width, 0, 0, width, height);
        return bitmap;
    }

 public static Bitmap reliefImage(Bitmap bm) {

        int width = bm.getWidth();
        int height = bm.getHeight();
        int color ;
        int r,g,b,a;

        Bitmap bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);

        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];

        bm.getPixels(oldPx, 0, width, 0, 0, width, height);

        for (int i=1;i<oldPx.length;i++) {
            color = oldPx[i-1];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            int nextColor = oldPx[i];
            int r1 = Color.red(nextColor);
            int g1 = Color.green(nextColor);
            int b1 = Color.blue(nextColor);

            r= r1-r+127;
            g= g1-g+127;
            b= b1-b+127;

            if (r > 255) {
                r = 255;
            }
            else if (r < 0) {
                r = 0;
            }

            if (g > 255) {
                g = 255;
            }
            else if (g< 0) {
                g = 0;
            }

            if (b > 255) {
                b = 255;
            }
            else if (b < 0) {
                b = 0;
            }

            newPx[i] = Color.argb(a, r, g, b);
        }

        bitmap.setPixels(newPx, 0, width, 0, 0, width, height);
        return bitmap;
    }


}

