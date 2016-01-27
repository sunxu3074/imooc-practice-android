#### 色彩特效处理

> 图片都是由点阵和颜色值组成的.
> - 所谓点阵就是一个包含像素的矩阵,每一个元素对应着图片上的一个像素.
> - 颜色值即ARGB. 分别对应着alpha,red,green,blue.

色彩处理中通常使用一下三个角度来描述一个图像.

- 色调(tone)
- 饱和度(saturation)
- 亮度(sluminance)

Android本身封装了一些API用于快速调整矩阵来实现改变色光属性.

```
// 改变色调
// 0,1,2分别代表Red,Green,Blue
// tone 代表角度 通常范围[-180,180]
ColorMatrix toneMatrix = new ColorMatrix();
toneMatrix.setRotate(0,tone);
toneMatrix.setRotate(1,tone);
toneMatrix.setRotate(2,tone);
```

```
// 改变饱和度
// saturation[0,2] 当饱和度为0时,图像就变为灰色图像了
ColorMatrix saturationMatrix = new ColorMatrix();
saturationMatrix.setSaturation(saturation);
```

```
// 改变亮度
// lum[0,2] 当亮度为0时,图像就变为全黑了.
ColorMatrix lumMatrix = new ColorMatrix();
lumMatrix.setScale(lum,lum,lum,1);
```

**postConcat()**方法来讲矩阵的作用效果混合,从而叠加处理效果.

```
ColorMatrix imageMatrix = new ColorMatrix();
imageMatrix.postConcat(toneMatrix);
imageMatrix.postConcat(saturationMatrix);
imageMatrix.postConcat(lumMatrix);
```
