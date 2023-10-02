1. 访问/add 可以增加一个学校
2. 访问/list 可以复现Typehandler在查询时无法正常工作的问题
3. 访问/order 可以复现`School::id.toOrd()`产生的sql语句里有base_entity的问题
4. 访问/order2 可以看到`School::id.column().toOrd()`一切正常