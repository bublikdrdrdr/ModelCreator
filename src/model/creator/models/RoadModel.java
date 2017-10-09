/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.creator.models;

import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import java.util.Random;
import model.creator.graphics.Model;
import model.creator.graphics.PolyAnimation;
import model.creator.graphics.Polygon;

/**
 *
 * @author Bublik
 */
public class RoadModel extends Model{
    
    Vector3f[] points = new Vector3f[]{  
        //Straight
        new Vector3f(0,0,0),
        new Vector3f(1,1,0),
        new Vector3f(0,0,10),
        new Vector3f(1,1,10),
        new Vector3f(9,1,0),
        new Vector3f(10,0,0),
        new Vector3f(9,1,10),
        new Vector3f(10,0,10),
        //End
        new Vector3f(1,1,8),
        new Vector3f(9,1,8),
        new Vector3f(2,1,6),
        new Vector3f(2,1,7),
        new Vector3f(8,1,6),
        new Vector3f(8,1,7),
        //Turn
        new Vector3f(0,0,6),
        new Vector3f(1,1,5),
        new Vector3f(9,1,1),
        new Vector3f(10,1,1),
        new Vector3f(4,0,10),
        new Vector3f(5,1,9),
        new Vector3f(10,1,9),
        new Vector3f(1,0,9),
        new Vector3f(2,1,8),
        //Triple
        new Vector3f(0,1,1),
        new Vector3f(1,1,1),
        new Vector3f(0,1,9),
        //Quadriple
        new Vector3f(1,1,9),
        new Vector3f(9,1,9),
    };
    
    private void scaleY(float scale){
        for(Vector3f vector:points){
            vector.y *= scale;
        }
    }
    
    float b = 256;
    long dur = 200;
    ColorRGBA[] colors = new ColorRGBA[]{
        new ColorRGBA(195/b, 195/b, 195/b, 1),
        new ColorRGBA(75/b, 75/b, 75/b, 1),
    };

    public RoadModel() {
        scaleY(0.5f);
        PolyAnimation buildStraightAnimation = new PolyAnimation("buildStraight");
        PolyAnimation buildEndAnimation = new PolyAnimation("buildEnd");
        PolyAnimation buildTurnAnimation = new PolyAnimation("buildTurn");
        PolyAnimation buildTripleAnimation = new PolyAnimation("buildTriple");
        PolyAnimation buildQuadripleAnimation = new PolyAnimation("buildQuadriple");
        PolyAnimation buildLoneAnimation = new PolyAnimation("buildLone");
        PolyAnimation destroyStraightAnimation = new PolyAnimation("destroyStraight");
        PolyAnimation destroyEndAnimation = new PolyAnimation("destroyEnd");
        PolyAnimation destroyTurnAnimation = new PolyAnimation("destroyTurn");
        PolyAnimation destroyTripleAnimation = new PolyAnimation("destroyTriple");
        PolyAnimation destroyQuadripleAnimation = new PolyAnimation("destroyQuadriple");
        PolyAnimation destroyLoneAnimation = new PolyAnimation("destroyLone");
        
        
        Polygon[] buildPolygons = new Polygon[]{
            //start straight
            p(0, 2, 2, 0, 2, 1, dur, d(1), 0),
            p(1, 2, 2, 1, 2, 3, dur, d(1), 0),
            p(4, 6, 6, 4, 6, 5, dur, d(1), 0),
            p(5, 6, 6, 5, 6, 7, dur, d(1), 0),
            p(6, 4, 4, 6, 4, 3, dur, d(2), 1),
            p(3, 4, 4, 3, 4, 1, dur, d(2), 1),
            //end straight
            
            //start dead end
            p(0, 8, 8, 0, 8, 1, dur, d(1), 0),
            p(0, 2, 2, 0, 2, 8, dur, d(1), 0),
            p(8, 2, 2, 8, 2, 7, dur, d(1), 0),
            p(8, 7, 7, 8, 7, 9, dur, d(1), 0),
            p(5, 9, 9, 5, 9, 7, dur, d(1), 0),
            p(4, 9, 9, 4, 9, 5, dur, d(1), 0),
            p(1, 8, 8, 1, 8, 4, dur, d(2), 1),
            p(4, 8, 8, 4, 8, 9, dur, d(2), 1),
            //end dead end
            
            //start turn
            p(0, 14, 14, 0, 14, 1, dur, d(1), 0),
            p(1, 14, 14, 1, 14, 15, dur, d(1), 0),
            p(15, 14, 14, 15, 14, 21, dur, d(1), 0),
            p(15, 21, 21, 15, 21, 22, dur, d(1), 0),
            p(22, 21, 21, 22, 21, 18, dur, d(1), 0),
            p(22, 18, 18, 22, 18, 19, dur, d(1), 0),
            p(19, 18, 18, 19, 18, 20, dur, d(1), 0),
            p(20, 18, 18, 20, 18, 7, dur, d(1), 0),
            p(4, 16, 16, 4, 16, 5, dur, d(1), 0),
            p(5, 16, 16, 5, 16, 17, dur, d(1), 0),
            p(1, 15, 15, 1, 15, 4, dur, d(2), 1),
            p(15, 22, 22, 15, 22, 4, dur, d(2), 1),
            p(22, 19, 19, 22, 19, 4, dur, d(2), 1),
            p(4, 19, 19, 4, 19, 16, dur, d(2), 1),
            p(16, 19, 19, 16, 19, 20, dur, d(2), 1),
            p(16, 20, 20, 16, 20, 17, dur, d(2), 1),
            //end turn
            
            //start triple
            p(0, 23, 23, 0, 23, 24, dur, d(1), 0),
            p(0, 24, 24, 0, 24, 1, dur, d(1), 0),
            p(4, 16, 16, 4, 16, 5, dur, d(1), 0),
            p(5, 16, 16, 5, 16, 17, dur, d(1), 0),
            p(25, 2, 2, 25, 2, 20, dur, d(1), 0),
            p(20, 2, 2, 20, 2, 7, dur, d(2), 0),
            p(1, 24, 24, 1, 24, 4, dur, d(2), 1),
            p(4, 24, 24, 4, 24, 16, dur, d(2), 1),
            p(23, 25, 25, 23, 25, 17, dur, d(3), 1),
            p(17, 25, 25, 17, 25, 20, dur, d(3), 1),
            
            //end triple
            
            //start quadriple
            p(0, 23, 23, 0, 23, 24, dur, d(1), 0),
            p(0, 24, 24, 0, 24, 1, dur, d(1), 0),
            p(4, 16, 16, 4, 16, 5, dur, d(1), 0),
            p(5, 16, 16, 5, 16, 17, dur, d(1), 0),
            p(25, 2, 2, 25, 2, 26, dur, d(1), 0),
            p(26, 2, 2, 26, 2, 3, dur, d(1), 0),
            p(27, 6, 6, 27, 6, 7, dur, d(1), 0),
            p(27, 7, 7, 27, 7, 20, dur, d(1), 0),
            p(1, 24, 24, 1, 24, 4, dur, d(2), 1),
            p(4, 24, 24, 4, 24, 16, dur, d(2), 1),
            p(23, 25, 25, 23, 25, 24, dur, d(2), 1),
            p(24, 25, 25, 24, 25, 26, dur, d(2), 1),
            p(26, 3, 3, 26, 3, 27, dur, d(2), 1),
            p(27, 3, 3, 27, 3, 6, dur, d(2), 1),
            p(16, 27, 27, 16, 27, 17, dur, d(2), 1),
            p(17, 27, 27, 17, 27, 20, dur, d(2), 1),
            p(24, 26, 26, 24, 26, 16, dur, d(3), 1),
            p(16, 26, 26, 16, 26, 27, dur, d(3), 1),
            //end quadriple
            
            //start lone
            p(0, 23, 23, 0, 23, 24, dur, d(1), 0),
            p(0, 24, 24, 0, 24, 1, dur, d(1), 0),
            p(4, 16, 16, 4, 16, 5, dur, d(1), 0),
            p(5, 16, 16, 5, 16, 17, dur, d(1), 0),
            p(25, 2, 2, 25, 2, 26, dur, d(1), 0),
            p(26, 2, 2, 26, 2, 3, dur, d(1), 0),
            p(27, 6, 6, 27, 6, 7, dur, d(1), 0),
            p(27, 7, 7, 27, 7, 20, dur, d(1), 0),
            p(1, 24, 24, 1, 24, 4, dur, d(2), 0),
            p(4, 24, 24, 4, 24, 16, dur, d(2), 0),
            p(23, 25, 25, 23, 25, 24, dur, d(2), 0),
            p(24, 25, 25, 24, 25, 26, dur, d(2), 0),
            p(26, 3, 3, 26, 3, 27, dur, d(2), 0),
            p(27, 3, 3, 27, 3, 6, dur, d(2), 0),
            p(16, 27, 27, 16, 27, 17, dur, d(2), 0),
            p(17, 27, 27, 17, 27, 20, dur, d(2), 0),
            p(24, 26, 26, 24, 26, 16, dur, d(3), 1),
            p(16, 26, 26, 16, 26, 27, dur, d(3), 1),
            //end lone
        };
        
        for (int i = 0; i < 6; i++){
            buildStraightAnimation.addPolygon(buildPolygons[i]);
        }
        addAnimation(buildStraightAnimation);
        
        int j = 0;
        Polygon[] destroyStraightPolygons = new Polygon[6];
        for (int i = 0; i < 6; i++){
            destroyStraightPolygons[i] = new Polygon(buildPolygons[j].getStartColor(),
                    buildPolygons[j].getEndColor(), buildPolygons[j].getEndPoints(), buildPolygons[j].getStartPoints(), dur, dur*7-buildPolygons[j].getDelay());
            j++;
        }
        
        for (Polygon polygon: destroyStraightPolygons) destroyStraightAnimation.addPolygon(polygon);
        addAnimation(destroyStraightAnimation);
        
        
        for (int i = 6; i < 14; i++){
            buildEndAnimation.addPolygon(buildPolygons[i]);
        }
        addAnimation(buildEndAnimation);
        
        Polygon[] destroyEndPolygons = new Polygon[8];
        j = 6;
        for (int i = 0; i < 8; i++){
            destroyEndPolygons[i] = new Polygon(buildPolygons[j].getStartColor(),
                    buildPolygons[j].getEndColor(), buildPolygons[j].getEndPoints(), buildPolygons[j].getStartPoints(), dur, dur*7-buildPolygons[j].getDelay());
            j++;
        }
        
        for (Polygon polygon: destroyEndPolygons) destroyEndAnimation.addPolygon(polygon);
        addAnimation(destroyEndAnimation);
        
        
        for (int i = 14; i < 30; i++){
            buildTurnAnimation.addPolygon(buildPolygons[i]);
        }
        addAnimation(buildTurnAnimation);
        
        Polygon[] destroyTurnPolygons = new Polygon[16];
        j = 14;
        for (int i = 0; i < 16; i++){
            destroyTurnPolygons[i] = new Polygon(buildPolygons[j].getStartColor(),
                    buildPolygons[j].getEndColor(), buildPolygons[j].getEndPoints(), buildPolygons[j].getStartPoints(), dur, dur*7-buildPolygons[j].getDelay());
            j++;
        }
        
        for (Polygon polygon: destroyTurnPolygons) destroyTurnAnimation.addPolygon(polygon);
        addAnimation(destroyTurnAnimation);
        
        for (int i = 30; i < 40; i++){
            buildTripleAnimation.addPolygon(buildPolygons[i]);
        }
        addAnimation(buildTripleAnimation);
        
        Polygon[] destroyTriplePolygons = new Polygon[10];
        j = 30;
        for (int i = 0; i < 10; i++){
            destroyTriplePolygons[i] = new Polygon(buildPolygons[j].getStartColor(),
                    buildPolygons[j].getEndColor(), buildPolygons[j].getEndPoints(), buildPolygons[j].getStartPoints(), dur, dur*7-buildPolygons[j].getDelay());
            j++;
        }
        
        for (Polygon polygon: destroyTriplePolygons) destroyTripleAnimation.addPolygon(polygon);
        addAnimation(destroyTripleAnimation);
        
        for (int i = 40; i < 58; i++){
            buildQuadripleAnimation.addPolygon(buildPolygons[i]);
        }
        addAnimation(buildQuadripleAnimation);
        
        Polygon[] destroyQuadriplePolygons = new Polygon[18];
        j = 40;
        for (int i = 0; i < 18; i++){
            destroyQuadriplePolygons[i] = new Polygon(buildPolygons[j].getStartColor(),
                    buildPolygons[j].getEndColor(), buildPolygons[j].getEndPoints(), buildPolygons[j].getStartPoints(), dur, dur*7-buildPolygons[j].getDelay());
            j++;
        }
        
        for (Polygon polygon: destroyQuadriplePolygons) destroyQuadripleAnimation.addPolygon(polygon);
        addAnimation(destroyQuadripleAnimation);
        
        for (int i = 58; i < 76; i++){
            buildLoneAnimation.addPolygon(buildPolygons[i]);
        }
        addAnimation(buildLoneAnimation);
        
        Polygon[] destroyLonePolygons = new Polygon[18];
        j = 58;
        for (int i = 0; i < 18; i++){
            destroyLonePolygons[i] = new Polygon(buildPolygons[j].getStartColor(),
                    buildPolygons[j].getEndColor(), buildPolygons[j].getEndPoints(), buildPolygons[j].getStartPoints(), dur, dur*7-buildPolygons[j].getDelay());
            j++;
        }
        
        for (Polygon polygon: destroyLonePolygons) destroyLoneAnimation.addPolygon(polygon);
        addAnimation(destroyLoneAnimation);
    }
    
    
    private ColorRGBA c(int index){
        return colors[index];
    }
    
    private Vector3f v(int index){
        return points[index];
    }
    
    private long d(int mult){
        return dur*mult;
    }
    
    private Polygon p(int s1, int s2, int s3, int e1, int e2, int e3, long time, long delay, int color){
        return p(s1, s2, s3, e1, e2, e3, time, delay, c(color));
    }
    
    private Polygon p(int s1, int s2, int s3, int e1, int e2, int e3, long time, long delay, ColorRGBA color){
        return new Polygon(color, color, new Vector3f[]{v(s1), v(s2),v(s3)}, new Vector3f[]{v(e1),v(e2),v(e3)}, time, delay);
    }
    
}
