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
public class TreeModel extends Model{
    Vector3f[] points = new Vector3f[]{
            new Vector3f(0.246f, 0, -11.4f),
            new Vector3f(-9.75f, 0, 5.132f),
            new Vector3f(10.25f, 0, 5.132f),
            new Vector3f(0.246f, 26.25f, -11.4f),
            new Vector3f(-9.75f, 26.25f, 5.132f),
            new Vector3f(10.25f, 26.25f, 5.132f),
            new Vector3f(-35f, 26.25f, -35f),
            new Vector3f(-35f, 26.25f, 35f),
            new Vector3f(35f, 26.25f, 35f),
            new Vector3f(35f, 26.25f, -35f),
            new Vector3f(-21f, 54.3f, -21),
            new Vector3f(-21f, 54.3f, 21),
            new Vector3f(21f, 54.3f, 21),
            new Vector3f(21f, 54.3f, -21),
            new Vector3f(-28.63f, 54.3f, -28.63f),
            new Vector3f(-28.63f, 54.3f, 28.63f),
            new Vector3f(28.63f, 54.3f, 28.63f),
            new Vector3f(28.63f, 54.3f, -28.63f),
            new Vector3f(-9.8f, 83.56f, -9.8f),
            new Vector3f(-9.8f, 83.56f, 9.8f),
            new Vector3f(9.8f, 83.56f, 9.8f),
            new Vector3f(9.8f, 83.56f, -9.8f),
            new Vector3f(-18.35f, 83.56f, -18.35f),
            new Vector3f(-18.35f, 83.56f, 18.35f),
            new Vector3f(18.35f, 83.56f, 18.35f),
            new Vector3f(18.35f, 83.56f, -18.35f),
            new Vector3f(0,111f, 0)
        };
    
    public TreeModel(){
        scalePoints();
        
        PolyAnimation buildAnimation = new PolyAnimation("build");
        PolyAnimation stage1Animation = new PolyAnimation("stage1");
        PolyAnimation stage2Animation = new PolyAnimation("stage2");
        PolyAnimation destroy1Animation = new PolyAnimation("destroy1");
        PolyAnimation destroy2Animation = new PolyAnimation("destroy2");
        
        
        float b = 256f;
        long dur = 1000;
        ColorRGBA[] colors = new ColorRGBA[]{
            new ColorRGBA(124/b,62/b,0,1f),
            new ColorRGBA(0,217/b, 0,1),
            new ColorRGBA(0,198/b, 89/b, 1),
            new ColorRGBA(109/b, 178/b, 47/b,1)
        };
        
        Polygon[] buildPolygons = new Polygon[]{
          //stem
            new Polygon(colors[0], colors[0], gP(2,0,0),gP(2,0,5), dur, 0),
            new Polygon(colors[0], colors[0], gP(0,1,0),gP(0,1,3), dur, 0),
            new Polygon(colors[0], colors[0], gP(1,2,1),gP(1,2,5), dur, 0),
            
            new Polygon(colors[0], colors[0], gP(0,0,5),gP(0,3,5), dur, dur),
            new Polygon(colors[0], colors[0], gP(1,1,3),gP(1,4,3), dur, dur),
            new Polygon(colors[0], colors[0], gP(1,5,1),gP(1,5,4), dur, dur),
            
            new Polygon(colors[0], colors[0], gP(3,3,3),gP(3,4,5), dur, dur*2),
            //end stem
            
            //first stage
            new Polygon(colors[1], colors[1], gP(6,9,9),gP(6,13,9), dur, dur*3),
            new Polygon(colors[1], colors[1], gP(9,8,8),gP(9,12,8), dur, dur*3),
            new Polygon(colors[1], colors[1], gP(8,7,7),gP(8,11,7), dur, dur*3),
            new Polygon(colors[1], colors[1], gP(7,6,6),gP(7,10,6), dur, dur*3),
            
            new Polygon(colors[1], colors[1], gP(6,6,13),gP(6,10,13), dur, dur*4),
            new Polygon(colors[1], colors[1], gP(9,9,12),gP(9,13,12), dur, dur*4),
            new Polygon(colors[1], colors[1], gP(8,8,11),gP(8,12,11), dur, dur*4),
            new Polygon(colors[1], colors[1], gP(7,7,10),gP(7,11,10), dur, dur*4),
            //end first
            
            //second stage
            new Polygon(colors[1], colors[1], gP(14,17,17),gP(14,21,17), dur, dur*5),
            new Polygon(colors[1], colors[1], gP(17,16,16),gP(17,20,16), dur, dur*5),
            new Polygon(colors[1], colors[1], gP(16,15,15),gP(16,19,15), dur, dur*5),
            new Polygon(colors[1], colors[1], gP(15,14,14),gP(15,18,14), dur, dur*5),
            
            new Polygon(colors[1], colors[1], gP(14,14,21),gP(14,18,21), dur, dur*6),
            new Polygon(colors[1], colors[1], gP(17,17,20),gP(17,21,20), dur, dur*6),
            new Polygon(colors[1], colors[1], gP(16,16,19),gP(16,20,19), dur, dur*6),
            new Polygon(colors[1], colors[1], gP(15,15,18),gP(15,19,18), dur, dur*6),
            //end second
            
            //third stage
            new Polygon(colors[1], colors[1], gP(22,25,25),gP(22,26,25), dur, dur*7),
            new Polygon(colors[1], colors[1], gP(25,24,24),gP(25,26,24), dur, dur*7),
            new Polygon(colors[1], colors[1], gP(24,23,23),gP(24,26,23), dur, dur*7),
            new Polygon(colors[1], colors[1], gP(23,22,22),gP(23,26,22), dur, dur*7)
            //end third
        };
        
        
        Polygon[] stage1Polygons = new Polygon[buildPolygons.length];
        for (int i = 0; i < stage1Polygons.length; i++){
            if (i >= 7){
                if (i%3==0)
            stage1Polygons[i] = new Polygon(colors[1], colors[2], buildPolygons[i].getEndPoints(), buildPolygons[i].getEndPoints(), buildPolygons[i].getDuration(), 0);
                else
                    stage1Polygons[i] = new Polygon(colors[1], colors[3], buildPolygons[i].getEndPoints(), buildPolygons[i].getEndPoints(), buildPolygons[i].getDuration(), 0);
            }
            else
                stage1Polygons[i] = new Polygon(colors[0], colors[0], buildPolygons[i].getEndPoints(), buildPolygons[i].getEndPoints(), buildPolygons[i].getDuration(), 0);
        }
        
        Polygon[] stage2Polygons = new Polygon[buildPolygons.length];
        for (int i = 0; i < stage2Polygons.length; i++){
            if (i >=7){
                if (i%3==0)
            stage2Polygons[i] = new Polygon(colors[2], colors[1], buildPolygons[i].getEndPoints(), buildPolygons[i].getEndPoints(), buildPolygons[i].getDuration(), 0);
            else
                 stage2Polygons[i] = new Polygon(colors[3], colors[1], buildPolygons[i].getEndPoints(), buildPolygons[i].getEndPoints(), buildPolygons[i].getDuration(), 0);   
            }else
                stage2Polygons[i] = new Polygon(colors[0], colors[0], buildPolygons[i].getEndPoints(), buildPolygons[i].getEndPoints(), buildPolygons[i].getDuration(), 0);
        }
        
        Polygon[] destroy1Polygons = new Polygon[buildPolygons.length];
        for (int i = 0; i < destroy1Polygons.length; i++){
            destroy1Polygons[i] = new Polygon(buildPolygons[i].getStartColor(),
                    buildPolygons[i].getEndColor(), buildPolygons[i].getEndPoints(), buildPolygons[i].getStartPoints(), dur, dur*7-buildPolygons[i].getDelay());
        }
        
        Polygon[] destroy2Polygons = new Polygon[buildPolygons.length];
        for (int i = 0; i < destroy2Polygons.length; i++){
            destroy2Polygons[i] = new Polygon(stage1Polygons[i].getEndColor(),
                    stage1Polygons[i].getEndColor(), buildPolygons[i].getEndPoints(), buildPolygons[i].getStartPoints(), dur, dur*7-buildPolygons[i].getDelay());
        }
        
        for (Polygon polygon: buildPolygons) buildAnimation.addPolygon(polygon);
        for (Polygon polygon: stage1Polygons) stage1Animation.addPolygon(polygon);
        for (Polygon polygon: stage2Polygons) stage2Animation.addPolygon(polygon);
        for (Polygon polygon: destroy1Polygons) destroy1Animation.addPolygon(polygon);
        for (Polygon polygon: destroy2Polygons) destroy2Animation.addPolygon(polygon);
        
        
        addAnimation(buildAnimation);
        addAnimation(stage1Animation);
        addAnimation(stage2Animation);
        addAnimation(destroy1Animation);
        addAnimation(destroy2Animation);
    }
    
    private Vector3f[] gP(int i1, int i2, int i3){
        return new Vector3f[]{points[i1], points[i2], points[i3]};
    }
    
    private void scalePoints(){
        float scale = 0.01f;
        for (Vector3f vector3f: points){
            vector3f.scaleAdd(scale, Vector3f.ZERO);
        }
    }
}
