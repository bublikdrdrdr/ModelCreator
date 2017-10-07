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
public class TerrainModel extends Model{
    
    Vector3f[] points = new Vector3f[]{  
        new Vector3f(0,0,0),
        new Vector3f(3,0,0),
        new Vector3f(5,0,0),
        new Vector3f(2.5f,0,1),
        new Vector3f(1,0,2),
        new Vector3f(4.5f, 0, 2),
        new Vector3f(0,0,2.5f),
        new Vector3f(3,0,2.5f),
        new Vector3f(2,0,3.5f),
        new Vector3f(5,0,3.5f),
        new Vector3f(3.5f, 0,4),
        new Vector3f(0,0,5),
        new Vector3f(1.5f, 0,5),
        new Vector3f(3.5f, 0,5),
        new Vector3f(5,0,5)
    };
    
    float b = 256;
    
    ColorRGBA[] colors = new ColorRGBA[]{
        new ColorRGBA(118/b, 164/b, 65/b, 1),
        new ColorRGBA(93/b, 145/b, 63/b, 1),
        new ColorRGBA(86/b, 137/b, 62/b, 1),
        new ColorRGBA(131/b, 178/b, 64/b, 1),
        new ColorRGBA(46/b, 104/b, 53/b, 1),
    };

    public TerrainModel() {
        PolyAnimation buildAnimation = new PolyAnimation("build");
        
        long dur = 1000;
        Polygon[] buildPolygons = new Polygon[]{
            p(0, 1, 1, 0, 3, 1, dur, 0),
            p(1,2,2,1,5,2, dur, 0),
            p(3,1,1,3,5,1, dur, 0),
            p(5,3,3,5,3,7, dur, 0),
            p(4,7,7,4,7,3, dur, 0),
            p(4,3,3,4,3,0, dur, 0),
            p(0,6,6,0,6,4, dur, 0),
            p(7,9,9,7,9,5, dur, 0),
            p(5,9,9,5,9,2, dur, 0),
            p(7,4,4,7,4,8, dur, 0),
            p(6,8,8,6,8,4, dur, 0),
            p(6,11,11,6,11,8, dur, 0),
            p(11,12,12,11,12,8, dur, 0),
            p(8,10,10,8,10,7, dur, 0),
            p(7,10,10,7,10,9, dur, 0),
            p(14,9,9,14,9,10, dur, 0),
            p(10,13,13,10,13,14, dur, 0),
            p(8,12,12,8,12,10, dur, 0),
            p(10,12,12,10,12,13, dur, 0),
            
        };
        
        for (Polygon polygon: buildPolygons){
            buildAnimation.addPolygon(polygon);
        }
        this.addAnimation(buildAnimation);
    }
    
    private ColorRGBA c(int index){
        return colors[index];
    }
    
    private Vector3f v(int index){
        return points[index];
    }
    
    
    Random random = new Random();
    int last = -1;
    private ColorRGBA pr(){
        if (last==-1){
            last = random.nextInt(colors.length-1);
            return colors[last];
        } else{
            ColorRGBA res = colors[last];
            last = -1;
            return res;
        }
    }
    
    private Polygon p(int s1, int s2, int s3, int e1, int e2, int e3, long time, long delay){
        return p(s1, s2, s3, e1, e2, e3, time, delay, pr());
    }
    
    private Polygon p(int s1, int s2, int s3, int e1, int e2, int e3, long time, long delay, int color){
        return p(s1, s2, s3, e1, e2, e3, time, delay, c(color));
    }
    
    private Polygon p(int s1, int s2, int s3, int e1, int e2, int e3, long time, long delay, ColorRGBA color){
        return new Polygon(color, color, new Vector3f[]{v(s1), v(s2),v(s3)}, new Vector3f[]{v(e1),v(e2),v(e3)}, time, delay);
    }
    
}
