* Written: 14/12/2023   
 By: Kimberly Njamen   
 Student No. X00214281   
 Description: Ohm's Law Resistance Calculator   
 Learning Objectives Checklist: 
 1. Design a GUI: Done 
 2. Declare a local and global variable and initialise them: Global variable- Lines 94-114 / Local- lines 309,313,325,329 
 3. Use a for and/ or while loop: Lines 325, 329 
 4. Implement if or an if else statement - Line 365+ 
 5. Use atleast one logical operator: Line 365+ 
 6. Declare and array and access each element of the array: Line 34 and line 351 
 7. Write a function, call and return a value from the function.: 1st Function- Written: Lines 305-357, Called and returned value : Line 292 / 2nd Function- Written: Lines 656-713, Called and returned value: line 472 
 8. Perform a calculation; Line 623 
 9. Use the mouse and/ or keyboard built in functions: Line 361 
 10. Fully comment all code and include title block: Done 
 */ 
 
 
String displayKeypad[][]={  // An array of strings storing a sequence of characters + curly brackets opens array 
  {   
    "1", "2", "3"  // Storing the characters "1", "2", "3 
  }   
  , {   

    "4", "5", "6"    // Storing the characters "1", "2", "3 
  }   

  , {   

    "7", "8", "9"   
 
  }   

  , {   
 
    "Clear", "0", "Calc"   

  }   
 
};   
 
// Initialises all the global variables  
 
int numeralvalue=0;  // Setting the initial value of the variable numeralvalue to 0 
int mouseclicks=0;  // Setting the initial value of the variable mouseclicks to 0 
int current=0;  // Setting the initial value of the variable current to 0 
 
float totalcurrent=0;  // Setting the initial value of the variable totalcurrent to 0 
int voltage=0;  // Setting the initial value of the variable voltage to 0 
int totalvoltage=0;  // Setting the initial value of the variable totalvoltage to 0 
float totalresistance=0;  // Setting the initial value of the variable totalresistance to 0 

void setup() {  // Function runs once to set up environment + curly bracket opens function 
  size(650, 650); //Sets Size of window set to 650 pizels by 650 pixels  
  background(255); //Sets the colour of the background to white  
  strokeWeight(5); //Sets the Thickness of lines to 5 pixels thick  
  // Lines draw circuit 
 
  line(40, 50, 300, 50); // Draws a line from points(40,50) to points (300,50) 
  line(40, 50, 40, 150);  // Draws a line from points (40,50) to points (40,150) 
  line(10, 150, 70, 150);  // Draws a line from points (10,150) to points (70,150) 
  line(20, 180, 60, 180);  // Draws a line from points (20,180) to points (60,180) 
  line(40, 180, 40, 280);  // Draws a line from points (40,180) to points (40,280) 
  line(40, 280, 300, 280);  // Draws a line from points (40,280) to points (300,280) 
  line(300, 50, 300, 280);  // Draws a line from points (300,50) to points (300,280) 
  rect(285, 115, 30, 70);  // Draws a rectangle of point (285,113), with a width of 30 pixels and a height of 70 
  line(20, 100, 20, 120);  // Draws a line from points (20,100) to points (20,120) 
  line(10, 110, 30, 110);  // Draws a line from points (10,110) to points (30,110) 
  line(10, 220, 30, 220);  // Draws a line from points (10,220) to points (30,220) 
  line(130, 50, 120, 45);  // Draws a line from points (130,50) to points (120,45) 
  line(130, 50, 120, 55);  // Draws a line from points (130,50) to points (120,55) 
  textSize(20);  // Sets the size of the text on the display window to 20 pixels 
  fill(0);  //Fills in all shaped and lines black 
  
  // Displays the Text around the circuit for current, resistance and voltage on the display window 
  text("Voltage Source = ", 30, 310); // Displays the text "Voltage Source" at points (30,310) on the display window 
  text("Total Resistance Value = ", 320.5, 110.5);  // Displays the text "Total Resistance Value" at points (320.5,110.5) on the display window 
  text("Current Value = ", 10, 20);  // Displays the text "Current Value" at points (10,20) on the display window 
  
  strokeWeight(1);  // Sets the thickness of lines to 1 pixel thick 
  println ("Input Voltage value"); // Displays/Prints the text "Input Voltage Value" to the console window 
  println ("Input Current value in m Amps, Programme will convert to Amps");  // Displays/ Prints the text "Input Current value in m Amps, Programme will convert to Amps" to the console window 
  fill(255);  //Fills in shapes white 
  rect(400, 304, 195, 53);  // Draws a rectangle of point (400,304) with a width of 195 pixels and a height of 53 
  fill(0);  // Fills in shapes and text black 
 
 
  //Displays the text for the calculation on the display window 
  text("Ohms law, V=I*R", 50, 450); // Displays the text "Ohm's Law, V=I*R" at points (50,450) on the display window 
  text("V = ", 45, 510);  // Displays the text "V = " at points (45,510) on the display window 
  text("R = V divided by I ", 50, 480);  // Displays the text "R= V divided by I" at points (50,480) on the display window 
  text( "I = ", 50, 540);  // Displays the text "I = " at points (50,450) on the display window 
  textSize(50);  //Sets the text size to 50 pixels  
  text("Calculation", 40, 400);  // Displays the text "Calculation" at points (40,400) on the display window 
  textSize(20);  //Sets text size back to 20 pixels 
  text( " Volts", 500, 340); // Displays the text "Volts" at points (500,340) on the display window 
  textSize(30); // Sets the text size to 30 pixels 
  text("Input Voltage", 400, 260); // Displays the text "Input Voltage" at points (400,260) on the display window 
  textSize(20); // Sets the text size to 20 
}  // Closes function 
 
 

void draw() {  // Function runs continuously and loops to refresh + curly brackets opens function 

  println(mouseX); 
  println(mouseY); 
  drawKeypad();  //Calls on the function drawKeypad() that draws a keypad  
  textSize(15); //Sets size of text to 15 pixels 
} // Closes function   
 
 
void drawKeypad() { // Function runs to draw a keypad +curly brackets opens function 
  int buttonSize= width/10;  // Sets the local variable buttonSize to an initial value of tw width of the display window divided by 10 
  int offSet4Text = buttonSize/2;  // Sets the local variable offSet4Text to an intial value of te value of the variable buttonSze divided by two 
  textSize(offSet4Text);  // Sets the text size to the value of the variable offSet4Text 
  textAlign(CENTER, CENTER);  // Aligns the text involved with the keypad to the centre  
  
  for (int j=0; j<=3; j++) {  // For loop statement : Initialising the value of the variable j to 0, questioning whether j is smaller than or equal to 3, if it is the value of j is incremented by 1 each time  
    for (int i=0; i<=2; i++) {  // Nested For loop statement: Initialising the value of the variable i to 0, questioning wether i is smaller than or equal to 2, if it is the value of i is incremented by 1 each time 
      fill(255);  // Fills in shapes and text white 
      rect((i*buttonSize)+400, j*buttonSize+ 380, buttonSize, buttonSize, 5);  // Draws a rectangle of points ((i*buttonsize)+400,(j*buttonSize)+380)) with a width of the value of the variable buttonSize, and a length of the vlue of the variable buttonSize, with the corners rounded off by 5 pixels 
      rect(465, 575, buttonSize, buttonSize, 5);  // Draws a rectangle from points (465,575), with a width and length of the value of the variable buttonSize, rounded off at the corners by 5 pixels 
      fill(0);  // Fills in shaped and text black 
      textSize(20);  // Sets the text size to 20 pixels 
      text(displayKeypad[j][i], offSet4Text +(i*buttonSize)+400, offSet4Text+(j*buttonSize)+380); // Displays the characters/numbers stored in the array of strings into the rectangles on the display window 
      text("O", 497, 607); // Displays the text "0" at points (497,607) on the display window 
    } 
  } 
}   
 
 
 
void mousePressed() {  // Function only runs when the mouse button is pressed + curly bracket opens function 
  if ((mouseX>400)&&(mouseY>381)&&(mouseX<465)&&(mouseY<444)) {  // if statement: If the co-ordinates of mouseX and mouseY are within these parameters  
    numeralvalue=1;  // Sets the value of the variable numeralvalue to 1 
  }   
  if ((mouseX>467)&&(mouseY>381)&&(mouseX<529)&&(mouseY<444)) { // if statement: If the co-ordinates of mouseX and mouseY are within these parameters   
    numeralvalue=2; // Sets the value of the variable numeralvalue to 2 
  }   
  if ((mouseX>532)&&(mouseY>381)&&(mouseX<593)&&(mouseY<444)) { // if statement: If the co-ordinates of mouseX and mouseY are within these parameters   
    numeralvalue=3; // Sets the value of the variable numeralvalue to 3 
  }   
  if ((mouseX>400)&&(mouseY>446)&&(mouseX<465)&&(mouseY<507)) {  // if statement: If the co-ordinates of mouseX and mouseY are within these parameters  
    numeralvalue=4; // Sets the value of the variable numeralvalue to 4 
  }   
  if ((mouseX>467)&&(mouseY>444)&&(mouseX<529)&&(mouseY<508)) {  // if statement: If the co-ordinates of mouseX and mouseY are within these parameters  
    numeralvalue=5; // Sets the value of the variable numeralvalue to 5 
  }   
  if ((mouseX>532)&&(mouseY>444)&&(mouseX<595)&&(mouseY<508)) {  // if statement: If the co-ordinates of mouseX and mouseY are within these parameters  
    numeralvalue=6; // Sets the value of the variable numeralvalue to 6 
  }   
  if ((mouseX>400)&&(mouseY>510)&&(mouseX<465)&&(mouseY<572)) {  // if statement: If the co-ordinates of mouseX and mouseY are within these parameters  
    numeralvalue=7; // Sets the value of the variable numeralvalue to 7 
  }   
  if ((mouseX>467)&&(mouseY>510)&&(mouseX<529)&&(mouseY<572)) {  // if statement: If the co-ordinates of mouseX and mouseY are within these parameters  
    numeralvalue=8; // Sets the value of the variable numeralvalue to 8 
  }   
  if ((mouseX>532)&&(mouseY>510)&&(mouseX<593)&&(mouseY<572)) {  // if statement: If the co-ordinates of mouseX and mouseY are within these parameters  
    numeralvalue=9; // Sets the value of the variable numeralvalue to 9 
  }  
  if ((mouseX>465)&&(mouseY>575)&&(mouseX<530)&&(mouseY<640)) {  // if statement: If the co-ordinates of mouseX and mouseY are within these parameters  
    numeralvalue=0; // Sets the value of the variable numeralvalue to 0 
  }    
  if ((mouseX>465)&&(mouseY>640)&&(mouseX<470)&&(mouseY<645)) {  // if statement: If the co-ordinates of mouseX and mouseY are within these parameters  
    numeralvalue=0; // Sets the value of the variable numeralvalue to 0 
  }   
  if ((mouseX>400)&&(mouseY>575)&&(mouseX<470)&&(mouseY<645)) { // if statement:Clear button: If the co-ordinates of mouseX and mouseY are within these parameters  
    mouseclicks--;  // The variable mouseClicks decreses by 1 each time  
    clearInput(); // The clearInput() function is called on 
  } else {   // curly bracket closes statement + else statement + curly brackets opens statement  

    mouseclicks++;  // The value of the variable mouseclicks is increasing each time 

    if ((mouseX>530)&&(mouseY>577)&&(mouseX<595)&&(mouseY<645)) { // if statement: Calculate button: If the co-ordinates of mouseX and mouseY are within these parameters  
      println("Total Resistance = " + totalresistance + " Ohms");  // Displays/ Prints the text "Total Resistance" + the value of the variable totalresistance + the text "Ohms" to the console  
      textSize(20); // Sets the text size to 20 pixels  
      text(totalresistance + " ohms", 420, 132);   // Displays the value of the variable totalresistance + the text "Ohms" at points (420,132) on the dispplay window    
      text( "R = " + totalvoltage/totalcurrent + " ohms", 130, 600);  // Display the text "R" + the values of the variables totalvoltage divided by totalcurrent + the text "ohms" at points (130,600) on the display window 
      fill(255);  // Fills in shapes and text white  
      text(totalresistance + " ohms", 420, 132); // Displays the value of the variable totalresistance + the text "ohms" at points (420,132) on the display window 
      println("To clear calculator fully, press clear 5 times"); // Displays/ Prints the text "To clear the calculator fully, press the clear button 5 times" on the console window 
    }  // Closes statement/ function  

    if (mouseclicks==1) {  // If statement: if the value of the variable mouseclicks is equal to 1 + curly brackets opens statement/function 
      voltage=numeralvalue;  // The value of the variable voltage is set to the value of the variable numeral value  
      textSize(20);  // The text size is set to 20 pixels  
      text(numeralvalue, 420, 330); // Displays the value of the variable numeralvalue at points (420,33) on the display window 
    } // closes function  
 
    //Calculates the voltage from inputs, and displays it   
    if (mouseclicks==2) { //If statement: if the value of the variale mouseclicks is equal to 2 + curly bracket opens function 
      totalvoltage=(voltage*10)+numeralvalue;  // Sets the value of the variable total voltage to the value of the variable voltage multiplied by ten added on to the vaue of the variable numeralvalue 
      textSize(20);  // Sets the text size to 20 pixels  
      text(totalvoltage + "V", 230, 300);  // Displays the value of the variable totalvoltage + the text "V" at points (230,300) on the display window 
      println("Total Voltage = " + totalvoltage + " V");  // Displays/ Prints the text "Total Voltage = " + the value of the varible totalvoltage + the text "V" on the console window  
      text(totalvoltage + " V", 130, 500);  // Displays the value of the variable totalvoltage + the text "V" at points (130,500) on the display window  
      text(numeralvalue, 432, 330); // Displays the value of the variable numeralvalue at points (432,330) on the display window 
    }  // Closes function 

    if (mouseclicks==3) {  // If statement: if the value of the variable mouseclicks is equal to 3 + curly brackets opens function 
      fill(255); // Fills in shapes and text white 
      stroke(255);  // Fills in the borders around shapes white 
      rect(400, 230, 300, 50); // Draws a rectangle from points (400,230), with a width of 300 and a height of 50 pixels  
      stroke(0); // Fills in the borders areound shapes black 
      fill(255);  // Fills in shapes and text white  
      current=numeralvalue;  // Sets the value of the variable current to the value of the variable numeral value 
      textSize(20);  //Sets the size of the text to 20 pixels 
      fill(0);  // Fills in shapes and text black 
      rect(400, 304, 195, 53);  // Draws a rectangle from points (400,304) with a width of 195 and a height of 53 pixels  
      fill(255);  // Fill is shapes and text white 
      text(numeralvalue +  "           mAmps", 490, 330);  // Displays the value of the variable numeral value + the text "Amps" at points (490,330) of the display window   
      fill(0); // Fills in shapes and text black 
      text("Input Current in mA", 480, 260); // Displays the text " Input current in mA" at points (480,260); 
    }  // Closes function 
 

    if (mouseclicks==4) {  // If statement: if the value of the variable mouseclicks is equal to 4 
      fill(255);  // Fills in shapes and text white 
      textSize(20);  // Sets the text size to 20 pixels 
      text(numeralvalue, 430, 330);  // Displays the value of the variable numeralvalue at points (430,330) on the display window  
      fill(0);  // Fills in shapes and text black 
      totalcurrent=((current*10)+numeralvalue)*pow(10, -3);  // Sets the value of the variable totalcurrent to the value of the variable current multiplied by 10 multiplied by 10 to the power of -3 
      println("Total Current = " + totalcurrent + " Amps");  // Displays / Prints the text " Total Current = " + the value of the variable total current + the text "Amps" on the console window  
      textSize(20);  // Sets the size of the text to 20 pixels 
      text(totalcurrent + "          Amps", 310, 10);  // Dispplays the value of the variable totalcurrent + the text "Amps" at points (310.10) on the display window 
      text( totalcurrent + " Amps", 190, 530);  // Displays the value of the variable totalcurrent + the text " Amps" at the points (190,530) 
      totalresistance=totalvoltage/totalcurrent; // Sets the value of the variable tottal resistance to the value of the values of totalvoltage divided by totalcurrent 
      rect(330, 120, 180, 30);  // Draws a rectangle from points (330,120) with a width of 180 and a height of 30 pixels 
      text( "R = " + totalvoltage + " Divided by " + totalcurrent, 170, 560); // Displays the text "R" + the value of the variable total voltage + the text "Divided by" + the value of the variable totalcurrent at points (170,560) on the display window   
    } // Closes function 
  } // Closes function 
}  // Closes function 
 
 
void clearInput() { // Function called clearInputs that Clears all previous inputs  
  fill(255);  // Fills in shapes and text white 
  stroke(0);  // Fills in borders around shaped black 
  rect(400, 304, 195, 53);  // Draws a rectangle from points (400,304) with a width of 195 and a height of 53 pixels 
  stroke(255);  // Fills the borders around shapes white 
  rect(100, 490, 200, 20);  // Draws a rectangle from points (100,490) with a width of 200 and a height of 20 pixels 
  rect(190, 290, 170, 30);  // Draws a rectangle from points (190,290) with a width of 170 and a height if 30 pixels 
  rect(90, 520, 190, 20);  // Draws a rectangle from points (90,520) with a width of 190 and a height of 20 pixels 
  rect(170, 5, 650, 20);  // Draws a rectangle from points (170,5) with a width of 650 and a eight of 20 pixels 
  rect(65, 550, 260, 20);  // Draws a rectangle from points (65,550) with a width of 260 and a height if 20 
  rect(55, 590, 180, 20);  // Draws a rectangle from points (55,590) with a width of 180 and a height if 20 pixels  
  rect(380, 230, 300, 50); // Draws a rectangle from points (380,230) with a width of 300 and a height of 50 pixels  
  stroke(0);  // Fills in borders around shapes black 
  fill(0);  //Fills in shapes and text black 
}  // closes function 
 
 
 
 
 
 