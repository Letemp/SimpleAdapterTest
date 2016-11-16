package book.chapter10.simpleadaptertest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.ListActivity;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		String[] names =new String[]{"明天会更好","浅川","萍水相逢"};//昵称数据
		String[] infos =new String[]{"个性签名：魔剑！","个性签名：拼搏！","个性签名：不求人喜！"};//签名数据
		int[] imageids=new int[]{R.drawable.i1,R.drawable.i2,R.drawable.i3};//头像图片ID
		
		/*将每一项各部分数据关联起来，即将每一个人的信息放在一起。这里采用Map对象保存每一项的数据，一个Map对象就是一项数据，
		 * Map对象的集合就是所有项的数据*/
		
		//定义一个集合，集合中的元素为Map类型，Map对象的key为String类型，值为Object类型
		List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();
		
		//for循环将每项数据关联起来
		for(int i=0;i<names.length;i++){
			
			/*由于Map对象中存放的数据既有String又有int，所以Map对象的声明为Map<String,Object>*/
			
			//创建一个Map对象，用于存放单项数据，一个Map对象就是列表中的一项数据
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("img", imageids[i]);//将头像放入Map对象
			map.put("title", names[i]);//将昵称放入Map对象
			map.put("info", infos[i]);//将签名放入Map对象
			listItems.add(map);//将Map对象添加到集合中
		}
		
		/*数据源定义好后，将其与具体的布局文件关联起来，需要借助Adapter。创建SimpleAdapter对象时，需要传递5个参数
		 * 第一个：Context，即Adapter所依赖的上下文对象，通常是当前的Activity
		 * 第二个：数据源，通常是一个数组或集合
		 * 第三个：每一项对应的布局文件
		 * 第四个：表示单项中每部分的来源
		 * 第五个：表示每部分数据所对应的界面控件id，并且控件id必须是在第三个参数的布局的文件中定义的*/
		
		//创建SimpleAdapter
		SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.activity_main,
				new String[]{"title","info","img"},new int[]{R.id.title,R.id.info,R.id.img});
		//将Adapter对象与列表关联
		setListAdapter(simpleAdapter);
	}

}
