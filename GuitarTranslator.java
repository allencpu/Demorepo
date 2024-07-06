import processing.core.PApplet;
import processing.core.PImage;

	public class FreeFret extends PApplet{
		
		
		//configure GUI's FretBoard for FretMaster Guitar Translator 
		
		PImage neck;public int oY;
		public int currX; public int currY;
		public int presX; public int presY; 
		public String currZ=""; 
		public String presZ="";
		public int undraw;
		private static final long serialVersionUID = 1L;
		

		
		int[] dots = {1,3,5,7,9,12,15,17,19,21,24};
		String[] notes= {"E","F","F#","G","G#","A","A#","B","C","C#","D","D#"};

		public void setup() {
			
			colorMode(RGB,255,255,255);
			size(400,800);
			background(0);
			stroke(255);
		drawDots();
		labelStrings();
	}
		private void drawDots() {
			int q= dots.length;
			for (int c=0; c<q; c++ ) {
				int y=dots[c]*29;fill(255,255,250);
				ellipse(45,y+66,10,10);
			};
			labelStrings();
			
		}
		private void labelStrings() {
			textSize(20);
			fill(255,0,0);
			text("FRETMaster",130,20);
			fill(255,255,245);
			textSize(9);text("Guitar Translator by Neckrophobia",150,30);
			fill(10,20,175);text("tm Allen Kenneth",10,790);
			
			fill(100,200,100);
			textSize(18);
			String [] strings = {"E","A","D","G","B","E"};
			for (int d= 0;d<strings.length;d++) {
			text(strings[d],55+(d*50),75);}
			
		}
		public void draw() {
			drawStrings();
			drawFrets(); 

			// position mouse
				currX=(int)((mouseX-62)/50);
				currY=(int)((mouseY-75)/29)+1;
		
				if (undraw>0) {
					fill(0,0,0);stroke(2); ellipse (75+(presX*50),66+(presY*29),10,10);
					fill(0,0,0);
					if (presY>=1) rect(54+(presX*50),53+(presY*29),16,20);
				}
				if (presX==currX && presY==currY){ undraw=0;}
			if (currX>=0&& currX<= 5 && currY>=1) {
				fill(100,100,200);stroke(1);
				
				ellipse(75+(currX*50),66+(currY*29),10,10);
				if (currX<=5 && currY<=24 && currY>=1){
					currZ=showNote(currX,currY);
					textSize(14); fill(220,220,100);
					text(currZ,54+(currX*50), 66+(currY*29));
					
				}
				}
			presX=currX; presY=currY; presZ=currZ;
			}
		private void drawFrets() {
			for (int b=0; b<24;b++) {
				int y=(b*29);
				
				line(70,80+y,330,80+y);
				oY=y;}
			
		}
		private void drawStrings() {
			stroke(255);
			for (int a=0; a<6; a++) {
				int x=a*50;
			line(x+75,50,x+75,750);}
			
		}
		private String showNote(int currX2, int currY2) {
			int noteX= currX2; int noteY = currY2;
			if (noteY>=12) {noteY=noteY-12;}
			int modX= noteX*5;
			while  (modX>=12) modX=modX-12;
			int noteT= noteY+modX;
			if (noteX>=4) {noteT=noteT-1;}
			if (noteT>=12) {noteT=noteT-12;}
			return notes[noteT];
			
		}
		public void mouseMoved(){
			 undraw= 1; presZ=currZ;
		}
		public void mouseClicked() {
			int noteY=currY;
			if (mouseX<70 || mouseX> 370) {clear();labelStrings();
			drawDots();}
			if (currX>=0 && currX<=5) {
			if (noteY>=12) {noteY=noteY-12;}
			int modX= (currX*5);
			while (modX>=12) modX=modX-12;
			int noteT = noteY+modX;
			if (currX>=4) {noteT=noteT-1;}
			if(noteT>=12) {noteT=noteT-12;}
			
			finishNotes(noteT);undraw=0;}
		}
		private void finishNotes(int noteT) {
			// fill in matching notes
			String z= notes[noteT];
			int x=0;int xmod=0;
			int y =noteT;
			
			for (int cy=0; cy<6 ; cy=cy+1){
				
				textSize(15); 
				if (x>=4) {xmod=1;}
				if(x<4) {xmod=0;}

				 if (y<=12) {
					 fill(200,100,200);
					if(y>0) {  text(z,54+(x*50), 68+((y+xmod)*29));
					fill(100,100,200);
					ellipse(75+(x*50),66+((y+xmod)*29),10,10);}
					fill(200,100,200);
					 text(z,54+(x*50), 68+((y+12+xmod)*29));
					 fill(100,100,200);
					 ellipse(75+(x*50),66+((y+12+xmod)*29),10,10);
					 }
				 
				x++; y=y-5;
				if (y<0)y=y+12;
				}
				}	
				
			}
			

