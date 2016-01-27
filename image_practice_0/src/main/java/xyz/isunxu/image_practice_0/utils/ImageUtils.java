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
     * @param bm
     * @param tone 色调
     * @param saturation 饱和度
     * @param lum 亮度
     * @return 生成新的bitmap
     */
    public static Bitmap handleImageMatrix(Bitmap bm,float tone,float saturation,float lum) {
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
        canvas.drawBitmap(bm,0,0,paint);
        return bitmap;
    }
}

