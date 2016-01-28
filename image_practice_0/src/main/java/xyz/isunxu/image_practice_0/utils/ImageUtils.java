package xyz.isunxu.image_practice_0.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
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


}

