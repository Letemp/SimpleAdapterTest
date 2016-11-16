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
		
		String[] names =new String[]{"��������","ǳ��","Ƽˮ���"};//�ǳ�����
		String[] infos =new String[]{"����ǩ����ħ����","����ǩ����ƴ����","����ǩ����������ϲ��"};//ǩ������
		int[] imageids=new int[]{R.drawable.i1,R.drawable.i2,R.drawable.i3};//ͷ��ͼƬID
		
		/*��ÿһ����������ݹ�������������ÿһ���˵���Ϣ����һ���������Map���󱣴�ÿһ������ݣ�һ��Map�������һ�����ݣ�
		 * Map����ļ��Ͼ��������������*/
		
		//����һ�����ϣ������е�Ԫ��ΪMap���ͣ�Map�����keyΪString���ͣ�ֵΪObject����
		List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();
		
		//forѭ����ÿ�����ݹ�������
		for(int i=0;i<names.length;i++){
			
			/*����Map�����д�ŵ����ݼ���String����int������Map���������ΪMap<String,Object>*/
			
			//����һ��Map�������ڴ�ŵ������ݣ�һ��Map��������б��е�һ������
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("img", imageids[i]);//��ͷ�����Map����
			map.put("title", names[i]);//���ǳƷ���Map����
			map.put("info", infos[i]);//��ǩ������Map����
			listItems.add(map);//��Map������ӵ�������
		}
		
		/*����Դ����ú󣬽��������Ĳ����ļ�������������Ҫ����Adapter������SimpleAdapter����ʱ����Ҫ����5������
		 * ��һ����Context����Adapter�������������Ķ���ͨ���ǵ�ǰ��Activity
		 * �ڶ���������Դ��ͨ����һ������򼯺�
		 * ��������ÿһ���Ӧ�Ĳ����ļ�
		 * ���ĸ�����ʾ������ÿ���ֵ���Դ
		 * ���������ʾÿ������������Ӧ�Ľ���ؼ�id�����ҿؼ�id�������ڵ����������Ĳ��ֵ��ļ��ж����*/
		
		//����SimpleAdapter
		SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.activity_main,
				new String[]{"title","info","img"},new int[]{R.id.title,R.id.info,R.id.img});
		//��Adapter�������б����
		setListAdapter(simpleAdapter);
	}

}
