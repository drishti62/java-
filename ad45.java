[8:09 AM, 2/23/2024] Sanika Ture: import java.io.*;

class ConsoleDemo {

public static void main(String args[]) {

String str;

Console con;
[8:20 AM, 2/23/2024] Sanika Ture: // Obtain a reference to the console. con = System.console();

// If no console available, exit.

if (con == null) return;

// Read a string and then display it.

str

= con.readLine("Enter a string: "); con.printf("Here is your string: %s\n", str);

}

}