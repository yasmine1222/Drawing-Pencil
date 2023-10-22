// NOTE: Once you understand how this sample code works,
//       you will want to delete/change most of it. :)

import java.util.*;

class HW04 extends App {
    
    int frame_index;
    ArrayList<ArrayList<ArrayList<Vector2>>>animation;
    
    void setup() {
        System.out.println("Press Q to quit.");
        System.out.println("Press R to rerun setup().");
        
        animation= new ArrayList<>();
        animation.add( new ArrayList<>());
        int frame_index =0;
    }
    
    void loop() {
        ArrayList<ArrayList<Vector2>> drawing = animation.get(frame_index);
        if (mousePressed) { System.out.println("Mouse pressed."); }
        if (mouseHeld) { System.out.println("Mouse held."); }
        if (mouseReleased) { System.out.println("Mouse released."); }
        if (keyPressed('S')) { System.out.println("Key S pressed."); }
        if (keyToggled('P')) { System.out.println("Key P toggled."); }
        if (mousePressed){
            
            drawing.add(new ArrayList<Vector2>());
        }
        if (mouseHeld) {
            drawing.get(drawing.size()-1).add(mousePosition);
        }
        
        
        
        for (int i = 0; i < drawing.size(); ++i){
            ArrayList<Vector2> stroke = drawing.get(i);
            for ( int j =0; j<stroke.size()-1; ++j){ 
                drawLine(stroke.get(j), stroke.get(j+1), Vector3.black);
            }   
        }
        
        if (keyPressed('X')){
            for (int k = 0; k<drawing.size(); ++k){
                ArrayList<Vector2> stroke = drawing.get(k);
                for ( int l =0; l<stroke.size()-1; ++l){
                    Vector2 position=stroke.get(l);
                    stroke.set(l, new Vector2(-position.x,position.y));
                }
            } 
        }
        if (keyPressed('Y')){
            for (int m = 0; m<drawing.size(); ++m){
                ArrayList<Vector2> stroke = drawing.get(m);
                for ( int n =0; n<stroke.size()-1; ++n){
                    Vector2 position=stroke.get(n);
                    stroke.set(n, new Vector2(position.x,-position.y));
                }
            }
        }
        if (keyPressed('S')){
            animation.add( new ArrayList<>());
            frame_index++;
        }
        if (keyToggled('P')){
            frame_index++;
            frame_index = frame_index % animation.size();
            
        }
        
            if (keyPressed('.')){
                frame_index++;
            }
            
            if (keyPressed(',')){
                frame_index--;
            }
            
        }
    
    public static void main(String[] arguments) {
        App app = new HW04();
        app.setWindowBackgroundColor(1.0, 1.0, 1.0);
        app.setWindowSizeInWorldUnits(8.0, 8.0);
        app.setWindowCenterInWorldUnits(0.0, 0.0);
        app.setWindowHeightInPixels(512);
        app.setWindowTopLeftCornerInPixels(64, 64);
        app.run();
    }
}