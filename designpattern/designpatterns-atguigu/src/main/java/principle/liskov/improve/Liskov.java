package principle.liskov.improve;

public class Liskov {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		System.out.println("11-3=" + a.func1(11, 3));
		System.out.println("1-8=" + a.func1(1, 8));

		System.out.println("-----------------------");
		B b = new B();
		//锟斤拷为B锟洁不锟劫继筹拷A锟洁，锟斤拷说锟斤拷锟斤拷撸锟斤拷锟斤拷锟斤拷锟絝unc1锟斤拷锟斤拷锟斤拷锟�
		//锟斤拷锟斤拷锟斤拷傻墓锟斤拷芫突锟斤拷锟斤拷确
		System.out.println("11+3=" + b.func1(11, 3));//锟斤拷锟斤本锟斤拷锟斤拷锟斤拷锟�11+3
		System.out.println("1+8=" + b.func1(1, 8));// 1+8
		System.out.println("11+3+9=" + b.func2(11, 3));


		//使锟斤拷锟斤拷锟斤拷锟饺伙拷锟斤拷锟绞癸拷玫锟紸锟斤拷锟斤拷胤锟斤拷锟�
		System.out.println("11-3=" + b.func3(11, 3));// 锟斤拷锟斤本锟斤拷锟斤拷锟斤拷锟�11-3


	}

}

//锟斤拷锟斤拷一锟斤拷锟斤拷锟接伙拷锟斤拷锟侥伙拷锟斤拷
class Base {
	//锟窖革拷锟接伙拷锟斤拷锟侥凤拷锟斤拷锟酵筹拷员写锟斤拷Base锟斤拷
}

// A锟斤拷
class A extends Base {
	// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟侥诧拷
	public int func1(int num1, int num2) {
		return num1 - num2;
	}
}

// B锟斤拷坛锟斤拷锟紸
// 锟斤拷锟斤拷锟斤拷一锟斤拷锟铰癸拷锟杰ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷,然锟斤拷锟�9锟斤拷锟�
class B extends Base {
	//锟斤拷锟紹锟斤拷要使锟斤拷A锟斤拷姆锟斤拷锟�,使锟斤拷锟斤拷瞎锟较�
	private A a = new A();

	//锟斤拷锟斤，锟斤拷写锟斤拷A锟斤拷姆锟斤拷锟�, 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷识
	public int func1(int a, int b) {
		return a + b;
	}

	public int func2(int a, int b) {
		return func1(a, b) + 9;
	}

	//锟斤拷锟斤拷锟斤拷然锟斤拷使锟斤拷A锟侥凤拷锟斤拷
	public int func3(int a, int b) {
		return this.a.func1(a, b);
	}
}
