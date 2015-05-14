# ListViewDemo
##listview保留点击选中的样式

最近在工作中遇到了需要保留listview的选中效果使用户知道当前浏览条目的需求，故而通过百度加一些自己写的修改找到了一个合适的方式。

代码在工程里面，要点是要在listview中添加`android:choiceMode="singleChoice"`的属性设置，这样是确保listview只能选中单条item，其他的都在代码中，较为容易理解。
