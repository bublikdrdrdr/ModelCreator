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
public class SimpleModel extends Model{

    public SimpleModel() {     
        PolyAnimation buildAnimation = new PolyAnimation("build_lvl_1");
        PolyAnimation upgradeAnimation = new PolyAnimation("upgrade_lvl_2");
        PolyAnimation downgradeAnimation = new PolyAnimation("downgrade_lvl_1");
        PolyAnimation destroy1Animation = new PolyAnimation("destroy_lvl_1");
        PolyAnimation destroy2Animation = new PolyAnimation("destroy_lvl_2");
        float point = 0.5f;
        float smallPoint = 0.3f;
        long duration = 500;
        
        Vector3f[] points = new Vector3f[]{
            new Vector3f(-point, 0, -point),
            new Vector3f(-point, 0, point),
            new Vector3f(point, 0, point),
            new Vector3f(point, 0, -point),
            new Vector3f(-point, 1, -point),
            new Vector3f(-point, 1, point),
            new Vector3f(point, 1, point),
            new Vector3f(point, 1, -point),
            new Vector3f(-smallPoint, 1.3f, -smallPoint),
            new Vector3f(-smallPoint, 1.3f, smallPoint),
            new Vector3f(smallPoint, 1.3f, smallPoint),
            new Vector3f(smallPoint, 1.3f, -smallPoint)
        };
        
        ColorRGBA[] colors = new ColorRGBA[]{
            new ColorRGBA(0.27f, 0.433f, 0.71f, 1f),
            new ColorRGBA(0.25f, 0.55f, 0.71f, 1f),
            new ColorRGBA(0.45f, 0.39f, 0.71f, 1f)
        };
        Polygon[] buildPolygons = new Polygon[]{
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[0],
                points[1],
                points[1]
            }, new Vector3f[]{
                points[0],
                points[1],
                points[5]
            }, duration, 0),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[1],
                points[2],
                points[2]
            }, new Vector3f[]{
                points[1],
                points[2],
                points[6]
            }, duration, 0),
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[2],
                points[3],
                points[3]
            }, new Vector3f[]{
                points[2],
                points[3],
                points[7]
            }, duration, 0),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[0],
                points[0],
                points[3]
            }, new Vector3f[]{
                points[0],
                points[7],
                points[3]
            }, duration, 0),
            
            
            
            new Polygon(colors[2], colors[2], new Vector3f[]{
                points[5],
                points[1],
                points[1]
            }, new Vector3f[]{
                points[5],
                points[1],
                points[6]
            }, duration, duration),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[2],
                points[2],
                points[6]
            }, new Vector3f[]{
                points[2],
                points[7],
                points[6]
            }, duration, duration),
            new Polygon(colors[2], colors[2], new Vector3f[]{
                points[0],
                points[0],
                points[7]
            }, new Vector3f[]{
                points[0],
                points[4],
                points[7]
            }, duration, duration),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[0],
                points[0],
                points[4]
            }, new Vector3f[]{
                points[0],
                points[5],
                points[4]
            }, duration, duration),
            
            
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[6],
                points[6],
                points[7]
            }, new Vector3f[]{
                points[5],
                points[6],
                points[7]
            }, duration, duration*2),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[7],
                points[4],
                points[4]
            }, new Vector3f[]{
                points[7],
                points[4],
                points[5]
            }, duration, duration*2)
        };
        
        Polygon[] upgradePolygons = new Polygon[]{
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[0],
                points[1],
                points[5]
            }, new Vector3f[]{
                points[0],
                points[1],
                points[5]
            }, 0, 0),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[1],
                points[2],
                points[6]
            }, new Vector3f[]{
                points[1],
                points[2],
                points[6]
            }, 0, 0),
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[2],
                points[3],
                points[7]
            }, new Vector3f[]{
                points[2],
                points[3],
                points[7]
            }, 0, 0),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[0],
                points[7],
                points[3]
            }, new Vector3f[]{
                points[0],
                points[7],
                points[3]
            }, 0, 0),
            
            
            
            new Polygon(colors[2], colors[2], new Vector3f[]{
                points[5],
                points[1],
                points[6]
            }, new Vector3f[]{
                points[5],
                points[1],
                points[6]
            }, 0, 0),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[2],
                points[7],
                points[6]
            }, new Vector3f[]{
                points[2],
                points[7],
                points[6]
            }, 0, 0),
            new Polygon(colors[2], colors[2], new Vector3f[]{
                points[0],
                points[4],
                points[7]
            }, new Vector3f[]{
                points[0],
                points[4],
                points[7]
            }, 0, 0),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[0],
                points[5],
                points[4]
            }, new Vector3f[]{
                points[0],
                points[5],
                points[4]
            }, 0, 0),
            
            
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[5],
                points[6],
                points[7]
            }, new Vector3f[]{
                points[11],
                points[6],
                points[7]
            }, duration, 0),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[7],
                points[4],
                points[5]
            }, new Vector3f[]{
                points[8],
                points[4],
                points[5]
            }, duration, 0),
               
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[5],
                points[6],
                points[6]
            }, new Vector3f[]{
                points[5],
                points[6],
                points[10]
            }, duration, 0),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[7],
                points[4],
                points[7]
            }, new Vector3f[]{
                points[7],
                points[4],
                points[11]
            }, duration, 0),
                
                
                
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[5],
                points[10],
                points[5]
            }, new Vector3f[]{
                points[5],
                points[10],
                points[9]
            }, duration, duration),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[11],
                points[6],
                points[6]
            }, new Vector3f[]{
                points[11],
                points[10],
                points[6]
            }, duration, duration),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[4],
                points[4],
                points[11]
            }, new Vector3f[]{
                points[4],
                points[8],
                points[11]
            }, duration, duration),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[5],
                points[9],
                points[9]
            }, new Vector3f[]{
                points[5],
                points[9],
                points[8]
            }, duration, duration),
                
                
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[8],
                points[8],
                points[11]
            }, new Vector3f[]{
                points[8],
                points[9],
                points[11]
            }, duration, duration*2),
                new Polygon(colors[2], colors[2], new Vector3f[]{
                points[10],
                points[10],
                points[11]
            }, new Vector3f[]{
                points[9],
                points[10],
                points[11]
            }, duration, duration*2)
        };
        
        Polygon[] downgradePolygons = new Polygon[]{
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[0],
                points[1],
                points[5]
            }, new Vector3f[]{
                points[0],
                points[1],
                points[5]
            }, 0, 0),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[1],
                points[2],
                points[6]
            }, new Vector3f[]{
                points[1],
                points[2],
                points[6]
            }, 0, 0),
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[2],
                points[3],
                points[7]
            }, new Vector3f[]{
                points[2],
                points[3],
                points[7]
            }, 0, 0),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[0],
                points[7],
                points[3]
            }, new Vector3f[]{
                points[0],
                points[7],
                points[3]
            }, 0, 0),
            
            
            
            new Polygon(colors[2], colors[2], new Vector3f[]{
                points[5],
                points[1],
                points[6]
            }, new Vector3f[]{
                points[5],
                points[1],
                points[6]
            }, 0, 0),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[2],
                points[7],
                points[6]
            }, new Vector3f[]{
                points[2],
                points[7],
                points[6]
            }, 0, 0),
            new Polygon(colors[2], colors[2], new Vector3f[]{
                points[0],
                points[4],
                points[7]
            }, new Vector3f[]{
                points[0],
                points[4],
                points[7]
            }, 0, 0),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[0],
                points[5],
                points[4]
            }, new Vector3f[]{
                points[0],
                points[5],
                points[4]
            }, 0, 0),
            
            
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[11],
                points[6],
                points[7]
            }, new Vector3f[]{
                points[5],
                points[6],
                points[7]
            }, duration, duration*2),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[8],
                points[4],
                points[5]
            }, new Vector3f[]{
                points[7],
                points[4],
                points[5]
            }, duration, duration*2),
               
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[5],
                points[6],
                points[10]
            }, new Vector3f[]{
                points[5],
                points[6],
                points[6]
            }, duration, duration*2),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[7],
                points[4],
                points[11]
            }, new Vector3f[]{
                points[7],
                points[4],
                points[7]
            }, duration, duration*2),
                
                
                
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[5],
                points[10],
                points[9]
            }, new Vector3f[]{
                points[5],
                points[10],
                points[5]
            }, duration, duration),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[11],
                points[10],
                points[6]
            }, new Vector3f[]{
                points[11],
                points[6],
                points[6]
            }, duration, duration),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[4],
                points[8],
                points[11]
            }, new Vector3f[]{
                points[4],
                points[4],
                points[11]
            }, duration, duration),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[5],
                points[9],
                points[8]
            }, new Vector3f[]{
                points[5],
                points[9],
                points[9]
            }, duration, duration),
                
                
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[8],
                points[9],
                points[11]
            }, new Vector3f[]{
                points[8],
                points[8],
                points[11]
            }, duration, 0),
                new Polygon(colors[2], colors[2], new Vector3f[]{
                points[9],
                points[10],
                points[11]
            }, new Vector3f[]{
                points[10],
                points[10],
                points[11]
            }, duration, 0)
        };
        
        Polygon[] destroy2Polygons = new Polygon[]{
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[0],
                points[1],
                points[5]
            }, new Vector3f[]{
                points[0],
                points[1],
                points[1]
            }, duration, duration*4),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[1],
                points[2],
                points[6]
            }, new Vector3f[]{
                points[1],
                points[2],
                points[2]
            }, duration, duration*4),
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[2],
                points[3],
                points[7]
            }, new Vector3f[]{
                points[2],
                points[3],
                points[3]
            }, duration, duration*4),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[0],
                points[7],
                points[3]
            }, new Vector3f[]{
                points[0],
                points[3],
                points[3]
            }, duration, duration*4),
            
            
            
            new Polygon(colors[2], colors[2], new Vector3f[]{
                points[5],
                points[1],
                points[6]
            }, new Vector3f[]{
                points[1],
                points[1],
                points[6]
            }, duration, duration*3),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[2],
                points[7],
                points[6]
            }, new Vector3f[]{
                points[2],
                points[7],
                points[2]
            }, duration, duration*3),
            new Polygon(colors[2], colors[2], new Vector3f[]{
                points[0],
                points[4],
                points[7]
            }, new Vector3f[]{
                points[0],
                points[4],
                points[0]
            }, duration, duration*3),
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[0],
                points[5],
                points[4]
            }, new Vector3f[]{
                points[0],
                points[5],
                points[0]
            }, duration, duration*3),
            
            
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[11],
                points[6],
                points[7]
            }, new Vector3f[]{
                points[7],
                points[6],
                points[7]
            }, duration, duration*2),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[8],
                points[4],
                points[5]
            }, new Vector3f[]{
                points[4],
                points[4],
                points[5]
            }, duration, duration*2),
               
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[5],
                points[6],
                points[10]
            }, new Vector3f[]{
                points[5],
                points[6],
                points[6]
            }, duration, duration*2),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[7],
                points[4],
                points[11]
            }, new Vector3f[]{
                points[7],
                points[4],
                points[7]
            }, duration, duration*2),
                
                
                
            new Polygon(colors[0], colors[0], new Vector3f[]{
                points[5],
                points[10],
                points[9]
            }, new Vector3f[]{
                points[5],
                points[10],
                points[5]
            }, duration, duration),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[11],
                points[10],
                points[6]
            }, new Vector3f[]{
                points[11],
                points[6],
                points[6]
            }, duration, duration),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[4],
                points[8],
                points[11]
            }, new Vector3f[]{
                points[4],
                points[4],
                points[11]
            }, duration, duration),
                new Polygon(colors[1], colors[1], new Vector3f[]{
                points[5],
                points[9],
                points[8]
            }, new Vector3f[]{
                points[5],
                points[9],
                points[9]
            }, duration, duration),
                
                
            new Polygon(colors[1], colors[1], new Vector3f[]{
                points[8],
                points[9],
                points[11]
            }, new Vector3f[]{
                points[8],
                points[8],
                points[11]
            }, duration, 0),
                new Polygon(colors[2], colors[2], new Vector3f[]{
                points[9],
                points[10],
                points[11]
            }, new Vector3f[]{
                points[10],
                points[10],
                points[11]
            }, duration, 0)
        };
        
        
        
        for (Polygon polygon : buildPolygons) buildAnimation.addPolygon(polygon);
        for (Polygon polygon : upgradePolygons) upgradeAnimation.addPolygon(polygon);
        for (Polygon polygon : downgradePolygons) downgradeAnimation.addPolygon(polygon);
        for (Polygon polygon : destroy2Polygons) destroy2Animation.addPolygon(polygon);
        
        this.addAnimation(buildAnimation);
        this.addAnimation(upgradeAnimation);
        this.addAnimation(downgradeAnimation);
        this.addAnimation(destroy1Animation);
        this.addAnimation(destroy2Animation);
    }
    
}
