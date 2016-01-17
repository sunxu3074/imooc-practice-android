#### 用ViewPager实现tab笔记

- ImageButton 设置src,background.当点击改变背景时用imageButton.setImageResoure(R.drawable.xxx=);才会生效.
- 父布局会将点击事件传给ImageButton,而ImageButton并没有处理点击事件.

  解决方案1 为ImageButton添加监听器处理点击事件(笨)

  解决方案2 将ImageButton设置为不可点击 clickable="false";

- 大致流程

 绘制布局,top,viewpager,bottom.
 
 initViews();
 
 initDatas(); // setPagerAdapter(); 重写4个方法
 
 initListeners(); // 为底部每个tab添加监听器,为viewpager添加监听器.(点击tab,viewPager动,点viewpager,tab跟着动)
