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
	//����first�ڵ�
	private Person first=new Person(-1);
	
	//��ӳ�Ա�����ɻ��ζ���
	public void add(int num) {
		if(num<1) {
			System.out.println("numֵ����");
			return;
		}
		Person cur=null;
		for(int i=1;i<=num;i++) {
			//���ݱ�Ŵ�����Ա
			Person person=new Person(i);
			//����ǵ�һ����Ա
			if(i==1) {
				first=person;
				first.setNext(first);//���ɻ�
				cur=first;
			}else {
				cur.setNext(person);//ָ����һ���ڵ�
				person.setNext(first);//ָ���һ���ڵ�
				cur=person;//����
			}
		}
	}
	
	//�����Ȧ˳��
	//startNo��ʼ��λ��
	//countNum������
	//num��Ա��
	public void countPerson(int startNo,int countNum,int num) {
		//��֤���ݺ�����
		if(first==null||startNo<1||startNo>num) {
			System.out.println("�����������,����������");
			return;
		}
		//��������ָ��
		Person temp=first;
		while(true) {
			if(temp.getNext()==first) {
				break;
			}
			temp=temp.getNext();
		}
		//����ǰ������first��temp�ƶ�startNo-1��
		for(int j=0;j<startNo-1;j++) {
			first=first.getNext();
			temp=temp.getNext();
		}
		//����ʱ����first��tempͬʱ�ƶ�countNum-1�Σ�Ȼ���Ȧ
		//ѭ����ֱ��ֻ��һ����Ա
		while(true) {
			if(temp==first) {//ֻ��һ����Ա
				break;
			}
			//first��tempͬʱ�ƶ�countNum-1
			for(int j=0;j<countNum-1;j++) {
				first=first.getNext();
				temp=temp.getNext();
			}
			//��ʱfirstָ��Ľڵ���ǳ�Ȧ�ĳ�Ա
			System.out.printf("%d��Ȧ",first.getNo());
			//��Ȧ
			first=first.getNext();
			temp.setNext(first);
		}
		System.out.println("�������Ȧ�ڵ��ǳ�Ա"+first.getNo());
	}
	
	//������������
	public void showcircleLinkedList() {
		if(first==null) {
			System.out.println("����Ϊ��");
			return;
		}
		Person cur=first;
		while(true) {
			System.out.println(cur.getNo());
			if(cur.getNext()==first) {//ִ�е���˵���������
				break;
			}
			cur=cur.getNext();//����
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