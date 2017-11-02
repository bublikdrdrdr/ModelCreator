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
public class PowerplantModel extends Model{
    
    Vector3f[] points = new Vector3f[]{  
        //Straight
        new Vector3f(0,0,1),
        new Vector3f(1,0,0),
        new Vector3f(0,1,0),
        new Vector3f(1,1,0),
        new Vector3f(1,0,1),
        new Vector3f(1,1,1),
        new Vector3f(0,1,1)
    };
    
    private void scale(float scale){
        for(Vector3f vector:points){
            vector.x *= scale;
            vector.y *= scale;
            vector.z *= scale;
        }
    }
    
    float b = 256;
    long dur = 200;
    ColorRGBA[] colors = new ColorRGBA[]{
        new ColorRGBA(224/b, 190/b, 0/b, 1)
    };

    public PowerplantModel() {
        scale(1f);
        PolyAnimation buildAnimation = new PolyAnimation("build");
        PolyAnimation destroyAnimation = new PolyAnimation("destroy");
        
        Polygon[] buildPolygons = new Polygon[]{
            p(0, 4, 4, 0, 4, 5, dur, d(1), 0),
            p(0, 5, 5, 0, 5, 6, dur, d(1), 0),
            p(1, 3, 3, 1, 3, 5, dur, d(1), 0),
            p(1, 5, 5, 1, 5, 4, dur, d(1), 0),
            p(2, 6, 6, 2, 6, 3, dur, d(1), 0),
            p(3, 6, 6, 3, 6, 5, dur, d(1), 0),
        };
        
        for (int i = 0; i < 6; i++){
            buildAnimation.addPolygon(buildPolygons[i]);
        }
        addAnimation(buildAnimation);
        
        int j = 0;
        Polygon[] destroyPolygons = new Polygon[6];
        for (int i = 0; i < 6; i++){
            destroyPolygons[i] = new Polygon(buildPolygons[j].getStartColor(),
                    buildPolygons[j].getEndColor(), buildPolygons[j].getEndPoints(), buildPolygons[j].getStartPoints(), dur, dur*7-buildPolygons[j].getDelay());
            j++;
        }
        
        for (Polygon polygon: destroyPolygons) destroyAnimation.addPolygon(polygon);
        addAnimation(destroyAnimation);
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
