class Box {

private double width;

private double height;

private double depth;

// construct clone of an object

Box (Box ob) { // pass object to constructor

width ob.width;

height ob.height;

}

depth ob.depth;

// constructor used when all dimensions specified Box (double w, double h, double d) {

width = wi

height = h;

depth = d;

}

// constructor used when no dimensions specified Box () { height = -1; // an uninitialized

width = -1; // use -1 to indicate

depth = -1; // box

}

// constructor used when cube is created

Box (double len) {

width= height = depth = len;

}

// compute and return volume double volume () { return width height depth;

}

}

// BoxWeight now fully implements all constructors.

class BoxWeight extends Box { double weight; // weight of box

// construct clone of an object.

BoxWeight (BoxWeight ob) { // pass object to constructor super (ob);

weight ob.weight;

}

// constructor when all parameters are specified BoxWeight (double w, double h, double d, double m) {
super(w, h, d); // call superclass constructor weight = m;

}

// default constructor

BoxWeight () {

super();

}

weight = -1;

// constructor used when cube is created.

BoxWeight (double len, double m) {

super (len);

weight = m;

}

}

class DemoSuper {

public static void main(String args[]) {

BoxWeight mybox1 = new BoxWeight (10, 20, 15, 34.3); BoxWeight mybox2 BoxWeight mybox3 BoxWeight mycube BoxWeight myclone double vol; new BoxWeight (2, 3, 4, 0.076); new BoxWeight(); // default new BoxWeight (3, 2); new BoxWeight (myboxl);

vol myboxl.volume();

System.out.println("Volume of myboxl is " + vol); System.out.println("Weight of myboxl is " + myboxl.weight); System.out.println();

vol mybox2.volume();

System.out.println("Volume of mybox2 is " + vol); System.out.println("Weight of mybox2 is " + mybox2.weight); System.out.println();

vol mybox3.volume();

System.out.println("Volume of mybox3 is " + vol); System.out.println("Weight of mybox3 is " + mybox3.weight); System.out.println();

vol myclone.volume();

System.out.println("Volume of myclone is " + vol); System.out.println("Weight of myclone is " + myclone.weight); System.out.println();

vol mycube.volume();

System.out.println("Volume of mycube is " + vol); System.out.println("Weight of mycube is " + mycube.weight); System.out.println();

}

}
class A {

int i;

}

// Create a subclass by extending class A.
class B extends A {

int i; // this i hides the i in A

B(int a, int b) {

super. i = a; // i in A

i = b; // i in B

}

void show() {

System.out.println("i in superclass: 11 + super.i);

System.out.println("i in subclass:

+ i);

}

}

class UseSuper {

public static void main(String args[]) { B subob new B(1, 2);

subob.show();

}

}