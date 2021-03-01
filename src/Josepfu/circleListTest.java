package Josepfu;

public class circleListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleLinkedList cll=new CircleLinkedList();
		cll.add(5);
		cll.showcircleLinkedList();
		
		cll.countPerson(1, 2, 5);
	}

}
class CircleLinkedList{
	//创建first节点
	private Person first=new Person(-1);
	
	//添加成员，构成环形队列
	public void add(int num) {
		if(num<1) {
			System.out.println("num值错误");
			return;
		}
		Person cur=null;
		for(int i=1;i<=num;i++) {
			//根据编号创建成员
			Person person=new Person(i);
			//如果是第一个成员
			if(i==1) {
				first=person;
				first.setNext(first);//构成环
				cur=first;
			}else {
				cur.setNext(person);//指向下一个节点
				person.setNext(first);//指向第一个节点
				cur=person;//后移
			}
		}
	}
	
	//计算出圈顺序
	//startNo开始的位置
	//countNum报的数
	//num成员数
	public void countPerson(int startNo,int countNum,int num) {
		//验证数据合理性
		if(first==null||startNo<1||startNo>num) {
			System.out.println("参数输入错误,请重新输入");
			return;
		}
		//创建辅助指针
		Person temp=first;
		while(true) {
			if(temp.getNext()==first) {
				break;
			}
			temp=temp.getNext();
		}
		//报数前，先让first和temp移动startNo-1次
		for(int j=0;j<startNo-1;j++) {
			first=first.getNext();
			temp=temp.getNext();
		}
		//报数时，让first和temp同时移动countNum-1次，然后出圈
		//循环，直到只有一个成员
		while(true) {
			if(temp==first) {//只有一个成员
				break;
			}
			//first和temp同时移动countNum-1
			for(int j=0;j<countNum-1;j++) {
				first=first.getNext();
				temp=temp.getNext();
			}
			//此时first指向的节点就是出圈的成员
			System.out.printf("%d出圈",first.getNo());
			//出圈
			first=first.getNext();
			temp.setNext(first);
		}
		System.out.println("最后留在圈内的是成员"+first.getNo());
	}
	
	//遍历环形链表
	public void showcircleLinkedList() {
		if(first==null) {
			System.out.println("链表为空");
			return;
		}
		Person cur=first;
		while(true) {
			System.out.println(cur.getNo());
			if(cur.getNext()==first) {//执行到这说明遍历完毕
				break;
			}
			cur=cur.getNext();//后移
		}
	}
}
class Person{
	private int no;
	private Person next;
	public Person() {
		super();
	}
	public Person(int no) {
		super();
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Person getNext() {
		return next;
	}
	public void setNext(Person next) {
		this.next = next;
	}	
}