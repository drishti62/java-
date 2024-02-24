class VarArgs4 {

static void vaTest (int v) {

System.out.print("vaTest (int...): " +

"Number of args: + v.length + 11 Contents: ");

for (int x: v)

System.out.print(x + "); 11

System.out.println();

}

static void vaTest (boolean... v) {

System.out.print("vaTest (boolean ...) " +

11 "Number of args: + v.length + 11 Contents: ");

for (boolean x : v)

System.out.print(x + 11 ");

System.out.println();

}

public static void main(String args[]) {
vaTest (1, 2, 3); // OK

vaTest (true, false, false); // OK

vaTest(); // Error: Ambiguous!

}

}