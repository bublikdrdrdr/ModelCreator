/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.creator;

import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import model.creator.graphics.ExampleModel;
import model.creator.graphics.GeometryAnimationManager;
import model.creator.graphics.Model;
import model.creator.graphics.PolyAnimation;
import model.creator.graphics.Polygon;
import model.creator.models.SimpleModel;

/**
 *
 * @author Bublik
 */
public class Workplace extends Main{
    
    public static void main(String[] args) {
        new Workplace();
    }

    @Override
    public Model createModel() {
        //TODO: create model manager, return it in this method and run project to see result
        Model model = new SimpleModel();
        saveFile(model);
        return model;
    }

    @Override
    public void runAnimation() {
        runAnimationAfter("build_lvl_1", 0);
        runAnimationAfter("upgrade_lvl_2", 2000);
        runAnimationAfter("downgrade_lvl_1", 4000);
        runAnimationAfter("upgrade_lvl_2", 6000);
        runAnimationAfter("destroy_lvl_2", 8000);
    }
    
    
    
}
