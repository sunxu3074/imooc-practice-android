#### 用ViewPager实现tab笔记

- ImageButton 设置src,background.当点击改变背景时用imageButton.setImageResoure(R.drawable.xxx=);才会生效.

 > setBackgroundResource is for setting the background of an ImageView;setImageResource is for setting the src image of the ImageView.
 
- 父布局会将点击事件传给ImageButton,而ImageButton并没有处理点击事件.

  解决方案1 为ImageButton添加监听器处理点击事件(笨)

  解决方案2 将ImageButton设置为不可点击 clickable="false";

- 大致流程

 绘制布局,top,viewpager,bottom.
 
 initViews();
 
 initDatas(); // setPagerAdapter(); 重写4个方法
 
 initListeners(); // 为底部每个tab添加监听器,为viewpager添加监听器.(点击tab,viewPager动,点viewpager,tab跟着动)


#### 用Fragment实现tab笔记

- Button上写入英文字母会显示大写 在xml中添加android:textAllCaps="false"
- tab之间的fragment会存在点击穿透问题.让每个fragment都继承onTouchListener,重写onTouch();return true即可.
- 大致流程
  
  绘制布局,top,FrameLayout,bottom;

  initView();
  
  initListeners(); //这里只存在点击底部四个tab区域,然后让fragment跟着动就行.FragmentTransaction.hide();FragmentTransaction.sh   ow();FragmentTransaction.commit();
  
  
#### 用FragmentPagerAdapter+ViewPager实现tab笔记
  
 - 和使用ViewPager实现Tab页面类似,不同的是数据源不一样.一个是List\<View\>,一个是List\<FragmentPagerAdapter\>.
 
#### 用TabLayout实现tab笔记
  
 
   ```java
   <android.support.design.widget.TabLayout
        app:tabGravity="fill"                   // fill or center
        app:tabIndicatorColor="#18a342"         // 指示器颜色
        app:tabIndicatorHeight="3dp"            // 指示器的高度
        app:tabMode="fixed"                     // fixed or scrollable 
        app:tabSelectedTextColor="#18a342"      // 选中文本颜色
        app:tabTextColor="#ffffffff"            // 默认文本颜色
        app:tabBackground="@drawable/bottom_bar" // background
        />
   ```
   
 大致流程
   
  - initViews();
  - initDatas(); // 先初始化ViewPager里面的数据(List\<FragmentPagerAdapter\>),然后tabLayout.setupWithViewPager(mViewPager);
   
> tabLayout.getTabAt(position).select(); //指定position位置为点击状态
 
