/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.creator.models;

import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import model.creator.graphics.Model;
import model.creator.graphics.PolyAnimation;
import model.creator.graphics.Polygon;

/**
 *
 * @author Bublik
 */
public class FinalTree extends Model{
    
    float h1 = 10;
    float h2 = 16;
    float h3 = 19;
    float r1 = 4;
    float r2 = 2f;
    int duration = 150;
    
    Vector3f[] points = new Vector3f[]{
        new Vector3f(-1,0,-1),
        new Vector3f(-1,0,1),
        new Vector3f(1,0,1),
        new Vector3f(1,0,-1),
        
        new Vector3f(-1,h1,-1),
        new Vector3f(-1,h1,1),
        new Vector3f(1,h1,1),
        new Vector3f(1,h1,-1),
        
        new Vector3f(-r1,h1,-r1),
        new Vector3f(-r1,h1,r1),
        new Vector3f(r1,h1,r1),
        new Vector3f(r1,h1,-r1),
        
        new Vector3f(-r1,h2,-r1),
        new Vector3f(-r1,h2,r1),
        new Vector3f(r1,h2,r1),
        new Vector3f(r1,h2,-r1),
        
        new Vector3f(-r2,h2,-r2),
        new Vector3f(-r2,h2,r2),
        new Vector3f(r2,h2,r2),
        new Vector3f(r2,h2,-r2),
        
        new Vector3f(-r2,h3,-r2),
        new Vector3f(-r2,h3,r2),
        new Vector3f(r2,h3,r2),
        new Vector3f(r2,h3,-r2)
    };
    
    ColorRGBA colors[] = new ColorRGBA[]{
        ColorRGBA.Brown,
        ColorRGBA.Green
    };
    
    private void scale(float scale){
        for(Vector3f vector:points){
            vector.x *= scale;
            vector.y *= scale;
            vector.z *= scale;
        }
    }
    
    public FinalTree(){
        scale(0.1f);
        PolyAnimation buildAnimation = new PolyAnimation("build");
        PolyAnimation destroyAnimation = new PolyAnimation("destroy");
        
        
         Polygon[] buildPolygons = new Polygon[]{
            p(3,2,2,3,6,2, duration, d(0), 0),
            p(2,1,1,2,6,1, duration, d(0), 0),
            p(3,3,3,3,7,6, duration, d(1), 0),
            p(1,1,1,1,6,5, duration, d(1), 0),
            p(11,10,10,11,14,10, duration, d(2), 1),
            p(10,9,9,10,14,9, duration, d(2), 1),
            p(11,11,11,11,15,14, duration, d(3), 1),
            p(9,9,9,9,14,13, duration, d(3), 1),
            p(14,12,12,14,15,12, duration, d(4), 1),
            p(14,12,12,14,12,13, duration, d(4), 1),
            p(19,18,18,19,22,18, duration, d(5), 1),
            p(18,17,17,18,22,17, duration, d(5), 1),
            p(19,23,23,19,23,22, duration, d(5), 1),
            p(17,21,21,17,22,21, duration, d(5), 1),
            p(23,23,23,23,20,22, duration, d(6), 1),
            p(21,21,21,21,22,20, duration, d(6), 1)
            
        };
        
        for (int i = 0; i < buildPolygons.length; i++){
            buildAnimation.addPolygon(buildPolygons[i]);
        }
        addAnimation(buildAnimation);
        
        int j = 0;
        Polygon[] destroyPolygons = new Polygon[buildPolygons.length];
        for (int i = 0; i < buildPolygons.length; i++){
            destroyPolygons[i] = new Polygon(buildPolygons[j].getStartColor(),
                    buildPolygons[j].getEndColor(), buildPolygons[j].getEndPoints(), buildPolygons[j].getStartPoints(), duration*2, 0);
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
        return duration*mult;
    }
    
    
    
    private Polygon p(int s1, int s2, int s3, int e1, int e2, int e3, long time, long delay, int color){
        return p(s1, s2, s3, e1, e2, e3, time, delay, c(color));
    }
    
    private Polygon p(int s1, int s2, int s3, int e1, int e2, int e3, long time, long delay, ColorRGBA color){
        return new Polygon(color, color, new Vector3f[]{v(s1), v(s2),v(s3)}, new Vector3f[]{v(e1),v(e2),v(e3)}, time, delay);
    }
    
}
